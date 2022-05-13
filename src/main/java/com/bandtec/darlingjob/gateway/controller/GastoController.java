package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.GastoFixoRequestDTO;
import com.bandtec.darlingjob.dto.GastoFixoResponseDTO;
import com.bandtec.darlingjob.dto.GastoFuturoRequestDTO;
import com.bandtec.darlingjob.dto.GastoFuturoResponseDTO;
import com.bandtec.darlingjob.service.BuscarGastosFixos;
import com.bandtec.darlingjob.service.BuscarGastosFuturos;
import com.bandtec.darlingjob.service.CriarGastoFixo;
import com.bandtec.darlingjob.service.CriarGastoFuturo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/gastos")
public class GastoController {

    @Autowired
    private CriarGastoFuturo criarGastoFuturo;

    @Autowired
    private CriarGastoFixo criarGastoFixo;

    @Autowired
    private BuscarGastosFuturos buscarGastosFuturos;

    @Autowired
    private BuscarGastosFixos buscarGastosFixos;

    @PostMapping("/{idUsuario}/futuros")
    public ResponseEntity<GastoFuturoResponseDTO> criarFuturo(
            @PathVariable Integer idUsuario,
            @RequestBody GastoFuturoRequestDTO gastoFuturoRequestDTO
    ){
        gastoFuturoRequestDTO.setIdUsuario(idUsuario);
        return ResponseEntity.ok(criarGastoFuturo.execute(gastoFuturoRequestDTO));
    }

    @PostMapping("/{idUsuario}/fixos")
    public ResponseEntity<GastoFixoResponseDTO> criarFixo(
            @PathVariable Integer idUsuario,
            @RequestBody GastoFixoRequestDTO gastoFixoRequestDTO
    ){
        gastoFixoRequestDTO.setIdUsuario(idUsuario);
        return ResponseEntity.ok(criarGastoFixo.execute(gastoFixoRequestDTO));
    }

    @GetMapping("/{idUsuario}/futuros")
    public ResponseEntity<List<GastoFuturoResponseDTO>> buscarFuturos(
            @PathVariable Integer idUsuario
    ){
        return ResponseEntity.ok(buscarGastosFuturos.execute(idUsuario));
    }

    @GetMapping("/{idUsuario}/fixos")
    public ResponseEntity<List<GastoFixoResponseDTO>> buscarFixos(
            @PathVariable Integer idUsuario
    ){
        return ResponseEntity.ok(buscarGastosFixos.execute(idUsuario));
    }


}
