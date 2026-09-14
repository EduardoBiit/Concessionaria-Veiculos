public class Vendedor extends Usuarios{
    public Vendedor(int id, String name) {
        super(id, name);
    }

    @Override
    public void VisualizarOportunidade() {
        System.out.println("Vendedor está visualizando suas oportunidades.");
    }
    /*  Funcionalidade prevista para a parte 2, pois não é um requisito obrigatório para a primeira parte, vamos
     * vamos implementar novas funções para usuarios que são Vendedores */
}
