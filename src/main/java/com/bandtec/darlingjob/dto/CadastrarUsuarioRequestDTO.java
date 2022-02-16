package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CadastrarUsuarioRequestDTO {
    @JsonProperty("nome")
    private String nome;

    @JsonProperty("senha")
    private String senha;

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

    @JsonProperty("horario_fim_dia")
    private String horarioFimDia;

    @JsonProperty("trabalha_feriados")
    private Boolean trabalhaFeriados;

    @JsonProperty("tipo_servico")
    private String tipoServico;

    private Endereco endereco;

    public CadastrarUsuarioRequestDTO() {
    }

    public CadastrarUsuarioRequestDTO(String nome, String senha, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role, Endereco endereco) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.role = role;
        this.endereco = endereco;
    }

    public CadastrarUsuarioRequestDTO(String nome, String senha, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role, String diasDisponiveis, String horarioFeriadoFim, String horarioFeriadoInicio, String horarioInicioDia, String horarioFimDia, Boolean trabalhaFeriados, Endereco endereco) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.role = role;
        this.diasDisponiveis = diasDisponiveis;
        HorarioFeriadoFim = horarioFeriadoFim;
        HorarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioInicioDia = horarioInicioDia;
        this.horarioFimDia = horarioFimDia;
        this.trabalhaFeriados = trabalhaFeriados;
        this.endereco = endereco;
    }

    public CadastrarUsuarioRequestDTO(String nome, String senha, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role, String diasDisponiveis, String horarioFeriadoFim, String horarioFeriadoInicio, String horarioInicioDia, String horarioFimDia, Boolean trabalhaFeriados, String tipoServico, Endereco endereco) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.role = role;
        this.diasDisponiveis = diasDisponiveis;
        HorarioFeriadoFim = horarioFeriadoFim;
        HorarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioInicioDia = horarioInicioDia;
        this.horarioFimDia = horarioFimDia;
        this.trabalhaFeriados = trabalhaFeriados;
        this.tipoServico = tipoServico;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void setDiasDisponiveis(String diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    public String getHorarioFeriadoFim() {
        return HorarioFeriadoFim;
    }

    public void setHorarioFeriadoFim(String horarioFeriadoFim) {
        HorarioFeriadoFim = horarioFeriadoFim;
    }

    public String getHorarioFeriadoInicio() {
        return HorarioFeriadoInicio;
    }

    public void setHorarioFeriadoInicio(String horarioFeriadoInicio) {
        HorarioFeriadoInicio = horarioFeriadoInicio;
    }

    public String getHorarioInicioDia() {
        return horarioInicioDia;
    }

    public void setHorarioInicioDia(String horarioInicioDia) {
        this.horarioInicioDia = horarioInicioDia;
    }

    public String getHorarioFimDia() {
        return horarioFimDia;
    }

    public void setHorarioFimDia(String horarioFimDia) {
        this.horarioFimDia = horarioFimDia;
    }

    public Boolean getTrabalhaFeriados() {
        return trabalhaFeriados;
    }

    public void setTrabalhaFeriados(Boolean trabalhaFeriados) {
        this.trabalhaFeriados = trabalhaFeriados;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }
}
