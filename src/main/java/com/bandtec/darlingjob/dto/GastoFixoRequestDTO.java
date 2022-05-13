package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;

import javax.persistence.*;

public class GastoFixoRequestDTO {
    private String nome;

    private String valor;

    private Integer idUsuario;

    public GastoFixoRequestDTO(String nome, String valor, Integer idUsuario) {
        this.nome = nome;
        this.valor = valor;
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
