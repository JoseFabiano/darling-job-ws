package com.bandtec.projetojpa01.controle;

import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.repositorio.ContratadoRepository;
import com.bandtec.projetojpa01.requisicao.ContratadoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ContratadoController.class})
class ContratadoControllerTest {

    @Autowired
    ContratadoController controller;

    @MockBean
    ContratadoRepository repository;

    @Test
    void get_semContratado_status204SemCorpo(){
        when(repository.findAll()).thenReturn((new ArrayList<>()));
        ResponseEntity response = controller.getContratado();
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void get_comContratado_status200ListaNoCorpo(){
        List<Contratado> contratadoMock = List.of(mock(Contratado.class), mock(Contratado.class));
        when(repository.findAll()).thenReturn(contratadoMock);
        ResponseEntity response = controller.getContratado();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
        assertEquals(contratadoMock, response.getBody());
    }

//    @Test
//    void get_apenasUmContratado_status200ComCorpo(){
//        Integer id = 100;
//        Optional<Contratado> contratadoMock = Optional.ofNullable(new Contratado);
//        when(repository.existsById(id)).thenReturn(true);
//        when(repository.findById(id)).thenReturn(contratadoMock);
//        ResponseEntity response = controller.getContratado(id);
//
//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(contratadoMock, response.getBody());
//    }

    @Test
    void get_apenasUmContratado_status404SemCorpo(){
        Integer id = 100;
        when(repository.existsById(id)).thenReturn(false);
        ResponseEntity response = controller.getContratado(id);
        assertEquals(404, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

//    @Test
//    void post_cadastroContratado_status201(){
//        ContratadoDTO contratado = new ContratadoDTO();
//        ResponseEntity response = controller.postContratado(contratado);
//        assertEquals(201, response.getStatusCodeValue());
//    }
}