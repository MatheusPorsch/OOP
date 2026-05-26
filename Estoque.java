import java.util.HashMap;

public class Estoque {

    private HashMap<Recurso, Integer> recursos = new HashMap<Recurso, Integer>();
    
    public Estoque() {}

    public Estoque(HashMap<Recurso, Integer> recursos) {
        this.recursos = recursos;
    }

    public HashMap<Recurso, Integer> getRecurso(){
        return recursos;
    }

    public void adicionarRecurso(Recurso recurso, int quantidade){
        recursos.put(recurso, quantidade);
    }

    public void removerRecurso(Recurso recurso){
        recursos.remove(recurso);
    }

    @Override
    public String toString(){

        StringBuilder sb = new StringBuilder();

        recursos.forEach((chave, valor) -> {
            sb.append(chave + "; Valor: " + valor + ";\n");
        });

        return sb.toString();
    }
}
