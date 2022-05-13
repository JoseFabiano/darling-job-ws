package com.bandtec.darlingjob.dto;

public class FinalizarContratoDTO {

    private String feedback;

    private Boolean wasPerformed;

    private Integer avaliacao;

    private Integer idContrato;

    public FinalizarContratoDTO() {
    }

    public FinalizarContratoDTO(String feedback, Boolean wasPerformed, Integer idContrato) {
        this.feedback = feedback;
        this.wasPerformed = wasPerformed;
        this.idContrato = idContrato;
    }

    public FinalizarContratoDTO(String feedback, Boolean wasPerformed, Integer avaliacao, Integer idContrato) {
        this.feedback = feedback;
        this.wasPerformed = wasPerformed;
        this.avaliacao = avaliacao;
        this.idContrato = idContrato;
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

    public Boolean getWasPerformed() {
        return wasPerformed;
    }

    public void setWasPerformed(Boolean wasPerformed) {
        this.wasPerformed = wasPerformed;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }
}
