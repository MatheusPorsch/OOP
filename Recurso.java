public class Recurso {
    private int codigo;
    private String nome;
    
    public Recurso() {}

    public Recurso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void uptadeRecursoCodigo (int codigo) {
        setCodigo(codigo);
    }

    public void uptadeRecursoNome (String nome) {
        setNome(nome);
    }

    @Override
    public String toString(){
        return "Codigo: " + this.codigo + "; Nome: " + this.nome;
    }

}
