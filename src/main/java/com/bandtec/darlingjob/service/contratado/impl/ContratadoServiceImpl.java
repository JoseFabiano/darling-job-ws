package com.bandtec.darlingjob.service.contratado.impl;

import com.bandtec.darlingjob.dto.ContratadoRequestDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;
import com.bandtec.darlingjob.gateway.repository.ContratadoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.Contratado;
import com.bandtec.darlingjob.service.contratado.ContratadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratadoServiceImpl implements ContratadoService {

    @Autowired
    private ContratadoRepository contratadoRepository;

    @Override
    public List<Contratado> getByNome(String nome) {
        return contratadoRepository.findByNomeLike(nome);
    }

    @Override
    public List<Contratado> getContratatosByTipoServico(String tipoServico) {
        return contratadoRepository.findByTipoServicoLike(tipoServico);
    }

    @Override
    public List<Contratado> getListContratado() {
        return contratadoRepository.findAll();
    }

    @Override
    public Contratado postContratado(ContratadoRequestDTO contratadoRequestDTO) {
        Contratado contratado = ContratadoRequestDTO.convertToDomain(contratadoRequestDTO);
        return contratadoRepository.save(contratado);
    }

    @Override
    public Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO) {
        return contratadoRepository.findByNomeAndSenha(loginRequestDTO.getNome(), loginRequestDTO.getSenha())
                .map(it -> new LoginResponseDTO());
    }


}
