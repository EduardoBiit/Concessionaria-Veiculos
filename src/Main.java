import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int escolha = 0;
        Scanner scanner = new Scanner(System.in);

        Usuarios Vendendor = new Vendedor(01, "Davi");
        Usuarios Administrador = new Administrador(02, "Eduardo");

        Vendendor.VisualizarOportunidade();
        Administrador.VisualizarOportunidade();

        do {
            System.out.println("==== MENU ====");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Cadastrar Oportunidade");
            System.out.println("5. Listar Oportunidades (Funil Vendas)");
            System.out.println("6. Avançar Status da Oportunidade");
            System.out.println("7. Remover Oportunidade");
            System.out.println("0. Sair");
            System.out.println("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {

            }

        } while (escolha != 6);
    }
}