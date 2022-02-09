package com.bandtec.projetojpa01.requisicao;

import com.bandtec.projetojpa01.dominio.Contratado;

import java.util.List;

public class ContratadoDTO {
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
    private List<String> qtdDiasDisponiveis;
    private String trabFeriados;
    private String horarioInicio;
    private String horarioFim;
    private String horarioFeriadoInicio;
    private String horarioFeriadoFim;
    private Boolean isLogado = false;
    private Integer mediaFeedback = 0;

    public ContratadoDTO(String email, String nome, String cpf, String rg, String genero, String dataNascimento, String telefoneFixo, String telefoneCelular, String cep, String senha, String tipoServico, List<String> qtdDiasDisponiveis, String trabFeriados, String horarioInicio, String horarioFim, String horarioFeriadoInicio, String horarioFeriadoFim, Boolean isLogado, Integer mediaFeedback) {
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
        this.qtdDiasDisponiveis = qtdDiasDisponiveis;
        this.trabFeriados = trabFeriados;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.isLogado = isLogado;
        this.mediaFeedback = mediaFeedback;
    }

    public static Contratado convertToDomain(ContratadoDTO novoContratado) {

        StringBuilder qtdDiasDisponiveis = new StringBuilder();

        for (String it : novoContratado.getQtdDiasDisponiveis()) {
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
                novoContratado.cep,
                novoContratado.senha,
                novoContratado.tipoServico,
                qtdDiasDisponiveis.toString(),
                novoContratado.trabFeriados,
                novoContratado.horarioInicio,
                novoContratado.horarioFim,
                novoContratado.horarioFeriadoInicio,
                novoContratado.horarioFeriadoFim,
                novoContratado.isLogado = false,
                novoContratado.mediaFeedback = 0
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

    public List<String> getQtdDiasDisponiveis() {
        return qtdDiasDisponiveis;
    }

    public void setQtdDiasDisponiveis(List<String> qtdDiasDisponiveis) {
        this.qtdDiasDisponiveis = qtdDiasDisponiveis;
    }

    public String getTrabFeriados() {
        return trabFeriados;
    }

    public void setTrabFeriados(String trabFeriados) {
        this.trabFeriados = trabFeriados;
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