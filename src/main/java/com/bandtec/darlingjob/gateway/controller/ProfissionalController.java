package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.ProfissionalResponseDTO;
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

//    @Autowired
//    private ContratadoRepository contratadoRepository;

//    @PostMapping("/login")
//    private ResponseEntity<LoginResponseDTO> loginContratado(@RequestBody LoginRequestDTO loginRequestDTO) {
//        return ResponseEntity.of(profissionalService.autenticar(loginRequestDTO));
//    }
//
//    @PostMapping
//    public ResponseEntity<ProfissionalResponseDTO> createContratado(
//            @RequestBody ProfissionalRequestDTO novoContratado
//    ) {
//        return ResponseEntity.ok(profissionalService.createContratado(novoContratado));
//    }
//
//    @GetMapping("/buscar-nome/{nome}")
//    public ResponseEntity<List<ProfissionalResponseDTO>> getContratadoByNome(@PathVariable String nome) {
//
//        List<ProfissionalResponseDTO> listContratado = profissionalService.getByNome(nome);
//
//        if (listContratado.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(listContratado);
//        }
//    }
//
//    @GetMapping("/buscar-servico/{tipoServico}")
//    public ResponseEntity<List<ProfissionalResponseDTO>> getContratatosByTipoServico(@PathVariable String tipoServico) {
//
//        List<ProfissionalResponseDTO> listContratado = profissionalService.getContratatosByTipoServico(tipoServico);
//
//        if (listContratado.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(listContratado);
//        }
//
//    }
//
//    @GetMapping
//    public ResponseEntity<List<ProfissionalResponseDTO>> getListContratado() {
//
//        List<ProfissionalResponseDTO> contratados = profissionalService.getContratados();
//
//        if (contratados.isEmpty()) {
//            return ResponseEntity.noContent().build();
//        } else {
//            return ResponseEntity.ok(contratados);
//        }
//
//    }

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

