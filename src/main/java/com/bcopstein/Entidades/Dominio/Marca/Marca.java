package com.bcopstein.Entidades.Dominio.Marca;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Marca {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long nroMarca;
    private String nome;
    private boolean isLuxo;

    public Marca(){}

    public Marca(String nome, boolean isLuxo) {
        this.nome = nome;
        this.isLuxo = isLuxo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Marca) {
            return ((Marca) obj).getNome().equals(this.getNome());
        } else return false;
    }

    public Long getNroMarca() {
        return nroMarca;
    }

    public void setNroMarca(Long nroMarca) {
        this.nroMarca = nroMarca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isLuxo() {
        return isLuxo;
    }

    public void setLuxo(boolean isLuxo) {
        this.isLuxo = isLuxo;
    }
}
