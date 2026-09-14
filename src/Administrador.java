public class Administrador extends Usuarios{
    public Administrador(int id, String name) {
        super(id, name);
    }

    @Override
    public void VisualizarOportunidade() {
        System.out.println("Administrador visualizando todas as Oportunidades.");
    }
    /* Funcionalidade prevista para a parte 2, pois não é um requisito obrigatório para a primeira parte, vamos
    * vamos implementar mais poder para usuarios que são administradores  */
}
