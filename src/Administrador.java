public class Administrador extends Usuarios{
    public Administrador(int id, String name) {
        super(id, name);
    }

    @Override
    public void VisualizarOportunidade() {
        System.out.println("Administrador visualizando todas as Oportunidades.");
    }
}
