public abstract class Usuarios {
    private int id;
    private String name;

    public Usuarios(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public abstract void VisualizarOportunidade();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
