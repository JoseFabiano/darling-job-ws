package com.bandtec.darlingjob.controle;

import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.bandtec.darlingjob.gateway.controller.EnderecoController;
import com.bandtec.darlingjob.gateway.repository.EnderecoRepository;
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
class EnderecoControllerTest {

    @Autowired
    EnderecoController controller;

    @MockBean
    EnderecoRepository repository;

    @Test
    void get_semEndereco_status204SemCorpo(){
        when(repository.findAll()).thenReturn((new ArrayList<>()));
        ResponseEntity response = controller.getEndereco();
        assertEquals(204, response.getStatusCodeValue());
    }

    @Test
    void get_comEndereco_status200ListaNoCorpo(){
        List<Endereco> enderecoMock = List.of(mock(Endereco.class), mock(Endereco.class));
        when(repository.findAll()).thenReturn(enderecoMock);
        ResponseEntity response = controller.getEndereco();

        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.hasBody());
        assertEquals(enderecoMock, response.getBody());
    }

    @Test
    void get_apenasUmEndereco_status200ComCorpo(){
        Integer id = 100;
        Optional<Endereco> enderecoMock = Optional.ofNullable(new Endereco());
        when(repository.existsById(id)).thenReturn(true);
        when(repository.findById(id)).thenReturn(enderecoMock);
        ResponseEntity response = controller.getEndereco(id);

        assertEquals(200, response.getStatusCodeValue());
        assertEquals(enderecoMock, response.getBody());
    }

    @Test
    void post_cadastroEndereco_status201(){
        Endereco endereco = new Endereco();
        List<Endereco> enderecoList = List.of(mock(Endereco.class));
        ResponseEntity response = controller.postEndereco(endereco);
        repository.save(endereco);
        when(repository.findAll()).thenReturn(enderecoList);
        assertEquals(201, response.getStatusCodeValue());
    }
}