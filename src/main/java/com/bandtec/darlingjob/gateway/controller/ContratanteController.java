package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.DadosContratanteDTO;
import com.bandtec.darlingjob.service.BuscarDadosContratante;
import com.bandtec.darlingjob.utils.FilaObj;
import com.bandtec.darlingjob.gateway.repository.dominio.Contratante;
import com.bandtec.darlingjob.gateway.repository.ContratanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/contratante")
public class ContratanteController {

    @Autowired
    private ContratanteRepository contratanteRepository;

    @Autowired
    private BuscarDadosContratante buscarDadosContratante;

    @GetMapping
    public ResponseEntity<List<Contratante>> getContratante() {
        List<Contratante> contratante = contratanteRepository.findAll();
        List<Contratante> contratanteResultado = new ArrayList<>();
        FilaObj filaObj = new FilaObj(contratante.size());

        for(Contratante contratante1 : contratante){
            filaObj.add(contratante1);
        }

        for(int i = 0; i < contratante.size(); i++){
            contratanteResultado.add((Contratante) filaObj.poll());
        }

        if (contratante.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(contratanteResultado);
    }

    @PostMapping
    public ResponseEntity postContratante(@RequestBody Contratante novoContratante) {
        contratanteRepository.save(novoContratante);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getContratante(@PathVariable int id) {
        if (contratanteRepository.existsById(id)) {
            return ResponseEntity.status(200).body(contratanteRepository.findById(id));
        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateContratante(@PathVariable int id,
                                           @RequestBody Contratante contratante) {
        if (contratanteRepository.existsById(id)) {
            contratante.setIdContratante(id);
            contratanteRepository.save(contratante);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/logado/{idUsuarioContratante}")
    public ResponseEntity<DadosContratanteDTO> dadosContratante(
            @PathVariable Integer idUsuarioContratante
    ){

        return ResponseEntity.ok(buscarDadosContratante.execute(idUsuarioContratante));
    }

}
