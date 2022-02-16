package com.bandtec.darlingjob.gateway.repository;

import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByRoleEquals(String role);

    Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    Usuario findByTipoServicoLike(String tipoServico);

    List<Usuario> findByTipoServicoContainsAndRoleEquals(String tipoServico, String role);

    @Query(value = "", nativeQuery = true)
    List<Usuario> findByTipoServicoIsLikeAndRoleIs(String tipoServico, String role);

//    Usuario findByTipoServicoLikeAndRoleEquals(String tipoServico, String role);

    Usuario findByNomeLike(String nome);

    Usuario findByNomeLikeAndRoleEquals(String nome, String role);

    Usuario findByNomeIsLikeAndRoleEquals(String nome, String profissional);
}
