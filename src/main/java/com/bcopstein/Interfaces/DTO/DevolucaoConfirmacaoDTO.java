package com.bcopstein.Interfaces.DTO;

public class DevolucaoConfirmacaoDTO {
    private boolean confirmado;

    public DevolucaoConfirmacaoDTO() {}
    
    public DevolucaoConfirmacaoDTO(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }
}
