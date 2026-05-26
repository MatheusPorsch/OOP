import java.util.Date;

public class ExecucaoTarefa {
    
    //Atributos
    int codigo;
    Date inicio;
    Date fim;
    QuantidadeTarefa quantidade;
    Colaborador colaborador;

    //Construtor Vazio
    public ExecucaoTarefa() {};

    //Construtor com Parâmetros
    public ExecucaoTarefa(int codigo, Date inicio, Date fim, Colaborador colaborador){

        this.codigo = codigo;
        this.inicio = inicio;
        this.fim = fim;
        this.colaborador = colaborador;
        
    }

    //Getters
    public int getCodigo(){
        return this.codigo;
    }
    public Date getInicio(){
        return this.inicio;
    }
    public Date getFim(){
        return this.fim;
    }   
    public QuantidadeTarefa getQuantidade(){
        return this.quantidade;
    }     
    public Colaborador getColaborador(){
        return this.colaborador;
    }

    //Setters
    private void setCodigo(int codigo){
        this.codigo = codigo;
    }
    private void setInicio(Date inicio){
        this.inicio = inicio;
    }
    private void setFim(Date fim){
        this.fim = fim;
    }
    private void setQuantidade(QuantidadeTarefa quantidade){
        this.quantidade = quantidade;
    }
    private void setColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
    }

    //Updaters
    public void updateCodigo(int codigo){
        setCodigo(codigo);
    }
    public void updateInicio(Date inicio){
        setInicio(inicio);
    }
    public void updateFim(Date fim){
        setFim(fim);
    }
    public void updateQuantidade(QuantidadeTarefa quantidade){
        setQuantidade(quantidade);
    }
    public void updateColaborador(Colaborador colaborador){
        setColaborador(colaborador);
    }

    //toString
    @Override
    public String toString() {

        return "\nCodigo: " + this.codigo +
               "\nColaborador: " + this.colaborador.getNome() +
               ";\nData de Início: " + this.inicio +
               ";\nData de Fim: " + this.fim + this.quantidade;

    }

}
