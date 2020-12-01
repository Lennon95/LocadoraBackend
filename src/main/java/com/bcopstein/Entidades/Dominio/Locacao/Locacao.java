package com.bcopstein.Entidades.Dominio.Locacao;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.util.Date;

public class Locacao {
    private Carro carro;
    private Date inicio;
    private Date fim;
    private boolean devolvido;
    private Date devolvidoEm;
    private int diariasCobradas;
    private int diariasUtilizadas;
    private float valorCobrado;
    private float valorResidual;
    private long kminicio;
    private long fmfinal;
    private Cliente cliente;
    private float valorPrePago;

    public Locacao() {
    }

    public Locacao(Carro carro, Date inicio, Date fim, boolean devolvido, Date devolvidoEm, int diariasCobradas, int diariasUtilizadas, float valorCobrado, float valorResidual, long kminicio, long fmfinal, Cliente cliente, float valorPrePago) {
        this.carro = carro;
        this.inicio = inicio;
        this.fim = fim;
        this.devolvido = devolvido;
        this.devolvidoEm = devolvidoEm;
        this.diariasCobradas = diariasCobradas;
        this.diariasUtilizadas = diariasUtilizadas;
        this.valorCobrado = valorCobrado;
        this.valorResidual = valorResidual;
        this.kminicio = kminicio;
        this.fmfinal = fmfinal;
        this.cliente = cliente;
        this.valorPrePago = valorPrePago;
    }

    @Override
    public String toString() {
        return this.getInicio().toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Locacao) {
            return ((Locacao) obj).getInicio().equals(this.getInicio());
        } else {
            return false;
        }
    }

    /**
     * @return the carro
     */
    public Carro getCarro() {
        return carro;
    }

    /**
     * @param carro the carro to set
     */
    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    /**
     * @return the inicio
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * @param inicio the inicio to set
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * @return the fim
     */
    public Date getFim() {
        return fim;
    }

    /**
     * @param fim the fim to set
     */
    public void setFim(Date fim) {
        this.fim = fim;
    }

    /**
     * @return the devolvido
     */
    public boolean isDevolvido() {
        return devolvido;
    }

    /**
     * @param devolvido the devolvido to set
     */
    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    /**
     * @return the devolvidoEm
     */
    public Date getDevolvidoEm() {
        return devolvidoEm;
    }

    /**
     * @param devolvidoEm the devolvidoEm to set
     */
    public void setDevolvidoEm(Date devolvidoEm) {
        this.devolvidoEm = devolvidoEm;
    }

    /**
     * @return the diariasCobradas
     */
    public int getDiariasCobradas() {
        return diariasCobradas;
    }

    /**
     * @param diariasCobradas the diariasCobradas to set
     */
    public void setDiariasCobradas(int diariasCobradas) {
        this.diariasCobradas = diariasCobradas;
    }

    /**
     * @return the diariasUtilizadas
     */
    public int getDiariasUtilizadas() {
        return diariasUtilizadas;
    }

    /**
     * @param diariasUtilizadas the diariasUtilizadas to set
     */
    public void setDiariasUtilizadas(int diariasUtilizadas) {
        this.diariasUtilizadas = diariasUtilizadas;
    }

    /**
     * @return the valorCobrado
     */
    public float getValorCobrado() {
        return valorCobrado;
    }

    /**
     * @param valorCobrado the valorCobrado to set
     */
    public void setValorCobrado(float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    /**
     * @return the valorResidual
     */
    public float getValorResidual() {
        return valorResidual;
    }

    /**
     * @param valorResidual the valorResidual to set
     */
    public void setValorResidual(float valorResidual) {
        this.valorResidual = valorResidual;
    }

    /**
     * @return the kminicio
     */
    public long getKminicio() {
        return kminicio;
    }

    /**
     * @param kminicio the kminicio to set
     */
    public void setKminicio(long kminicio) {
        this.kminicio = kminicio;
    }

    /**
     * @return the fmfinal
     */
    public long getFmfinal() {
        return fmfinal;
    }

    /**
     * @param fmfinal the fmfinal to set
     */
    public void setFmfinal(long fmfinal) {
        this.fmfinal = fmfinal;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the valorPrePago
     */
    public float getValorPrePago() {
        return valorPrePago;
    }

    /**
     * @param valorPrePago the valorPrePago to set
     */
    public void setValorPrePago(float valorPrePago) {
        this.valorPrePago = valorPrePago;
    }
    
    
    
}
