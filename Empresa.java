import java.util.ArrayList;
import java.util.HashMap;

public class Empresa {
    
    //Atributos
    private int codigo;
    private String nome;
    private ArrayList<Tarefa> tarefas = new ArrayList<Tarefa>();
    private ArrayList<Evento> eventos = new ArrayList<Evento>();
    private ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();
    private Estoque estoque;

    //Construtor Vazio
    public Empresa(){}

    //Construtores com Parâmetros
    public Empresa(String nome){

        this.codigo = 0;
        this.nome = nome;
        this.estoque = new Estoque();

    }
    public Empresa(String nome, ArrayList<Colaborador> colaboradores, Estoque estoque){

        this.codigo = 0;
        this.nome = nome;
        this.colaboradores = colaboradores;
        this.estoque = estoque;
        
    }   

    //Getters
    public int getCodigo(){
        return this.codigo;
    }
    public String getNome(){
        return this.nome;
    }
    public ArrayList<Colaborador> getColaborador(){
        return this.colaboradores;
    }   
    public ArrayList<Tarefa> getTarefa(){
        return this.tarefas;
    }    
    public ArrayList<Evento> getEvento(){
        return this.eventos;
    }    
    public HashMap<Recurso, Integer> getRecurso(){
        return estoque.getRecurso();
    }
    public Estoque getEstoque(){
        return this.estoque;
    }

    //Setters
    private void setCodigo(int codigo){
        this.codigo = codigo;
    }
    private void setNome(String nome){
        this.nome = nome;
    }

    //Updaters
    public void updateCodigo(int codigo){
        setCodigo(codigo);
    }
    public void updateNome(String nome){
        setNome(nome);;
    }

    //Adds
    public void addColaborador(Colaborador colaborador){
        this.colaboradores.add(colaborador);
    }
    public void addTarefa(Tarefa tarefa){
        this.tarefas.add(tarefa);
    }
    public void addEvento(Evento evento){
        this.eventos.add(evento);
    }
    public void addRecurso(Recurso recurso, int quantidade){
        estoque.adicionarRecurso(recurso, quantidade);
    }

    //Removes
    public void removeColaborador(Colaborador colaborador){
        this.colaboradores.remove(colaborador);;
    }    
    public void removeTarefa(Tarefa tarefa){
        this.tarefas.remove(tarefa);;
    }    
    public void removeEvento(Evento evento){
        this.eventos.remove(evento);;
    }    
    public void removeRecurso(Recurso recurso, int quantidade){
        estoque.removerRecurso(recurso, quantidade);
    }

    //toString
    @Override
    public String toString(){

        return "Objeto Empresa;\nCodigo " + this.codigo + ";\nNome: " + this.nome + ";\nColaboradores: " + this.colaboradores.toString().substring(1, this.colaboradores.toString().length() -1) + ";\nEventos: " + this.eventos.toString().substring(1, this.eventos.toString().length() -1) + ";\nTarefas: " + this.tarefas.toString().substring(1, this.tarefas.toString().length() -1) +";\nEstoque: \n" + this.estoque;
    
    }

}
