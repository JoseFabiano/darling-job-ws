package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ContratoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarContratos {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<ContratoResponseDTO> execute(String idUsuario){

        List<Contrato> teste = contratoRepository.findByContratado_IdUsuario(Integer.valueOf(idUsuario));

        return contratoRepository.findByContratado_IdUsuario(Integer.valueOf(idUsuario))
                .stream()
                .map(ContratoResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

}
