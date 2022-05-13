package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.GastoFuturo;

public class GastoFuturoResponseDTO {
    private Integer idGastoFuturo;

    private String nome;

    private String valor;

    private Integer idUsuario;

    public GastoFuturoResponseDTO(Integer idGastoFuturo, String nome, String valor, Integer idUsuario) {
        this.idGastoFuturo = idGastoFuturo;
        this.nome = nome;
        this.valor = valor;
        this.idUsuario = idUsuario;
    }

    public Integer getIdGastoFuturo() {
        return idGastoFuturo;
    }

    public void setIdGastoFuturo(Integer idGastoFuturo) {
        this.idGastoFuturo = idGastoFuturo;
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

    public static GastoFuturoResponseDTO convertFromDomain(GastoFuturo gastoFuturoSalvo) {
        return new GastoFuturoResponseDTO(
                gastoFuturoSalvo.getIdGastoFuturo(),
                gastoFuturoSalvo.getNome(),
                gastoFuturoSalvo.getValor(),
                gastoFuturoSalvo.getUsuario().getIdUsuario()
        );
    }
}
