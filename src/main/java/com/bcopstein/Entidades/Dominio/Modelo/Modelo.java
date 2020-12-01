package com.bcopstein.Entidades.Dominio.Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private Long idmarca;

    public Modelo(){}

    public Modelo(String nome, Long idmarca) {
        this.nome = nome;
        this.idmarca = idmarca;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdmarca() {
        return idmarca;
    }

    public void setIdmarca(Long idmarca) {
        this.idmarca = idmarca;
    }
}
