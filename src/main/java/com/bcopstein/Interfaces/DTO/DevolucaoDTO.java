package com.bcopstein.Interfaces.DTO;

public class DevolucaoDTO {
    private String placaCarro;
    
    public DevolucaoDTO(String placaCarro) {
        this.placaCarro = placaCarro;
    }

    public String getPlacaCarro() {
        return placaCarro;
    }

    public void setPlacaCarro(String placaCarro) {
        this.placaCarro = placaCarro;
    }
}
