package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contrato")
    private Integer idContrato;
    private String categoria;
    private String endereco;
    private String data;
    private String hora;
    private String valor;

    @Column(name = "is_acepted")
    private String isAcepted = "NR";

    @ManyToOne
    @JoinColumn(name = "id_contratante")
    private Contratante contratante;

    @ManyToOne
    @JoinColumn(name = "id_contratado")
    private Contratado contratado;

    public Contrato(){
    }

    public Contrato(Integer idContrato, Integer idContratado, Integer idContratante, String categoria, String endereco, String data, String hora, String valor) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
    }

    public Integer getIdContrato() {
        return idContrato;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAcepted() {
        return isAcepted;
    }

    public void setAcepted(String acepted) {
        isAcepted = acepted;
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

    public void setIdContrato(Integer idContrato) {
        this.idContrato = idContrato;
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

    public String getIsAcepted() {
        return isAcepted;
    }

    public void setIsAcepted(String isAcepted) {
        this.isAcepted = isAcepted;
    }

    public Contratante getContratante() {
        return contratante;
    }

    public void setContratante(Contratante contratante) {
        this.contratante = contratante;
    }

    public Contratado getContratado() {
        return contratado;
    }

    public void setContratado(Contratado contratado) {
        this.contratado = contratado;
    }
}
