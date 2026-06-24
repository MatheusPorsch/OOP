import com.fasterxml.jackson.annotation.JsonCreator;

public class Recurso {

    // Atributos
    private int codigo;
    private String nome;

    // Construtor Vazio
    public Recurso() {}

    // Construtor com Parâmetros
    public Recurso(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    // Getters
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }

    // Setters
    private void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    private void setNome(String nome) {
        this.nome = nome;
    }

    // Updaters
    public void updateCodigo(int codigo) {
        setCodigo(codigo);
    }
    public void updateNome(String nome) {
        setNome(nome);
    }

    @Override
    public int hashCode() {
        return codigo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Recurso other = (Recurso) obj;
        return codigo == other.codigo;
    }

    // ---- Suporte ao Jackson para usar Recurso como CHAVE de Map ----

    @JsonCreator
    public static Recurso fromString(String chave) {
        // formato esperado: "codigo:nome"
        String[] partes = chave.split(":", 2);
        int codigo = Integer.parseInt(partes[0]);
        String nome = partes.length > 1 ? partes[1] : "";
        return new Recurso(codigo, nome);
    }

    @Override
    public String toString() {
        return this.codigo + ":" + this.nome;
    }
}
