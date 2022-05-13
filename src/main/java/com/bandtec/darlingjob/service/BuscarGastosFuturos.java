package com.bandtec.darlingjob.service;

import com.bandtec.darlingjob.dto.GastoFixoResponseDTO;
import com.bandtec.darlingjob.dto.GastoFuturoRequestDTO;
import com.bandtec.darlingjob.dto.GastoFuturoResponseDTO;
import com.bandtec.darlingjob.gateway.repository.GastoFuturoRepository;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFixo;
import com.bandtec.darlingjob.gateway.repository.dominio.GastoFuturo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuscarGastosFuturos {

    @Autowired
    private GastoFuturoRepository gastoFuturoRepository;

    public List<GastoFuturoResponseDTO> execute(Integer idUsuario) {

        List<GastoFuturo> gastosFuturos = gastoFuturoRepository.findByUsuario_IdUsuario(idUsuario);

        return gastosFuturos.stream()
                .map(gastoFuturo -> new GastoFuturoResponseDTO(
                        gastoFuturo.getIdGastoFuturo(),
                        gastoFuturo.getNome(),
                        gastoFuturo.getValor(),
                        idUsuario
                )).collect(Collectors.toList());
    }
}
