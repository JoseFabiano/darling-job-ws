package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario", insertable = false)
    private Integer idUsuario;

    @Column(name = "nome")
    private String nome;

    @Column(name = "senha")
    private String senha;

    @Column(name = "email")
    private String email;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "telefone_celular")
    private String telefoneCelular;

    @Column(name = "telefone_fixo")
    private String telefoneFixo;

    @Column(name = "rg")
    private String rg;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "data_nascimento")
    private String dataNascimento;

    @Column(name = "genero")
    private String genero;

    @Column(name = "dias_disponiveis")
    private String diasDisponiveis;

    @Column(name = "horario_feriado_fim")
    private String horarioFeriadoFim;

    @Column(name = "horario_feriado_inicio")
    private String horarioFeriadoInicio;

    @Column(name = "horario_inicio_dia")
    private String horarioInicioDia;

    @Column(name = "horarioFimDia")
    private String horarioFimDia;

    @Column(name = "trabalhaFeriados")
    private Boolean trabalhaFeriados;

    @Column(name = "tipo_servico")
    private String tipoServico;

    @Column(name = "role")
    private String role;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_endereco", referencedColumnName = "id_endereco")
    private Endereco endereco;

    public Usuario() {
    }

    public Usuario(String nome, String senha, String email, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String role, String diasDisponiveis, String horarioFeriadoFim, String horarioFeriadoInicio, String horarioInicioDia, String horarioFimDia, Boolean trabalhaFeriados, String tipoServico, Endereco endereco) {
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
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioInicioDia = horarioInicioDia;
        this.horarioFimDia = horarioFimDia;
        this.trabalhaFeriados = trabalhaFeriados;
        this.tipoServico = tipoServico;
        this.endereco = endereco;
    }

    public Usuario(Integer idUsuario, String nome, String senha, String email, String descricao, String telefoneCelular, String telefoneFixo, String rg, String cpf, String dataNascimento, String genero, String diasDisponiveis, String horarioFeriadoFim, String horarioFeriadoInicio, String horarioInicioDia, String horarioFimDia, Boolean trabalhaFeriados, String tipoServico, String role, Endereco endereco) {
        this.idUsuario = idUsuario;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
        this.descricao = descricao;
        this.telefoneCelular = telefoneCelular;
        this.telefoneFixo = telefoneFixo;
        this.rg = rg;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.genero = genero;
        this.diasDisponiveis = diasDisponiveis;
        this.horarioFeriadoFim = horarioFeriadoFim;
        this.horarioFeriadoInicio = horarioFeriadoInicio;
        this.horarioInicioDia = horarioInicioDia;
        this.horarioFimDia = horarioFimDia;
        this.trabalhaFeriados = trabalhaFeriados;
        this.tipoServico = tipoServico;
        this.role = role;
        this.endereco = endereco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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
        return horarioFeriadoFim;
    }

    public void setHorarioFeriadoFim(String horarioFeriadoFim) {
        this.horarioFeriadoFim = horarioFeriadoFim;
    }

    public String getHorarioFeriadoInicio() {
        return horarioFeriadoInicio;
    }

    public void setHorarioFeriadoInicio(String horarioFeriadoInicio) {
        this.horarioFeriadoInicio = horarioFeriadoInicio;
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
