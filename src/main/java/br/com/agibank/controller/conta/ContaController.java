package br.com.agibank.controller.conta;

import br.com.agibank.beans.conta.TipoConta;
import br.com.agibank.bo.conta.ContaBO;
import br.com.agibank.dao.conta.ContaDAO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ContaController {

    private final ContaDAO contaDAO = new ContaDAO();
    private final ContaBO contaBO = new ContaBO();
    private String resultado;

    public ContaController() throws SQLException {
    }

    public String buscarStatusConta(int idConta){
        try{
            resultado = contaBO.buscarStatusConta(idConta);
        }catch (SQLException e){
            resultado = "Erro: " + e.getMessage();
        }
        return resultado;
    }

    public String exibirTitularConta(int idConta){
        try{
            resultado = contaBO.exibirTitularConta(idConta);
        }catch (SQLException e){
            resultado = "Erro: " + e.getMessage();
        }
        return resultado;
    }

    public String exibirTiposConta(int idConta) throws SQLException {

        return contaBO.exibirTiposConta(idConta);

    }


    public int cadastrarConta(int idUsuario, int idTipo, double idClasse, int idAgencia, int numero, double saldo, String dataAbertura) {
        contaBO.cadastrarConta(idUsuario, idTipo, idClasse, idAgencia, numero, saldo, dataAbertura);
        return 1;
    }

    public int deletarConta(int idConta){
        contaBO.deletarConta(idConta);
        return 1;
    }

    public int tratamento(int idUsuario) throws SQLException {
        contaDAO.listarContasUsuario(idUsuario);
        return 1;
    }

    public int listarContaUsuario(int idUsuario) throws SQLException {
        tratamento(idUsuario);
        return 1;
    }


}