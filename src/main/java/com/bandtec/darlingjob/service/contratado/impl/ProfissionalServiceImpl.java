package com.bandtec.darlingjob.service.contratado.impl;

import com.bandtec.darlingjob.dto.ProfissionalRequestDTO;
import com.bandtec.darlingjob.dto.ProfissionalResponseDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;
import com.bandtec.darlingjob.gateway.repository.ContratadoRepository;
import com.bandtec.darlingjob.gateway.repository.EnderecoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Profissional;
import com.bandtec.darlingjob.service.contratado.ProfissionalService;
import com.bandtec.darlingjob.utils.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfissionalServiceImpl implements ProfissionalService {

    @Autowired
    private ContratadoRepository contratadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<ProfissionalResponseDTO> getByNome(String nome) {

        List<Profissional> listProfissional = contratadoRepository.findByNomeLike(nome);

        return listProfissional
                .stream()
                .map(ProfissionalResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfissionalResponseDTO> getContratatosByTipoServico(String tipoServico) {

        List<Profissional> listProfissional = contratadoRepository.findByTipoServicoLike(tipoServico);

        return listProfissional
                .stream()
                .map(ProfissionalResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfissionalResponseDTO> getContratados() {

        List<Profissional> profissionals = contratadoRepository.findAll();

        List<Profissional> profissionalResultado = new ArrayList<>();
        FilaObj<Profissional> filaObj = new FilaObj(profissionals.size());

        profissionals.forEach(filaObj::add);

        for (int i = 0; i < profissionals.size(); i++) {
            profissionalResultado.add((Profissional) filaObj.poll());
        }

        return profissionalResultado
                .stream()
                .map(ProfissionalResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ProfissionalResponseDTO createContratado(ProfissionalRequestDTO profissionalRequestDTO) {
        Profissional profissional = ProfissionalRequestDTO.convertToDomain(profissionalRequestDTO);

        Profissional profissionalSalvo = contratadoRepository.save(profissional);

        enderecoRepository.save(profissionalSalvo.getEndereco());

        return ProfissionalResponseDTO.convertFromDomain(profissionalSalvo);
    }

    @Override
    public Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO) {
        return contratadoRepository
                .findByNomeAndSenha(loginRequestDTO.getNome(), loginRequestDTO.getSenha())
                .map(LoginResponseDTO::convertFromDomain);
    }


}
