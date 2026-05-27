import java.util.HashMap;

public class Estoque {

    //Atributos
    private HashMap<Recurso, Integer> recursos = new HashMap<Recurso, Integer>();
    
    //Construtor Vazio
    public Estoque() {}

    //Construtor com Parâmetros
    public Estoque(HashMap<Recurso, Integer> recursos) {

        this.recursos = recursos;

    }

    //Getter
    public HashMap<Recurso, Integer> getRecurso(){
        return recursos;
    }

    //Add
    public void adicionarRecurso(Recurso recurso, int quantidade){
        recursos.put(recurso, quantidade);
    }

    //Remove
    public void removerRecurso(Recurso recurso, int quantidade){
        recursos.remove(recurso);
    }

    //Aumentar Quantidade No Estoque
    public void aumentarQuantidadeRecurso(Recurso recurso, int quantidade){

        if(quantidade < 0){
            System.out.println("Erro: A Quantidade Deve Ser Maior que Zero");
            return;
        }

        this.getRecurso().merge(recurso, quantidade, Integer::sum);

    }

    //Diminuir Quantidade No Estoque
    public void diminuirQuantidadeRecurso(Recurso recurso, int quantidade){

        if(quantidade < 0){
            System.out.println("Erro: A Quantidade Deve Ser Maior que Zero");
            return;
        }

        this.getRecurso().computeIfPresent(recurso, (c, v) -> v - quantidade >= 0 ? v - quantidade : 0);

    }

    //toString
    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();
        recursos.forEach((chave, valor) -> {
            sb.append(chave + "; Quantidade: " + valor + ";\n");
        });
        return sb.toString();

    }
    
}
