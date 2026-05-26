import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    
    private int codigo;
    private String nome;

    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private ArrayList<Evento> eventos = new ArrayList<Evento>();
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

    public ArrayList<Tarefa> getTarefa(){
        return this.tarefas;
    }

    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }

    public void removeTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);;
    }

    public ArrayList<Evento> getEvento(){
        return this.eventos;
    }

    public void addEvento(Evento evento){
        this.eventos.add(evento);
    }

    public void removeEvento(Evento evento){
        this.eventos.remove(evento);;
    }

    public HashMap<Recurso, Integer> getRecurso(){
        return estoque.getRecurso();
    }

    public Estoque getEstoque(){
        return this.estoque;
    }

    public void addRecurso(Recurso recurso, int quantidade){
        estoque.adicionarRecurso(recurso, quantidade);
    }

    public void removeRecurso(Recurso recurso, int quantidade){
        estoque.removerRecurso(recurso);
    }

    @Override
    public String toString(){
        return "Objeto Empresa;\nCodigo " + this.codigo + ";\nNome: " + this.nome + ";\nColaboradores: " + this.colaboradores.toString().substring(1, this.colaboradores.toString().length() -1) + ";\nEventos: " + this.eventos.toString().substring(1, this.eventos.toString().length() -1) + ";\nTarefas: " + this.tarefas.toString().substring(1, this.tarefas.toString().length() -1) +";\nEstoque: \n" + this.estoque;
    }

}
