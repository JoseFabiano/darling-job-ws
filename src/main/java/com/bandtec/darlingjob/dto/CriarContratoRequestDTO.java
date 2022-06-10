package com.bandtec.darlingjob.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CriarContratoRequestDTO {

    @JsonProperty("categoria")
    private String categoria;

    @JsonProperty("data")
    private String data;

    @JsonProperty("valor")
    private String valor;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("hora")
    private String hora;

    @JsonProperty("id_usuario_profissional")
    private Integer idUsuarioProfissional;

    @JsonProperty("id_usuario_contratante")
    private Integer idUsuarioContratante;



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

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
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


}
