package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.*;
import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import com.bandtec.darlingjob.service.CriarContrato;
import com.bandtec.darlingjob.service.FinalizarContrato;
import com.bandtec.darlingjob.service.ListarContratos;
import com.bandtec.darlingjob.service.ResponderContrato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ListarContratos listarContratos;

    @Autowired
    private CriarContrato criarContrato;
    @Autowired
    private ResponderContrato responderContrato;

    @Autowired
    private FinalizarContrato finalizarContrato;

    @GetMapping
    public ResponseEntity<List<ContratoResponseDTO>> getContratos(
            @RequestParam("id_usuario") String idUsuario
    ) {

        List<ContratoResponseDTO> contratos = listarContratos.execute(idUsuario);

        if (contratos.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(contratos);
        }

    }

    @PostMapping
    public ResponseEntity<ContratoCriadoResponseDTO> criarContrato(
            @RequestBody CriarContratoRequestDTO criarContratoRequestDTO
    ) {
        return ResponseEntity.ok(criarContrato.execute(criarContratoRequestDTO));
    }

    @PutMapping("/{idContrato}/responder")
    public ResponseEntity<ContratoResponseDTO> responderContrato(
            @PathVariable Integer idContrato,
            @RequestBody ResponderContratoDTO responderContratoDTO
    ){

        responderContratoDTO.setIdContrato(idContrato);

        return ResponseEntity.ok(responderContrato.execute(responderContratoDTO));
    }

    @PutMapping("/{idContrato}/finalizar")
    public ResponseEntity<ContratoResponseDTO> finalizarContrato(
            @PathVariable Integer idContrato,
            @RequestBody FinalizarContratoDTO finalizarContratoDTO
    ){

        finalizarContratoDTO.setIdContrato(idContrato);

        return ResponseEntity.ok(finalizarContrato.execute(finalizarContratoDTO));
    }

}
