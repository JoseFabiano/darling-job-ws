package com.bandtec.projetojpa01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contratante{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idContratante;
    private String email;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private String telefoneFixo;
    private String celular;
    private String cep;
    private String senha;
    private Boolean isLogado = false;
    private Integer mediaFeedback = 0;

    public Integer getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(Integer idContratante) {
        this.idContratante = idContratante;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getLogado() {
        return isLogado;
    }

    public void setLogado(Boolean logado) {
        isLogado = logado;
    }

    public Integer getMediaFeedback() {
        return mediaFeedback;
    }

    public void setMediaFeedback(Integer mediaFeedback) {
        this.mediaFeedback = mediaFeedback;
    }
}
