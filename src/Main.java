void main() {
    System.out.println("===== TESTE DO CRUD - Concessionaria Veiculos =====");

    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    GerenciadorVeiculo gerenciadorVeiculo = new GerenciadorVeiculo();
    GerenciadorOportunidade gerenciadorOportunidade = new GerenciadorOportunidade();
    GerenciadorUsuarios gerenciadorUsuarios = new GerenciadorUsuarios();

    // ---------- CLIENTE ----------
    System.out.println("\n--- CLIENTE ---");
    Cliente cliente1 = new Cliente(1, "Joao Silva", "(11) 99999-0001", "joao@email.com", "VIP");
    gerenciadorCliente.cadastrar(cliente1);

    System.out.println("Listando clientes:");
    for (Cliente c : gerenciadorCliente.listarTodos()) {
        System.out.println("  #" + c.getId() + " " + c.getNome() + " - " + c.getTelefone() + " - " + c.getEmail() + " - " + c.getClassificao());
    }

    gerenciadorCliente.atualizar(1, "Joao Silva Junior", null, null, null);

    // ---------- VEICULO ----------
    System.out.println("\n--- VEICULO ---");
    veiculo veiculo1 = new veiculo(1, "Onix", 2023, "Chevrolet", "Prata", 85000);
    gerenciadorVeiculo.cadastrar(veiculo1);

    System.out.println("Listando veiculos:");
    for (veiculo v : gerenciadorVeiculo.listarTodos()) {
        System.out.println("  #" + v.getId() + " " + v.getMarca() + " " + v.getModelo() + " (" + v.getAno() + ") - " + v.getCor() + " - R$" + v.getPreco());
    }

    gerenciadorVeiculo.atualizar(1, null, null, null, "Branco", 82000);

    // ---------- OPORTUNIDADE ----------
    System.out.println("\n--- OPORTUNIDADE ---");
    Oportunidade oportunidade1 = new Oportunidade(1, cliente1.getId(), "Onix", "Venda", 82000, "2026-10-15");
    gerenciadorOportunidade.cadastrar(oportunidade1);

    System.out.println("Status inicial: " + oportunidade1.getStatus());
    gerenciadorOportunidade.alterarStatus(1, StatusOportunidade.Status.CONTATO_REALIZADO);
    gerenciadorOportunidade.alterarStatus(1, StatusOportunidade.Status.TEST_DRIVE);
    System.out.println("Status apos avancar no funil: " + oportunidade1.getStatus());

    System.out.println("Listando oportunidades:");
    for (Oportunidade o : gerenciadorOportunidade.listarTodos()) {
        System.out.println("  #" + o.getId() + " cliente=" + o.getClienteId() + " veiculo=" + o.getVeiculo() + " status=" + o.getStatus() + " valor=R$" + o.getValorEstimado());
    }

    // ---------- USUARIOS ----------
    System.out.println("\n--- USUARIOS ---");
    Administrador admin1 = new Administrador(1, "Maria Admin");
    Vendedor vendedor1 = new Vendedor(2, "Pedro Vendedor");
    gerenciadorUsuarios.cadastrar(admin1);
    gerenciadorUsuarios.cadastrar(vendedor1);

    System.out.println("Listando usuarios:");
    for (Usuarios u : gerenciadorUsuarios.listarTodos()) {
        System.out.println("  #" + u.getId() + " " + u.getName() + " (" + u.getClass().getSimpleName() + ")");
        u.VisualizarOportunidade();
    }

    // ---------- DELETE ----------
    System.out.println("\n--- REMOVENDO REGISTROS ---");
    gerenciadorCliente.remover(1);
    gerenciadorVeiculo.remover(1);
    gerenciadorOportunidade.remover(1);
    gerenciadorUsuarios.remover(2);

    System.out.println("\n--- VALIDACAO: tentando cadastrar cliente sem nome (deve dar erro) ---");
    try {
        gerenciadorCliente.cadastrar(new Cliente(2, "", "(11) 90000-0000", "semnome@email.com", "Regular"));
    } catch (IllegalArgumentException e) {
        System.out.println("Erro capturado como esperado: " + e.getMessage());
    }

    System.out.println("\n===== FIM DO TESTE =====");
}
