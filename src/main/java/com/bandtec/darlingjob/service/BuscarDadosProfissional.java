package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.DadosProfissionalDTO;
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
import java.util.stream.Stream;

@Service
public class BuscarDadosProfissional {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ContratoRepository contratoRepository;

    public DadosProfissionalDTO execute(Integer idUsuarioProfissional) {

        Usuario usuario = usuarioRepository.findById(idUsuarioProfissional).get();

        List<Contrato> listContratos = new ArrayList<>();

        contratoRepository.findAll()
                .stream()
                .filter(it -> Objects.equals(it.getContratado().getIdUsuario(), idUsuarioProfissional))
                .forEach(listContratos::add);

        List<FeedbacksDTO> feedbacksDTOList = new ArrayList<>();

        listContratos.forEach(it -> {

            Integer avaliacao = 0;

            if (it.getAvaliacao() != null){
                avaliacao = it.getAvaliacao();
            }

            feedbacksDTOList.add(new FeedbacksDTO(
                    it.getFeedback(),
                    avaliacao.toString()
            ));
        });

        return new DadosProfissionalDTO(
                usuario.getDescricao(),
                usuario.getTipoServico(),
                feedbacksDTOList
        );
    }
}
