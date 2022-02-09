package com.bandtec.projetojpa01.controle;

import com.bandtec.projetojpa01.classes.Csv;
import com.bandtec.projetojpa01.classes.FilaObj;
import com.bandtec.projetojpa01.classes.ListaObj;
import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.dominio.Contratante;
import com.bandtec.projetojpa01.repositorio.ContratanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/darlingjob/contratante")
public class ContratanteController {

    @Autowired
    private ContratanteRepository repository;
    private ArrayList<Contratante> contratante;

    @CrossOrigin
    @GetMapping
    public ResponseEntity getContratante() {
        List<Contratante> contratante = repository.findAll();
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

    @CrossOrigin
    @PostMapping
    public ResponseEntity postContratante(@RequestBody Contratante novoContratante) {
        repository.save(novoContratante);
        return ResponseEntity.status(201).build();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity getContratante(@PathVariable int id) {
        if (repository.existsById(id)) {
            return ResponseEntity.status(200).body(repository.findById(id));
        }

        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity deleteContratante(@PathVariable int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.status(200).build();
        }

        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/login/{email}/{senha}")
    private ResponseEntity loginContratante(@PathVariable String email, @PathVariable String senha) {
        List<Contratante> contratanteList = repository.findAll();
        for (int i = 0; i < contratanteList.size(); i++) {
            Contratante contratante = contratanteList.get(i);
            if (contratante.getEmail().equalsIgnoreCase(email) &&
                    contratante.getSenha().equals(senha)) {

                contratante.setLogado(true);
                repository.save(contratante);
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/login/{id}")
    private ResponseEntity logoutContratante(@PathVariable Integer id) {
        List<Contratante> contratanteList = repository.findAll();
        for (int i = 0; i < contratanteList.size(); i++) {
            Contratante contratante = contratanteList.get(i);
            if (contratante.getIdContratante().equals(id)) {
                contratante.setLogado(false);
                repository.save(contratante);
                return ResponseEntity.status(201).build();
            }
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @GetMapping("/logado/{email}/{senha}")
    public ResponseEntity userLogado(@PathVariable String email, @PathVariable String senha){
        List<Contratante> contratanteList = repository.findAll();
        for (int i = 0; i < contratanteList.size(); i++) {
            if(contratanteList.get(i).getEmail().equalsIgnoreCase(email) &&
                    contratanteList.get(i).getSenha().equals(senha)){
                return ResponseEntity.status(200).body(contratanteList.get(i));
            }
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity updateContratante(@PathVariable int id,
                                           @RequestBody Contratante contratante) {
        if (repository.existsById(id)) {
            contratante.setIdContratante(id);
            repository.save(contratante);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @CrossOrigin
    @PostMapping("/download")
    public ResponseEntity downloadLista() {
        ListaObj<Contratante> listaContratante = new ListaObj<Contratante>((int) repository.count());
        List<Contratante> contratanteAux = repository.findAll();
        for (int i = 0; i < contratanteAux.size(); i++) {
            Contratante contratante = contratanteAux.get(i);
            listaContratante.adiciona(contratante);
        }

        Csv.gravaArquivoContratante(listaContratante, "Contratante");

        return ResponseEntity.status(200).build();
    }

    @CrossOrigin
    @GetMapping("/lercsv")
    public ResponseEntity lerCsv(){
        Csv.leExibeArquivoContratante("Contratante");
        return ResponseEntity.status(200).build();
    }
}
