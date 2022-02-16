package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ProfissionalResponseDTO;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ListarProfissionais {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<ProfissionalResponseDTO> execute(){
        return usuarioRepository.findByRoleEquals("profissional")
                .stream()
                .map(ProfissionalResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

}
