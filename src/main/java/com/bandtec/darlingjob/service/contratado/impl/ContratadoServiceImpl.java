package com.bandtec.darlingjob.service.contratado.impl;

import com.bandtec.darlingjob.dto.ContratadoRequestDTO;
import com.bandtec.darlingjob.dto.ContratadoResponseDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;
import com.bandtec.darlingjob.gateway.repository.ContratadoRepository;
import com.bandtec.darlingjob.gateway.repository.EnderecoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contratado;
import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.bandtec.darlingjob.service.contratado.ContratadoService;
import com.bandtec.darlingjob.utils.FilaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContratadoServiceImpl implements ContratadoService {

    @Autowired
    private ContratadoRepository contratadoRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public List<ContratadoResponseDTO> getByNome(String nome) {

        List<Contratado> listContratado = contratadoRepository.findByNomeLike(nome);

        return listContratado
                .stream()
                .map(ContratadoResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratadoResponseDTO> getContratatosByTipoServico(String tipoServico) {

        List<Contratado> listContratado = contratadoRepository.findByTipoServicoLike(tipoServico);

        return listContratado
                .stream()
                .map(ContratadoResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<ContratadoResponseDTO> getContratados() {

        List<Contratado> contratados = contratadoRepository.findAll();

        List<Contratado> contratadoResultado = new ArrayList<>();
        FilaObj<Contratado> filaObj = new FilaObj(contratados.size());

        contratados.forEach(filaObj::add);

        for (int i = 0; i < contratados.size(); i++) {
            contratadoResultado.add((Contratado) filaObj.poll());
        }

        return contratadoResultado
                .stream()
                .map(ContratadoResponseDTO::convertFromDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ContratadoResponseDTO createContratado(ContratadoRequestDTO contratadoRequestDTO) {
        Contratado contratado = ContratadoRequestDTO.convertToDomain(contratadoRequestDTO);

        Contratado contratadoSalvo = contratadoRepository.save(contratado);

        enderecoRepository.save(contratadoSalvo.getEndereco());

        return ContratadoResponseDTO.convertFromDomain(contratadoSalvo);
    }

    @Override
    public Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO) {
        return contratadoRepository
                .findByNomeAndSenha(loginRequestDTO.getNome(), loginRequestDTO.getSenha())
                .map(LoginResponseDTO::convertFromDomain);
    }


}
