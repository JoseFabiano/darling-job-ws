package com.bandtec.projetojpa01.controle;

import com.bandtec.projetojpa01.dominio.Endereco;
import com.bandtec.projetojpa01.repositorio.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/darlingjob/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    private ArrayList<Endereco> endereco;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getEndereco() {
        List<Endereco> endereco = repository.findAll();

        if (endereco.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(endereco);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity postEndereco(@RequestBody Endereco novoEndereco) {
        repository.save(novoEndereco);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getEndereco(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.status(200).body(repository.findById(id));
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
