package com.bcopstein.Entidades.Dominio.Carro;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Carro {
    @Id
    private String placa;
    private Marca marca;
    private Modelo modelo;
    private boolean hasArCondicionado;
    private boolean hasDirecao;
    private boolean HasCambioautomatico;
    
    private long km;
    private Cor cor;
    private boolean isDisponivel;
    private Date disponivelEm;
    

    public Carro() {
    }
    
    public Carro(String placa, Marca marca, Modelo modelo, boolean hasArCondicionado, boolean hasDirecao, boolean HasCambioautomatico) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.hasArCondicionado = hasArCondicionado;
        this.hasDirecao = hasDirecao;
        this.HasCambioautomatico = HasCambioautomatico;
    }

    public String getPlaca() {
        return placa;
    }

    public Marca getMarca() {
        return marca;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public boolean hasArCondicionado() {
        return isHasArCondicionado();
    }

    public boolean hasDirecao() {
        return isHasDirecao();
    }

    public boolean hasCambioautomatico() {
        return isHasArCondicionado();
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
        }else return false;
    }
    
    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the hasArCondicionado
     */
    public boolean isHasArCondicionado() {
        return hasArCondicionado;
    }

    /**
     * @param hasArCondicionado the hasArCondicionado to set
     */
    public void setHasArCondicionado(boolean hasArCondicionado) {
        this.hasArCondicionado = hasArCondicionado;
    }

    /**
     * @return the hasDirecao
     */
    public boolean isHasDirecao() {
        return hasDirecao;
    }

    /**
     * @param hasDirecao the hasDirecao to set
     */
    public void setHasDirecao(boolean hasDirecao) {
        this.hasDirecao = hasDirecao;
    }

    /**
     * @return the HasCambioautomatico
     */
    public boolean isHasCambioautomatico() {
        return HasCambioautomatico;
    }

    /**
     * @param HasCambioautomatico the HasCambioautomatico to set
     */
    public void setHasCambioautomatico(boolean HasCambioautomatico) {
        this.HasCambioautomatico = HasCambioautomatico;
    }

    /**
     * @return the km
     */
    public long getKm() {
        return km;
    }

    /**
     * @param km the km to set
     */
    public void setKm(long km) {
        this.km = km;
    }

    /**
     * @return the cor
     */
    public Cor getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    /**
     * @return the isDisponivel
     */
    public boolean isIsDisponivel() {
        return isDisponivel;
    }

    /**
     * @param isDisponivel the isDisponivel to set
     */
    public void setIsDisponivel(boolean isDisponivel) {
        this.isDisponivel = isDisponivel;
    }

    /**
     * @return the disponivelEm
     */
    public Date getDisponivelEm() {
        return disponivelEm;
    }

    /**
     * @param disponivelEm the disponivelEm to set
     */
    public void setDisponivelEm(Date disponivelEm) {
        this.disponivelEm = disponivelEm;
    }
    
    
}
