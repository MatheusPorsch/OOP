public class Evento {

    private int codigo;
    private String nome;
    private int progresso;
    private int passoAtual;
    private int passosTotais;

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

    private void calcularProgresso() {
        if (passosTotais > 0) {
            this.progresso = (passoAtual * 100) / passosTotais;
        } else {
            this.progresso = 0;
        }
    }

    public void addExecucao(Evento evento, Tarefa tarefa, Recurso recurso, int q) {
        System.out.println("Execução adicionada:");
        System.out.println("Evento: " + evento.getNome());
        System.out.println("Tarefa: " + tarefa.getNome());
        System.out.println("Recurso: " + recurso.getNome());
        System.out.println("Quantidade: " + q);
    }

    @Override
    public String toString() {
        return "Evento [codigo=" + codigo +
               ", nome=" + nome +
               ", progresso=" + progresso + "%" +
               ", passoAtual=" + passoAtual +
               ", passosTotais=" + passosTotais + "]";
    }
}
