package com.bandtec.darlingjob.gateway.repository;

import com.bandtec.darlingjob.gateway.repository.dominio.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface ContratoRepository extends JpaRepository<Contrato, Integer> {

//    @Query("select c.dataServico, c.valorServico, c.horaServico from Contrato c where c.id = ?1")
//    List<ContratoResponse> findContratosById(Integer idContratado);

//    @Query(value = "select * from Contrato c where c.is_acepted = 'S'", nativeQuery = true)List<Contrato> findTrueContrato();

//    @Query(value = "select * from Contrato c where c.is_acepted = 'N'", nativeQuery = true)List<Contrato> findFalseContrato();

//    @Query(value = "select * from Contrato c where c.is_acepted = 'NR'", nativeQuery = true)List<Contrato> findNullContrato();

//    @Query(value = "SELECT id_contrato, categoria, [data], endereco, hora, is_acepted, valor, id_usuario_profissional, id_usuario_contratante, feedback " +
//            "FROM [darling-job].dbo.contrato c " +
//            "where c.id_usuario_profissional = :idUsuario or c.id_usuario_contratante = :idUsuario", nativeQuery = true)
//    List<Contrato> findByIdUsuario(String idUsuario);

    List<Contrato> findByContratado_IdUsuario(Integer idUsuario);

    List<Contrato> findByContratante_IdUsuario(Integer idUsuario);


}
