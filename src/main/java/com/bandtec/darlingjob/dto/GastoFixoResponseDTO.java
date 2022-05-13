package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.GastoFixo;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFuturo;

public class GastoFixoResponseDTO {
    private Integer idGastoFixo;

    private String nome;

    private String valor;

    private Integer idUsuario;

    public GastoFixoResponseDTO() {
    }

    public GastoFixoResponseDTO(Integer idGastoFixo, String nome, String valor) {
        this.idGastoFixo = idGastoFixo;
        this.nome = nome;
        this.valor = valor;
    }

    public GastoFixoResponseDTO(Integer idGastoFixo, String nome, String valor, Integer idUsuario) {
        this.idGastoFixo = idGastoFixo;
        this.nome = nome;
        this.valor = valor;
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdGastoFixo() {
        return idGastoFixo;
    }

    public void setIdGastoFixo(Integer idGastoFixo) {
        this.idGastoFixo = idGastoFixo;
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

    public static GastoFixoResponseDTO convertFromDomain(GastoFixo gastoFixoSalvo) {
        return new GastoFixoResponseDTO(
                gastoFixoSalvo.getIdGastoFixo(),
                gastoFixoSalvo.getNome(),
                gastoFixoSalvo.getValor(),
                gastoFixoSalvo.getUsuario().getIdUsuario()
        );
    }
}
