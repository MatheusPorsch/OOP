
public class EventoTarefa {
	
	private Evento evento;
	private Tarefa tarefa;
	private int passoAtual;

	public EventoTarefa() {}

	public EventoTarefa(Evento evento, Tarefa tarefa, int passoAtual){
		this.evento = evento;
		this.tarefa = tarefa;
		this.passoAtual = passoAtual;
	}

	public Evento getEvento(){
		return this.evento;
	}

	public void setEvento(Evento evento){
		this.evento = evento;
	}

	public Tarefa getTarefa(){
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa){
		this.tarefa = tarefa;
	}

	public int getPassoAtual(){
		return this.passoAtual;
	}

	public void setPassoAtual(int passoAtual){
		this.passoAtual = passoAtual;
	}
	
    @Override
    public String toString() {
        return "\nEvento: " + this.evento.getNome() + ";\nTarefa: " + this.tarefa.getNome() + ";\nPasso: " + this.passoAtual + ".";
    }
}
