public class Estoque {
    private int quantidade;
    private Recurso recursos[];
    
    public Estoque() {}

    public Estoque(int quantidade, Recurso[] recursos) {
        this.quantidade = quantidade;
        this.recursos = recursos;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Recurso[] getRecursos() {
        return recursos;
    }
    
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setRecursos(Recurso[] recursos) {
        this.recursos = recursos;
    }

    

}
