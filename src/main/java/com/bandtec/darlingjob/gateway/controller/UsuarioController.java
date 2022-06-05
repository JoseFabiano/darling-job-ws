package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.*;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import com.bandtec.darlingjob.service.*;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private AutenticarUsuario autenticarUsuario;

    @Autowired
    private CadastrarUsuario cadastrarUsuario;

    @Autowired
    private BuscarUsuarioPeloId buscarUsuarioPeloId;

    @PostMapping("/autenticar")
    private ResponseEntity<AutenticarResponseDTO> autenticarUsuario(@RequestBody AutenticarRequestDTO autenticarRequestDTO) {
        return ResponseEntity.of(autenticarUsuario.execute(autenticarRequestDTO));
    }

    @PostMapping
    public ResponseEntity<CadastrarUsuarioResponseDTO> cadastrarUsuario(
            @RequestBody CadastrarUsuarioRequestDTO cadastrarUsuarioRequestDTO
    ) {
        return ResponseEntity.ok(cadastrarUsuario.execute(cadastrarUsuarioRequestDTO));
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<UsuarioResponseDTO> findUsuarioById(
            @PathVariable Integer idUsuario
    ){
        return ResponseEntity.of(buscarUsuarioPeloId.execute(idUsuario));
    }

}
