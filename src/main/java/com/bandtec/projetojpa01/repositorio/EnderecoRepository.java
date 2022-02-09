package com.bandtec.projetojpa01.repositorio;

import com.bandtec.projetojpa01.dominio.Contratante;
import com.bandtec.projetojpa01.dominio.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
