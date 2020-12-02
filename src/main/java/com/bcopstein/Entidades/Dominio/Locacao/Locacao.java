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
    private Long id;
    
    @ManyToOne
    @JoinColumn(name="idcarro", nullable=false)
    private Carro carro;
    
    private LocalDate inicio;
    private LocalDate fim;
    private boolean devolvido;
    private LocalDate devolvidoem;
    private float valorcobrado;
    
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
        this.devolvidoem = devolvidoEm;
        this.valorcobrado = valorCobrado;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return devolvidoem;
    }

    public void setDevolvidoEm(LocalDate devolvidoem) {
        this.devolvidoem = devolvidoem;
    }

    public float getValorcobrado() {
        return valorcobrado;
    }

    public void setValorcobrado(float valorcobrado) {
        this.valorcobrado = valorcobrado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
