public class Vendedor extends Usuarios{
    public Vendedor(int id, String name) {
        super(id, name);
    }

    @Override
    public void VisualizarOportunidade() {
        System.out.println("Vendedor está visualizando suas oportunidades.");
    }
}
