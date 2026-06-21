public class Tarefa {
    
    //Atributos
    private int codigo;
    private String nome;
    private String descricao;
    
    //Construtor Vazio
    public Tarefa() {}

    //Construtor com Parâmtros
    public Tarefa(int codigo, String nome, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
    }
    
    //Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }    
    public String getDescricao() {
        return descricao;
    }

    //Setters
    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    //Updaters
    public void updateCodigo(int codigo) {
        setCodigo(codigo);
    }
    public void updateNome(String nome) {
       setNome(nome);
    }
    public void updateDescricao(String descricao) {
        setDescricao(descricao);
    }

    //toString
    @Override
    public String toString() {

        return "\ncodigo: " + codigo + "; nome: " + nome + "; descricao: " + descricao;

    }

}
