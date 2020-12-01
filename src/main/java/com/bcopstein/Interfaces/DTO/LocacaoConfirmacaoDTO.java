package com.bcopstein.Interfaces.DTO;

import java.time.LocalDate;

public class LocacaoConfirmacaoDTO {
    private int codigo;
    private boolean confirmado;
    private float valorSeguro;
    private float valorDesconto;
    private float subtotal;
    private float totalPagar;
    private LocalDate dataDevolucao;  

    public LocacaoConfirmacaoDTO() {
    }

    public LocacaoConfirmacaoDTO(int codigo, boolean confirmado, float valorSeguro, float valorDesconto, float subtotal, float totalPagar, LocalDate dataDevolucao) {
        this.codigo = codigo;
        this.confirmado = confirmado;
        this.valorSeguro = valorSeguro;
        this.valorDesconto = valorDesconto;
        this.subtotal = subtotal;
        this.totalPagar = totalPagar;
        this.dataDevolucao = dataDevolucao;
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the confirmado
     */
    public boolean isConfirmado() {
        return confirmado;
    }

    /**
     * @param confirmado the confirmado to set
     */
    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    /**
     * @return the valorSeguro
     */
    public float getValorSeguro() {
        return valorSeguro;
    }

    /**
     * @param valorSeguro the valorSeguro to set
     */
    public void setValorSeguro(float valorSeguro) {
        this.valorSeguro = valorSeguro;
    }

    /**
     * @return the valorDesconto
     */
    public float getValorDesconto() {
        return valorDesconto;
    }

    /**
     * @param valorDesconto the valorDesconto to set
     */
    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    /**
     * @return the subtotal
     */
    public float getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the totalPagar
     */
    public float getTotalPagar() {
        return totalPagar;
    }

    /**
     * @param totalPagar the totalPagar to set
     */
    public void setTotalPagar(float totalPagar) {
        this.totalPagar = totalPagar;
    }

    /**
     * @return the dataDevolucao
     */
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    /**
     * @param dataDevolucao the dataDevolucao to set
     */
    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
}
