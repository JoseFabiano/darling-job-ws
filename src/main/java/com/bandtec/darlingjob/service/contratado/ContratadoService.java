package com.bandtec.darlingjob.service.contratado;

import com.bandtec.darlingjob.dto.ContratadoRequestDTO;
import com.bandtec.darlingjob.dto.ContratadoResponseDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ContratadoService {

    List<ContratadoResponseDTO> getByNome(String nome);

    List<ContratadoResponseDTO> getContratatosByTipoServico(String tipoServico);

    List<ContratadoResponseDTO> getContratados();

    ContratadoResponseDTO createContratado(ContratadoRequestDTO contratadoRequestDTO);

    Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO);

}
