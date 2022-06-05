package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.UsuarioResponseDTO;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BuscarUsuarioPeloId {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<UsuarioResponseDTO> execute(Integer idUsuario) {
        return usuarioRepository.findById(idUsuario)
                .map(UsuarioResponseDTO::convertFromDomain);
    }
}
