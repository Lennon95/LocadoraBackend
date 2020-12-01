package com.bcopstein.Interfaces.DTO;

public class LocacaoDTO {
    private String placaCarro;
    private String docCliente;
    private Date inicio;
    private Date fim;

    public LocacaoDTO(String placaCarro, String docCliente, Date inicio, Date fim) {
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

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }    
}
