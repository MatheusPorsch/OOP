import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Evento {

    //Atributos
    private int codigo;
    private String nome;
    private int progresso;
    private int passoAtual;
    private int passosTotais;
    private ArrayList<ExecucaoTarefa> execucoes = new ArrayList<ExecucaoTarefa>();

    //Construtor Vazio
    public Evento() {}

    //Construtor com Parâmetros
    public Evento(int codigo, String nome, int passosTotais) {

        this.codigo = codigo;
        this.nome = nome;
        this.passosTotais = passosTotais;
        this.passoAtual = 0;
        this.progresso = 0;

    }

    //Getters
    public int getCodigo() {
	  	return codigo;
	}
	public String getNome() {
	  	return nome;
	}
	public int getProgresso() {
	  	return progresso;
	}
	public int getPassoAtual() {
		  return passoAtual;
	}
	public int getPassosTotais() {
		  return passosTotais;
	}    
    public ArrayList<ExecucaoTarefa> getExecucao(){
        return this.execucoes;
    }
    
    //Setters
	public void setCodigo(int codigo) {
	  	this.codigo = codigo;
	}
	public void setNome(String nome) {
		  this.nome = nome;
	}
	public void setPassoAtual(int passoAtual) {
		  this.passoAtual = passoAtual;
	}
	public void setPassosTotais(int passosTotais) {
		  this.passosTotais = passosTotais;
	}

    //Updates
    public void updateCodigo(int codigo) {
        this.codigo = codigo;
    }
    public void updateNome(String nome) {
        this.nome = nome;
    }
    public void updatePassoAtual(int passoAtual) {
        this.passoAtual = passoAtual;
        calcularProgresso();
    }
    public void updatePassosTotais(int passosTotais) {
        this.passosTotais = passosTotais;
        calcularProgresso();
    }

    //Add
    public void addExecucao(ExecucaoTarefa execucao){
        this.execucoes.add(execucao);
    }

    //Remove
    public void removeExecucao(ExecucaoTarefa execucao){
        this.execucoes.remove(execucao);;
    }

    //Método para Executar Tarefa
    public ExecucaoTarefa criarExecucao(Empresa empresa, Tarefa tarefa, Colaborador colaborador, Recurso recurso, int numero, Date inicio, Date fim){

        // VALIDAÇÕES
        Estoque estoque = empresa.getEstoque();
        HashMap<Recurso, Integer> hm = estoque.getRecurso();

        if(!hm.containsKey(recurso)){
            System.out.println("Erro: Recurso não existe no estoque!");
            return null;
        }

        if(hm.get(recurso) < numero){
            System.out.println("Erro: Quantidade insuficiente no estoque!");
            return null;
        }

        if(colaborador == null){
            System.out.println("Erro: Execução sem colaborador!");
            return null;
        }

        if(inicio == null || fim == null || fim.before(inicio)){
            System.out.println("Erro: Datas inválidas!");
            return null;
        }

        if(this.passoAtual >= this.passosTotais){
            System.out.println("Erro: Evento já concluído!");
            return null;
        }

        // CRIAÇÃO

        int passo = this.passoAtual + 1;

        EventoTarefa eventotarefa = new EventoTarefa(this, tarefa, passo);

        QuantidadeTarefa quantidade = new QuantidadeTarefa(recurso, numero);
        quantidade.updateEventoTarefa(eventotarefa);

        int codigoExecucao = this.execucoes.size() + 1;

        ExecucaoTarefa execucaoTarefa = new ExecucaoTarefa(codigoExecucao, inicio, fim, colaborador);
        execucaoTarefa.updateQuantidade(quantidade);

        // ATUALIZAÇÕES

        this.execucoes.add(execucaoTarefa); // salva execução

        this.updatePassoAtual(passo); // atualiza progresso

        int quantidadeAtual = hm.get(recurso);

        if (quantidadeAtual == numero) {
            estoque.removerRecurso(recurso); // remove totalmente
        } else {
            hm.put(recurso, quantidadeAtual - numero); // atualiza quantidade
        } 
        return execucaoTarefa;
    }

    //Método para Calcular Progresso
    private void calcularProgresso() {
        if (passosTotais > 0) {
            this.progresso = 100 * passoAtual / passosTotais;
        } else {
            this.progresso = 0;
        }
    }

    //toString
    @Override
    public String toString() {
        return "\ncodigo: " + codigo +
               "; nome: " + nome +
               "; progresso: " + progresso + "%" +
               "; passoAtual: " + passoAtual +
               "; passosTotais: " + passosTotais;
    }
}
