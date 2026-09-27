import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GerenciadorOportunidade {
    private List<Oportunidade> oportunidades = new ArrayList<>();

    // CREATE (Com validação de dados obrigatórios - Requisito TDE)
    public void cadastrar(Oportunidade oportunidade) {
        if (oportunidade.getClienteId() <= 0) {
            throw new IllegalArgumentException("Erro: ID do cliente é obrigatório e deve ser válido!");
        }
        if (oportunidade.getVeiculo() == null || oportunidade.getVeiculo().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Veículo da oportunidade é obrigatório!");
        }
        if (oportunidade.getTipo() == null || oportunidade.getTipo().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Tipo da oportunidade é obrigatório!");
        }
        if (oportunidade.getValorEstimado() <= 0) {
            throw new IllegalArgumentException("Erro: Valor estimado deve ser maior que zero!");
        }
        if (oportunidade.getDataPrevista() == null || oportunidade.getDataPrevista().trim().isEmpty()) {
            throw new IllegalArgumentException("Erro: Data prevista é obrigatória!");
        }
        oportunidades.add(oportunidade);
        System.out.println("✅ Oportunidade cadastrada com sucesso!");
    }

    // READ (Listar Todas)
    public List<Oportunidade> listarTodos() {
        return oportunidades;
    }

    // READ (Buscar por ID)
    public Optional<Oportunidade> buscarPorId(int id) {
        return oportunidades.stream().filter(o -> o.getId() == id).findFirst();
    }

    // UPDATE (dados da oportunidade — o status muda só via alterarStatusOportunidade, respeitando o funil)
    public boolean atualizar(int id, String novoVeiculo, String novoTipo, Integer novoValor, String novaData) {
        Optional<Oportunidade> opt = buscarPorId(id);
        if (opt.isPresent()) {
            Oportunidade o = opt.get();
            if (novoVeiculo != null && !novoVeiculo.trim().isEmpty()) o.setVeiculo(novoVeiculo);
            if (novoTipo != null && !novoTipo.trim().isEmpty()) o.setTipo(novoTipo);
            if (novoValor != null && novoValor > 0) o.setValorEstimado(novoValor);
            if (novaData != null && !novaData.trim().isEmpty()) o.setDataPrevista(novaData);
            System.out.println("✅ Dados da oportunidade atualizados com sucesso!");
            return true;
        }
        System.out.println("❌ Oportunidade não encontrada!");
        return false;
    }

    // UPDATE específico para o status, respeitando a regra de transição já existente em Oportunidade
    public boolean alterarStatus(int id, StatusOportunidade.Status novoStatus) {
        Optional<Oportunidade> opt = buscarPorId(id);
        if (opt.isPresent()) {
            opt.get().alterarStatus(novoStatus);
            return true;
        }
        System.out.println("❌ Oportunidade não encontrada!");
        return false;
    }

    // DELETE
    public boolean remover(int id) {
        boolean removido = oportunidades.removeIf(o -> o.getId() == id);
        if (removido) {
            System.out.println("✅ Oportunidade removida com sucesso!");
        } else {
            System.out.println("❌ Oportunidade não encontrada!");
        }
        return removido;
    }
}
