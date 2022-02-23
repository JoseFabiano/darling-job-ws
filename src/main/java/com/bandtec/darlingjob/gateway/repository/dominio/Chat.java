package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class Chat {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_chat")
    private Integer idChat;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_contrato", referencedColumnName = "id_contrato")
    private Contrato contrato;

    public Chat() {
    }

    public Chat(Integer idChat, Contrato contrato) {
        this.idChat = idChat;
        this.contrato = contrato;
    }

    public Integer getIdChat() {
        return idChat;
    }

    public void setIdChat(Integer idChat) {
        this.idChat = idChat;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }
}
