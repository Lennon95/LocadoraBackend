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
    private boolean cambioautomatico;
    private Long km;
    private String cor;

    public Carro(){}
    
    public Carro(String placa, Long nroMarca, Long nroModelo, boolean arCondicionado, boolean hasDirecao, boolean HasCambioautomatico) {
        this.placa = placa;
        this.nroMarca = nroMarca;
        this.nroModelo = nroModelo;
        this.arCondicionado = arCondicionado;
        this.direcao = hasDirecao;
        this.cambioautomatico = HasCambioautomatico;
    }

    @Override
    public String toString() {
        return "Carro [hasArCondicionado=" + isHasArCondicionado() + ", HasCambioautomatico=" + isHasCambioautomatico() + ", hasDirecao="
                + isHasDirecao() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", placa=" + getPlaca() + "]";
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

    public boolean isCambioautomatico() {
        return cambioautomatico;
    }

    public void setCambioautomatico(boolean cambioautomatico) {
        this.cambioautomatico = cambioautomatico;
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
