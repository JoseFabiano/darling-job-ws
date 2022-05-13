package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ContratoResponseDTO;
import com.bandtec.darlingjob.dto.FinalizarContratoDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalizarContrato {

    @Autowired
    private ContratoRepository contratoRepository;

    public ContratoResponseDTO execute(FinalizarContratoDTO finalizarContratoDTO) {

        Contrato contrato = contratoRepository.findById(finalizarContratoDTO.getIdContrato()).get();

        contrato.setFeedback(finalizarContratoDTO.getFeedback());
        contrato.setWasPerformed(finalizarContratoDTO.getWasPerformed().toString());
        contrato.setAvaliacao(finalizarContratoDTO.getAvaliacao());

        return ContratoResponseDTO.convertFromDomain(contratoRepository.save(contrato));
    }
}
