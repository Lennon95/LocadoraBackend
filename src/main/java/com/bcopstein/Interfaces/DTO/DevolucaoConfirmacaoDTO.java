package com.bcopstein.Interfaces.DTO;

public class DevolucaoConfirmacaoDTO {
    private boolean confirmado;
    private int codigo;

    public DevolucaoConfirmacaoDTO(boolean confirmado, int codigo) {
        this.confirmado = confirmado;
        this.codigo = codigo;
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public void setConfirmado(boolean confirmado) {
        this.confirmado = confirmado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
