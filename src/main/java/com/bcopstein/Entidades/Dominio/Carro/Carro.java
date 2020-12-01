package com.bcopstein.Entidades.Dominio.Carro;

import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {
    
    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private long id;
    
    private String placa;
    
    @ManyToOne
    @JoinColumn(name="idmarca", nullable=false)
    private Marca marca;
    
    @ManyToOne
    @JoinColumn(name="idmodelo", nullable=false)
    private Modelo modelo;
    
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean arCondicionado;
    
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean direcao;
    
    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private boolean cambioAutomatico;
    
    private Long km;
    private String cor;

    public Carro(){}
    
    public Carro(String placa, Marca marca, Modelo modelo, boolean arCondicionado, boolean direcao, boolean cambioAutomatico) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.arCondicionado = arCondicionado;
        this.direcao = direcao;
        this.cambioAutomatico = cambioAutomatico;
    }

    @Override
    public String toString() {
        return "Carro [hasArCondicionado=" + isArCondicionado() + ", HasCambioautomatico=" + isCambioAutomatico() + ", hasDirecao="
                + isDirecao() + ", marca=" + getMarca() + ", modelo=" + getModelo() + ", placa=" + getPlaca() + "]";
    } 

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Carro) {
            return ((Carro) obj).getPlaca().equals(this.getPlaca());
        }
        
        return false;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setNroMarca(Marca marca) {
        this.marca = marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
}
