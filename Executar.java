import java.util.Scanner;
import java.util.TreeMap;
import java.util.InputMismatchException;

public class Executar {
    
    public static Scanner scanner = new Scanner(System.in);

    public static String campoTexto1;
    public static String campoTexto2;
    public static int campoInteiro1;
    public static int campoInteiro2;
    public static Empresa empresa1;

    private static TreeMap<String, Empresa> dicionarioEmpresas = new TreeMap<String, Empresa>();

    public static void main(String[] args) {

        int selecao;
        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione uma Opção:");
            System.out.println("0 - Listar Empresas");
            System.out.println("1 - Criar Empresa");
            System.out.println("2 - Excluir Empresa");
            System.out.println("3 - Entrar em Empresa");
            System.out.println("-----------------------------------");
            try{
            selecao = scanner.nextInt();
            scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Erro: Você deve Digitar um Número");
                scanner.nextLine();
                continue;
            }

            switch(selecao){
                case 0:
                    listarEmpresas();
                    break;
                case 1:
                    criacaoEmpresa();
                    break;
                case 2:
                    campoInteiro1 = exclusaoEmpresa();
                    if(campoInteiro1 == 0){
                        System.out.println("Exclusão Realizada com Sucesso");
                    } else {
                        System.out.println("Erro: Empresa Não Localizada");
                    }
                    break;
                case 3:
                    empresa1 = loginEmpresa();
                    if(empresa1 != null){
                        System.out.println("Login Realizado com Sucesso");
                        efetuarLogin(empresa1);
                    } else {
                        System.out.println("Erro: Empresa Não Localizada");
                    }
                    break;
            }
        }
    }

    public static void listarEmpresas(){
        StringBuilder sb = new StringBuilder();
        sb.append("\nEmpresas:");
        if(dicionarioEmpresas.isEmpty()){
            sb.append("\n - Não Há Empresas");
        } else {
            sb.append("\n");
            dicionarioEmpresas.forEach((chave, valor) -> {
                sb.append(" - " + chave + "\n");
            });
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }

    public static Empresa criacaoEmpresa(){

        System.out.println("Digite o Nome da Nova Empresa: ");
        campoTexto1 = scanner.nextLine();
        Empresa empresa = new Empresa(campoTexto1);
        dicionarioEmpresas.put(campoTexto1, empresa);
        return empresa;

    }

    public static int exclusaoEmpresa(){

        System.out.println("Digite o Nome da Empresa para Exclusão: ");
        campoTexto1 = scanner.nextLine();
        if(dicionarioEmpresas.containsKey(campoTexto1)){
            dicionarioEmpresas.remove(campoTexto1);
            return 0;
        } else {
            return 1;
        }

    }

    public static Empresa loginEmpresa(){

        System.out.println("Digite o Nome da Empresa para Login: ");
        campoTexto1 = scanner.nextLine();
        if(dicionarioEmpresas.containsKey(campoTexto1)){
            return dicionarioEmpresas.get(campoTexto1);
        } else {
            return null;
        }

    }

    public static void efetuarLogin(Empresa empresa){

        int selecao;
        while(true){
            
            System.out.println("-----------------------------------");

            System.out.println("Selecione a Ação:");

            System.out.println("-----------------------------------");


            System.out.println("1 - Criar Colaborador");
            System.out.println("2 - Criar Evento");
            System.out.println("3 - Criar Tarefa");
            System.out.println("4 - Criar Recurso");

            System.out.println("5 - Execução de Tarefa em Evento");

            
            System.out.println("4 - Aumentar Quantidade de Recurso");
            System.out.println("4 - Diminuir Quantidade de Recurso");
            
            System.out.println("0 - Alterar Colaborador");
            System.out.println("4 - Alterar Evento");
            System.out.println("4 - Alterar Tarefa");
            System.out.println("4 - Alterar Recurso");
            System.out.println("4 - Alterar Execução");

            System.out.println("0 - Listar Colaboradores");
            System.out.println("4 - Listar Eventos");
            System.out.println("4 - Listar Tarefas");
            System.out.println("4 - Listar Recursos");
            System.out.println("4 - Listar Execuções");

            System.out.println("1 - Excluir Colaborador");
            System.out.println("2 - Excluir Evento");
            System.out.println("3 - Excluir Tarefa");
            System.out.println("4 - Excluir Recurso");
            System.out.println("4 - Excluir Execução");

            System.out.println("-----------------------------------");

            try{
            selecao = scanner.nextInt();
            scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Erro: Você deve Digitar um Número");
                scanner.nextLine();
                continue;
            }

            switch(selecao){
                case 0:
                    listarEmpresas();
                    break;
                case 1:
                    criacaoEmpresa();
                    break;
                case 2:
                    campoInteiro1 = exclusaoEmpresa();
                    if(campoInteiro1 == 0){
                        System.out.println("Exclusão Realizada com Sucesso");
                    } else {
                        System.out.println("Erro: Empresa Não Localizada");
                    }
                    break;
                case 3:
                    empresa1 = loginEmpresa();
                    if(empresa1 != null){
                        System.out.println("Login Realizado com Sucesso");
                        efetuarLogin(empresa1);
                    } else {
                        System.out.println("Erro: Empresa Não Localizada");
                    }
                    break;
            }
        }

    }
        // int codigo;
        // String nome;

        // System.out.println("Digite o nome da Empresa: ");
        // nome = scanner.next();

        // codigo = 1;

        // Empresa empresa = new Empresa(codigo, nome);


        // Colaborador colaborador1 = new Colaborador();
        // colaborador1.updateNome("Matheus");

        // Colaborador colaborador2 = new Colaborador();
        // colaborador2.updateNome("Eduardo");

        // empresa.addColaborador(colaborador1);
        // empresa.addColaborador(colaborador2);


        // Evento evento1 = new Evento();
        // evento1.setNome("Festa de Aniversário");
        // Evento evento2 = new Evento();
        // evento2.setNome("Almoço");
        // empresa.addEvento(evento1);
        // empresa.addEvento(evento2);
    
        // Tarefa tarefa1 = new Tarefa();
        // tarefa1.updateNome("Varrer");
        // Tarefa tarefa2 = new Tarefa();
        // tarefa2.updateNome("Por a mesa");
        // empresa.addTarefa(tarefa1);
        // empresa.addTarefa(tarefa2);

        // Recurso recurso1 = new Recurso();
        // recurso1.updateNome("Vassoura");
        // Recurso recurso2 = new Recurso();
        // recurso2.updateNome("Prato");
        // empresa.addRecurso(recurso1, 2);
        // empresa.addRecurso(recurso2, 10);

        // ExecucaoTarefa execucao = evento2.criarExecucao(empresa, tarefa1, colaborador1, recurso2, 1, null, null);

        // System.out.println("-----------------------------------");
        // try{
        // System.out.println(execucao.toString().substring(1, execucao.toString().length()-1));
        // } catch (Exception e) {
        //     System.out.println("Erro!");
        // }
        // System.out.println("-----------------------------------");

    
}
