package br.com.agibank.controller;

import java.time.LocalDate;

import br.com.agibank.dao.transacoes.TransacaoDAO;

import java.sql.SQLException;

public class ScoreController{
    private final TransacaoDAO transacaoDAO = new TransacaoDAO();
    public ScoreController() throws SQLException {
    }

    public double retornarSomaValorMes(int id_conta){
        try {
            return transacaoDAO.SomarMovimentacaoPorMes(id_conta);
        }catch (SQLException e){
            System.out.printf(e.getMessage());
        }
        return 0;
    }

    public double calcularScorePorValor(int id_conta){
        try{
             return transacaoDAO.SomarMovimentacaoPorMes(id_conta)*0.1;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public double atualizarScore(int id_conta){
        LocalDate hoje = LocalDate.now();

        if(hoje.getDayOfMonth() == 1){
            try{
                double pontuacaoValor = transacaoDAO.atualizarScoreConta(calcularScorePorValor(id_conta),id_conta);
                return pontuacaoValor;
            }catch (SQLException e){
                System.out.printf(e.getMessage());
            }
        }

        return 0;
    }


}


