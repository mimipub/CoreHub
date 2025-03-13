package org.example.beans.usuarios;

import java.util.Date;

public class Usuarios {

    private int idUsuario;
    private String nome;
    private String apelido;
    private String senha;
    private String email;
    private int telefone;
    private Date dataAbertura;
    private String rua;
    private int numeroRua;
    private String complemento;

    public Usuarios(int idUsuario, String nome, String apelido, String senha, String email, int telefone, Date dataAbertura, String rua, int numeroRua) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.dataAbertura = dataAbertura;
        this.rua = rua;
        this.numeroRua = numeroRua;
    }

    public Usuarios(int idUsuario, String nome, String apelido, String senha, String email, int telefone, Date dataAbertura, String rua, int numeroRua, String complemento) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.apelido = apelido;
        this.senha = senha;
        this.email = email;
        this.telefone = telefone;
        this.dataAbertura = dataAbertura;
        this.rua = rua;
        this.numeroRua = numeroRua;
        this.complemento = complemento;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public int getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(int numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
