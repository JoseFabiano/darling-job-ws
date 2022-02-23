package com.bandtec.darlingjob.gateway.controller;

import com.bandtec.darlingjob.dto.ContratoResponseDTO;
import com.bandtec.darlingjob.service.ListarContratos;
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

    @GetMapping
    public ResponseEntity<List<ContratoResponseDTO>> getContratos(
            @RequestParam("id_usuario") String idUsuario
    ) {

        List<ContratoResponseDTO> contratos = listarContratos.execute(idUsuario);

        if (contratos.isEmpty()){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.ok(contratos);
        }

    }

//        @Autowired
//        private Txt txtConverter;

//        @Autowired
//        private ContratoRepository repository;
//        private ArrayList<Contrato> contrato;

//        @Autowired
//        private ContratanteRepository contratanteRepository;

//        @Autowired
//        private ContratadoRepository contratadoRepository;

//        @CrossOrigin
//        @PostMapping
//        public ResponseEntity postContrato(@RequestBody Contrato contrato){
//            repository.save(contrato);
//            return ResponseEntity.status(201).build();
//        }

//        @CrossOrigin
//        @GetMapping("/{id}/true")
//        public ResponseEntity trocarAcepted(@PathVariable int id){
//            List<Contrato> contratos = repository.findAll();
//            for (int i = 0; i < contratos.size(); i++) {
//                Contrato contrato = contratos.get(i);
//                if (contrato.getIdContrato().equals(id)) {
//                    contrato.setIsAcepted("S");
//                    repository.save(contrato);
//                    return ResponseEntity.status(200).build();
//                }
//            }
//            return ResponseEntity.status(404).build();
//        }

//    @CrossOrigin
//    @GetMapping("/{id}/false")
//    public ResponseEntity trocarAceptedN(@PathVariable int id){
//        List<Contrato> contratos = repository.findAll();
//        for (int i = 0; i < contratos.size(); i++) {
//            Contrato contrato = contratos.get(i);
//            if (contrato.getIdContrato().equals(id)) {
//                contrato.setIsAcepted("N");
//                repository.save(contrato);
//                return ResponseEntity.status(200).build();
//            }
//        }
//        return ResponseEntity.status(404).build();
//    }

//        @CrossOrigin
//        @GetMapping("/isAcepted/true")
//        public ResponseEntity getTrue(){
//            if(repository.findTrueContrato().isEmpty()){
//                return ResponseEntity.status(404).build();
//            }else{
//                return ResponseEntity.status(200).body(repository.findTrueContrato());
//            }
//        }

//        @CrossOrigin
//        @GetMapping("/isAcepted/false")
//        public ResponseEntity getFalse(){
//            if(repository.findTrueContrato().isEmpty()){
//                return ResponseEntity.status(404).build();
//            } else {
//                return ResponseEntity.status(200).body(repository.findFalseContrato());
//            }
//        }

//        @CrossOrigin
//        @GetMapping
//        public ResponseEntity getContrato(){
//            List<Contrato> contratos = repository.findNullContrato();
//            List<Contrato> contratosReturn = new ArrayList<>();
//
//            PilhaObj pilhaObj = new PilhaObj(contratos.size());
//
//            for(Contrato contrato : contratos ){
//                pilhaObj.push(contrato);
//            }
//
//            for(int i = 0; i < contratos.size();i++){
//                contratosReturn.add((Contrato) pilhaObj.pop());
//            }
//            if (contratos.isEmpty()) {
//                return ResponseEntity.status(204).build();
//            }
//
//            return ResponseEntity.status(200).body(contratosReturn);
//        }

//        @CrossOrigin
//        @GetMapping("/{id}")
//        public ResponseEntity getContratoId(@PathVariable int id){
//            if (repository.existsById(id)) {
//                return ResponseEntity.status(200).body(repository.findById(id));
//            }
//            return ResponseEntity.status(404).build();
//        }

//        @CrossOrigin
//        @GetMapping("/txt")
//        public ResponseEntity<Resource> getPropertyTxt() throws FileNotFoundException {
//
//            List<Contrato> lista = repository.findAll();
//            txtConverter.gravaArquivoTxt(lista, "contrato");
//            File file = new File("contrato");
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=contrato.txt");
//            headers.add(HttpHeaders.CACHE_CONTROL, "no-cache, no-store, must-revalidate");
//            headers.add(HttpHeaders.PRAGMA, "no-cache");
//            headers.add(HttpHeaders.EXPIRES, "0");
//            InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//            return ResponseEntity.ok()
//                    .headers(headers)
//                    .contentLength(file.length())
//                    .contentType(MediaType.APPLICATION_OCTET_STREAM)
//                    .body(resource);
//        }

//        @CrossOrigin
//        @PostMapping("/import")
//        public ResponseEntity importTxt(@RequestBody MultipartFile file) throws Exception {
//            byte[] data = file.getBytes();
//            FileOutputStream out = new FileOutputStream("contrato");
//            out.write(data);
//            List<Contrato> listaContrato =  txtConverter.leArquivoTxt("contrato.txt");
//            List<Contratante> listaContratante = contratanteRepository.findAll();
//            List<Contratado> listaContratado = contratadoRepository.findAll();
//            for (Contrato contrato : listaContrato){
////                if (listaContratado.stream().map(c -> c.getIdContratado()).collect(Collectors.toList()).contains(contrato.getContratado().getIdContratado())
////                && listaContratante.stream().map(c -> c.getIdContratante()).collect(Collectors.toList()).contains(contrato.getContratante().getIdContratante())){
//                    repository.save(contrato);
//                }else{
//                    throw new Exception("Contratado ou Contratante não existente");
//                }
//            }
//            PrintWriter writer = new PrintWriter("contrato.txt");
//            writer.print("");
//            writer.close();
//
//            return ResponseEntity.status(200).body("Leu");
//        }
}
