package com.bcopstein.Interfaces.DTO;

import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import com.bcopstein.Entidades.Dominio.Carro.Carro;


public class DevolucaoSubtotalDTO {
    private Cliente cliente;
    private Carro carro;
    private int diarias;
    private float valorSeguro;
    private float valorDesconto;
    private float subtotal;
    private float valorPrePago;
    private float totalPagar;


    public DevolucaoSubtotalDTO(Cliente cliente, Carro carro, int diarias, float valorSeguro,
                                float subtotal, float valorPrePago, float totalPagar) {
        this.cliente = cliente;
        this.carro = carro;
        this.diarias = diarias;
        this.valorSeguro = valorSeguro;
        this.subtotal = subtotal;
        this.valorPrePago = valorPrePago;
        this.totalPagar = totalPagar;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getDiarias() {
        return diarias;
    }

    public void setDiarias(int diarias) {
        this.diarias = diarias;
    }

    public float getValorSeguro() {
        return valorSeguro;
    }

    public void setValorSeguro(float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getValorPrePago() {
        return valorPrePago;
    }

    public void setValorPrePago(float valorPrePago) {
        this.valorPrePago = valorPrePago;
    }

    public float getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }
}
