package com.bcopstein.Entidades.Dominio.Carro;

public class Modelo {
    private String nome;
    private Marca marca;

    public Modelo() {
    }

    public Modelo(String nome, Marca marca) {
        this.nome = nome;
        this.marca = marca;
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
    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the marca
     */
    public Marca getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }
    
    
}
