package com.bandtec.darlingjob.dto;

import com.bandtec.darlingjob.gateway.repository.dominio.Contratado;
import com.bandtec.darlingjob.gateway.repository.dominio.Endereco;

import java.util.List;

public class ContratadoRequestDTO {
    private String email;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;
    private String dataNascimento;
    private String telefoneFixo;
    private String telefoneCelular;
    private String cep;
    private String senha;
    private String tipoServico;
    private List<String> diasDisponiveis;
    private String trabalhaFeriados;
    private String horarioInicio;
    private String horarioFim;
    private String horarioFeriadoInicio;
    private String horarioFeriadoFim;
    private Boolean isLogado = false;
    private Integer mediaFeedback = 0;

    public ContratadoRequestDTO(String email, String nome, String cpf, String rg, String genero, String dataNascimento, String telefoneFixo, String telefoneCelular, String cep, String senha, String tipoServico, List<String> diasDisponiveis, String trabalhaFeriados, String horarioInicio, String horarioFim, String horarioFeriadoInicio, String horarioFeriadoFim, Boolean isLogado, Integer mediaFeedback) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.cep = cep;
        this.senha = senha;
        this.tipoServico = tipoServico;
        this.diasDisponiveis = diasDisponiveis;
        this.trabalhaFeriados = trabalhaFeriados;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.isLogado = isLogado;
        this.mediaFeedback = mediaFeedback;
    }

    public static Contratado convertToDomain(ContratadoRequestDTO novoContratado) {

        StringBuilder qtdDiasDisponiveis = new StringBuilder();

        for (String it : novoContratado.getDiasDisponiveis()) {
            qtdDiasDisponiveis.append(" ").append(it);
        }

        return new Contratado(
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
                new Endereco()
        );
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}