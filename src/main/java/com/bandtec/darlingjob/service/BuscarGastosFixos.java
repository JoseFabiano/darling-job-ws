package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.GastoFixoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.GastoFixoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFixo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarGastosFixos {

    @Autowired
    private GastoFixoRepository gastoFixoRepository;

    public List<GastoFixoResponseDTO> execute(Integer idUsuario) {

        List<GastoFixo> gastosFixos = gastoFixoRepository.findByUsuario_IdUsuario(idUsuario);

        return gastosFixos.stream()
                .map(gastoFixo -> new GastoFixoResponseDTO(
                        gastoFixo.getIdGastoFixo(),
                        gastoFixo.getNome(),
                        gastoFixo.getValor(),
                        idUsuario
                )).collect(Collectors.toList());
    }
}
