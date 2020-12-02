package com.bcopstein.Interfaces.DTO;

public class LocacaoDTO {
    private String placaCarro;
    private String docCliente;
    private String inicio;
    private String fim;

    public LocacaoDTO(String placaCarro, String docCliente, String inicio, String fim) {
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

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }    
}
