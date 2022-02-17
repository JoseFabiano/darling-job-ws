package com.bandtec.darlingjob.gateway.repository;

import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    List<Usuario> findByRoleEquals(String role);

    Optional<Usuario> findByNomeAndSenha(String nome, String senha);

    @Query(value = "SELECT id_usuario, horario_feriado_fim, horario_feriado_inicio, cpf, data_nascimento, dias_disponiveis, email, genero, horario_fim_dia, horario_inicio_dia, nome, rg, [role], senha, telefone_celular, telefone_fixo, tipo_servico, trabalha_feriados, id_endereco " +
            "FROM [darling-job].dbo.usuario u " +
            "where (u.tipo_servico like CONCAT('%', :tipoServico, '%') and u.role = :role)", nativeQuery = true)
    List<Usuario> findByTipoServicoIsLikeAndRoleIs(String tipoServico, String role);

    @Query(value = "SELECT id_usuario, horario_feriado_fim, horario_feriado_inicio, cpf, data_nascimento, dias_disponiveis, email, genero, horario_fim_dia, horario_inicio_dia, nome, rg, [role], senha, telefone_celular, telefone_fixo, tipo_servico, trabalha_feriados, id_endereco " +
            "FROM [darling-job].dbo.usuario u " +
            "where (u.nome like CONCAT('%', :nome, '%') and u.role = :role)", nativeQuery = true)
    List<Usuario> findByNomeIsLikeAndRoleEquals(String nome, String role);
}
