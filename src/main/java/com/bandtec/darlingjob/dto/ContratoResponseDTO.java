package com.bandtec.darlingjob.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class ContratoResponseDTO {

    private LocalDate dataServico;
    private LocalTime horaServico;
    private Double valorServico;

    public ContratoResponseDTO(LocalDate dataServico, LocalTime horaServico, Double valorServico) {
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
