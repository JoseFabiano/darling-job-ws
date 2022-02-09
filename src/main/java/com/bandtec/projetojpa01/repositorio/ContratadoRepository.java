package com.bandtec.projetojpa01.repositorio;

import com.bandtec.projetojpa01.dominio.Contratado;
import com.bandtec.projetojpa01.resposta.ContradadoNomeCategoriaResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContratadoRepository extends JpaRepository<Contratado, Integer> {

    List<Contratado> findByTipoServicoLike(String tipoServico);

//    @Query(value = "SELECT c.id_contratado, c.nome FROM Contratado c WHERE c.nome = ?1", nativeQuery = true)
//    List<Contratado> findContratadoNome(String nome);

    List<Contratado> findByNomeLike(String nome);
//
//    @Query(value = "SELECT * FROM Contratado c, FLOOR((CAST (GetDate() AS DECIMAL) - CAST(c.dataNascimento AS DECIMAL)) / 365.25) WHERE c.tipoServico" +
//            "= ?1", nativeQuery = true)
//    List<Contratado> findUserIdade(String tipoServico);


//    @Query(value = "SELECT * FROM Contratado c WHERE c.categoria = ?1", nativeQuery = true)
//    List<Contratado> findContratadoCategoria(String tipoServico);

//    @Query(value = "Select new br.com.bandtec.projetojpa01.resposta.ContradadoNomeCategoriaResponse(c.categoria, con.nome) from Contrato c join Contratante con on c.id_contratante = con.id_contratante where c.id_contratada = ?1")
//    List<ContradadoNomeCategoriaResponse> listarContratado(Integer id);
}
