public class QuantidadeTarefa {

    //Atributos
    EventoTarefa eventoTarefa;
    Recurso recurso;
    int quantidade;

    //Construtor Vazio
    public QuantidadeTarefa() {}

    //Construtor com Prâmetros
    public QuantidadeTarefa(Recurso recurso, int quantidade){

        this.recurso = recurso;
        this.quantidade = quantidade;
        
    }

    //Getters
    public EventoTarefa getEventoTarefa() {
        return eventoTarefa;
    }
    public Recurso getRecurso() {
        return this.recurso;
    }    
    public int getQuantidade() {
        return this.quantidade;
    }

    //Setters
    private void setEventoTarefa(EventoTarefa eventoTarefa) {
        this.eventoTarefa = eventoTarefa;
    }
    private void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }  
    private void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    //Updaters
    public void updateEventoTarefa(EventoTarefa eventoTarefa) {
        setEventoTarefa(eventoTarefa);
    }
    public void updateRecurso(Recurso recurso) {
        setRecurso(recurso);
    }  
    public void updateQuantidade(int quantidade) {
        setQuantidade(quantidade);
    }

    //toString
    @Override
    public String toString() {

        return "\nRecurso: " + this.recurso + ";\nQuantidade: " + this.quantidade + this.eventoTarefa;

    }

}