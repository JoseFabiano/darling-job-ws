package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ContratoCriadoResponseDTO {

    public ContratoCriadoResponseDTO(Integer idContrato, String categoria, String data, String valor, String endereco, String isAcepted, Integer idUsuarioProfissional, Integer idUsuarioContratante, String wasPerformed, String feedback, Integer avaliacao) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.data = data;
        this.valor = valor;
        this.endereco = endereco;
        this.isAcepted = isAcepted;
        this.idUsuarioProfissional = idUsuarioProfissional;
        this.idUsuarioContratante = idUsuarioContratante;
        this.wasPerformed = wasPerformed;
        this.feedback = feedback;
        this.avaliacao = avaliacao;
    }

    @JsonProperty("id_contrato")
    private Integer idContrato;

    @JsonProperty("categoria")
    private String categoria;

    @JsonProperty("data")
    private String data;

    @JsonProperty("valor")
    private String valor;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("is_acepted")
    private String isAcepted;

    @JsonProperty("id_usuario_profissional")
    private Integer idUsuarioProfissional;

    @JsonProperty("id_usuario_contratante")
    private Integer idUsuarioContratante;

    @JsonProperty("wasPerformed")
    private String wasPerformed;

    @JsonProperty("feedback")
    private String feedback;

    @JsonProperty("avaliacao")
    private Integer avaliacao;

    public static ContratoCriadoResponseDTO convertFromDomain(Contrato contrato) {
        return new ContratoCriadoResponseDTO(
                contrato.getIdContrato(),
                contrato.getCategoria(),
                contrato.getData(),
                contrato.getValor(),
                contrato.getEndereco(),
                contrato.getIsAcepted(),
                contrato.getContratado().getIdUsuario(),
                contrato.getContratante().getIdUsuario(),
                contrato.getWasPerformed(),
                contrato.getFeedback(),
                contrato.getAvaliacao()
        );
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Integer getIdUsuarioProfissional() {
        return idUsuarioProfissional;
    }

    public void setIdUsuarioProfissional(Integer idUsuarioProfissional) {
        this.idUsuarioProfissional = idUsuarioProfissional;
    }

    public Integer getIdUsuarioContratante() {
        return idUsuarioContratante;
    }

    public void setIdUsuarioContratante(Integer idUsuarioContratante) {
        this.idUsuarioContratante = idUsuarioContratante;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getIsAcepted() {
        return isAcepted;
    }

    public void setIsAcepted(String isAcepted) {
        this.isAcepted = isAcepted;
    }

    public String getWasPerformed() {
        return wasPerformed;
    }

    public void setWasPerformed(String wasPerformed) {
        this.wasPerformed = wasPerformed;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(Integer avaliacao) {
        this.avaliacao = avaliacao;
    }
}
