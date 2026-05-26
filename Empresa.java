import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    
    private int codigo;
    private String nome;

    private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    private Estoque estoque;

    public Empresa(){}

    public Empresa(int codigo, String nome){

        this.codigo = codigo;
        this.nome = nome;
        this.estoque = new Estoque();
    }

    public Empresa(int codigo, String nome, ArrayList<Colaborador> colaboradores, Estoque estoque){

        this.codigo = codigo;
        this.nome = nome;
        this.colaboradores = colaboradores;
        this.estoque = estoque;
        
    }   

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public ArrayList<Colaborador> getColaborador(){
        return this.colaboradores;
    }

    public void addColaborador(Colaborador colaborador){
        this.colaboradores.add(colaborador);
    }

    public void removeColaborador(Colaborador colaborador){
        this.colaboradores.remove(colaborador);;
    }

    public HashMap<Recurso, Integer> getRecurso(){
        return estoque.getRecurso();
    }

    public void addRecurso(Recurso recurso, int quantidade){
        estoque.adicionarRecurso(recurso, quantidade);
    }

    public void removeRecurso(Recurso recurso, int quantidade){
        estoque.removerRecurso(recurso);
    }


    @Override
    public String toString(){
        return "Objeto Empresa;\nCodigo " + this.codigo + ";\nNome: " + this.nome + ";\nColaboradores: " + this.colaboradores.toString().substring(1, this.colaboradores.toString().length() -1) + ";\nEstoque: \n" + this.estoque;
    }

}
