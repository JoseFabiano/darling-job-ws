package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ContratoResponseDTO;
import com.bandtec.darlingjob.dto.ResponderContratoDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ResponderContrato {

    @Autowired
    private ContratoRepository contratoRepository;

    public ContratoResponseDTO execute(ResponderContratoDTO responderContratoDTO) {
        Contrato contrato = contratoRepository.findById(responderContratoDTO.getIdContrato()).get();

        contrato.setIsAcepted(responderContratoDTO.getAcepted().toString());
        
        return ContratoResponseDTO.convertFromDomain(contratoRepository.save(contrato));
    }
}
