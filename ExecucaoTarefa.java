import java.util.Date;

public class ExecucaoTarefa {
    
    int codigo;
    Date inicio;
    Date fim;

    Quantidade quantidade;
    Colaborador colaborador;

    public ExecucaoTarefa() {};

    public ExecucaoTarefa(int codigo, Date inicio, Date fim, Colaborador colaborador){
        this.codigo = codigo;
        this.inicio = inicio;
        this.fim = fim;
        this.colaborador = colaborador;
    }

    public int getCodigo(){
        return this.codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public Date getInicio(){
        return this.inicio;
    }

    public void setInicio(Date inicio){
        this.inicio = inicio;
    }

    public Date getFim(){
        return this.fim;
    }

    public void setFim(Date fim){
        this.fim = fim;
    }

    public Quantidade getQuantidade(){
        return this.quantidade;
    }

    public void setQuantidade(Quantidade quantidade){
        this.quantidade = quantidade;
    }

    public Colaborador getColaborador(){
        return this.colaborador;
    }

    public void setColaborador(Colaborador colaborador){
        this.colaborador = colaborador;
    }

    @Override
    public String toString() {
        return "\nCodigo: " + this.codigo +
               "\nColaborador: " + this.colaborador.getNome() +
               ";\nData de Início: " + this.inicio +
               ";\nData de Fim: " + this.fim + this.quantidade;
    }

}
