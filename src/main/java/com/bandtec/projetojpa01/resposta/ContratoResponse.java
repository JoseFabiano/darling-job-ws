package com.bandtec.projetojpa01.resposta;

import java.time.LocalDate;
import java.time.LocalTime;

public class ContratoResponse {

    private LocalDate dataServico;
    private LocalTime horaServico;
    private Double valorServico;

    public ContratoResponse(LocalDate dataServico, LocalTime horaServico, Double valorServico) {
        this.dataServico = dataServico;
        this.horaServico = horaServico;
        this.valorServico = valorServico;
    }

    public LocalDate getDataServico() {
        return dataServico;
    }

    public LocalTime getHoraServico() {
        return horaServico;
    }

    public Double getValorServico() {
        return valorServico;
    }
}
