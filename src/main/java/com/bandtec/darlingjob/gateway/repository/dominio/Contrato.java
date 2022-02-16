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
    private String isAcepted;

    @ManyToOne
    @JoinColumn(name = "id_usuario_contratante")
    private Usuario contratante;

    @ManyToOne
    @JoinColumn(name = "id_usuario_profissional")
    private Usuario contratado;

    public Contrato() {
    }

    public Contrato(Integer idContrato, String categoria, String endereco, String data, String hora, String valor, String isAcepted, Usuario contratante, Usuario contratado) {
        this.idContrato = idContrato;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
        this.isAcepted = isAcepted;
        this.contratante = contratante;
        this.contratado = contratado;
    }

    public Contrato(Object o, int idContratada, int idContratante, String categoria, String endereco, String data, String hora, String valor) {
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
}
