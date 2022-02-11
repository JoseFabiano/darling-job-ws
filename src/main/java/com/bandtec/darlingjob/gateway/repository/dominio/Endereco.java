package com.bandtec.darlingjob.gateway.repository.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Endereco {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_endereco")
    @JsonProperty("id_endereco")
    private int idEndereco;
    private String endereco;
    private String complemento;
    private Integer numero;
    private String bairro;
    private String pais;
    private String estado;
    private String cidade;

    public Endereco() {
    }

    public Endereco(int idEndereco, String endereco, String complemento, Integer numero, String bairro, String pais, String estado, String cidade, String cep) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }

    public Endereco(int idEndereco, String endereco, String complemento, Integer numero, String bairro, String pais, String estado, String cidade) {
        this.idEndereco = idEndereco;
        this.endereco = endereco;
        this.complemento = endereco;
        this.numero = numero;
        this.bairro = bairro;
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
