package com.bandtec.projetojpa01.controle;

import com.bandtec.projetojpa01.classes.*;
import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.dominio.Contrato;
import com.bandtec.projetojpa01.repositorio.ContratadoRepository;
import com.bandtec.projetojpa01.requisicao.ContratadoDTO;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/darlingjob/contratado")
public class ContratadoController {

    @Autowired
    private ContratadoRepository repository;
    private ArrayList<Contratado> contratado;


    @CrossOrigin
    @GetMapping("/buscarNome/{nome}")
    public ResponseEntity getBuscaNome(@PathVariable String nome){
       return ResponseEntity.status(200).body(repository.findByNomeLike(nome));
    }


    @CrossOrigin
    @GetMapping("/buscarServico/{tipoServico}")
    public ResponseEntity getBuscaCategoria(@PathVariable String tipoServico){
        List<Contratado> contratados = repository.findByTipoServicoLike(tipoServico);
        List<Contratado> contratadosExibir = new ArrayList<>();

        FilaObj<Contratado> filaObj = new FilaObj<>(contratados.size());

        for(Contratado contratado : contratados ){
            filaObj.add(contratado);
        }

        if (filaObj.isEmpty()) {
            return ResponseEntity.status(204).build();
        } else {
            while (!filaObj.isEmpty()) {
                contratadosExibir.add(filaObj.poll());
            }
        }

        return ResponseEntity.status(200).body(contratadosExibir);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity getContratado() {
        List<Contratado> contratados = repository.findAll();
        List<Contratado> contratadoResultado = new ArrayList<>();

        FilaObj filaObj = new FilaObj(contratados.size());
        for(Contratado contratado : contratados){
            filaObj.add(contratado);
        }
        for(int i = 0; i < contratados.size();i++){
            contratadoResultado.add((Contratado) filaObj.poll());
        }
        if (contratados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(contratadoResultado);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity postContratado(@RequestBody ContratadoDTO novoContratado) {
        Contratado contratado = ContratadoDTO.convertToDomain(novoContratado);
        repository.save(contratado);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getContratado(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.status(200).body(repository.findById(id));
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteContratado(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity updateContratado(@PathVariable int id,
                                           @RequestBody Contratado contratado) {
        if (repository.existsById(id)) {
            contratado.setIdContratado(id);
            repository.save(contratado);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/login/{email}/{senha}")
    private ResponseEntity loginContratado(@PathVariable String email, @PathVariable String senha) {
        List<Contratado> contratadosList = repository.findAll();
        for (int i = 0; i < contratadosList.size(); i++) {
            Contratado contratado = contratadosList.get(i);
            if (contratado.getEmail().equalsIgnoreCase(email) &&
                    contratado.getSenha().equals(senha)) {

                contratado.setLogado(true);
                repository.save(contratado);
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/logout/{id}")
    private ResponseEntity logoutContratado(@PathVariable Integer id) {
        List<Contratado> contratadosList = repository.findAll();
        for (int i = 0; i < contratadosList.size(); i++) {
            Contratado contratado = contratadosList.get(i);
            if (contratado.getIdContratado().equals(id)) {

                contratado.setLogado(false);
                repository.save(contratado);
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/logado/{email}/{senha}")
    public ResponseEntity userLogado(@PathVariable String email, @PathVariable String senha){
        List<Contratado> contratadosList = repository.findAll();
        for (int i = 0; i < contratadosList.size(); i++) {
            if(contratadosList.get(i).getEmail().equalsIgnoreCase(email) &&
            contratadosList.get(i).getSenha().equals(senha)){
                return ResponseEntity.status(200).body(contratadosList.get(i));
            }
        }
        return ResponseEntity.status(404).build();
    }

//    @CrossOrigin
//    @GetMapping("/contratante-nome/{id}")
//    public ResponseEntity getContratanteNomeCategoria(@PathVariable Integer id) {
//        return ResponseEntity.of(Optional.of(repository.listarContratado(id)));
//    }

    @CrossOrigin
    @PostMapping("/download")
    public ResponseEntity downloadLista() {
        ListaObj<Contratado> listaContratado = new ListaObj<Contratado>((int) repository.count());
        List<Contratado> contratadoAux = repository.findAll();
        for (int i = 0; i < contratadoAux.size(); i++) {
            Contratado contratado = contratadoAux.get(i);
            listaContratado.adiciona(contratado);
        }

        Csv.gravaArquivoContratado(listaContratado, "Contratado");

        return ResponseEntity.status(200).build();
    }

    @CrossOrigin
    @GetMapping("/lercsv")
    public ResponseEntity lerCsv(){
        Csv.leExibeArquivoContratado("Contratado");
        return ResponseEntity.status(200).build();
    }
}

