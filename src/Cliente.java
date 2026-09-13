public class Cliente {
    /* Atributos Clientes */
    private int id;
    private String nome;
    private String telefone;
    private String email;
    private String Classificao;
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Construtor Java */
    public Cliente(int id, String nome, String telefone, String email, String classificao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        Classificao = classificao;
    }
    /* -------------------------------------------------------------------------------------------------------------- */

    /* Getters para transformar o Private em Public */
    public int getId() {
        return id;
    }

    public String getClassificao() {
        return Classificao;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

}
