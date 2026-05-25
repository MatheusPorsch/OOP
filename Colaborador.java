public class Colaborador {
    private int codigo;
    private String nome;
    private String funcao;
    private String usuario;
    private String senha;

    public Colaborador() {}

    public Colaborador(int codigo, String nome, String funcao, String usuario, String senha) {
        this.codigo = codigo;
        this.nome = nome;
        this.funcao = funcao;
        this.usuario = usuario;
        this.senha = senha;
    }

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

    public void updateColaboradorCodigo(int codigo) {
        setCodigo(codigo);
    }
 
    public void updateColaboradorNome(String nome) {
        setNome(nome);
    }
 
    public void updateColaboradorFuncao(String funcao) {
        setFuncao(funcao);
    }
 
    public void updateColaboradorUsuario(String usuario) {
        setUsuario(usuario);
    }
 
    public void updateColaboradorSenha(String senha) {
        setSenha(senha);
    }
}
