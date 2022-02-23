package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalTime;

public class ContratoResponseDTO {
    private Integer idContrato;
    private String categoria;
    private String endereco;
    private String data;
    private String hora;
    private String valor;
    private String feedback;
    private String isAcepted;
    private Usuario contratante;
    private Usuario contratado;

    public ContratoResponseDTO(Integer idContrato, String categoria, String endereco, String data, String hora, String valor, String feedback, String isAcepted, Usuario contratante, Usuario contratado) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.feedback = feedback;
        this.isAcepted = isAcepted;
        this.contratante = contratante;
        this.contratado = contratado;
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

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
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

    public static ContratoResponseDTO convertFromDomain(Contrato contrato) {
        return new ContratoResponseDTO(
                contrato.getIdContrato(),
                contrato.getCategoria(),
                contrato.getEndereco(),
                contrato.getData(),
                contrato.getHora(),
                contrato.getValor(),
                contrato.getFeedback(),
                contrato.getIsAcepted(),
                contrato.getContratante(),
                contrato.getContratado()
        );
    }
}
