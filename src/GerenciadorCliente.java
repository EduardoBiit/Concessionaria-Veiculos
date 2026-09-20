import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorCliente {
    private List<Cliente> clientes = new ArrayList<>();

    // CREATE (Com validação de dados obrigatórios - Requisito TDE)
    public void cadastrar(Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome do cliente é obrigatório!");
        }
        if (cliente.getTelefone() == null || cliente.getTelefone().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Telefone do cliente é obrigatório!");
        }
        if (cliente.getEmail() == null || !cliente.getEmail().contains("@")) {
            throw new IllegalArgumentException("Erro: E-mail em formato inválido!");
        }
        clientes.add(cliente);
        System.out.println("✅ Cliente cadastrado com sucesso!");
    }

    // READ (Listar Todos)
    public List<Cliente> listarTodos() {
        return clientes;
    }

    // READ (Buscar por ID)
    public Optional<Cliente> buscarPorId(int id) {
        return clientes.stream().filter(c -> c.getId() == id).findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, String novoNome, String novoTelefone, String novoEmail, String novaClassificacao) {
        Optional<Cliente> opt = buscarPorId(id);
        if (opt.isPresent()) {
            Cliente c = opt.get();
            if (novoNome != null && !novoNome.trim().isEmpty()) c.setNome(novoNome);
            if (novoTelefone != null && !novoTelefone.trim().isEmpty()) c.setTelefone(novoTelefone);
            if (novoEmail != null && novoEmail.contains("@")) c.setEmail(novoEmail);
            if (novaClassificacao != null && !novaClassificacao.trim().isEmpty()) c.setClassificacao(novaClassificacao);
            System.out.println("✅ Dados do cliente atualizados com sucesso!");
            return true;
        }
        System.out.println("❌ Cliente não encontrado!");
        return false;
    }

    // DELETE
    public boolean remover(int id) {
        boolean removido = clientes.removeIf(c -> c.getId() == id);
        if (removido) {
            System.out.println("✅ Cliente removido com sucesso!");
        } else {
            System.out.println("❌ Cliente não encontrado!");
        }
        return removido;
    }
}
