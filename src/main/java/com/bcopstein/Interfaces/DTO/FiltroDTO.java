package com.bcopstein.Interfaces.DTO;

public class FiltroDTO {
    private String inicio;
    private String fim;
    private boolean arcondicionado = false;
    private boolean direcao = false;
    private boolean cambio = false;
    private long idmarca = 0;
    private long idmodelo = 0;

    public FiltroDTO() {
    }
    
    public FiltroDTO(String inicioLocacao, String fimLocacao, boolean arcondicionado, boolean direcao,
            boolean cambio, long idmarca, long idmodelo) {
        this.inicio = inicioLocacao;
        this.fim = fimLocacao;
        this.arcondicionado = arcondicionado;
        this.direcao = direcao;
        this.cambio = cambio;
        this.idmarca = idmarca;
        this.idmodelo = idmodelo;
    }

    public String getInicioLocacao() {
        return inicio;
    }

    public void setInicioLocacao(String inicioLocacao) {
        this.inicio = inicioLocacao;
    }

    public String getFimLocacao() {
        return fim;
    }

    public void setFimLocacao(String fimLocacao) {
        this.fim = fimLocacao;
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
        return "FiltroDTO [arcondicionado=" + isArcondicionado() + ", cambio=" + isCambio() + ", direcao=" + isDirecao()
                + ", fimLocacao=" + getFimLocacao() + ", inicioLocacao=" + getInicioLocacao() + ", idmarca=" + idmarca + ", idmodelo=" + idmodelo + "]";
    }

    /**
     * @param arcondicionado the arcondicionado to set
     */
    public void setArcondicionado(boolean arcondicionado) {
        this.arcondicionado = arcondicionado;
    }

    /**
     * @param direcao the direcao to set
     */
    public void setDirecao(boolean direcao) {
        this.direcao = direcao;
    }

    /**
     * @param cambio the cambio to set
     */
    public void setCambio(boolean cambio) {
        this.cambio = cambio;
    }

    /**
     * @return the idmarca
     */
    public long getIdmarca() {
        return idmarca;
    }

    /**
     * @param idmarca the idmarca to set
     */
    public void setIdmarca(long idmarca) {
        this.idmarca = idmarca;
    }

    /**
     * @return the idmodelo
     */
    public long getIdmodelo() {
        return idmodelo;
    }

    /**
     * @param idmodelo the idmodelo to set
     */
    public void setIdmodelo(long idmodelo) {
        this.idmodelo = idmodelo;
    }
}
