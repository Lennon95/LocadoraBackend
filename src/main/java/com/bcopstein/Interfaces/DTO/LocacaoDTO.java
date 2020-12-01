package com.bcopstein.Interfaces.DTO;

import java.time.LocalDate;

public class LocacaoDTO {
    private String placaCarro;
    private String docCliente;
    private LocalDate inicio;
    private LocalDate fim;

    public LocacaoDTO(String placaCarro, String docCliente, LocalDate inicio, LocalDate fim) {
        this.placaCarro = placaCarro;
        this.docCliente = docCliente;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getDocCliente() {
        return docCliente;
    }

    public void setDocCliente(String docCliente) {
        this.docCliente = docCliente;
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
}
