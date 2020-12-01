package com.bcopstein.Entidades.Dominio.Modelo;

import com.bcopstein.Entidades.Dominio.Marca.Marca;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
    private float valor; 
    
    @ManyToOne
    @JoinColumn(name="idmarca", nullable=false)
    private Marca marca;

    public Modelo(){}

    public Modelo(String nome, Marca marca) {
        this.nome = nome;
        this.marca = marca;
    }

    @Override
    public String toString() {
        return this.getNome();
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

    public Marca getMarca() {
        return marca;
    }

    public void setIdmarca(Marca marca) {
        this.setMarca(marca);
    }

    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
}
