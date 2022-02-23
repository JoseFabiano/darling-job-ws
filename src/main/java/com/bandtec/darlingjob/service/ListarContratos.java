package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ContratoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarContratos {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<ContratoResponseDTO> execute(String idUsuario){
        return contratoRepository.findByIdUsuario(idUsuario)
                .stream()
                .map(ContratoResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

}
