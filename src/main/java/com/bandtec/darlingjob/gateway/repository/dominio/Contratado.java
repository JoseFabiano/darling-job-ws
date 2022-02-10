package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class Contratado {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_contratado")
    private Integer idContratado;
    private String email;
    private String nome;
    private String cpf;
    private String rg;
    private String genero;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(name = "telefone_celular")
    private String telefoneCelular;
    private String senha;

    @Column(name = "tipo_servico")
    private String tipoServico;

    @Column(name = "dias_disponiveis")
    private String diasDisponiveis;

    @Column(name = "trabalha_feriados")
    private String trabalhaFeriados;

    @Column(name = "horario_inicio")
    private String horarioInicio;

    @Column(name = "horario_fim")
    private String horarioFim;

    @Column(name = "horario_feriado_inicio")
    private String horarioFeriadoInicio;

    @Column(name = "horario_feriado_fim")
    private String horarioFeriadoFim;

    @Column(name = "is_logado")
    private Boolean isLogado = false;

    @Column(name = "media_feedback")
    private Integer mediaFeedback = 0;

    @ManyToOne
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Contratado() {

    }


    public Contratado(Integer idContratado, String email, String nome, String cpf, String rg, String genero, String dataNascimento, String telefoneFixo, String telefoneCelular, String senha, String tipoServico, String diasDisponiveis, String trabalhaFeriados, String horarioInicio, String horarioFim, String horarioFeriadoInicio, String horarioFeriadoFim, Boolean isLogado, Integer mediaFeedback, Endereco endereco) {
        this.idContratado = idContratado;
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
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
        this.endereco = endereco;
    }

    public Contratado(String email, String nome, String cpf, String rg, String genero, String dataNascimento, String telefoneFixo, String telefoneCelular, String senha, String tipoServico, String toString, String trabFeriados, String horarioInicio, String horarioFim, String horarioFeriadoInicio, String horarioFeriadoFim, Boolean aBoolean, Integer integer, Endereco endereco) {
        this.email = email;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.dataNascimento = dataNascimento;
        this.telefoneFixo = telefoneFixo;
        this.telefoneCelular = telefoneCelular;
        this.senha = senha;
        this.tipoServico = tipoServico;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.endereco = endereco;
    }

    public String getTrabalhaFeriados() {
        return trabalhaFeriados;
    }

    public void setTrabalhaFeriados(String trabalhaFeriados) {
        this.trabalhaFeriados = trabalhaFeriados;
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

    public Integer getIdContratado() {
        return idContratado;
    }

    public void setIdContratado(Integer idContratado) {
        this.idContratado = idContratado;
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

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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
}

