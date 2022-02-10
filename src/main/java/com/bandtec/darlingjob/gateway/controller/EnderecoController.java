package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.bandtec.darlingjob.gateway.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    private ArrayList<Endereco> endereco;

    @GetMapping
    public ResponseEntity<List<Endereco>> getEndereco() {
        List<Endereco> endereco = repository.findAll();

        if (endereco.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(endereco);
    }

    @PostMapping
    public ResponseEntity<?> postEndereco(@RequestBody Endereco novoEndereco) {
        repository.save(novoEndereco);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEndereco(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.status(200).body(repository.findById(id));
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEndereco(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
