package com.bcopstein.Entidades.Dominio.Locacao;

import java.time.LocalDate;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;


@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long nroLocacao;
    
    @ManyToOne
    private Carro carro;
    private LocalDate inicio;
    private LocalDate fim;
    private boolean devolvido;
    private LocalDate devolvidoEm;
    private int diariasCobradas;
    private int diariasUtilizadas;
    private float valorCobrado;
    private float valorResidual;
    private Long kminicio;
    private Long fmfinal;
    
    @ManyToOne
    private Cliente cliente;
    private float valorPrePago;

    public Locacao(){}

    public Locacao(Carro carro, LocalDate inicio, LocalDate fim, boolean devolvido, LocalDate devolvidoEm,
                   int diariasCobradas, int diariasUtilizadas, float valorCobrado,
                   float valorResidual, Long kminicio, Long fmfinal, Cliente cliente, float valorPrePago) {
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

    public Long getNroLocacao() {
        return nroLocacao;
    }

    public void setNroLocacao(Long nroLocacao) {
        this.nroLocacao = nroLocacao;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public LocalDate getInicio() {
        return inicio;
    }

    public void setInicio(LocalDate inicio) {
        this.inicio = inicio;
    }

    public LocalDate getFim() {
        return fim;
    }

    public void setFim(LocalDate fim) {
        this.fim = fim;
    }

    public boolean isDevolvido() {
        return devolvido;
    }

    public void setDevolvido(boolean devolvido) {
        this.devolvido = devolvido;
    }

    public LocalDate getDevolvidoEm() {
        return devolvidoEm;
    }

    public void setDevolvidoEm(LocalDate devolvidoEm) {
        this.devolvidoEm = devolvidoEm;
    }

    public int getDiariasCobradas() {
        return diariasCobradas;
    }

    public void setDiariasCobradas(int diariasCobradas) {
        this.diariasCobradas = diariasCobradas;
    }

    public int getDiariasUtilizadas() {
        return diariasUtilizadas;
    }

    public void setDiariasUtilizadas(int diariasUtilizadas) {
        this.diariasUtilizadas = diariasUtilizadas;
    }

    public float getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public float getValorResidual() {
        return valorResidual;
    }

    public void setValorResidual(float valorResidual) {
        this.valorResidual = valorResidual;
    }

    public Long getKminicio() {
        return kminicio;
    }

    public void setKminicio(Long kminicio) {
        this.kminicio = kminicio;
    }

    public Long getFmfinal() {
        return fmfinal;
    }

    public void setFmfinal(Long fmfinal) {
        this.fmfinal = fmfinal;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public float getValorPrePago() {
        return valorPrePago;
    }

    public void setValorPrePago(float valorPrePago) {
        this.valorPrePago = valorPrePago;
    }
}
