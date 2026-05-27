import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

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
        menuPrincipal:
        while(true){
            
            System.out.println("-----------------------------------");

            System.out.println("Selecione a acão desejada:");

            System.out.println("-----------------------------------");
            
            System.out.println("1 - Criar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Listar");
            System.out.println("4 - Executar");
            System.out.println("5 - Controlar Estoque");
            System.out.println("6 - Excluir");

            System.out.println("-----------------------------------");
            
            try{
                selecao = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e){
                System.out.println("Erro: Você deve Digitar um Número");
                scanner.nextLine();
                continue;
            }

            switch (selecao) {
                case 1: {
                    System.out.println("-----------------------------------");

                    System.out.println("Selecione o que você deseja criar:");

                    System.out.println("-----------------------------------");

                    System.out.println("1 - Criar Colaborador");
                    System.out.println("2 - Criar Evento");
                    System.out.println("3 - Criar Tarefa");
                    System.out.println("4 - Criar Recurso");
                    System.out.println("5 - Voltar");

                    System.out.println("-----------------------------------");

                    try{
                        selecao = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você deve Digitar um Número");
                        scanner.nextLine();
                        continue;
                    }

                    switch (selecao) {
                        case 1: {
                            System.out.println("Código do Colaborador:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Nome do Colaborador:");
                            String nome = scanner.nextLine();
                            System.out.println("Funcao do Colaborador:");
                            String funcao = scanner.nextLine();
                            System.out.println("Usuario do Colaborador:");
                            String usuario = scanner.nextLine();
                            System.out.println("Senha do Colaborador:");
                            String senha = scanner.nextLine();
                            
                            Colaborador c = new Colaborador(codigo, nome, funcao, usuario, senha);
                            empresa.addColaborador(c);
                            System.out.println("Colaborador criado com sucesso!");
                            break;
                        }
                        case 2: {
                            System.out.println("Código do Evento:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Nome do Evento:");
                            String nome = scanner.nextLine();
                            System.out.println("Número de passos totais do Evento:");
                            int passosTotais = scanner.nextInt();
                            scanner.nextLine();

                            Evento e = new Evento(codigo, nome, passosTotais);
                            empresa.addEvento(e);
                            System.out.println("Evento criado com sucesso!");
                            break;
                        }
                        case 3: {
                            System.out.println("Código da Tarefa:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Nome da Tarefa:");
                            String nome = scanner.nextLine();
                            System.out.println("Descrição da Tarefa:");
                            String descricao = scanner.nextLine();

                            Tarefa t = new Tarefa(codigo, nome, descricao);
                            empresa.addTarefa(t);
                            System.out.println("Tarefa criada com sucesso!");
                            break;
                        }
                        case 4: {
                            System.out.println("Código do Recurso:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Nome do Recurso:");
                            String nome = scanner.nextLine();
                            System.out.println("Quantidade:");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            Recurso r = new Recurso(codigo, nome);
                            empresa.addRecurso(r, quantidade);
                            System.out.println("Recurso criado com sucesso!");
                            break;
                        }
                        case 5: {
                            continue menuPrincipal;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("-----------------------------------");

                    System.out.println("Selecione o que você deseja Alterar:");

                    System.out.println("-----------------------------------");

                    System.out.println("1 - Alterar Colaborador");
                    System.out.println("2 - Alterar Evento");
                    System.out.println("3 - Alterar Tarefa");
                    System.out.println("4 - Alterar Recurso");
                    System.out.println("5 - Alterar Execução");
                    System.out.println("6 - Voltar");

                    System.out.println("-----------------------------------");

                    try{
                        selecao = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você deve Digitar um Número");
                        scanner.nextLine();
                        continue;
                    }

                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o código do colaborador você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Colaborador encontrado = null;
                            for (Colaborador c : empresa.getColaborador()) {
                                if (c.getCodigo() == codigo) {
                                    encontrado = c;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                System.out.println("Novo nome:");
                                String nome = scanner.nextLine();
                                System.out.println("Nova função:");
                                String funcao = scanner.nextLine();
                                System.out.println("Novo usuário:");
                                String usuario = scanner.nextLine();
                                System.out.println("Nova senha:");
                                String senha = scanner.nextLine();
                                
                                encontrado.updateNome(nome);
                                encontrado.updateFuncao(funcao);
                                encontrado.updateUsuario(usuario);
                                encontrado.updateSenha(senha);
                                System.out.println("Colaborador alterado com sucesso!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código do evento você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Evento encontrado = null;
                            for (Evento e : empresa.getEvento()) {
                                if (e.getCodigo() == codigo) {
                                    encontrado = e;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                System.out.println("Novo nome:");
                                String nome = scanner.nextLine();
                                
                                encontrado.updateNome(nome);
                                System.out.println("Evento alterado com sucesso!");
                            } else {
                                System.out.println("Erro: Evento não encontrado!");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o código da tarefa você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Tarefa encontrado = null;
                            for (Tarefa t : empresa.getTarefa()) {
                                if (t.getCodigo() == codigo) {
                                    encontrado = t;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                System.out.println("Novo nome:");
                                String nome = scanner.nextLine();
                                System.out.println("Nova descricao:");
                                String descricao = scanner.nextLine();

                                encontrado.updateNome(nome);
                                encontrado.updateDescricao(descricao);
                                System.out.println("Tarefa alterada com sucesso!");
                            } else {
                                System.out.println("Erro: Tarefa não encontrada!");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o código do recurso você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Recurso encontrado = null;
                            for (Recurso r : empresa.getRecurso().keySet()) {
                                if (r.getCodigo() == codigo) {
                                    encontrado = r;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                System.out.println("Novo nome do Recurso:");
                                String nome = scanner.nextLine();
                                
                                encontrado.updateNome(nome);
                                System.out.println("Recurso alterado com sucesso!");
                            } else {
                                System.out.println("Erro: Recurso não encontrado!");
                            }
                            break;
                        }
                        case 5: {
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
                        case 6: {
                            continue menuPrincipal;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println("-----------------------------------");

                    System.out.println("Selecione o que você deseja listar:");

                    System.out.println("-----------------------------------");

                    System.out.println("1 - Listar Colaboradores");
                    System.out.println("2 - Listar Eventos");
                    System.out.println("3 - Listar Tarefas");
                    System.out.println("4 - Listar Recursos");
                    System.out.println("5 - Listar Execuções");
                    System.out.println("6 - Voltar");

                    System.out.println("-----------------------------------");

                    try{
                        selecao = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você deve Digitar um Número");
                        scanner.nextLine();
                        continue;
                    }

                    switch (selecao) {
                        case 1:
                            boolean temColaborador = false;

                            for (Colaborador c : empresa.getColaborador()) {
                                System.out.println(c);
                                temColaborador = true;
                            }

                            if (!temColaborador) {
                                System.out.println("Não há colaboradores cadastrados!");
                            }
                            break;
                        case 2:
                            boolean temEvento = false;

                            for (Evento e : empresa.getEvento()) {
                                System.out.println(e);
                                temEvento = true;
                            }

                            if (!temEvento) {
                                System.out.println("Não há eventos cadastrados!");
                            }
                            break;
                        case 3:
                            boolean temTarefa = false;

                            for (Tarefa t : empresa.getTarefa()) {
                                System.out.println(t);
                                temTarefa = true;
                            }

                            if (!temTarefa) {
                                System.out.println("Não há tarefas cadastradas!");
                            }
                            break;
                        case 4:
                            boolean temRecurso = false;

                            for (Recurso r : empresa.getRecurso().keySet()) {
                                System.out.println(r + "; Quantidade: " + empresa.getRecurso().get(r));
                                temRecurso = true;
                            }

                            if (!temRecurso) {
                                System.out.println("Não há recursos cadastrados!");
                            }
                            break;
                        case 5: 
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
                        case 6: 
                            continue menuPrincipal;
                    }
                    break;
                }
                case 4: {
                    System.out.println("-----------------------------------");
                    System.out.println("Executar Tarefa em Evento");
                    System.out.println("-----------------------------------");

                    // declara tudo aqui em cima!
                    Evento eventoEncontrado = null;
                    Tarefa tarefaEncontrada = null;
                    Colaborador colaboradorEncontrado = null;
                    Recurso recursoEncontrado = null;
                    int numero = 0;

                    System.out.println("Digite o código do Evento:");
                    int codigoEvento = scanner.nextInt();
                    scanner.nextLine();

                    for (Evento ev : empresa.getEvento()) {
                        if (ev.getCodigo() == codigoEvento) {
                            eventoEncontrado = ev;
                            break;
                        }
                    }
                    if (eventoEncontrado == null) { System.out.println("Erro: Evento não encontrado!"); break; }

                    System.out.println("Digite o código da Tarefa:");
                    int codigoTarefa = scanner.nextInt();
                    scanner.nextLine();

                    for (Tarefa t : empresa.getTarefa()) {
                        if (t.getCodigo() == codigoTarefa) {
                            tarefaEncontrada = t;
                            break;
                        }
                    }
                    if (tarefaEncontrada == null) { System.out.println("Erro: Tarefa não encontrada!"); break; }

                    System.out.println("Digite o código do Colaborador:");
                    int codigoColab = scanner.nextInt();
                    scanner.nextLine();

                    for (Colaborador c : empresa.getColaborador()) {
                        if (c.getCodigo() == codigoColab) {
                            colaboradorEncontrado = c;
                            break;
                        }
                    }
                    if (colaboradorEncontrado == null) { System.out.println("Erro: Colaborador não encontrado!"); break; }

                    System.out.println("Digite o código do Recurso:");
                    int codigoRecurso = scanner.nextInt();
                    scanner.nextLine();

                    for (Recurso r : empresa.getRecurso().keySet()) {
                        if (r.getCodigo() == codigoRecurso) {
                            recursoEncontrado = r;
                            break;
                        }
                    }
                    if (recursoEncontrado == null) { System.out.println("Erro: Recurso não encontrado!"); break; }

                    System.out.println("Digite a quantidade do Recurso:");
                    numero = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        ExecucaoTarefa execucao = eventoEncontrado.criarExecucao(
                            empresa,
                            tarefaEncontrada,
                            colaboradorEncontrado,
                            recursoEncontrado,
                            numero,
                            null,
                            null
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

                case 5: {
                    System.out.println("-----------------------------------");

                    System.out.println("Selecione o que você deseja fazer:");

                    System.out.println("-----------------------------------");

                    System.out.println("1 - Aumentar Quantidade de Recurso");
                    System.out.println("2 - Diminuir Quantidade de Recurso");
                    System.out.println("3 - Voltar");

                    System.out.println("-----------------------------------");

                    try{
                        selecao = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você deve Digitar um Número");
                        scanner.nextLine();
                        continue;
                    }

                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o código do recurso:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite a quantidade a adicionar:");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            Recurso encontrado = null;
                            for (Recurso r : empresa.getRecurso().keySet()){
                                if (r.getCodigo() == codigo) {
                                    encontrado = r;
                                    break;
                                }
                            }

                            if(encontrado != null) {
                                empresa.addRecurso(encontrado, quantidade);
                                System.out.println("Estoque aumentado!");
                            } else {
                                System.out.println("Recurso não encontrado!");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código do recurso:");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Digite a quantidade a remover:");
                            int quantidade = scanner.nextInt();
                            scanner.nextLine();

                            Recurso encontrado = null;
                            for (Recurso r : empresa.getRecurso().keySet()){
                                if (r.getCodigo() == codigo) {
                                    encontrado = r;
                                    break;
                                }
                            }

                            if(encontrado != null) {
                                empresa.removeRecurso(encontrado, quantidade);
                                System.out.println("Estoque diminuido!");
                            } else {
                                System.out.println("Recurso não encontrado!");
                            }
                            break;
                        }
                        case 3: 
                            continue menuPrincipal;
                    }
                    break;
                }

                case 6: {
                    System.out.println("-----------------------------------");

                    System.out.println("Selecione o que você deseja excluir:");

                    System.out.println("-----------------------------------");

                    System.out.println("1 - Excluir Colaborador");
                    System.out.println("2 - Excluir Evento");
                    System.out.println("3 - Excluir Tarefa");
                    System.out.println("4 - Excluir Recurso");
                    System.out.println("5 - Excluir Execução");
                    System.out.println("6 - Voltar");

                    System.out.println("-----------------------------------");

                    try{
                        selecao = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e){
                        System.out.println("Erro: Você deve Digitar um Número");
                        scanner.nextLine();
                        continue;
                    }

                    switch (selecao) {
                        case 1: {
                            System.out.println("Digite o código do colaborador você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Colaborador encontrado = null;
                            for (Colaborador c : empresa.getColaborador()) {
                                if (c.getCodigo() == codigo) {
                                    encontrado = c;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                empresa.removeColaborador(encontrado);
                                System.out.println("Colaborador excluido!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 2: {
                            System.out.println("Digite o código do evento você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Evento encontrado = null;
                            for (Evento ev : empresa.getEvento()) {
                                if (ev.getCodigo() == codigo) {
                                    encontrado = ev;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                empresa.removeEvento(encontrado);
                                System.out.println("Colaborador excluido!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 3: {
                            System.out.println("Digite o código da tarefa você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Tarefa encontrado = null;
                            for (Tarefa t : empresa.getTarefa()) {
                                if (t.getCodigo() == codigo) {
                                    encontrado = t;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                empresa.removeTarefa(encontrado);
                                System.out.println("Colaborador excluido!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 4: {
                            System.out.println("Digite o código do recurso você deseja alterar: ");
                            int codigo = scanner.nextInt();
                            scanner.nextLine();

                            Recurso encontrado = null;
                            for (Recurso r : empresa.getRecurso().keySet()) {
                                if (r.getCodigo() == codigo) {
                                    encontrado = r;
                                    break;
                                }
                            }

                            if (encontrado != null) {
                                empresa.removeRecurso(encontrado, 0);
                                System.out.println("Colaborador excluido!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 5: {
                            System.out.println("Digite o código do colaborador você deseja alterar: ");
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
                                System.out.println("Colaborador excluido!");
                            } else {
                                System.out.println("Erro: Colaborador não encontrado!");
                            }
                            break;
                        }
                        case 6: {
                            continue menuPrincipal;
                        }
                    }

                    break;
                }
            }
/*


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
    */
    
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
} 
