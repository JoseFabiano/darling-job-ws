package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.ContratadoResponseDTO;
import com.bandtec.darlingjob.dto.LoginRequestDTO;
import com.bandtec.darlingjob.dto.LoginResponseDTO;
import com.bandtec.darlingjob.service.contratado.ContratadoService;
import com.bandtec.darlingjob.dto.ContratadoRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/contratado")
public class ContratadoController {

    @Autowired
    private ContratadoService contratadoService;

//    @Autowired
//    private ContratadoRepository contratadoRepository;

    @PostMapping("/login")
    private ResponseEntity<LoginResponseDTO> loginContratado(@RequestBody LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.of(contratadoService.autenticar(loginRequestDTO));
    }

    @PostMapping
    public ResponseEntity<ContratadoResponseDTO> createContratado(
            @RequestBody ContratadoRequestDTO novoContratado
    ) {
        return ResponseEntity.ok(contratadoService.createContratado(novoContratado));
    }

    @GetMapping("/buscar-nome/{nome}")
    public ResponseEntity<List<ContratadoResponseDTO>> getContratadoByNome(@PathVariable String nome) {

        List<ContratadoResponseDTO> listContratado = contratadoService.getByNome(nome);

        if (listContratado.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listContratado);
        }
    }

    @GetMapping("/buscar-servico/{tipoServico}")
    public ResponseEntity<List<ContratadoResponseDTO>> getContratatosByTipoServico(@PathVariable String tipoServico) {

        List<ContratadoResponseDTO> listContratado = contratadoService.getContratatosByTipoServico(tipoServico);

        if (listContratado.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(listContratado);
        }

    }

    @GetMapping
    public ResponseEntity<List<ContratadoResponseDTO>> getListContratado() {

        List<ContratadoResponseDTO> contratados = contratadoService.getContratados();

        if (contratados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(contratados);
        }

    }

//    @GetMapping("/{idContratado}")
//    public ResponseEntity<?> getContratado(@PathVariable int idContratado) {
//        if (contratadoRepository.existsById(idContratado)) {
//            return ResponseEntity.status(200).body(contratadoRepository.findById(idContratado));
//        }
//        return ResponseEntity.status(404).build();
//    }

//    @DeleteMapping("/{idContratado}")
//    public ResponseEntity<?> deleteContratado(@PathVariable int idContratado) {
//        if (contratadoRepository.existsById(idContratado)) {
//            contratadoRepository.deleteById(idContratado);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

//    @PutMapping("/{idContrato}")
//    public ResponseEntity<?> updateContratado(@PathVariable int idContrato,
//                                           @RequestBody Contratado contratado) {
//        if (contratadoRepository.existsById(idContrato)) {
//            contratado.setIdContratado(idContrato);
//            contratadoRepository.save(contratado);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

//    @GetMapping("/logout/{id}")
//    private ResponseEntity<?> logoutContratado(@PathVariable Integer id) {
//        List<Contratado> contratadosList = contratadoService.getListContratado();
//        for (Contratado contratado : contratadosList) {
//            if (contratado.getIdContratado().equals(id)) {
//
//                contratado.setLogado(false);
//                contratadoService.save(contratado);
//                return ResponseEntity.status(201).build();
//            }
//        }
//        return ResponseEntity.status(404).build();
//    }

//    @GetMapping("/logado/{email}/{senha}")
//    public ResponseEntity<?> userLogado(@PathVariable String email, @PathVariable String senha){
//        List<Contratado> contratadosList = contratadoRepository.findAll();
//        for (Contratado contratado : contratadosList) {
//            if (contratado.getEmail().equalsIgnoreCase(email) &&
//                    contratado.getSenha().equals(senha)) {
//                return ResponseEntity.status(200).body(contratado);
//            }
//        }
//        return ResponseEntity.of(optionalContratado);
//    }

//    @PostMapping("/download")
//    public ResponseEntity<?> downloadLista() {
//        ListaObj<Contratado> listaContratado = new ListaObj<Contratado>((int) contratadoService.count());
//        List<Contratado> contratadoAux = contratadoService.getListContratado();
//        for (Contratado contratado : contratadoAux) {
//            listaContratado.adiciona(contratado);
//        }
//
//        Csv.gravaArquivoContratado(listaContratado, "Contratado");
//
//        return ResponseEntity.status(200).build();
//    }

//    @GetMapping("/lercsv")
//    public ResponseEntity<?> lerCsv(){
//        Csv.leExibeArquivoContratado("Contratado");
//        return ResponseEntity.status(200).build();
//    }
}

