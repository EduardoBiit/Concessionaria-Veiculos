public abstract class Usuarios {
    /*Classe abstrata para servir de herança para as classes Administrador e Vendedor */
    private int id;
    private String name;

    public Usuarios(int id, String name) {
        this.id = id;
        this.name = name;
    }
    /* Classe criada com intenção de polimorfismo nas classes que tem como herança a classe Usuarios. */
    public abstract void VisualizarOportunidade();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
