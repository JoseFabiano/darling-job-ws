package com.bandtec.projetojpa01.controle;

import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.dominio.Contratante;
import com.bandtec.projetojpa01.repositorio.ContratanteRepository;
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

@SpringBootTest
class ContratanteControllerTest {
    @Autowired
    ContratanteController controller;

    @MockBean
    ContratanteRepository repository;

    @Test
    void get_semContratado_status204SemCorpo(){
        when(repository.findAll()).thenReturn((new ArrayList<>()));
        ResponseEntity response = controller.getContratante();
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void get_comContratado_status200ListaNoCorpo(){
        List<Contratante> contratanteMock = List.of(mock(Contratante.class), mock(Contratante.class));
        when(repository.findAll()).thenReturn(contratanteMock);
        ResponseEntity response = controller.getContratante();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
        assertEquals(contratanteMock, response.getBody());
    }

    @Test
    void get_apenasUmContratado_status200ComCorpo(){
        Integer id = 100;
        Optional<Contratante> contratanteMock = Optional.ofNullable(new Contratante());
        when(repository.existsById(id)).thenReturn(true);
        when(repository.findById(id)).thenReturn(contratanteMock);
        ResponseEntity response = controller.getContratante(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(contratanteMock, response.getBody());
    }

    @Test
    void get_apenasUmContratado_status404SemCorpo(){
        Integer id = 100;
        when(repository.existsById(id)).thenReturn(false);
        ResponseEntity response = controller.getContratante(id);
        assertEquals(404, response.getStatusCodeValue());
        assertFalse(response.hasBody());
    }

    @Test
    void post_cadastroContratado_status201(){
        Contratante contratante = new Contratante();
        List<Contratante> contratadoList = List.of(mock(Contratante.class));
        ResponseEntity response = controller.postContratante(contratante);
        repository.save(contratante);
        when(repository.findAll()).thenReturn(contratadoList);
        assertEquals(201, response.getStatusCodeValue());
    }
}