package com.bcopstein.Interfaces.DTO;

import java.time.LocalDate;

public class FiltroDTO {
    private LocalDate inicioLocacao;
    private LocalDate fimLocacao;
    private boolean arcondicionado = false;
    private boolean direcao = false;
    private boolean cambio = false;

    public FiltroDTO() {
    }
    
    public FiltroDTO(LocalDate inicioLocacao, LocalDate fimLocacao, boolean arcondicionado, boolean direcao,
            boolean cambio) {
        this.inicioLocacao = inicioLocacao;
        this.fimLocacao = fimLocacao;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambio = cambio;
    }

    public LocalDate getInicioLocacao() {
        return inicioLocacao;
    }

    public void setInicioLocacao(LocalDate inicioLocacao) {
        this.inicioLocacao = inicioLocacao;
    }

    public LocalDate getFimLocacao() {
        return fimLocacao;
    }

    public void setFimLocacao(LocalDate fimLocacao) {
        this.fimLocacao = fimLocacao;
    }

    public boolean isArcondicionado() {
        return arcondicionado;
    }

    public boolean isDirecao(){
        return direcao;
    }

    public boolean isCambio() {
        return cambio;
    }

    @Override
    public String toString() {
        return "FiltroDTO [arcondicionado=" + arcondicionado + ", cambio=" + cambio + ", direcao=" + direcao
                + ", fimLocacao=" + fimLocacao + ", inicioLocacao=" + inicioLocacao + "]";
    }
}
