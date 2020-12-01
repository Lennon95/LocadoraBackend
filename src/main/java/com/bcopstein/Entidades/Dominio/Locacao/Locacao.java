package com.bcopstein.Entidades.Dominio.Locacao;

import java.time.LocalDate;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Locacao {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long nroLocacao;
    
    @ManyToOne
    @JoinColumn(name="idcarro", nullable=false)
    private Carro carro;
    
    private LocalDate inicio;
    private LocalDate fim;
    private boolean devolvido;
    private LocalDate devolvidoEm;
    private float valorCobrado;
    
    @ManyToOne
    @JoinColumn(name="idcliente", nullable=false)
    private Cliente cliente;
    
    public Locacao(){}

    public Locacao(Carro carro, LocalDate inicio, LocalDate fim, boolean devolvido,
                   LocalDate devolvidoEm, float valorCobrado, Cliente cliente) {
        this.carro = carro;
        this.inicio = inicio;
        this.fim = fim;
        this.devolvido = devolvido;
        this.devolvidoEm = devolvidoEm;
        this.valorCobrado = valorCobrado;
        this.cliente = cliente;
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

    public float getValorCobrado() {
        return valorCobrado;
    }

    public void setValorCobrado(float valorCobrado) {
        this.valorCobrado = valorCobrado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
