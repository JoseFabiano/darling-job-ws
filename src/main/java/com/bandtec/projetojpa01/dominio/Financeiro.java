package com.bandtec.projetojpa01.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Financeiro {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String descServico;
    private int totalServico;
    private Double valorDia;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescServico() {
        return descServico;
    }

    public void setDescServico(String descServico) {
        this.descServico = descServico;
    }

    public int getTotalServico() {
        return totalServico;
    }

    public void setTotalServico(int totalServico) {
        this.totalServico = totalServico;
    }

    public Double getValorDia() {
        return valorDia;
    }

    public void setValorDia(Double valorDia) {
        this.valorDia = valorDia;
    }
}
