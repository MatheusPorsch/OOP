public class Colaborador {

    //Atributos
    private int codigo;
    private String nome;
    private String funcao;
    private String usuario;
    private String senha;

    //Construtor Vazio
    public Colaborador() {}

    //Construtor com Parâmetros
    public Colaborador(int codigo, String nome, String funcao, String usuario, String senha) {
        
        this.codigo = codigo;
        this.nome = nome;
        this.funcao = funcao;
        this.usuario = usuario;
        this.senha = senha;

    }

    //Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public String getFuncao() {
        return funcao;
    }
    public String getUsuario() {
        return usuario;
    }
    public String getSenha() {
        return senha;
    }

    //Setters
    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }
    private void setFuncao(String funcao) {
        this.funcao = funcao;
    }
    private void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    private void setSenha(String senha) {
        this.senha = senha;
    }

    //Updaters
    public void updateCodigo(int codigo) {
        setCodigo(codigo);
    }
    public void updateNome(String nome) {
        setNome(nome);
    }
    public void updateFuncao(String funcao) {
        setFuncao(funcao);
    }
    public void updateUsuario(String usuario) {
        setUsuario(usuario);
    }
    public void updateSenha(String senha) {
        setSenha(senha);
    }

    //toString
    @Override
    public String toString(){

        return "\nCodigo: " + this.codigo + "; Nome: " + this.nome + "; Função: " + this.funcao + "; Usuário: " + this.usuario + "; Senha: " + this.senha;
    
    }

}
