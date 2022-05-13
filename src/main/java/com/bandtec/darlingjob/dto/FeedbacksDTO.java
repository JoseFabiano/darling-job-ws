package com.bandtec.darlingjob.dto;

public class FeedbacksDTO {
    private String feedback;
    private String avaliacao;

    public FeedbacksDTO(String feedback, String avaliacao) {
        this.feedback = feedback;
        this.avaliacao = avaliacao;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }
}
