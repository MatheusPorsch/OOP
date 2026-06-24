import com.fasterxml.jackson.annotation.JsonIgnore;

public class EventoTarefa {
	
	//Atributos
	
	@JsonIgnore
	private Evento evento;
	private Tarefa tarefa;
	private int passoAtual;

	//Construtor Vazio
	public EventoTarefa() {}

	//Construtor com Parâmetros
	public EventoTarefa(Evento evento, Tarefa tarefa, int passoAtual){

		this.evento = evento;
		this.tarefa = tarefa;
		this.passoAtual = passoAtual;

	}

	//Getters
	public Evento getEvento(){
		return this.evento;
	}
	public Tarefa getTarefa(){
		return this.tarefa;
	}
	public int getPassoAtual(){
		return this.passoAtual;
	}

	//Setters
	private void setEvento(Evento evento){
		this.evento = evento;
	}
	private void setTarefa(Tarefa tarefa){
		this.tarefa = tarefa;
	}
	private void setPassoAtual(int passoAtual){
		this.passoAtual = passoAtual;
	}

	//Updaters
	public void updateEvento(Evento evento){
		setEvento(evento);
	}
	public void updateTarefa(Tarefa tarefa){
		setTarefa(tarefa);
	}
	public void updatePassoAtual(int passoAtual){
		setPassoAtual(passoAtual);
	}
	
	//toString
    @Override
    public String toString() {

        return "\nEvento: " + this.evento.getNome() + ";\nTarefa: " + this.tarefa.getNome() + ";\nPasso: " + this.passoAtual + ".";
		
    }

}
