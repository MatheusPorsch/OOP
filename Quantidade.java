public class Quantidade {

    EventoTarefa eventoTarefa;
    Recurso recurso;
    int quantidade;

    public Quantidade() {}

    public Quantidade(Recurso recurso, int quantidade){
        this.recurso = recurso;
        this.quantidade = quantidade;
    }

    public EventoTarefa getEventoTarefa() {
        return eventoTarefa;
    }
    
    public void setEventoTarefa(EventoTarefa eventoTarefa) {
        this.eventoTarefa = eventoTarefa;
    }

    public Recurso getRecurso() {
        return this.recurso;
    }
    
    public void setRecurso(Recurso recurso) {
        this.recurso = recurso;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "\nRecurso: " + this.recurso + ";\nQuantidade: " + this.quantidade + this.eventoTarefa;
    }

}