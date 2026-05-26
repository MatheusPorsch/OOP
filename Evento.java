import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Evento {

    private int codigo;
    private String nome;
    private int progresso;
    private int passoAtual;
    private int passosTotais;

    private ArrayList<ExecucaoTarefa> execucoes = new ArrayList<ExecucaoTarefa>();

    public Evento() {}

    public Evento(int codigo, String nome, int passosTotais) {
        this.codigo = codigo;
        this.nome = nome;
        this.passosTotais = passosTotais;
        this.passoAtual = 0;
        this.progresso = 0;
    }

   public int getCodigo() {
	  	return codigo;
	}
	public void setCodigo(int codigo) {
	  	this.codigo = codigo;
	}
	public String getNome() {
	  	return nome;
	}
	public void setNome(String nome) {
		  this.nome = nome;
	}
	public int getProgresso() {
	  	return progresso;
	}
	public void setProgresso(int progresso) {
	  	this.progresso = progresso;
	}
	public int getPassoAtual() {
		  return passoAtual;
	}
	public void setPassoAtual(int passoAtual) {
		  this.passoAtual = passoAtual;
	}
	public int getPassosTotais() {
		  return passosTotais;
	}
	public void setPassosTotais(int passosTotais) {
		  this.passosTotais = passosTotais;
	}

    public void updateCodigoEvento(int codigo) {
        this.codigo = codigo;
    }

    public void updateEventoNome(String nome) {
        this.nome = nome;
    }

    public void updateEventoPassoAtual(int passoAtual) {
        this.passoAtual = passoAtual;
        calcularProgresso();
    }

    public void updateEventoPassosTotais(int passosTotais) {
        this.passosTotais = passosTotais;
        calcularProgresso();
    }

    public ExecucaoTarefa criarExecucao(Empresa empresa, Tarefa tarefa, Colaborador colaborador, Recurso recurso, int numero, Date inicio, Date fim){
        
        ExecucaoTarefa execucaoTarefa = new ExecucaoTarefa();
        Estoque estoque = empresa.getEstoque();

        HashMap<Recurso, Integer> hm = estoque.getRecurso();

        if(hm.containsKey(recurso)){
            if(hm.get(recurso) < numero){
                return null;
            }
        } else{
            return null;
        }

        EventoTarefa eventotarefa = new EventoTarefa();
        eventotarefa.setEvento(this);
        eventotarefa.setTarefa(tarefa);
        eventotarefa.setPassoAtual(0);

        Quantidade quantidade = new Quantidade(recurso, numero);
        quantidade.setEventoTarefa(eventotarefa);

        execucaoTarefa.setColaborador(colaborador);
        execucaoTarefa.setQuantidade(quantidade);

        return execucaoTarefa;
    }

    public ArrayList<ExecucaoTarefa> getExecucao(){
        return this.execucoes;
    }

    public void addExecucao(ExecucaoTarefa execucao){
        this.execucoes.add(execucao);
    }

    public void removeExecucao(ExecucaoTarefa execucao){
        this.execucoes.remove(execucao);;
    }

    private void calcularProgresso() {
        if (passosTotais > 0) {
            this.progresso = (passoAtual * 100) / passosTotais;
        } else {
            this.progresso = 0;
        }
    }

    // public void addExecucao(Evento evento, Tarefa tarefa, Recurso recurso, int q) {
    //     System.out.println("Execução adicionada:");
    //     System.out.println("Evento: " + evento.getNome());
    //     System.out.println("Tarefa: " + tarefa.getNome());
    //     System.out.println("Recurso: " + recurso.getNome());
    //     System.out.println("Quantidade: " + q);
    // }

    @Override
    public String toString() {
        return "\ncodigo: " + codigo +
               "; nome: " + nome +
               "; progresso: " + progresso + "%" +
               "; passoAtual: " + passoAtual +
               "; passosTotais: " + passosTotais;
    }
}
