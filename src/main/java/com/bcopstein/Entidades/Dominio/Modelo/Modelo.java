package com.bcopstein.Entidades.Dominio.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long nroModelo;
    private String nome;
    private Long nroMarca;

    public Modelo(){}

    public Modelo(String nome, Long nroMarca) {
        this.nome = nome;
        this.nroMarca = nroMarca;
    }

    @Override
    public String toString() {
        return this.nome;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Modelo) {
            return (((Modelo) obj).getNome().equals(this.getNome()));
        } else return false;
    }

    public Long getNroModelo() {
        return nroModelo;
    }

    public void setNroModelo(Long nroModelo) {
        this.nroModelo = nroModelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getNroMarca() {
        return nroMarca;
    }

    public void setNroMarca(Long nroMarca) {
        this.nroMarca = nroMarca;
    }
}
