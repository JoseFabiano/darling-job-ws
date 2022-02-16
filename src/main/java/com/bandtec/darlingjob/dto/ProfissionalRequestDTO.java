package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Profissional;
import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ProfissionalRequestDTO {
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
    private List<String> diasDisponiveis;

    @JsonProperty("trabalha_feriados")
    private String trabalhaFeriados;

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

    @JsonProperty("senha")
    private String senha;

    public static Profissional convertToDomain(ProfissionalRequestDTO novoContratado) {

        StringBuilder qtdDiasDisponiveis = new StringBuilder();

        for (String it : novoContratado.getDiasDisponiveis()) {
            qtdDiasDisponiveis.append(" ").append(it);
        }

        return new Profissional(
                novoContratado.email,
                novoContratado.nome,
                novoContratado.cpf,
                novoContratado.rg,
                novoContratado.genero,
                novoContratado.dataNascimento,
                novoContratado.telefoneFixo,
                novoContratado.telefoneCelular,
                novoContratado.senha,
                novoContratado.tipoServico,
                qtdDiasDisponiveis.toString(),
                novoContratado.trabalhaFeriados,
                novoContratado.horarioInicio,
                novoContratado.horarioFim,
                novoContratado.horarioFeriadoInicio,
                novoContratado.horarioFeriadoFim,
                novoContratado.isLogado = false,
                novoContratado.mediaFeedback = 0,
                new Endereco(
                        novoContratado.getEndereco().getIdEndereco(),
                        novoContratado.getEndereco().getEndereco(),
                        novoContratado.getEndereco().getComplemento(),
                        novoContratado.getEndereco().getNumero(),
                        novoContratado.getEndereco().getBairro(),
                        novoContratado.getEndereco().getPais(),
                        novoContratado.getEndereco().getEstado(),
                        novoContratado.getEndereco().getCidade()
                )
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

    public List<String> getDiasDisponiveis() {
        return diasDisponiveis;
    }

    public void setDiasDisponiveis(List<String> diasDisponiveis) {
        this.diasDisponiveis = diasDisponiveis;
    }

    public String getTrabalhaFeriados() {
        return trabalhaFeriados;
    }

    public void setTrabalhaFeriados(String trabalhaFeriados) {
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}