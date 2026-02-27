package DAO;

import conexao.Conexao;
import entity.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public void CadastrarUsuario(Usuario usuario) {

        String sql = "INSERT INTO pessoas (nome, email, telefone) VALUES (?,?,?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getTelefone());

            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void listarUsuarios() {
        String sql = "SELECT * FROM pessoas WHERE nome = 'paulete'";

        try (Connection conn = Conexao.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                System.out.println(rs.getString("nome"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarUsuario(Usuario usuario) {

        String sql = "DELETE FROM pessoas WHERE nome = ?";
        PreparedStatement ps = null;
        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void atualizarUsuario(Usuario usuario) {
        String sql = "UPDATE pessoas SET nome = (?) WHERE id = (?)";

        PreparedStatement ps = null;

        try {
            ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getId());
            ps.execute();
        } catch (SQLException e)  {
            throw new RuntimeException(e);
        }
    }

}
