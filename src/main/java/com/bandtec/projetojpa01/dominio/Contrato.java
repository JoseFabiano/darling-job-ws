package com.bandtec.projetojpa01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Contrato {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer idContratada;
    private Integer idContratante;
    private String categoria;
    private String endereco;
    private String data;
    private String hora;
    private String valor;
    private String isAcepted = "NR";

    public Contrato(){
    }

    public Contrato(Integer id, Integer idContratada, Integer idContratante, String categoria, String endereco, String data, String hora, String valor) {
        this.id = id;
        this.idContratada = idContratada;
        this.idContratante = idContratante;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.hora = hora;
        this.valor = valor;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdContratada() {
        return idContratada;
    }

    public void setIdContratada(Integer idContratada) {
        this.idContratada = idContratada;
    }

    public Integer getIdContratante() {
        return idContratante;
    }

    public void setIdContratante(Integer idContratante) {
        this.idContratante = idContratante;
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

    public void setId(Integer id) {
        this.id = id;
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
}
