import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorUsuarios {
    // Usuarios é abstrata: a lista guarda tanto Administrador quanto Vendedor (polimorfismo).
    private List<Usuarios> usuarios = new ArrayList<>();

    // CREATE (Com validação de dados obrigatórios - Requisito TDE)
    public void cadastrar(Usuarios usuario) {
        if (usuario.getName() == null || usuario.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Nome do usuário é obrigatório!");
        }
        usuarios.add(usuario);
        System.out.println("✅ Usuário cadastrado com sucesso!");
    }

    // READ (Listar Todos)
    public List<Usuarios> listarTodos() {
        return usuarios;
    }

    // READ (Buscar por ID)
    public Optional<Usuarios> buscarPorId(int id) {
        return usuarios.stream().filter(u -> u.getId() == id).findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, String novoNome) {
        Optional<Usuarios> opt = buscarPorId(id);
        if (opt.isPresent()) {
            Usuarios u = opt.get();
            if (novoNome != null && !novoNome.trim().isEmpty()) u.setName(novoNome);
            System.out.println("✅ Dados do usuário atualizados com sucesso!");
            return true;
        }
        System.out.println("❌ Usuário não encontrado!");
        return false;
    }

    // DELETE
    public boolean remover(int id) {
        boolean removido = usuarios.removeIf(u -> u.getId() == id);
        if (removido) {
            System.out.println("✅ Usuário removido com sucesso!");
        } else {
            System.out.println("❌ Usuário não encontrado!");
        }
        return removido;
    }
}
