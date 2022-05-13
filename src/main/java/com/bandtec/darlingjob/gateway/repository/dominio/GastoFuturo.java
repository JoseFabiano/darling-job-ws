package com.bandtec.darlingjob.gateway.repository.dominio;

import javax.persistence.*;

@Entity
public class GastoFuturo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_gasto_futuro")
    private Integer idGastoFuturo;

    private String nome;

    private String valor;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public GastoFuturo() {
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public GastoFuturo(String nome, String valor, Usuario usuario) {
        this.nome = nome;
        this.valor = valor;
        this.usuario = usuario;
    }

    public Integer getIdGastoFuturo() {
        return idGastoFuturo;
    }

    public void setIdGastoFuturo(Integer idGastoFuturo) {
        this.idGastoFuturo = idGastoFuturo;
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

}
