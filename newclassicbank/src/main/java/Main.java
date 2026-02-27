import DAO.UsuarioDAO;
import entity.Usuario;

public class Main {

    public static void main(String[] args) {
        Usuario u = new Usuario();

        u.setNome("Joao Paulo");
        u.setId("56");
        new UsuarioDAO().atualizarUsuario(u);
    }
}
