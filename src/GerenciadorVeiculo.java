import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorVeiculo {
    private List<veiculo> veiculos = new ArrayList<>();

    // CREATE (Com validação de dados obrigatórios - Requisito TDE)
    public void cadastrar(veiculo veiculo) {
        if (veiculo.getModelo() == null || veiculo.getModelo().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Modelo do veículo é obrigatório!");
        }
        if (veiculo.getMarca() == null || veiculo.getMarca().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Marca do veículo é obrigatória!");
        }
        if (veiculo.getAno() < 1900 || veiculo.getAno() > 2100) {
            throw new IllegalArgumentException("Erro: Ano do veículo é inválido!");
        }
        if (veiculo.getPreco() <= 0) {
            throw new IllegalArgumentException("Erro: Preço do veículo deve ser maior que zero!");
        }
        veiculos.add(veiculo);
        System.out.println("✅ Veículo cadastrado com sucesso!");
    }

    // READ (Listar Todos)
    public List<veiculo> listarTodos() {
        return veiculos;
    }

    // READ (Buscar por ID)
    public Optional<veiculo> buscarPorId(int id) {
        return veiculos.stream().filter(v -> v.getId() == id).findFirst();
    }

    // UPDATE
    public boolean atualizar(int id, String novoModelo, Integer novoAno, String novaMarca, String novaCor, Integer novoPreco) {
        Optional<veiculo> opt = buscarPorId(id);
        if (opt.isPresent()) {
            veiculo v = opt.get();
            if (novoModelo != null && !novoModelo.trim().isEmpty()) v.setModelo(novoModelo);
            if (novoAno != null && novoAno >= 1900 && novoAno <= 2100) v.setAno(novoAno);
            if (novaMarca != null && !novaMarca.trim().isEmpty()) v.setMarca(novaMarca);
            if (novaCor != null && !novaCor.trim().isEmpty()) v.setCor(novaCor);
            if (novoPreco != null && novoPreco > 0) v.setPreco(novoPreco);
            System.out.println("✅ Dados do veículo atualizados com sucesso!");
            return true;
        }
        System.out.println("❌ Veículo não encontrado!");
        return false;
    }

    // DELETE
    public boolean remover(int id) {
        boolean removido = veiculos.removeIf(v -> v.getId() == id);
        if (removido) {
            System.out.println("✅ Veículo removido com sucesso!");
        } else {
            System.out.println("❌ Veículo não encontrado!");
        }
        return removido;
    }
}
