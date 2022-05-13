package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class GastoFixo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_gasto_fixo")
    private Integer idGastoFixo;

    private String nome;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public GastoFixo() {
    }

    public GastoFixo(String nome, String valor, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
    }

    public GastoFixo(Integer idGastoFixo, String nome, String valor, Usuario usuario) {
        this.idGastoFixo = idGastoFixo;
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
    }

    public Integer getIdGastoFixo() {
        return idGastoFixo;
    }

    public void setIdGastoFixo(Integer idGastoFixo) {
        this.idGastoFixo = idGastoFixo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
