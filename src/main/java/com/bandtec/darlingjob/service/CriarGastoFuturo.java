package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.GastoFuturoRequestDTO;
import com.bandtec.darlingjob.dto.GastoFuturoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.GastoFuturoRepository;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFuturo;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarGastoFuturo {

    @Autowired
    private GastoFuturoRepository gastoFuturoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public GastoFuturoResponseDTO execute(GastoFuturoRequestDTO gastoFuturoRequestDTO) {

        Usuario usuario = usuarioRepository.findById(gastoFuturoRequestDTO.getIdUsuario()).get();

        GastoFuturo gastoFuturoSalvo = gastoFuturoRepository.save(new GastoFuturo(
                gastoFuturoRequestDTO.getNome(),
                gastoFuturoRequestDTO.getValor(),
                usuario
        ));
        return GastoFuturoResponseDTO.convertFromDomain(gastoFuturoSalvo);
    }
}
