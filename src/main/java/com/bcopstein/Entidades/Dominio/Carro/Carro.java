package com.bcopstein.Entidades.Dominio.Carro;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    private String placa;
    private Long nroMarca;
    private Long nroModelo;
    private boolean arCondicionado;
    private boolean direcao;
    private boolean cambioAutomatico;
    private Long km;
    private String cor;

    public Carro(){}
    
    public Carro(String placa, Long nroMarca, Long nroModelo, boolean arCondicionado, boolean direcao, boolean cambioAutomatico) {
        this.placa = placa;
        this.nroMarca = nroMarca;
        this.nroModelo = nroModelo;
        this.arCondicionado = arCondicionado;
        this.direcao = direcao;
        this.cambioAutomatico = cambioAutomatico;
        this.disponivel = true;
    }

    @Override
    public String toString() {
        return "Carro [hasArCondicionado=" + isArCondicionado() + ", HasCambioautomatico=" + isCambioAutomatico() + ", hasDirecao="
                + isDirecao() + ", marca=" + getNroMarca() + ", modelo=" + getNroModelo() + ", placa=" + getPlaca() + "]";
    } 

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Carro) {
            return ((Carro) obj).getPlaca().equals(this.getPlaca());
        }
        
        return false;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getNroMarca() {
        return nroMarca;
    }

    public void setNroMarca(Long nroMarca) {
        this.nroMarca = nroMarca;
    }

    public Long getNroModelo() {
        return nroModelo;
    }

    public void setNroModelo(Long nroModelo) {
        this.nroModelo = nroModelo;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isDirecao() {
        return direcao;
    }

    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
    }

    public boolean isCambioAutomatico() {
        return cambioAutomatico;
    }

    public void setCambioAutomatico(boolean cambioAutomatico) {
        this.cambioAutomatico = cambioAutomatico;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
