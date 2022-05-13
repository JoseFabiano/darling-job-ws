package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.DadosContratanteDTO;
import com.bandtec.darlingjob.dto.FeedbacksDTO;
import com.bandtec.darlingjob.gateway.repository.ContratoRepository;
import com.bandtec.darlingjob.gateway.repository.UsuarioRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BuscarDadosContratante {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    public DadosContratanteDTO execute(Integer idUsuarioContratante) {

        Usuario usuario = usuarioRepository.findById(idUsuarioContratante).get();

        List<Contrato> listContratos = new ArrayList<>();

        contratoRepository.findAll()
                .stream()
                .filter(it -> Objects.equals(it.getContratante().getIdUsuario(), idUsuarioContratante))
                .forEach(listContratos::add);

        List<FeedbacksDTO> feedbacksDTOList = new ArrayList<>();

        listContratos.forEach(it -> {
            feedbacksDTOList.add(new FeedbacksDTO(
                    it.getFeedback(),
                    it.getAvaliacao().toString()
            ));
        });

        return new DadosContratanteDTO(
                usuario.getDescricao(),
                usuario.getTipoServico(),
                feedbacksDTOList
        );
    }
}
