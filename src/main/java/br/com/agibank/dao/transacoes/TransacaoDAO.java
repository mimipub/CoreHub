package br.com.agibank.dao.transacoes;

import br.com.agibank.beans.transacoes.Transacao;
import br.com.agibank.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransacaoDAO {
    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public TransacaoDAO() throws SQLException {
        con = Conexao.getConexao();
    }

    public void fecharConexao() throws SQLException {
        con.close();
    }

    public int criarTransacao(Transacao transacao) throws SQLException {
        final String sql = "INSERT INTO Transacao (id_conta_origem, id_conta_destino, valor, descricao, id_tipo_transacao, transferencia_externa) VALUES (?,?,?,?,?,?)";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, transacao.getIdContaOrigem());
        stmt.setInt(2, transacao.getIdContaDestino());
        stmt.setDouble(3, transacao.getValor());
        stmt.setString(4, transacao.getDescricao());
        stmt.setInt(5, transacao.getIdTipoTransacao());
        stmt.setBoolean(6, transacao.isTransferenciaExterna());
        return stmt.executeUpdate();
    }

    public Transacao buscarTransacaoPorId(int id) throws SQLException{
        Transacao transacao = new Transacao();
        final String sql = "SELECT * FROM Transacao WHERE id_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();
        if(rs.next()){
            transacao.setId(rs.getInt("id_transacao"));
            transacao.setIdContaOrigem(rs.getInt("id_conta_origem"));
            transacao.setIdContaDestino(rs.getInt("id_conta_destino"));
            transacao.setValor(rs.getDouble("valor"));
            transacao.setDescricao(rs.getString("descricao"));
            transacao.setIdTipoTransacao(rs.getInt("id_tipo_transacao"));
            transacao.setTransferenciaExterna(rs.getBoolean("transferencia_externa"));
        }
        return transacao;
    }

    public int atualizarTransacao(int id, String descricao) throws SQLException {
        final String sql = "UPDATE Transacao SET descricao = ? WHERE id_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setString(1,descricao);
        stmt.setInt(2, id);
        return stmt.executeUpdate();
    }

    public int deletarTransacao(int id) throws SQLException {
        final String sql = "DELETE FROM Transacao WHERE id_transacao = ?";
        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        return stmt.executeUpdate();
    }

    public double SomarMovimentacaoPorMes (int id_conta) throws SQLException{
        final String sql = "select sum(valor) as soma " +
                "from Transacao t inner join Status_Transacao st on st.id_transacao = t.id_transacao where month(data) = month(now())" +
                "and year(data) = year(now()) " +
                "and st.status = 'APROVADO' " +
                "and (t.id_conta_destino = ? " +
                "or t.id_conta_origem = ?) " +
                "group by t.id_conta_origem";

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id_conta);
        stmt.setInt(2,id_conta);

        rs = stmt.executeQuery();

        if(rs.next()){
            return rs.getDouble("soma");
        }

        return 0;
    }

    public double atualizarScoreConta(double score, int id_conta) throws SQLException{
        final   String sql = "update Conta set score = score + ? where id_conta = ?";

        stmt = con.prepareStatement(sql);
        stmt.setDouble(1, score);
        stmt.setInt(2,id_conta);

        rs = stmt.executeQuery();

        if(rs.next()){
            return rs.getDouble("score + ?");
        }

        return 0;
    }

}