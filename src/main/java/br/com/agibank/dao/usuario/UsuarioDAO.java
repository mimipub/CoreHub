package br.com.agibank.dao.usuario;

import br.com.agibank.beans.Usuario;
import br.com.agibank.dao.Conexao;
import java.sql.*;
import java.time.LocalDate;

public class UsuarioDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public UsuarioDAO() throws SQLException {
        con = Conexao.getConexao();
    }

    public void fecharConexao() throws SQLException {
        con.close();
    }

    public int criarUsuario(Usuario usuario) throws SQLException {
        final String sql = "INSERT INTO Usuario (nome, apelido, senha, email, telefone, data_nascimento, rua, numero, complemento) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        stmt = con.prepareStatement(sql);

        stmt.setString(1, usuario.getNome());
        stmt.setString(2, usuario.getApelido());
        stmt.setString(3, usuario.getSenha());
        stmt.setString(4, usuario.getEmail());
        stmt.setInt(5, usuario.getTelefone());
        stmt.setDate(6, Date.valueOf(usuario.getData_nascimento()));
        stmt.setString(7, usuario.getRua());
        stmt.setInt(8, usuario.getNumero());
        stmt.setString(9, usuario.getComplemento());
        return stmt.executeUpdate();
    }

    public int atualizarCadastroUsuario(String nome, String apelido, String senha, String email, int telefone, LocalDate data_nascimento, String rua, int numero, String complemento, int id_usuario) throws SQLException {
        final String sql = "UPDATE Usuario SET nome = ?, apelido = ?, senha = ?, email = ?, telefone = ?, data_nascimento = ?, rua = ?, numero = ?, complemento = ? WHERE id_usuario = ?";
        stmt = con.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, apelido);
        stmt.setString(3, senha);
        stmt.setString(4, email);
        stmt.setInt(5, telefone);
        stmt.setDate(6, Date.valueOf(String.valueOf(data_nascimento)));
        stmt.setString(7, rua);
        stmt.setInt(8, numero);
        stmt.setString(9, complemento);
        stmt.setInt(10, id_usuario);
        return stmt.executeUpdate();
    }

    public void deletarUsuario(int id_usuario) throws SQLException {
        final String sql = "DELETE FROM Usuario WHERE id_usuario = ?";
        stmt = con.prepareStatement(sql);

        stmt.setInt(1, id_usuario);
        stmt.executeUpdate();
    }

    //TODO completar método para verificar se o usuario é cliente ou funcionario.
    public int verificarTipoUsuario(int id_usuario) throws SQLException{
        int id = 0;
        String sql = "SELECT * FROM Funcionario WHERE id_usuario = ?";

        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, id_usuario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            id = rs.getInt(id_usuario);
        }

        return id;
    }


    //TODO adicionar mais dados
    public Usuario buscarUsuarioPorId(int  id_usuario) throws SQLException{
        String sql = "SELECT * FROM Usuario WHERE id_usuario = ?";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setInt(1, id_usuario);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setApelido(rs.getString("apelido"));
            return usuario;
        }

        return null;
    }

    public Usuario buscarUsuarioLogin(String apelido, String senha) throws SQLException{
        String sql = "SELECT * FROM Usuario WHERE apelido = ? and senha = ?";

        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, apelido);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setFuncionario(verificarTipoUsuario(rs.getInt("id_usuario")) != 0);

            usuario.setId(rs.getInt("id_usuario"));
            usuario.setNome(rs.getString("nome"));
            usuario.setSenha(rs.getString("senha"));
            usuario.setApelido(rs.getString("apelido"));
            return usuario;
        }

        return null;
    }
}