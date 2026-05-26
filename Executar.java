import java.util.Scanner;
import java.util.Date;

public class Executar {
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int codigo;
        String nome;

        System.out.println("Digite o nome da Empresa: ");
        nome = scanner.next();

        codigo = 1;

        Empresa empresa = new Empresa(codigo, nome);

        Colaborador colaborador1 = new Colaborador();
        colaborador1.updateColaboradorNome("Matheus");

        Colaborador colaborador2 = new Colaborador();
        colaborador2.updateColaboradorNome("Eduardo");

        empresa.addColaborador(colaborador1);
        empresa.addColaborador(colaborador2);


        Evento evento1 = new Evento();
        evento1.setNome("Festa de Aniversário");
        Evento evento2 = new Evento();
        evento2.setNome("Almoço");
        empresa.addEvento(evento1);
        empresa.addEvento(evento2);
    
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNome("Varrer");
        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNome("Por a mesa");
        empresa.addTarefa(tarefa1);
        empresa.addTarefa(tarefa2);

        Recurso recurso1 = new Recurso();
        recurso1.setNome("Vassoura");
        Recurso recurso2 = new Recurso();
        recurso2.setNome("Prato");
        empresa.addRecurso(recurso1, 2);
        empresa.addRecurso(recurso2, 10);

        ExecucaoTarefa execucao = evento2.criarExecucao(empresa, tarefa1, colaborador1, recurso2, 100, null, null);

        System.out.println("-----------------------------------");
        try{
        System.out.println(execucao.toString().substring(1, execucao.toString().length()-1));
        } catch (Exception e) {
            System.out.println("Erro!");
        }
        System.out.println("-----------------------------------");
        scanner.close();

    }
    
}
