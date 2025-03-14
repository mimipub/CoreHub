package org.example.dao;

import java.text.SimpleDateFormat;
import java.util.*;

public class Contas {

    private int idConta;
    private int idUsuario;
    private int tipo;
    private int classe;
    private int agencia;
    private int numero;
    private double saldo;
    private Date dataAbertura;
    private String status;

    public Contas(int idConta, int idUsuario, int tipo, int classe, int agencia, int numero, double saldo, Date dataAbertura, String status) {
        this.idConta = idConta;
        this.idUsuario = idUsuario;
        this.tipo = tipo;
        this.classe = classe;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
        this.dataAbertura = dataAbertura;
        this.status = status;
    }

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getClasse() {
        return classe;
    }

    public void setClasse(int classe) {
        this.classe = classe;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }
}
