package com.bandtec.darlingjob.dto;

import java.util.List;

public class DadosContratanteDTO {

    private String descricao;

    private String tipoServico;

    private List<FeedbacksDTO> feedbacksDTOList;

    public DadosContratanteDTO(String descricao, String tipoServico, List<FeedbacksDTO> feedbacksDTOList) {
        this.descricao = descricao;
        this.tipoServico = tipoServico;
        this.feedbacksDTOList = feedbacksDTOList;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public List<FeedbacksDTO> getFeedbacksDTOList() {
        return feedbacksDTOList;
    }

    public void setFeedbacksDTOList(List<FeedbacksDTO> feedbacksDTOList) {
        this.feedbacksDTOList = feedbacksDTOList;
    }

    @Override
    public String toString() {
        return "DadosContratanteDTO{" +
                "descricao='" + descricao + '\'' +
                ", tipoServico='" + tipoServico + '\'' +
                ", feedbacksDTOList=" + feedbacksDTOList +
                '}';
    }
}
