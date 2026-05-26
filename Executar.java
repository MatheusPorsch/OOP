import java.util.Scanner;

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

        empresa.addRecurso(new Recurso(), 5);
        empresa.addRecurso(new Recurso(), 10);

        System.out.println("-----------------------------------");
        System.out.println(empresa);
        System.out.println("-----------------------------------");
        scanner.close();

    }
    
}
