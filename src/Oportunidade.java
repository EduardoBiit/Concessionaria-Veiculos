public class Oportunidade {
    /* Atributos Oportunidade */
    private int id;
    private int cliente;
    private String veiculo;
    private String tipo;
    private int valorEstimado;
    private String status;
    private String dataPrevista;
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Construtor Java */
    public Oportunidade(int id, int cliente, String veiculo, String tipo, int valorEstimado, String status, String dataPrevista) {
        this.id = id;
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.tipo = tipo;
        this.valorEstimado = valorEstimado;
        this.status = status;
        this.dataPrevista = dataPrevista;
    }
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Getters */
    public int getId() {
        return id;
    }

    public int getCliente() {
        return cliente;
    }

    public int getValorEstimado() {
        return valorEstimado;
    }

    public String getDataPrevista() {
        return dataPrevista;
    }

    public String getStatus() {
        return status;
    }

    public String getTipo() {
        return tipo;
    }

    public String getVeiculo() {
        return veiculo;
    }
}
