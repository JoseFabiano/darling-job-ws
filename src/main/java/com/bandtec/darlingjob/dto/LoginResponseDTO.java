package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Profissional;
import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginResponseDTO {

    @JsonProperty("id_contratado")
    private Integer idContratado;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("cpf")
    private String cpf;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("data_nascimento")
    private String dataNascimento;

    @JsonProperty("telefone_fixo")
    private String telefoneFixo;

    @JsonProperty("telefone_celular")
    private String telefoneCelular;

    @JsonProperty("tipo_servico")
    private String tipoServico;

    @JsonProperty("dias_disponiveis")
    private String diasDisponiveis;

    @JsonProperty("trabalha_feriados")
    private Boolean trabalhaFeriados;

    @JsonProperty("horario_inicio")
    private String horarioInicio;

    @JsonProperty("horario_fim")
    private String horarioFim;

    @JsonProperty("horario_feriado_inicio")
    private String horarioFeriadoInicio;

    @JsonProperty("horario_feriado_fim")
    private String horarioFeriadoFim;

    @JsonProperty("is_logado")
    private Boolean isLogado = false;

    @JsonProperty("media_feedback")
    private Integer mediaFeedback = 0;

    @JsonProperty("endereco")
    private Endereco endereco;

    public LoginResponseDTO() {
    }

    public LoginResponseDTO(Integer idContratado, String email, String nome, String cpf, String rg, String genero, String dataNascimento, String telefoneFixo, String telefoneCelular, String tipoServico, String diasDisponiveis, Boolean trabalhaFeriados, String horarioInicio, String horarioFim, String horarioFeriadoInicio, String horarioFeriadoFim, Boolean isLogado, Integer mediaFeedback, Endereco endereco) {
        this.idContratado = idContratado;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.tipoServico = tipoServico;
        this.diasDisponiveis = diasDisponiveis;
        this.trabalhaFeriados = trabalhaFeriados;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.isLogado = isLogado;
        this.mediaFeedback = mediaFeedback;
        this.endereco = endereco;
    }

    public static LoginResponseDTO convertFromDomain(Profissional profissional) {
        return new LoginResponseDTO(
                profissional.getIdContratado(),
                profissional.getEmail(),
                profissional.getNome(),
                profissional.getCpf(),
                profissional.getRg(),
                profissional.getGenero(),
                profissional.getDataNascimento(),
                profissional.getTelefoneFixo(),
                profissional.getTelefoneCelular(),
                profissional.getTipoServico(),
                profissional.getDiasDisponiveis(),
                profissional.getTrabalhaFeriados(),
                profissional.getHorarioInicio(),
                profissional.getHorarioFim(),
                profissional.getHorarioFeriadoInicio(),
                profissional.getHorarioFeriadoFim(),
                profissional.isLogado,
                profissional.getMediaFeedback(),
                profissional.getEndereco()
        );
    }

    public Integer getIdContratado() {
        return idContratado;
    }

    public void setIdContratado(Integer idContratado) {
        this.idContratado = idContratado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public String getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void setDiasDisponiveis(String diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    public Boolean getTrabalhaFeriados() {
        return trabalhaFeriados;
    }

    public void setTrabalhaFeriados(Boolean trabalhaFeriados) {
        this.trabalhaFeriados = trabalhaFeriados;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(String horarioFim) {
        this.horarioFim = horarioFim;
    }

    public String getHorarioFeriadoInicio() {
        return horarioFeriadoInicio;
    }

    public void setHorarioFeriadoInicio(String horarioFeriadoInicio) {
        this.horarioFeriadoInicio = horarioFeriadoInicio;
    }

    public String getHorarioFeriadoFim() {
        return horarioFeriadoFim;
    }

    public void setHorarioFeriadoFim(String horarioFeriadoFim) {
        this.horarioFeriadoFim = horarioFeriadoFim;
    }

    public Boolean getLogado() {
        return isLogado;
    }

    public void setLogado(Boolean logado) {
        isLogado = logado;
    }

    public Integer getMediaFeedback() {
        return mediaFeedback;
    }

    public void setMediaFeedback(Integer mediaFeedback) {
        this.mediaFeedback = mediaFeedback;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
