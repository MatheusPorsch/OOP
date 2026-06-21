public class Recurso {

    //Atributos
    private int codigo;
    private String nome;
    
    //Construtor Vazio
    public Recurso() {}

    //Construtor com Parâmetros
    public Recurso(int codigo, String nome) {

        this.codigo = codigo;
        this.nome = nome;
        
    }

    //Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    
    //Setters
    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    //Updaters
    public void updateCodigo (int codigo) {
        setCodigo(codigo);
    }
    public void updateNome (String nome) {
        setNome(nome);
    }

    //toString
    @Override
    public String toString(){
        return "Codigo: " + this.codigo + "; Nome: " + this.nome;
    }

}
