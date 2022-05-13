package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.GastoFixoRequestDTO;
import com.bandtec.darlingjob.dto.GastoFixoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.GastoFixoRepository;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFixo;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarGastoFixo {

    @Autowired
    private GastoFixoRepository gastoFixoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public GastoFixoResponseDTO execute(GastoFixoRequestDTO gastoFixoRequestDTO) {
        Usuario usuario = usuarioRepository.findById(gastoFixoRequestDTO.getIdUsuario()).get();

        GastoFixo gastoFixoSalvo = gastoFixoRepository.save(new GastoFixo(
                gastoFixoRequestDTO.getNome(),
                gastoFixoRequestDTO.getValor(),
                usuario
        ));
        return GastoFixoResponseDTO.convertFromDomain(gastoFixoSalvo);
    }
}
