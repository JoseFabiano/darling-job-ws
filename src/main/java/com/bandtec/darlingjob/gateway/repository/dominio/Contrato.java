package com.bandtec.darlingjob.gateway.repository.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contrato")
    private Integer idContrato;
    private String categoria;
    private String endereco;
    private String data;
    private String hora;
    private String valor;
    private String feedback;

    @Column(name = "is_acepted")
    private String isAcepted;

    private String wasPerformed;

    private Integer avaliacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario_contratante")
    private Usuario contratante;

    @ManyToOne
    @JoinColumn(name = "id_usuario_profissional")
    private Usuario contratado;

    public Contrato() {
    }

    public Contrato(String categoria, String data, String valor, String endereco, Usuario contratante, Usuario contratado, String hora) {
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.endereco = endereco;
        this.contratante = contratante;
        this.contratado = contratado;
        this.hora = hora;
    }

    public Contrato(Integer idContrato, String categoria, String endereco, String data, String hora, String valor, String feedback, String isAcepted, String wasPerformed, Integer avaliacao, Usuario contratante, Usuario contratado) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.feedback = feedback;
        this.isAcepted = isAcepted;
        this.wasPerformed = wasPerformed;
        this.avaliacao = avaliacao;
        this.contratante = contratante;
        this.contratado = contratado;
    }

    public Contrato(String categoria, String endereco, String data, String hora, String valor, String feedback, String isAcepted, String wasPerformed, Integer avaliacao, Usuario contratante, Usuario contratado) {
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.contratante = contratante;
        this.contratado = contratado;
    }

    public Contrato(Integer idContrato, String categoria, String endereco, String data, String hora, String valor, String isAcepted, Usuario contratante, Usuario contratado) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.isAcepted = isAcepted;
        this.contratante = contratante;
        this.contratado = contratado;
    }

    public Contrato(Object o, int idContratada, int idContratante, String categoria, String endereco, String data, String hora, String valor) {
    }

    public String getWasPerformed() {
        return wasPerformed;
    }

    public void setWasPerformed(String wasPerformed) {
        this.wasPerformed = wasPerformed;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getIsAcepted() {
        return isAcepted;
    }

    public void setIsAcepted(String isAcepted) {
        this.isAcepted = isAcepted;
    }

    public Usuario getContratante() {
        return contratante;
    }

    public void setContratante(Usuario contratante) {
        this.contratante = contratante;
    }

    public Usuario getContratado() {
        return contratado;
    }

    public void setContratado(Usuario contratado) {
        this.contratado = contratado;
    }
}
