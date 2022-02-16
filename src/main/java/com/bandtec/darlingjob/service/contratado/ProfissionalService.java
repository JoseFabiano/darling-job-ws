package com.bandtec.darlingjob.service.contratado;

import com.bandtec.darlingjob.dto.ProfissionalRequestDTO;
import com.bandtec.darlingjob.dto.ProfissionalResponseDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;

import java.util.List;
import java.util.Optional;

public interface ProfissionalService {

    List<ProfissionalResponseDTO> getByNome(String nome);

    List<ProfissionalResponseDTO> getContratatosByTipoServico(String tipoServico);

    List<ProfissionalResponseDTO> getContratados();

    ProfissionalResponseDTO createContratado(ProfissionalRequestDTO profissionalRequestDTO);

    Optional<LoginResponseDTO> autenticar(LoginRequestDTO loginRequestDTO);

}
