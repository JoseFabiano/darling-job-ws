package com.bandtec.darlingjob.dto;

public class ResponderContratoDTO {

    private Boolean isAcepted;
    private Integer idContrato;

    public ResponderContratoDTO(Boolean isAcepted) {
        this.isAcepted = isAcepted;
    }

    public ResponderContratoDTO(Boolean isAcepted, Integer idContrato) {
        this.isAcepted = isAcepted;
        this.idContrato = idContrato;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
    }

    public Boolean getAcepted() {
        return isAcepted;
    }

    public void setAcepted(Boolean acepted) {
        isAcepted = acepted;
    }
}
