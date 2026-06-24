import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Executar {
    
    public static Scanner scanner = new Scanner(System.in);

    public static String campoTexto1;
    public static String campoTexto2;
    public static int campoInteiro1;
    public static int campoInteiro2;
    public static Empresa empresa;

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
            System.out.println("9 - Sair");
            System.out.println("-----------------------------------");

            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 0 -> listarEmpresas();
                case 1 -> criacaoEmpresa();
                case 2 -> {
                    campoInteiro1 = exclusaoEmpresa();
                    if(campoInteiro1 == 0)
                        System.out.println("Exclusão Realizada com Sucesso");
                    else
                        System.out.println("Erro: Empresa Não Localizada");
                }
                case 3 -> {
                    empresa = loginEmpresa();
                    if(empresa != null){
                        System.out.println("Login Realizado com Sucesso");
                        mostrar_entidades(empresa);
                    } else
                        System.out.println("Erro: Empresa Não Localizada");
                }
                case 9 -> {
                    System.out.println("Saindo...");
                    return;
                }
                default -> System.out.println("Erro: Opção inválida!"); 
            }
        }
    }

    public static void listarEmpresas(){
        StringBuilder sb = new StringBuilder();
        sb.append("Listagem de Empresas:" + "\n");
        if(dicionarioEmpresas.isEmpty()){
            sb.append(" - Não Há Empresas" + "\n");
        } else {
            dicionarioEmpresas.forEach((chave, valor) -> {
                sb.append(" - " + chave + "\n");
            });
        }
        System.out.print(sb.toString());
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

    public static void mostrar_entidades(Empresa empresa){

        int selecao;
        while(true){
            
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Entidade:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Colaborador");
            System.out.println("2 - Evento");
            System.out.println("3 - Tarefa");
            System.out.println("4 - Recurso");
            System.out.println("5 - Execução");
            System.out.println("9 - Sair");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            switch(selecao){
                case 1 -> acao_colaborador(empresa);
                case 2 -> acao_evento(empresa);
                case 3 -> acao_tarefa(empresa);
                case 4 -> acao_recurso(empresa);
                case 5 -> acao_execucao(empresa);
                case 9 -> {
                    System.out.println("Voltando ao Menu de Empresas...");
                    return;
                }
                default -> System.out.println("Erro: Opção inválida!"); 
            }
        }
    }

    public static void acao_colaborador(Empresa empresa){

        int selecao;
        String input;

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Ação em Colaborador:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Consulta");
            System.out.println("9 - Voltar");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 1 -> {

                    boolean input_correto = false;
                    int captura_codigo = -1;
                    while(!input_correto){
                        System.out.println("Código do Colaborador:");
                        try {
                            captura_codigo = Integer.parseInt(scanner.nextLine());
                            input_correto = true;
                        } catch(NumberFormatException e){
                            System.out.println("Erro: O código deve ser um número!");
                        }
                    }

                    int codigo = captura_codigo;
                    System.out.println("Nome do Colaborador:");
                    String nome = scanner.nextLine();

                    if(empresa.getColaborador().stream().anyMatch(u -> u.getCodigo() == codigo || u.getNome().equals(nome))){
                        System.out.println("Erro: Colaborador com Nome/Codigo já existente!");
                        break;
                    }

                    System.out.println("Funcao do Colaborador:");
                    String funcao = scanner.nextLine();
                    System.out.println("Usuario do Colaborador:");
                    String usuario = scanner.nextLine();
                    System.out.println("Senha do Colaborador:");
                    String senha = scanner.nextLine();
                         
                    Colaborador c = new Colaborador(codigo, nome, funcao, usuario, senha);
                    empresa.addColaborador(c);
                    System.out.println("Colaborador criado com sucesso!");

                }
                case 2 -> {
                
                    System.out.println("Digite o código ou o nome do colaborador você deseja alterar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Colaborador alerar_colaborador = procurar_Colaborador(input);

                    if (alerar_colaborador != null) {
                        System.out.println("Novo nome:");
                        String nome = scanner.nextLine();
                        System.out.println("Nova função:");
                        String funcao = scanner.nextLine();
                        System.out.println("Novo usuário:");
                        String usuario = scanner.nextLine();
                        System.out.println("Nova senha:");
                        String senha = scanner.nextLine();
                        
                        if (empresa.getColaborador().stream().anyMatch(u -> u.getNome().equals(nome)))
                            System.out.println("Erro: O nome selecionado já está sendo usado!");
                        else{

                            if(!nome.isBlank())
                                alerar_colaborador.updateNome(nome);
                            if(!funcao.isBlank())
                                alerar_colaborador.updateFuncao(funcao);
                            if(!usuario.isBlank())
                                alerar_colaborador.updateUsuario(usuario);
                            if(!senha.isBlank())
                                alerar_colaborador.updateSenha(senha);

                            if(!(nome.isBlank() && funcao.isBlank() && usuario.isBlank() && senha.isBlank()))
                                System.out.println("Colaborador alterado com sucesso!");
                            else
                                System.out.println("Nenhuma alteração realizada!");
                        }
                    } else {
                        System.out.println("Erro: Colaborador não encontrado!");
                    }
                }
                case 3 -> {

                    System.out.println("Listagem de Colaboradores:\n");
                    if(!empresa.getColaborador().isEmpty())
                        for (Colaborador c : empresa.getColaborador())
                            System.out.println(c);
                    else
                        System.out.println("- Não há colaboradores cadastrados!");
                    System.out.println();

                }
                case 4 -> {

                    System.out.println("Digite o código ou o nome do colaborador você deseja excluir:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Colaborador colaborador_excluir = procurar_Colaborador(input);

                    if (colaborador_excluir != null) {
                        empresa.removeColaborador(colaborador_excluir);
                        System.out.println("Colaborador excluido!");
                    } else
                        System.out.println("Erro: Colaborador não encontrado!");

                }
                case 5 -> {

                    System.out.println("Digite o código ou o nome do colaborador você deseja pesquisar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Colaborador busca_colaborador = procurar_Colaborador(input);

                    if (busca_colaborador != null)
                        System.out.println(busca_colaborador);
                    else
                        System.out.println("Erro: Não há colaboradores com esse parâmetro!");
                }
                case 6 -> {
                    Persistencia.salvarEmpresa(empresa);
                    break;
                }
                case 7 -> {
                    Persistencia.carregarEmpresa(empresa.getNome());
                    break;
                }
                case 9 -> {
                
                    System.out.println("Voltando ao Menu de Entidades...");
                    return;

                }
                default -> System.out.println("Erro: Opção inválida!"); 

            }
        }
    }
                
    public static void acao_evento(Empresa empresa){

        int selecao;
        String input;

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Ação em Evento:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Consulta");
            System.out.println("9 - Voltar");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 1 -> {

                    boolean input_correto = false;
                    int captura_codigo = -1;
                    while(!input_correto){
                        System.out.println("Código do Evento:");
                        try {
                            captura_codigo = Integer.parseInt(scanner.nextLine());
                            input_correto = true;
                        } catch(NumberFormatException e){
                            System.out.println("Erro: O código deve ser um número!");
                        }
                    }

                    int codigo = captura_codigo;

                    System.out.println("Nome do Evento:");
                    String nome = scanner.nextLine();

                    if(empresa.getEvento().stream().anyMatch(u -> u.getCodigo() == codigo || u.getNome().equals(nome))){
                        System.out.println("Erro: Evento com Nome/Codigo já existente!");
                        break;
                    }

                    input_correto = false;
                    int captura_Numero_de_pessoas = -1;
                    while(!input_correto){
                        System.out.println("Número de Pessoas no Evento:");
                        try {
                            captura_Numero_de_pessoas = Integer.parseInt(scanner.nextLine());
                            input_correto = true;
                        } catch(NumberFormatException e){
                            System.out.println("Erro: O código deve ser um número!");
                        }
                    }

                    Evento e = new Evento(codigo, nome, captura_Numero_de_pessoas);
                    empresa.addEvento(e);
                    System.out.println("Evento criado com sucesso!");

                }
                case 2 -> {
                    
                    System.out.println("Digite o código ou o nome do evento você deseja alterar: ");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Evento alterar_evento = procurar_Evento(input);

                    if (alterar_evento != null) {

                        System.out.println("Novo nome:");
                        String nome = scanner.nextLine();

                        System.out.println("Nova quantidade de passos:");
                        String quantidade_passos = scanner.nextLine();

                        if (empresa.getEvento().stream().anyMatch(u -> u.getNome().equals(nome)))
                            System.out.println("O nome selecionado já está sendo usado!");
                        else{

                            if(!nome.isBlank())
                                alterar_evento.updateNome(nome);
                            if(!quantidade_passos.isBlank())
                                try {
                                    alterar_evento.updatePassosTotais(Integer.parseInt(quantidade_passos));
                                } catch (NumberFormatException e) {
                                    System.out.println("Erro: O Valor digitado não é um número!");
                                }

                            if(!(nome.isBlank() && quantidade_passos.isBlank()))
                                System.out.println("Evento alterado com sucesso!");
                            else
                                System.out.println("Nenhuma alteração realizada!");
                        }
                    } else 
                        System.out.println("Erro: Evento não encontrado!");
                }
                case 3 -> {

                    System.out.println("Listagem de Eventos:\n");
                    if(!empresa.getEvento().isEmpty())
                        for (Evento e : empresa.getEvento())
                            System.out.println(e);
                    else
                        System.out.println("- Não há eventos cadastrados!");
                    System.out.println();

                }

                case 4 -> {
                    System.out.println("Digite o código ou o nome do evento você deseja excluir: ");
                    input = scanner.nextLine();

                    Evento excluir_evento = procurar_Evento(input);

                    if (excluir_evento != null) {
                        empresa.removeEvento(excluir_evento);
                        System.out.println("Evento excluido!");
                    } else {
                        System.out.println("Erro: Evento não encontrado!");
                    }
                    break;
                }
                case 5 -> {

                    System.out.println("Digite o código ou o nome do evento você deseja pesquisar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Evento pesquisa_evento = procurar_Evento(input);

                    if (pesquisa_evento != null)
                        System.out.println(pesquisa_evento);
                    else
                        System.out.println("Erro: Não há eventos com esse parâmetro!");
                }
                case 9 -> {
                    System.out.println("Voltando ao Menu de Entidades...");
                    return;
                }
                default -> System.out.println("Erro: Opção inválida!"); 
            }
        }
    }

    public static void acao_tarefa(Empresa empresa){

        int selecao;
        String input;

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Ação em Tarefa:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Consulta");
            System.out.println("9 - Voltar");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 1 -> {

                    boolean input_correto = false;
                    int captura_codigo = -1;
                    while(!input_correto){
                        System.out.println("Código da Tarefa:");
                        try {
                            captura_codigo = Integer.parseInt(scanner.nextLine());
                            input_correto = true;
                        } catch(NumberFormatException e){
                            System.out.println("Erro: O código deve ser um número!");
                        }
                    }

                    int codigo = captura_codigo;

                    System.out.println("Nome da Tarefa:");
                    String nome = scanner.nextLine();

                    if(empresa.getTarefa().stream().anyMatch(u -> u.getCodigo() == codigo || u.getNome().equals(nome))){
                        System.out.println("Erro: Tarefa com Nome/Codigo já existente!");
                        break;
                    }

                    System.out.println("Descrição da Tarefa:");
                    String descricao = scanner.nextLine();

                    Tarefa t = new Tarefa(codigo, nome, descricao);
                    empresa.addTarefa(t);
                    System.out.println("Tarefa criada com sucesso!");
                }
                case 2 -> {
                    
                    System.out.println("Digite o código ou o nome da tarefa você deseja alterar: ");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Tarefa alterar_tarefa = procurar_Tarefa(input);

                    if (alterar_tarefa != null) {

                        System.out.println("Novo nome:");
                        String nome = scanner.nextLine();
                        
                        if (empresa.getTarefa().stream().anyMatch(u -> u.getNome().equals(nome))){
                            System.out.println("O nome selecionado já está sendo usado!");
                            break;
                        }

                        System.out.println("Descrição: ");
                        String descricao = scanner.nextLine();
                
                        if(!nome.isBlank())
                            alterar_tarefa.updateNome(nome);
                        if(!descricao.isBlank())
                           alterar_tarefa.updateDescricao(descricao);
                        if(!(nome.isBlank() && descricao.isBlank()))
                            System.out.println("Tarefa alterada com sucesso!");
                        else
                            System.out.println("Nenhuma alteração realizada!");
                    } else 
                        System.out.println("Erro: Evento não encontrado!");
                }
                case 3 -> {
                    System.out.println("Listagem de Tarefas:\n");
                    if(!empresa.getTarefa().isEmpty())
                        for (Tarefa t : empresa.getTarefa())
                            System.out.println(t);
                    else
                        System.out.println("- Não há tarefas cadastradas!");
                    System.out.println();
                }

                case 4 -> {

                    System.out.println("Digite o código ou o nome da tarefa que você deseja excluir: ");
                    input = scanner.nextLine();

                    Tarefa excluir_tarefa = procurar_Tarefa(input);

                    if (excluir_tarefa != null) {
                        empresa.removeTarefa(excluir_tarefa);
                        System.out.println("Tarefa excluida!");
                    } else {
                        System.out.println("Erro: Tarefa não encontrada!");
                    }
                    break;
                }
                case 5 -> {

                    System.out.println("Digite o código ou o nome da tarefa você deseja pesquisar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Tarefa pesquisar_tarefa = procurar_Tarefa(input);

                    if (pesquisar_tarefa != null)
                        System.out.println(pesquisar_tarefa);
                    else
                        System.out.println("Erro: Não há tarefas com esse parâmetro!");
                }
                case 9 -> {
                    System.out.println("Voltando ao Menu de Entidades...");
                    return;
                }
                default -> System.out.println("Erro: Opção inválida!"); 
            }
        }
    }

    public static void acao_recurso(Empresa empresa){

        int selecao;
        String input;

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Ação em Recurso:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Consulta");
            System.out.println("9 - Voltar");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 1 -> {

                    boolean input_correto = false;
                    int captura_codigo = -1;
                    while(!input_correto){
                        System.out.println("Código do Recurso:");
                        try {
                            captura_codigo = Integer.parseInt(scanner.nextLine());
                            input_correto = true;
                        } catch(NumberFormatException e){
                            System.out.println("Erro: O código deve ser um número!");
                        }
                    }

                    int codigo = captura_codigo;
                    System.out.println("Nome do Recurso:");
                    String nome = scanner.nextLine();

                    for (Map.Entry<Recurso, Integer> c : empresa.getEstoque().getRecurso().entrySet()) {
                        if(c.getKey().getNome().equals(nome) || c.getKey().getCodigo() == codigo){
                            System.out.println("Erro: Recurso com Nome/Codigo já existente!");
                            break;
                        }
                    }

                    System.out.println("Quantidade:");
                    String quantidade = scanner.nextLine();
                    
                    try {
                        Recurso r = new Recurso(codigo, nome);
                        empresa.addRecurso(r, Integer.parseInt(quantidade));
                        System.out.println("Recurso criado com sucesso!"); 
                    } catch (Exception e) {
                        System.out.println("Erro: Quantidade deve ser um número!");
                    }
                }
                case 2 -> {
                
                    System.out.println("Digite o código ou o nome do recurso você deseja alterar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Recurso alterar_recurso = procurar_Recurso(input);

                    if (alterar_recurso != null) {

                        System.out.println("Novo nome:");
                        String nome = scanner.nextLine();

                        if (empresa.getColaborador().stream().anyMatch(u -> u.getNome().equals(nome))){
                            System.out.println("Erro: O nome selecionado já está sendo usado!");
                            break;
                        }
                        
                        System.out.println("Nova quantidade:");
                        String str_quantidade = scanner.nextLine();

                        int quantidade = -1;

                        if(!str_quantidade.isBlank())
                        try {
                            quantidade = Integer.parseInt(str_quantidade);
                        } catch (NumberFormatException e) {
                            System.out.println("Erro: A quantidade deve ser um número!");
                            break;
                        }

                        if(!nome.isBlank())
                            alterar_recurso.updateNome(nome);

                        if(!str_quantidade.isBlank()){
                            for (Map.Entry<Recurso, Integer> c : empresa.getEstoque().getRecurso().entrySet()) {
                                if(c.getKey().getNome().contains(nome)) {
                                    c.setValue(quantidade);
                                }
                            }
                        }
                                                    
                        if(!(nome.isBlank() && str_quantidade.isBlank()))
                            System.out.println("Recurso alterado com sucesso!");
                        else
                            System.out.println("Nenhuma alteração realizada!");



                    } else {
                        System.out.println("Erro: Recurso não encontrado!");
                    }
                }
                case 3 -> {

                    System.out.println("Listagem de Recurso:\n");
                    if(!empresa.getEstoque().getRecurso().isEmpty())
                        for (Map.Entry<Recurso, Integer> r : empresa.getEstoque().getRecurso().entrySet())
                            System.out.println(r.getKey() + "; Quantidade: " + r.getValue());
                    else
                        System.out.println("- Não há recursos cadastrados!");
                    System.out.println();

                }
                case 4 -> {

                    System.out.println("Digite o código ou o nome do recurso que você deseja excluir:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Nenhum Parâmetro Selecionado!");
                        break;
                    }

                    Recurso excluir_recurso = procurar_Recurso(input);

                    if (excluir_recurso != null){
                        empresa.getEstoque().removerRecurso(excluir_recurso);
                        System.out.println("Recurso excluido!");
                    } else
                        System.out.println("Erro: Recurso não encontrado!");

                }
                case 5 -> {
                    System.out.println("Digite o código ou o nome do recurso que você deseja pesquisar:");
                    input = scanner.nextLine();
                    if(input.isBlank()){
                        System.out.println("Erro: Nenhum Parâmetro Selecionado!");
                        break;
                    }
                    Recurso busca_recurso = procurar_Recurso(input);

                    if (busca_recurso != null)
                        System.out.println(busca_recurso);
                    else
                        System.out.println("Erro: Não há recursos com esse parâmetro!");
                }
                case 9 -> {
                
                    System.out.println("Voltando ao Menu de Entidades...");
                    return;

                }
                default -> System.out.println("Erro: Opção inválida!"); 

            }
        }
    }       

    public static void acao_execucao(Empresa empresa){

        int selecao;

        while(true){
            System.out.println("-----------------------------------");
            System.out.println("Selecione a Ação em Execução:");
            System.out.println("-----------------------------------");
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Excluir");
            System.out.println("5 - Consulta");
            System.out.println("9 - Voltar");
            System.out.println("-----------------------------------");
            
            try{
                selecao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e){
                System.out.println("Erro: Você deve Digitar um Número");
                continue;
            }

            System.out.println("-----------------------------------");

            switch(selecao){
                case 1 -> {
                    System.out.println("-----------------------------------");
	         	    System.out.println("EXECUÇÃO DE TAREFA");
	         	    System.out.println("-----------------------------------");
	
	         	    // selecionar evento
	         	    System.out.println("Digite o nome do Evento:");
	         	    String codEvento = scanner.nextLine();
	
	         	    Evento eventoSelecionado = null;
	         	    for (Evento e : empresa.getEvento()) {
	         	        if (e.getNome().equals(codEvento)) {
	         	            eventoSelecionado = e;
	         	            break;
	         	        }
	         	    }
	
	         	    if (eventoSelecionado == null) {
	         	        System.out.println("Erro: Evento não encontrado!");
	         	        break;
	         	    }
	
	         	    // selecionar tarefa
	         	    System.out.println("Digite o nome da Tarefa:");
	         	    String codTarefa = scanner.nextLine();
	
	         	    Tarefa tarefaSelecionada = null;
	         	    for (Tarefa t : empresa.getTarefa()) {
	         	        if (t.getNome().equals(codTarefa)) {
	         	            tarefaSelecionada = t;
	         	            break;
	         	        }
	         	    }
	
	         	    if (tarefaSelecionada == null) {
	         	        System.out.println("Erro: Tarefa não encontrada!");
	         	        break;
	         	    }
	
	         	    // selecionar colaborador
	         	    System.out.println("Digite o nome do Colaborador:");
	         	    String codColab = scanner.nextLine();
	
	         	    Colaborador colaboradorSelecionado = null;
	         	    for (Colaborador c : empresa.getColaborador()) {
	         	        if (c.getNome().equals(codColab)) {
	         	            colaboradorSelecionado = c;
	         	            break;
	         	        }
	         	    }
	
	         	    if (colaboradorSelecionado == null) {
	         	        System.out.println("Erro: Colaborador não encontrado!");
	         	        break;
	         	    }
	
	         	    // selecionar recurso
	         	    System.out.println("Digite o nome do Recurso:");
	         	    String codRecurso = scanner.nextLine();
	
	         	    Recurso recursoSelecionado = null;
	         	    for (Recurso r : empresa.getRecurso().keySet()) {
	         	        if (r.getNome().equals(codRecurso)) {
	         	            recursoSelecionado = r;
	         	            break;
	         	        }
	         	    }
	
	         	    if (recursoSelecionado == null) {
	         	        System.out.println("Erro: Recurso não encontrado!");
	         	        break;
	         	    }
	
	         	    // quantidade
	         	    System.out.println("Digite a quantidade do recurso:");
	         	    int quantidade = scanner.nextInt();
	         	    scanner.nextLine();
	
	         	    if (quantidade <= 0) {
	         	        System.out.println("Erro: Quantidade inválida!");
	         	        break;
	         	    }
	
	         	    // leitura e conversão de datas
	         	    System.out.println("Digite a data de início (dd/MM/yyyy HH:mm):");
	         	    String inicioStr = scanner.nextLine();
	
	         	    System.out.println("Digite a data de fim (dd/MM/yyyy HH:mm):");
	         	    String fimStr = scanner.nextLine();
	
	         	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	         	    Date inicio = null;
	         	    Date fim = null;
	
	         	    try {
	         	        inicio = sdf.parse(inicioStr);
	         	        fim = sdf.parse(fimStr);
	         	    } catch (Exception e) {
	         	        System.out.println("Erro ao converter datas!");
	         	        break;
	         	    }
	         	    
	         	   try {
                       ExecucaoTarefa execucao = eventoSelecionado.criarExecucao(
                           empresa,
                           tarefaSelecionada,
                           colaboradorSelecionado,
                           recursoSelecionado,
                           quantidade,
                           inicio,
                           fim
                       );
                       
                       System.out.println("Execução criada com sucesso!");
                       System.out.println(execucao);
                   } catch (QuantidadeInvalidaException e) {
                       System.out.println(e.getMessage());
                   } catch (SemResponsavelException e) {
                       System.out.println(e.getMessage());
                   } catch (HorarioInvalidoException e) {
                       System.out.println(e.getMessage());
                   } catch (OrdemTarefaException e) {
                       System.out.println(e.getMessage());
                   }

                   break;
                }
                case 2 -> {
                    System.out.println("Digite o código da Execução que deseja alterar:");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    // busca em todos os eventos
                    ExecucaoTarefa encontrada = null;
                    for (Evento ev : empresa.getEvento()) {
                        for (ExecucaoTarefa ex : ev.getExecucao()) {
                            if (ex.getCodigo() == codigo) {
                                encontrada = ex;
                                break;
                            }
                        }
                        if (encontrada != null) break;
                    }

                    if (encontrada != null) {

                        // alterar colaborador
                        System.out.println("Digite o código do novo Colaborador:");
                        int codigoColab = scanner.nextInt();
                        scanner.nextLine();

                        Colaborador novoColab = null;
                        for (Colaborador c : empresa.getColaborador()) {
                            if (c.getCodigo() == codigoColab) {
                                novoColab = c;
                                break;
                            }
                        }

                        if (novoColab != null) {
                            encontrada.updateColaborador(novoColab);
                            System.out.println("Colaborador atualizado!");
                        } else {
                            System.out.println("Erro: Colaborador não encontrado!");
                        }

                        // alterar quantidade e recurso
                        System.out.println("Digite o código do novo Recurso:");
                        int codigoRecurso = scanner.nextInt();
                        scanner.nextLine();

                        Recurso novoRecurso = null;
                        for (Recurso r : empresa.getRecurso().keySet()) {
                            if (r.getCodigo() == codigoRecurso) {
                                novoRecurso = r;
                                break;
                            }
                        }

                        if (novoRecurso != null) {
                            System.out.println("Digite a nova quantidade:");
                            int novaQuantidade = scanner.nextInt();
                            scanner.nextLine();

                            encontrada.getQuantidade().updateRecurso(novoRecurso);
                            encontrada.getQuantidade().updateQuantidade(novaQuantidade);
                            System.out.println("Recurso e quantidade atualizados!");
                        } else {
                            System.out.println("Erro: Recurso não encontrado!");
                        }

                    } else {
                        System.out.println("Erro: Execução não encontrada!");
                    }
                    break;
                }
                case 3 -> {
                    boolean temExecucao = false;
                            
                    for (Evento ev : empresa.getEvento()) {
                        for (ExecucaoTarefa ex : ev.getExecucao()) {
                            System.out.println("Evento: " + ev.getNome());
                            System.out.println(ex);
                            temExecucao = true;
                        }
                    }
                    
                    if (!temExecucao) {
                        System.out.println("Não há execuções cadastradas!");
                    }
                    break;

                }
                case 4 -> {
                    System.out.println("Digite o nome da execução que você deseja excluir: ");
                    int codigo = scanner.nextInt();
                    scanner.nextLine();

                    ExecucaoTarefa encontrado = null;
                    Evento eventoDonoDA = null;

                    for (Evento ev : empresa.getEvento()) {
                        for (ExecucaoTarefa ex : ev.getExecucao()) {
                            if (ex.getCodigo() == codigo) {
                                encontrado = ex;
                                eventoDonoDA = ev; // guarda o evento pai!
                                break;
                            }
                        }
                        if (encontrado != null) break;
                    }


                    if (encontrado != null) {
                        eventoDonoDA.removeExecucao(encontrado);
                        System.out.println("Codigo excluido!");
                    } else {
                        System.out.println("Erro: Codigo não encontrado!");
                    }
                    break;
                }
                case 5 -> {
                    boolean temExecucao = false;
                            
                    System.out.println("Digite o código da execução: ");

                    
                    String getExecucao = scanner.nextLine();
                    
                    for (Evento ev : empresa.getEvento()) {
                        for (ExecucaoTarefa ex : ev.getExecucao()) {
                            try{
                                int pesquisaCodigo = Integer.parseInt(getExecucao);
                                if(ex.getCodigo() == pesquisaCodigo) {
                                    System.out.println(ex);
                                    temExecucao = true;
                                }
                
                            } catch (NumberFormatException e){
                                System.out.println("Não há execuções com esse parâmetro! ");
                                temExecucao = true;
                                break;
                            }   
                        }
                    }
                    
                    if (!temExecucao) {
                        System.out.println("Não há execuções com esse parâmetro! !");
                    }
                    break;
                }
                case 9 -> {
                    System.out.println("Voltando ao Menu de Entidades...");
                    return;
                }
                default -> System.out.println("Erro: Opção inválida!"); 
            }
        }
    }      

    public static Colaborador procurar_Colaborador(String nome_busca){

        int codigo_busca;

        Colaborador encontrado = null;
        try{
            codigo_busca = Integer.parseInt(nome_busca);
            for(Colaborador c : empresa.getColaborador()) {
                if (c.getCodigo() == codigo_busca || c.getNome().equals(nome_busca)) {
                    encontrado = c;
                    break;
                }
            }
        } catch (NumberFormatException e){
            for(Colaborador c : empresa.getColaborador()) {
                if (c.getNome().equals(nome_busca)) {
                    encontrado = c;
                    break;
                }
            }
        }

        return encontrado;
    }

    public static Evento procurar_Evento(String nome_busca){

        int codigo_busca;

        Evento encontrado = null;
        try{
            codigo_busca = Integer.parseInt(nome_busca);
            for(Evento e : empresa.getEvento()) {
                if (e.getCodigo() == codigo_busca || e.getNome().equals(nome_busca)) {
                    encontrado = e;
                    break;
                }
            }
        } catch (NumberFormatException er){
            for(Evento e : empresa.getEvento()) {
                if (e.getNome().equals(nome_busca)) {
                    encontrado = e;
                    break;
                }
            }
        }

        return encontrado;
    }

    public static Tarefa procurar_Tarefa(String nome_busca){

        int codigo_busca;

        Tarefa encontrado = null;
        try{
            codigo_busca = Integer.parseInt(nome_busca);
            for(Tarefa t : empresa.getTarefa()) {
                if (t.getCodigo() == codigo_busca || t.getNome().equals(nome_busca)) {
                    encontrado = t;
                    break;
                }
            }
        } catch (NumberFormatException e){
            for(Tarefa t : empresa.getTarefa()) {
                if (t.getNome().equals(nome_busca)) {
                    encontrado = t;
                    break;
                }
            }
        }

        return encontrado;
    }

    public static Recurso procurar_Recurso(String nome_busca){

        Recurso encontrado = null;

        int codigo_busca;

        try{

            codigo_busca = Integer.parseInt(nome_busca);

            for (Map.Entry<Recurso, Integer> c : empresa.getEstoque().getRecurso().entrySet()) {
       
                if(c.getKey().getNome().contains(nome_busca) || c.getKey().getCodigo() == codigo_busca) {
                    System.out.println("Codigo: " + c.getKey().getCodigo() + "; Nome: " + c.getKey().getNome() + "; Quantidade: " + c.getValue() + ".");
                    encontrado = c.getKey();
                }
            }

        } catch (NumberFormatException e){

            for (Map.Entry<Recurso, Integer> c : empresa.getEstoque().getRecurso().entrySet()) {
       
                if(c.getKey().getNome().contains(nome_busca)) {
                    System.out.println("Codigo: " + c.getKey().getCodigo() + "; Nome: " + c.getKey().getNome() + "; Quantidade: " + c.getValue() + ".");
                    encontrado = c.getKey();
                }
            }
        }
        return encontrado;
    }

}

            // System.out.println("-----------------------------------");
            // System.out.println("Selecione a acão desejada:");
            // System.out.println("-----------------------------------");
            // System.out.println("1 - Criar");
            // System.out.println("2 - Alterar");
            // System.out.println("3 - Listar");
            // System.out.println("4 - Executar");
            // System.out.println("5 - Controlar Estoque");
            // System.out.println("6 - Excluir");
            // System.out.println("7 - Consulta");
            // System.out.println("9 - Sair");
            // System.out.println("-----------------------------------");

            // switch (selecao) {
            //     case 1: {
            //         System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja criar:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Criar Colaborador");
            //         System.out.println("2 - Criar Evento");
            //         System.out.println("3 - Criar Tarefa");
            //         System.out.println("4 - Criar Recurso");
            //         System.out.println("5 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }

            //             case 2: {
            //                 System.out.println("Código do Evento:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();
            //                 System.out.println("Nome do Evento:");
            //                 String nome = scanner.nextLine();
            //                 System.out.println("Número de passos totais do Evento:");
            //                 int passosTotais = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Evento e = new Evento(codigo, nome, passosTotais);
            //                 empresa.addEvento(e);
            //                 System.out.println("Evento criado com sucesso!");
            //                 break;
            //             }
            //             case 3: {
            //                 System.out.println("Código da Tarefa:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();
            //                 System.out.println("Nome da Tarefa:");
            //                 String nome = scanner.nextLine();
            //                 System.out.println("Descrição da Tarefa:");
            //                 String descricao = scanner.nextLine();

            //                 Tarefa t = new Tarefa(codigo, nome, descricao);
            //                 empresa.addTarefa(t);
            //                 System.out.println("Tarefa criada com sucesso!");
            //                 break;
            //             }
            //             case 4: {
            //                 System.out.println("Código do Recurso:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();
            //                 System.out.println("Nome do Recurso:");
            //                 String nome = scanner.nextLine();
            //                 System.out.println("Quantidade:");
            //                 int quantidade = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Recurso r = new Recurso(codigo, nome);
            //                 empresa.addRecurso(r, quantidade);
            //                 System.out.println("Recurso criado com sucesso!");
            //                 break;
            //             }
            //             case 5: {
            //                 continue menuPrincipal;
            //             }
            //         }
            //         break;
            //     }
            //     case 2: {
            //         System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja Alterar:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Alterar Colaborador");
            //         System.out.println("2 - Alterar Evento");
            //         System.out.println("3 - Alterar Tarefa");
            //         System.out.println("4 - Alterar Recurso");
            //         System.out.println("5 - Alterar Execução");
            //         System.out.println("6 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }
   
            //             }
            //             case 2: {
            //                 System.out.println("Digite o código do evento você deseja alterar: ");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Evento encontrado = null;
            //                 for (Evento e : empresa.getEvento()) {
            //                     if (e.getCodigo() == codigo) {
            //                         encontrado = e;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     System.out.println("Novo nome:");
            //                     String nome = scanner.nextLine();
                                
            //                     encontrado.updateNome(nome);
            //                     System.out.println("Evento alterado com sucesso!");
            //                 } else {
            //                     System.out.println("Erro: Evento não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 3: {
            //                 System.out.println("Digite o código da tarefa você deseja alterar: ");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Tarefa encontrado = null;
            //                 for (Tarefa t : empresa.getTarefa()) {
            //                     if (t.getCodigo() == codigo) {
            //                         encontrado = t;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     System.out.println("Novo nome:");
            //                     String nome = scanner.nextLine();
            //                     System.out.println("Nova descricao:");
            //                     String descricao = scanner.nextLine();

            //                     encontrado.updateNome(nome);
            //                     encontrado.updateDescricao(descricao);
            //                     System.out.println("Tarefa alterada com sucesso!");
            //                 } else {
            //                     System.out.println("Erro: Tarefa não encontrada!");
            //                 }
            //                 break;
            //             }
            //             case 4: {
            //                 System.out.println("Digite o código do recurso você deseja alterar: ");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Recurso encontrado = null;
            //                 for (Recurso r : empresa.getRecurso().keySet()) {
            //                     if (r.getCodigo() == codigo) {
            //                         encontrado = r;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     System.out.println("Novo nome do Recurso:");
            //                     String nome = scanner.nextLine();
                                
            //                     encontrado.updateNome(nome);
            //                     System.out.println("Recurso alterado com sucesso!");
            //                 } else {
            //                     System.out.println("Erro: Recurso não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 5: {
            //                 System.out.println("Digite o código da Execução que deseja alterar:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();

            //                 // busca em todos os eventos
            //                 ExecucaoTarefa encontrada = null;
            //                 for (Evento ev : empresa.getEvento()) {
            //                     for (ExecucaoTarefa ex : ev.getExecucao()) {
            //                         if (ex.getCodigo() == codigo) {
            //                             encontrada = ex;
            //                             break;
            //                         }
            //                     }
            //                     if (encontrada != null) break;
            //                 }

            //                 if (encontrada != null) {

            //                     // alterar colaborador
            //                     System.out.println("Digite o código do novo Colaborador:");
            //                     int codigoColab = scanner.nextInt();
            //                     scanner.nextLine();

            //                     Colaborador novoColab = null;
            //                     for (Colaborador c : empresa.getColaborador()) {
            //                         if (c.getCodigo() == codigoColab) {
            //                             novoColab = c;
            //                             break;
            //                         }
            //                     }

            //                     if (novoColab != null) {
            //                         encontrada.updateColaborador(novoColab);
            //                         System.out.println("Colaborador atualizado!");
            //                     } else {
            //                         System.out.println("Erro: Colaborador não encontrado!");
            //                     }

            //                     // alterar quantidade e recurso
            //                     System.out.println("Digite o código do novo Recurso:");
            //                     int codigoRecurso = scanner.nextInt();
            //                     scanner.nextLine();

            //                     Recurso novoRecurso = null;
            //                     for (Recurso r : empresa.getRecurso().keySet()) {
            //                         if (r.getCodigo() == codigoRecurso) {
            //                             novoRecurso = r;
            //                             break;
            //                         }
            //                     }

            //                     if (novoRecurso != null) {
            //                         System.out.println("Digite a nova quantidade:");
            //                         int novaQuantidade = scanner.nextInt();
            //                         scanner.nextLine();

            //                         encontrada.getQuantidade().updateRecurso(novoRecurso);
            //                         encontrada.getQuantidade().updateQuantidade(novaQuantidade);
            //                         System.out.println("Recurso e quantidade atualizados!");
            //                     } else {
            //                         System.out.println("Erro: Recurso não encontrado!");
            //                     }

            //                 } else {
            //                     System.out.println("Erro: Execução não encontrada!");
            //                 }
            //                 break;
            //             }
            //             case 6: {
            //                 continue menuPrincipal;
            //             }
            //         }
            //         break;
            //     }
            //     case 3: {
            //         System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja listar:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Listar Colaboradores");
            //         System.out.println("2 - Listar Eventos");
            //         System.out.println("3 - Listar Tarefas");
            //         System.out.println("4 - Listar Recursos");
            //         System.out.println("5 - Listar Execuções");
            //         System.out.println("6 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }

            //         switch (selecao) {
            //             case 1:
            //                 boolean temColaborador = false;

            //                 for (Colaborador c : empresa.getColaborador()) {
            //                     System.out.println(c);
            //                     temColaborador = true;
            //                 }

            //                 if (!temColaborador) {
            //                     System.out.println("Não há colaboradores cadastrados!");
            //                 }
            //                 break;
            //             case 2:
            //                 boolean temEvento = false;

            //                 for (Evento e : empresa.getEvento()) {
            //                     System.out.println(e);
            //                     temEvento = true;
            //                 }

            //                 if (!temEvento) {
            //                     System.out.println("Não há eventos cadastrados!");
            //                 }
            //                 break;
            //             case 3:
            //                 boolean temTarefa = false;

            //                 for (Tarefa t : empresa.getTarefa()) {
            //                     System.out.println(t);
            //                     temTarefa = true;
            //                 }

            //                 if (!temTarefa) {
            //                     System.out.println("Não há tarefas cadastradas!");
            //                 }
            //                 break;
            //             case 4:
            //                 boolean temRecurso = false;

            //                 for (Recurso r : empresa.getRecurso().keySet()) {
            //                     System.out.println(r + "; Quantidade: " + empresa.getRecurso().get(r));
            //                     temRecurso = true;
            //                 }

            //                 if (!temRecurso) {
            //                     System.out.println("Não há recursos cadastrados!");
            //                 }
            //                 break;
            //             case 5: 
            //                 boolean temExecucao = false;
                            
            //                 for (Evento ev : empresa.getEvento()) {
            //                     for (ExecucaoTarefa ex : ev.getExecucao()) {
            //                         System.out.println("Evento: " + ev.getNome());
            //                         System.out.println(ex);
            //                         temExecucao = true;
            //                     }
            //                 }
                            
            //                 if (!temExecucao) {
            //                     System.out.println("Não há execuções cadastradas!");
            //                 }
            //                 break;
            //             case 6: 
            //                 continue menuPrincipal;
            //         }
            //         break;
            //     }
            //     case 4: {
	        //        	 System.out.println("-----------------------------------");
	        //  	    System.out.println("EXECUÇÃO DE TAREFA");
	        //  	    System.out.println("-----------------------------------");
	
	        //  	    // selecionar evento
	        //  	    System.out.println("Digite o nome do Evento:");
	        //  	    String codEvento = scanner.nextLine();
	
	        //  	    Evento eventoSelecionado = null;
	        //  	    for (Evento e : empresa.getEvento()) {
	        //  	        if (e.getNome().equals(codEvento)) {
	        //  	            eventoSelecionado = e;
	        //  	            break;
	        //  	        }
	        //  	    }
	
	        //  	    if (eventoSelecionado == null) {
	        //  	        System.out.println("Erro: Evento não encontrado!");
	        //  	        break;
	        //  	    }
	
	        //  	    // selecionar tarefa
	        //  	    System.out.println("Digite o nome da Tarefa:");
	        //  	    String codTarefa = scanner.nextLine();
	
	        //  	    Tarefa tarefaSelecionada = null;
	        //  	    for (Tarefa t : empresa.getTarefa()) {
	        //  	        if (t.getNome().equals(codTarefa)) {
	        //  	            tarefaSelecionada = t;
	        //  	            break;
	        //  	        }
	        //  	    }
	
	        //  	    if (tarefaSelecionada == null) {
	        //  	        System.out.println("Erro: Tarefa não encontrada!");
	        //  	        break;
	        //  	    }
	
	        //  	    // selecionar colaborador
	        //  	    System.out.println("Digite o nome do Colaborador:");
	        //  	    String codColab = scanner.nextLine();
	
	        //  	    Colaborador colaboradorSelecionado = null;
	        //  	    for (Colaborador c : empresa.getColaborador()) {
	        //  	        if (c.getNome().equals(codColab)) {
	        //  	            colaboradorSelecionado = c;
	        //  	            break;
	        //  	        }
	        //  	    }
	
	        //  	    if (colaboradorSelecionado == null) {
	        //  	        System.out.println("Erro: Colaborador não encontrado!");
	        //  	        break;
	        //  	    }
	
	        //  	    // selecionar recurso
	        //  	    System.out.println("Digite o nome do Recurso:");
	        //  	    String codRecurso = scanner.nextLine();
	
	        //  	    Recurso recursoSelecionado = null;
	        //  	    for (Recurso r : empresa.getRecurso().keySet()) {
	        //  	        if (r.getNome().equals(codRecurso)) {
	        //  	            recursoSelecionado = r;
	        //  	            break;
	        //  	        }
	        //  	    }
	
	        //  	    if (recursoSelecionado == null) {
	        //  	        System.out.println("Erro: Recurso não encontrado!");
	        //  	        break;
	        //  	    }
	
	        //  	    // quantidade
	        //  	    System.out.println("Digite a quantidade do recurso:");
	        //  	    int quantidade = scanner.nextInt();
	        //  	    scanner.nextLine();
	
	        //  	    if (quantidade <= 0) {
	        //  	        System.out.println("Erro: Quantidade inválida!");
	        //  	        break;
	        //  	    }
	
	        //  	    // leitura e conversão de datas
	        //  	    System.out.println("Digite a data de início (dd/MM/yyyy HH:mm):");
	        //  	    String inicioStr = scanner.nextLine();
	
	        //  	    System.out.println("Digite a data de fim (dd/MM/yyyy HH:mm):");
	        //  	    String fimStr = scanner.nextLine();
	
	        //  	    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	
	        //  	    Date inicio = null;
	        //  	    Date fim = null;
	
	        //  	    try {
	        //  	        inicio = sdf.parse(inicioStr);
	        //  	        fim = sdf.parse(fimStr);
	        //  	    } catch (Exception e) {
	        //  	        System.out.println("Erro ao converter datas!");
	        //  	        break;
	        //  	    }
	         	    
	        //  	   try {
            //            ExecucaoTarefa execucao = eventoSelecionado.criarExecucao(
            //                empresa,
            //                tarefaSelecionada,
            //                colaboradorSelecionado,
            //                recursoSelecionado,
            //                quantidade,
            //                inicio,
            //                fim
            //            );
                       
            //            System.out.println("Execução criada com sucesso!");
            //            System.out.println(execucao);
            //        } catch (QuantidadeInvalidaException e) {
            //            System.out.println(e.getMessage());
            //        } catch (SemResponsavelException e) {
            //            System.out.println(e.getMessage());
            //        } catch (HorarioInvalidoException e) {
            //            System.out.println(e.getMessage());
            //        } catch (OrdemTarefaException e) {
            //            System.out.println(e.getMessage());
            //        }

            //        break;
            //    }

            //     case 5: {
            //         System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja fazer:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Aumentar Quantidade de Recurso");
            //         System.out.println("2 - Diminuir Quantidade de Recurso");
            //         System.out.println("3 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }

            //         switch (selecao) {
            //             case 1: {
            //                 System.out.println("Digite o código do recurso:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();
            //                 System.out.println("Digite a quantidade a adicionar:");
            //                 int quantidade = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Recurso encontrado = null;
            //                 for (Recurso r : empresa.getRecurso().keySet()){
            //                     if (r.getCodigo() == codigo) {
            //                         encontrado = r;
            //                         break;
            //                     }
            //                 }

            //                 if(encontrado != null) {
            //                     empresa.addRecurso(encontrado, quantidade);
            //                     System.out.println("Estoque aumentado!");
            //                 } else {
            //                     System.out.println("Recurso não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 2: {
            //                 System.out.println("Digite o código do recurso:");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();
            //                 System.out.println("Digite a quantidade a remover:");
            //                 int quantidade = scanner.nextInt();
            //                 scanner.nextLine();

            //                 Recurso encontrado = null;
            //                 for (Recurso r : empresa.getRecurso().keySet()){
            //                     if (r.getCodigo() == codigo) {
            //                         encontrado = r;
            //                         break;
            //                     }
            //                 }

            //                 if(encontrado != null) {
            //                     empresa.removeRecurso(encontrado, quantidade);
            //                     System.out.println("Estoque diminuido!");
            //                 } else {
            //                     System.out.println("Recurso não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 3: 
            //                 continue menuPrincipal;
            //         }
            //         break;
            //     }

            //     case 6: {
            //         System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja excluir:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Excluir Colaborador");
            //         System.out.println("2 - Excluir Evento");
            //         System.out.println("3 - Excluir Tarefa");
            //         System.out.println("4 - Excluir Recurso");
            //         System.out.println("5 - Excluir Execução");
            //         System.out.println("6 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }

            //         switch (selecao) {
            //             case 1: {
                        	
            //                 System.out.println("Digite o nome do colaborador você deseja excluir: ");
            //                 String nome = scanner.nextLine();

            //                 Colaborador encontrado = null;
            //                 for (Colaborador c : empresa.getColaborador()) {
            //                     if (c.getNome().equals(nome)) {
            //                         encontrado = c;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     empresa.removeColaborador(encontrado);
            //                     System.out.println("Colaborador excluido!");
            //                 } else {
            //                     System.out.println("Erro: Colaborador não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 2: {
            //                 System.out.println("Digite o nome do evento você deseja excluir: ");
                            
            //                 String nome = scanner.nextLine();

            //                 Evento encontrado = null;
            //                 for (Evento ev : empresa.getEvento()) {
            //                     if (ev.getNome().equals(nome)) {
            //                         encontrado = ev;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     empresa.removeEvento(encontrado);
            //                     System.out.println("Evento excluido!");
            //                 } else {
            //                     System.out.println("Erro: Evento não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 3: {
            //                 System.out.println("Digite o nome da tarefa você deseja excluir: ");
                            
            //                 String nome = scanner.nextLine();

            //                 Tarefa encontrado = null;
            //                 for (Tarefa t : empresa.getTarefa()) {
            //                     if (t.getNome().equals(nome)) {
            //                         encontrado = t;
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     empresa.removeTarefa(encontrado);
            //                     System.out.println("Tarefa excluida!");
            //                 } else {
            //                     System.out.println("Erro: Tarefa não encontrada!");
            //                 }
            //                 break;
            //             }
            //             case 4: {
                        	
            //                 System.out.println("Digite o nome do recurso você deseja excluir: ");
            //                 String nome = scanner.nextLine();

            //                 Recurso encontrado = null;
            //                 for (Map.Entry<Recurso, Integer> r : empresa.getEstoque().getRecurso().entrySet()) {
            //                     if (r.getKey().getNome().equals(nome)) {
            //                         encontrado = r.getKey();
            //                         break;
            //                     }
            //                 }

            //                 if (encontrado != null) {
            //                     empresa.removeRecurso(encontrado, 0);
            //                     System.out.println("Recurso excluido!");
            //                 } else {
            //                     System.out.println("Erro: Recurso não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 5: {
            //                 System.out.println("Digite o nome da execução que você deseja excluir: ");
            //                 int codigo = scanner.nextInt();
            //                 scanner.nextLine();

            //                 ExecucaoTarefa encontrado = null;
            //                 Evento eventoDonoDA = null;

            //                 for (Evento ev : empresa.getEvento()) {
            //                     for (ExecucaoTarefa ex : ev.getExecucao()) {
            //                         if (ex.getCodigo() == codigo) {
            //                             encontrado = ex;
            //                             eventoDonoDA = ev; // guarda o evento pai!
            //                             break;
            //                         }
            //                     }
            //                     if (encontrado != null) break;
            //                 }


            //                 if (encontrado != null) {
            //                     eventoDonoDA.removeExecucao(encontrado);
            //                     System.out.println("Codigo excluido!");
            //                 } else {
            //                     System.out.println("Erro: Codigo não encontrado!");
            //                 }
            //                 break;
            //             }
            //             case 6: {
            //                 continue menuPrincipal;
            //             }
            //         }
            //         break;
            //     }
            //     case 7:{
            //     	System.out.println("-----------------------------------");

            //         System.out.println("Selecione o que você deseja consultar:");

            //         System.out.println("-----------------------------------");

            //         System.out.println("1 - Consultar Colaboradores");
            //         System.out.println("2 - Consultar Eventos");
            //         System.out.println("3 - Consultar Tarefas");
            //         System.out.println("4 - Consultar Recursos");
            //         System.out.println("5 - Consultar Execuções");
            //         System.out.println("6 - Voltar");

            //         System.out.println("-----------------------------------");

            //         try{
            //             selecao = scanner.nextInt();
            //             scanner.nextLine();
            //         } catch (InputMismatchException e){
            //             System.out.println("Erro: Você deve Digitar um Número");
            //             scanner.nextLine();
            //             continue;
            //         }

            //         String pesquisaString;
            //         int pesquisaCodigo;
            //         boolean conversao = false;
                    
            //         switch (selecao) {
            //             case 1:
                        	
            //                 boolean temColaborador = false;
                            
            //                 System.out.println("Digite o código ou o nome do colaborador: ");
            //                 pesquisaString = scanner.nextLine();
                            
            //                 for (Colaborador c : empresa.getColaborador()) {
       
            //                 	if(c.getNome().contains(pesquisaString)) {
            //                 		System.out.println(c);
            //                 		temColaborador = true;
            //                 	}
                                
            //                 }
                            
            //                 if(!temColaborador) {
                            	
            //                 	for (Colaborador c : empresa.getColaborador()) {
	        //                     	try{
	        //                     		pesquisaCodigo = Integer.parseInt(pesquisaString);
	        //                         	if(c.getCodigo() == pesquisaCodigo) {
	        //                         		System.out.println(c);
	        //                         		temColaborador = true;
	        //                         	}
	                  
	        //                     	} catch (NumberFormatException e){
	        //                     		System.out.println("Não há colaboradores com esse parâmetro! ");
	        //                     		temColaborador = true;
	        //                     		break;
	        //                     	}
            //                 	}
            //                 }
                            
            //                 if (!temColaborador) {
            //                     System.out.println("Não há colaboradores com esse parâmetro! ");
            //                 }
                            
            //                 break;
                            
            //             case 2:
                        	
                     
            //                 boolean temEvento = false;
                            
            //                 System.out.println("Digite o código ou o nome do evento: ");
            //                 pesquisaString = scanner.nextLine();
                            
            //                 conversao = false;
                            
            //             	try{
            //             		pesquisaCodigo = Integer.parseInt(pesquisaString);
            //             		conversao = true;
            //             	} catch (NumberFormatException e){} 
                        	
                        	
            //                 for (Evento c : empresa.getEvento()) {
       
            //                 	if(c.getNome().contains(pesquisaString)) {
            //                 		System.out.println(c);
            //                 		temEvento = true;
            //                 	}
                                
            //                     if(conversao && c.getCodigo() == Integer.parseInt(pesquisaString)) {
            //                     	System.out.println(c);
            //                     	temEvento = true;
            //                     }  
            //                 }
                            
            //                 if (!temEvento) {
            //                     System.out.println("Não há eventos com esse parâmetro! ");
            //                 }
                            
            //                 break;
            //             case 3:
                        	
                        	
            //                 boolean temTarefa = false;
                            
            //                 System.out.println("Digite o código ou o nome da tarefa: ");
                            
            //                 pesquisaString = scanner.nextLine();
                            
            //                 conversao = false;
                            
            //             	try{
            //             		pesquisaCodigo = Integer.parseInt(pesquisaString);
            //             		conversao = true;
            //             	} catch (NumberFormatException e){} 
                        	
                        	
            //                 for (Tarefa c : empresa.getTarefa()) {
       
            //                 	if(c.getNome().contains(pesquisaString)) {
            //                 		System.out.println(c);
            //                 		temTarefa = true;
            //                 	}
                                
            //                     if(conversao && c.getCodigo() == Integer.parseInt(pesquisaString)) {
            //                     	System.out.println(c);
            //                     	temTarefa = true;
            //                     }  
            //                 }
                            
            //                 if (!temTarefa) {
            //                     System.out.println("Não há tarefas com esse parâmetro! ");
            //                 }                            

                            
            //                 break;
            //             case 4:
                        	
            //                 boolean temRecurso = false;

            //                 System.out.println("Digite o código ou o nome do recurso: ");
                            
            //                 pesquisaString = scanner.nextLine();
                            
            //                 for (Map.Entry<Recurso, Integer> c : empresa.getEstoque().getRecurso().entrySet()) {
       
            //                 	if(c.getKey().getNome().contains(pesquisaString)) {
            //                 		System.out.println("Codigo: " + c.getKey().getCodigo() + "; Nome: " + c.getKey().getNome() + "; Quantidade: " + c.getValue() + ".");
            //                 		temRecurso = true;
            //                 	}
                                
            //                 	try{
            //                 		pesquisaCodigo = Integer.parseInt(pesquisaString);
            //                     	if(c.getKey().getCodigo() == pesquisaCodigo) {
            //                     		System.out.println("Codigo: " + c.getKey().getCodigo() + "; Nome: " + c.getKey().getNome() + "; Quantidade: " + c.getValue() + ".");
            //                     		temRecurso = true;
            //                     	}
                  
            //                 	} catch (NumberFormatException e){
            //                 		System.out.println("Não há recursos com esse parâmetro! ");
            //                 		temRecurso = true;
            //                 		break;
            //                 	}       
            //                 }
                            
            //                 if (!temRecurso) {
            //                     System.out.println("Não há recursos com esse parâmetro! ");
            //                 }  
                            
            //                 break;
            //             case 5: 
            //                 boolean temExecucao = false;
                            
            //                 System.out.println("Digite o código da execução: ");

                            
            //                 String getExecucao = scanner.nextLine();
                            
            //                 for (Evento ev : empresa.getEvento()) {
            //                     for (ExecucaoTarefa ex : ev.getExecucao()) {
            //                     	try{
            //                     		pesquisaCodigo = Integer.parseInt(getExecucao);
            //                         	if(ex.getCodigo() == pesquisaCodigo) {
            //                         		System.out.println(ex);
            //                         		temExecucao = true;
            //                         	}
                      
            //                     	} catch (NumberFormatException e){
            //                     		System.out.println("Não há execuções com esse parâmetro! ");
            //                     		temExecucao = true;
            //                     		break;
            //                     	}   
            //                     }
            //                 }
                            
            //                 if (!temExecucao) {
            //                     System.out.println("Não há execuções com esse parâmetro! !");
            //                 }
            //                 break;
                            
            //             case 6: 
            //                 continue menuPrincipal;
            //         }
            //         break
