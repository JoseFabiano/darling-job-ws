package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.AutenticarResponseDTO;
import com.bandtec.darlingjob.dto.AutenticarRequestDTO;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticarUsuario {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<AutenticarResponseDTO> execute(AutenticarRequestDTO autenticarRequestDTO){
                return usuarioRepository.findByNomeAndSenha(autenticarRequestDTO.getNome(), autenticarRequestDTO.getSenha())
                .map(AutenticarResponseDTO::convertFromDomain);
    }

}
