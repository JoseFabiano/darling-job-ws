package com.bandtec.projetojpa01.repositorio;

import com.bandtec.projetojpa01.dominio.Contrato;
import com.bandtec.projetojpa01.resposta.ContratoResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

//    @Query("select c.dataServico, c.valorServico, c.horaServico from Contrato c where c.id = ?1")
//    List<ContratoResponse> findContratosById(Integer idContratado);

    @Query(value = "select * from Contrato c where c.is_acepted = 'S'", nativeQuery = true)List<Contrato> findTrueContrato();

    @Query(value = "select * from Contrato c where c.is_acepted = 'N'", nativeQuery = true)List<Contrato> findFalseContrato();

    @Query(value = "select * from Contrato c where c.is_acepted = 'NR'", nativeQuery = true)List<Contrato> findNullContrato();
}
