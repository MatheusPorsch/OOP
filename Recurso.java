public class Recurso {
    private int codigo;
    private String nome;
    private int quantidade;
    
    public Recurso() {}

    public Recurso(int codigo, String nome, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public int getQuantidade() {
        return quantidade;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void uptadeRecursoCodigo (int codigo) {
        setCodigo(codigo);
    }

    public void uptadeRecursoNome (String nome) {
        setNome(nome);
    }

    public void uptadeRecursoQuantidade (int quantidade) {
        setQuantidade(quantidade);
    }
}
