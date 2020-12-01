package com.bcopstein.Interfaces.DTO;

import com.bcopstein.Entidades.Dominio.Carro.Carro;

public class CarrosDTO {
    private Carro carro;
    private float custo;
    private float seguro;
    private float descontos;
    private float total;
    
    public CarrosDTO(Carro carro, float custo, float seguro, float descontos, float total) {
        this.carro = carro;
        this.seguro = seguro;
        this.custo = custo;
        this.descontos = descontos;
        this.total = total;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getSeguro() {
        return seguro;
    }

    public void setSeguro(float seguro) {
        this.seguro = seguro;
    }

    public float getDescontos() {
        return descontos;
    }

    public void setDescontos(float descontos) {
        this.descontos = descontos;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
