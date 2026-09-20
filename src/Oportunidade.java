public class Oportunidade {
    private int id;
    private int clienteId;
    private String veiculo;
    private String tipo;
    private int valorEstimado;
    private StatusOportunidade.Status status;
    private String dataPrevista;

    public Oportunidade(int id, int clienteId, String veiculo, String tipo, int valorEstimado, String dataPrevista) {
        this.id = id;
        this.clienteId = clienteId;
        this.veiculo = veiculo;
        this.tipo = tipo;
        this.valorEstimado = valorEstimado;
        this.status = StatusOportunidade.Status.NOVO_LEAD; // Inicia sempre como NOVO_LEAD
        this.dataPrevista = dataPrevista;
    }

    /* Sequencias de if e else com intuito  */
    public void alterarStatus(StatusOportunidade.Status novoStatus) {
        if (this.status == StatusOportunidade.Status.NOVO_LEAD && novoStatus == StatusOportunidade.Status.CONTATO_REALIZADO) {
            this.status = novoStatus;
        } else if (this.status == StatusOportunidade.Status.CONTATO_REALIZADO && novoStatus == StatusOportunidade.Status.TEST_DRIVE) {
            this.status = novoStatus;
        } else if (this.status == StatusOportunidade.Status.TEST_DRIVE && novoStatus == StatusOportunidade.Status.PROPOSTA_FINANCIAMENTO) {
            this.status = novoStatus;
        } else if (this.status == StatusOportunidade.Status.PROPOSTA_FINANCIAMENTO && novoStatus == StatusOportunidade.Status.GANHO) {
            this.status = novoStatus;
        } else if (novoStatus == StatusOportunidade.Status.PERDIDO) {
            this.status = novoStatus;
        } else {
            System.out.println("Mudança de Status não permitida! Transição inválida no funil.");
        }
    }

    public int getId() { return id; }
    public int getClienteId() { return clienteId; }
    public String getVeiculo() { return veiculo; }
    public String getTipo() { return tipo; }
    public int getValorEstimado() { return valorEstimado; }
    public StatusOportunidade.Status getStatus() { return status; }
    public String getDataPrevista() { return dataPrevista; }

    /* Setters (adicionados para permitir o UPDATE do CRUD).
     * O status NÃO tem setter direto: ele só muda pela regra de negócio em alterarStatus(). */
    public void setVeiculo(String veiculo) { this.veiculo = veiculo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setValorEstimado(int valorEstimado) { this.valorEstimado = valorEstimado; }
    public void setDataPrevista(String dataPrevista) { this.dataPrevista = dataPrevista; }
}