package com.bandtec.darlingjob.service.contratado;

import com.bandtec.darlingjob.dto.ContratadoRequestDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;
import com.bandtec.darlingjob.gateway.repository.dominio.Contratado;

import java.util.List;
import java.util.Optional;

public interface ContratadoService {
    List<Contratado> getByNome(String nome);

    List<Contratado> getContratatosByTipoServico(String tipoServico);

    List<Contratado> getListContratado();

    Contratado postContratado(ContratadoRequestDTO contratadoRequestDTO);

    Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO);
}
