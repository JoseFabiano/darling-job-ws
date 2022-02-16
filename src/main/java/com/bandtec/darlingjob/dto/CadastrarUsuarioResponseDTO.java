package com.bandtec.darlingjob.dto;

import java.lang.String;
import com.bandtec.darlingjob.gateway.repository.dominio.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastrarUsuarioResponseDTO {
    @JsonProperty("id_usuario")
    private Integer idUsuario;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("email")
    private String email;

    @JsonProperty("telefone_celular")
    private String telefoneCelular;

    @JsonProperty("telefone_fixo")
    private String telefoneFixo;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("role")
    private String role;

    @JsonProperty("dias_disponiveis")
    private String diasDisponiveis;

    @JsonProperty("horario_feriado_fim")
    private String HorarioFeriadoFim;

    @JsonProperty("horario_feriado_inicio")
    private String HorarioFeriadoInicio;

    @JsonProperty("horario_inicio_dia")
    private String horarioInicioDia;

    @JsonProperty("horarioFimDia")
    private String horarioFimDia;

    @JsonProperty("trabalhaFeriados")
    private Boolean trabalhaFeriados;

    public CadastrarUsuarioResponseDTO(Integer idUsuario, String nome, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.role = role;
    }

    public CadastrarUsuarioResponseDTO(Integer idUsuario, String nome, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role, String diasDisponiveis, String horarioFeriadoFim, String horarioFeriadoInicio, String horarioInicioDia, String horarioFimDia, Boolean trabalhaFeriados) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.role = role;
        this.diasDisponiveis = diasDisponiveis;
        this.HorarioFeriadoFim = horarioFeriadoFim;
        this.HorarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioInicioDia = horarioInicioDia;
        this.horarioFimDia = horarioFimDia;
        this.trabalhaFeriados = trabalhaFeriados;
    }

    public static CadastrarUsuarioResponseDTO convertFromDomain(Usuario usuario) {
        return new CadastrarUsuarioResponseDTO(
                usuario.getIdUsuario(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getTelefoneCelular(),
                usuario.getTelefoneFixo(),
                usuario.getRg(),
                usuario.getCpf(),
                usuario.getDataNascimento(),
                usuario.getGenero(),
                usuario.getRole(),
                usuario.getDiasDisponiveis(),
                usuario.getHorarioFeriadoFim(),
                usuario.getHorarioFeriadoInicio(),
                usuario.getHorarioInicioDia(),
                usuario.getHorarioFimDia(),
                usuario.getTrabalhaFeriados()
        );
    }
}
