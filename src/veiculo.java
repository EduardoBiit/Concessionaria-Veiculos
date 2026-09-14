public class veiculo {
    /* Atributos do Veiculo */
    private int id;
    private String Modelo;
    private int Ano;
    private String Marca;
    private String Cor;
    private int preco;
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Construtor Java */
    public veiculo(int id, String modelo, int ano, String marca, String cor, int preco) {
        this.id = id;
        this.Modelo = modelo;
        this.Ano = ano;
        this.Marca = marca;
        this.Cor = cor;
        this.preco = preco;
    }
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Getters */
    public int getId() {
        return id;
    }

    public int getAno() {
        return Ano;
    }

    public int getPreco() {
        return preco;
    }

    public String getCor() {
        return Cor;
    }

    public String getMarca() {
        return Marca;
    }

    public String getModelo() {
        return Modelo;
    }
}
