import java.util.List;
import java.util.Optional;
import java.util.Scanner;

/**
 * Classe principal do CRM da Concessionaria de Veiculos (TDE - Parte 1).
 * Menu simples no terminal que usa os Gerenciadores ja prontos
 * (GerenciadorCliente, GerenciadorVeiculo, GerenciadorOportunidade, GerenciadorUsuarios).
 * Tudo em memoria, sem persistencia, conforme pedido na Parte 1.
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    static GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    static GerenciadorVeiculo gerenciadorVeiculo = new GerenciadorVeiculo();
    static GerenciadorOportunidade gerenciadorOportunidade = new GerenciadorOportunidade();
    static GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();

    static int idCliente = 1;
    static int idVeiculo = 1;
    static int idOportunidade = 1;
    static int idUsuario = 1;

    public static void main(String[] args) {
        carregarDadosDeExemplo();

        int opcao;
        do {
            System.out.println("\n===== CRM - CONCESSIONARIA DE VEICULOS =====");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Cadastrar veiculo");
            System.out.println("4. Listar veiculos");
            System.out.println("5. Cadastrar oportunidade");
            System.out.println("6. Listar oportunidades");
            System.out.println("7. Alterar status de uma oportunidade");
            System.out.println("8. Remover cliente");
            System.out.println("9. Cadastrar usuario (Administrador/Vendedor)");
            System.out.println("10. Listar usuarios");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");
            opcao = lerInteiro();

            switch (opcao) {
                case 1 -> cadastrarCliente();
                case 2 -> listarClientes();
                case 3 -> cadastrarVeiculo();
                case 4 -> listarVeiculos();
                case 5 -> cadastrarOportunidade();
                case 6 -> listarOportunidades();
                case 7 -> alterarStatusOportunidade();
                case 8 -> removerCliente();
                case 9 -> cadastrarUsuario();
                case 10 -> listarUsuarios();
                case 0 -> System.out.println("Encerrando...");
                default -> System.out.println("Opcao invalida!");
            }
        } while (opcao != 0);

        scanner.close();
    }

    /* ---------- CLIENTES ---------- */

    static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();
        System.out.print("Classificacao do lead (Frio/Morno/Quente): ");
        String classificacao = scanner.nextLine();

        try {
            Cliente cliente = new Cliente(idCliente, nome, telefone, email, classificacao);
            gerenciadorCliente.cadastrar(cliente);
            idCliente++;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void listarClientes() {
        List<Cliente> clientes = gerenciadorCliente.listarTodos();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        for (Cliente c : clientes) {
            System.out.println(c.getId() + " - " + c.getNome() + " - " + c.getTelefone()
                    + " - " + c.getEmail() + " - " + c.getClassificao());
        }
    }

    static void removerCliente() {
        System.out.print("ID do cliente a remover: ");
        int id = lerInteiro();
        gerenciadorCliente.remover(id);
    }

    /* ---------- VEICULOS ---------- */

    static void cadastrarVeiculo() {
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = lerInteiro();
        System.out.print("Cor: ");
        String cor = scanner.nextLine();
        System.out.print("Preco: ");
        int preco = lerInteiro();

        try {
            veiculo v = new veiculo(idVeiculo, modelo, ano, marca, cor, preco);
            gerenciadorVeiculo.cadastrar(v);
            idVeiculo++;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void listarVeiculos() {
        List<veiculo> veiculos = gerenciadorVeiculo.listarTodos();
        if (veiculos.isEmpty()) {
            System.out.println("Nenhum veiculo cadastrado.");
            return;
        }
        for (veiculo v : veiculos) {
            System.out.println(v.getId() + " - " + v.getModelo() + " - " + v.getMarca()
                    + " - " + v.getAno() + " - " + v.getCor() + " - " + v.getPreco());
        }
    }

    /* ---------- OPORTUNIDADES / FUNIL ---------- */

    static void cadastrarOportunidade() {
        listarClientes();
        System.out.print("ID do cliente vinculado: ");
        int clienteId = lerInteiro();

        if (gerenciadorCliente.buscarPorId(clienteId).isEmpty()) {
            System.out.println("Cliente nao encontrado!");
            return;
        }

        System.out.print("Veiculo de interesse: ");
        String veiculoDesejado = scanner.nextLine();
        System.out.print("Tipo (Venda/Test-drive): ");
        String tipo = scanner.nextLine();
        System.out.print("Valor estimado: ");
        int valor = lerInteiro();
        System.out.print("Data prevista (dd/mm/aaaa): ");
        String data = scanner.nextLine();

        try {
            Oportunidade oportunidade = new Oportunidade(idOportunidade, clienteId, veiculoDesejado, tipo, valor, data);
            gerenciadorOportunidade.cadastrar(oportunidade);
            idOportunidade++;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    static void listarOportunidades() {
        List<Oportunidade> oportunidades = gerenciadorOportunidade.listarTodos();
        if (oportunidades.isEmpty()) {
            System.out.println("Nenhuma oportunidade cadastrada.");
            return;
        }
        for (Oportunidade o : oportunidades) {
            System.out.println(o.getId() + " - Cliente " + o.getClienteId() + " - " + o.getVeiculo()
                    + " - " + o.getTipo() + " - R$" + o.getValorEstimado()
                    + " - Status: " + o.getStatus() + " - " + o.getDataPrevista());
        }
    }

    static void alterarStatusOportunidade() {
        System.out.print("ID da oportunidade: ");
        int id = lerInteiro();
        Optional<Oportunidade> opt = gerenciadorOportunidade.buscarPorId(id);

        if (opt.isEmpty()) {
            System.out.println("Oportunidade nao encontrada!");
            return;
        }

        System.out.println("Status atual: " + opt.get().getStatus());
        System.out.println("Escolha o novo status:");
        StatusOportunidade.Status[] status = StatusOportunidade.Status.values();
        for (int i = 0; i < status.length; i++) {
            System.out.println((i + 1) + " - " + status[i]);
        }
        System.out.print("Opcao: ");
        int escolha = lerInteiro();

        if (escolha < 1 || escolha > status.length) {
            System.out.println("Opcao invalida!");
            return;
        }

        // A regra de transicao do funil e validada dentro de Oportunidade.alterarStatus(),
        // por isso o status nunca e trocado direto aqui.
        gerenciadorOportunidade.alterarStatus(id, status[escolha - 1]);
    }

    /* ---------- USUARIOS ---------- */

    static void cadastrarUsuario() {
        System.out.print("Nome do usuario: ");
        String nome = scanner.nextLine();
        System.out.print("Perfil (1-Administrador / 2-Vendedor): ");
        int perfil = lerInteiro();

        Usuarios usuario = (perfil == 1)
                ? new Administrador(idUsuario, nome)
                : new Vendedor(idUsuario, nome);

        gerenciadorUsuarios.cadastrar(usuario);
        idUsuario++;
    }

    static void listarUsuarios() {
        List<Usuarios> usuarios = gerenciadorUsuarios.listarTodos();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
            return;
        }
        for (Usuarios u : usuarios) {
            String perfil = (u instanceof Administrador) ? "Administrador" : "Vendedor";
            System.out.print(u.getId() + " - " + u.getName() + " - " + perfil + " -> ");
            // Polimorfismo: cada perfil implementa VisualizarOportunidade() do seu jeito.
            u.VisualizarOportunidade();
        }
    }

    /* ---------- DADOS DE EXEMPLO ---------- */

    static void carregarDadosDeExemplo() {
        Cliente c1 = new Cliente(idCliente++, "Joao Silva", "(11) 91234-5678", "joao@email.com", "Quente");
        gerenciadorCliente.cadastrar(c1);

        veiculo v1 = new veiculo(idVeiculo++, "Onix", 2024, "Chevrolet", "Prata", 85000);
        gerenciadorVeiculo.cadastrar(v1);

        Oportunidade o1 = new Oportunidade(idOportunidade++, c1.getId(), v1.getModelo(), "Venda", 85000, "10/10/2026");
        gerenciadorOportunidade.cadastrar(o1);

        gerenciadorUsuarios.cadastrar(new Administrador(idUsuario++, "Ana"));
        gerenciadorUsuarios.cadastrar(new Vendedor(idUsuario++, "Carlos"));
    }

    /* ---------- LEITURA DE NUMEROS ---------- */

    static int lerInteiro() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.print("Digite um numero valido: ");
            }
        }
    }
}