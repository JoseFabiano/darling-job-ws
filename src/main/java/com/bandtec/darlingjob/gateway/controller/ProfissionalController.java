package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.DadosProfissionalDTO;
import com.bandtec.darlingjob.dto.ProfissionalResponseDTO;
import com.bandtec.darlingjob.service.BuscarDadosProfissional;
import com.bandtec.darlingjob.service.ListarProfissionais;
import com.bandtec.darlingjob.service.PesquisarProfissionalByNome;
import com.bandtec.darlingjob.service.PesquisarProfissionalByTipoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/profissional")
public class ProfissionalController {

    @Autowired
    private ListarProfissionais listarProfissionais;

    @Autowired
    private PesquisarProfissionalByNome pesquisarProfissionalByNome;

    @Autowired
    private PesquisarProfissionalByTipoServico pesquisarProfissionalByTipoServico;

    @Autowired
    private BuscarDadosProfissional buscarDadosProfissional;

    @GetMapping("/buscar-nome/{nome}")
    public ResponseEntity<List<ProfissionalResponseDTO>> listarProfissional(@PathVariable String nome) {

        List<ProfissionalResponseDTO> listContratado = pesquisarProfissionalByNome.execute(nome);

        if (listContratado.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listContratado);
        }
    }

    @GetMapping("/buscar-servico/{tipoServico}")
    public ResponseEntity<List<ProfissionalResponseDTO>> pesquisarProfissionalByTipoServico(@PathVariable String tipoServico) {

        List<ProfissionalResponseDTO> listContratado = pesquisarProfissionalByTipoServico.execute(tipoServico);

        if (listContratado.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listContratado);
        }

    }

    @GetMapping
    public ResponseEntity<List<ProfissionalResponseDTO>> listarProfissionais() {

        List<ProfissionalResponseDTO> contratados = listarProfissionais.execute();

        if (contratados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(contratados);
        }

    }

    @GetMapping("/logado/{idUsuarioProfissional}")
    public ResponseEntity<DadosProfissionalDTO> dadosProfissional(
            @PathVariable Integer idUsuarioProfissional
    ){

        return ResponseEntity.ok(buscarDadosProfissional.execute(idUsuarioProfissional));
    }

}

