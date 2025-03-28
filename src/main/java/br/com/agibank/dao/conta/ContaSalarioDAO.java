package br.com.agibank.dao.conta;

import br.com.agibank.beans.conta.ContaPoupanca;
import br.com.agibank.beans.conta.ContaSalario;
import br.com.agibank.dao.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ContaSalarioDAO {

    private Connection con;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ContaSalarioDAO() throws SQLException {
        con = Conexao.getConexao();
    }

    public void fecharConexao() throws SQLException {
        con.close();
    }

    public int cadastrarContaPoupanca(int idConta, int cnpj, String dataPagamento, double valorPagamento) throws SQLException {

        final String sql = "INSERT INTO Conta_Salario(id_conta, cnpj, data_pagamento, valor_pagamento) VALUES(?, ?, ?, ?)";

        stmt = con.prepareStatement(sql);

        stmt.setInt(1, idConta);
        stmt.setInt(2, cnpj);
        stmt.setDate(3, java.sql.Date.valueOf(dataPagamento));
        stmt.setDouble(4, valorPagamento);

        return stmt.executeUpdate();
    }

    public String buscarContaSalario(int id) throws SQLException {

        final String sql = "SELECT * FROM Conta_Salario WHERE id_conta_salario = ?";

        ContaSalario contaSalario = new ContaSalario();

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);
        rs = stmt.executeQuery();

        if(rs.next()){

            contaSalario.setIdContaSalario(rs.getInt("id_conta_salario"));
            contaSalario.setIdConta(rs.getInt("id_conta"));
            contaSalario.setCnpj(rs.getInt("cnpj"));
            contaSalario.setDataPagamento(rs.getDate("data_pagamento"));
            contaSalario.setValorPagamento(rs.getDouble("valor_pagamento"));

            return contaSalario.toString();

        }else return "Deu errado irmao";

    }

    public int atualizarContaSalario(int idConta, int cnpj, String dataPagamento, double valorPagamento, int idContaSalario) throws SQLException {

        final String sql = "UPDATE Conta_Salario SET id_conta = ?, cnpj = ?, data_pagamento = ?, valor_pagamento = ? WHERE id_conta_salario = ?";

        stmt = con.prepareStatement(sql);

        stmt.setInt(1, idConta);
        stmt.setInt(2, cnpj);
        stmt.setDate(3, java.sql.Date.valueOf(dataPagamento));
        stmt.setDouble(4, valorPagamento);
        stmt.setInt(5, idContaSalario);

        return stmt.executeUpdate();
    }

    public int deletarContaSalario(int id) throws SQLException {

        final String sql = "DELETE FROM Conta_Salario WHERE id_conta_salario = ?";

        stmt = con.prepareStatement(sql);
        stmt.setInt(1, id);

        return stmt.executeUpdate();

    }

}
