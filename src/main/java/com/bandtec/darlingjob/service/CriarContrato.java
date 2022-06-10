package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.ContratoCriadoResponseDTO;
import com.bandtec.darlingjob.dto.CriarContratoRequestDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CriarContrato {

    @Autowired
    private ContratoRepository contratoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public ContratoCriadoResponseDTO execute(CriarContratoRequestDTO criarContratoRequestDTO) {

        Optional<Usuario> contratante = usuarioRepository.findById(criarContratoRequestDTO.getIdUsuarioContratante());
        Optional<Usuario> profissional = usuarioRepository.findById(criarContratoRequestDTO.getIdUsuarioProfissional());

        Contrato contratoCriado = contratoRepository
                .save(new Contrato(
                        criarContratoRequestDTO.getCategoria(),
                        criarContratoRequestDTO.getData(),
                        criarContratoRequestDTO.getValor(),
                        criarContratoRequestDTO.getEndereco(),
                        contratante.get(),
                        profissional.get(),
                        criarContratoRequestDTO.getHora()
                ));

        return ContratoCriadoResponseDTO.convertFromDomain(contratoCriado);
    }
}
