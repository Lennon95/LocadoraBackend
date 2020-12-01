package com.bcopstein.Entidades.Dominio.Carro;

public class Cor {
    private String cor;

    public Cor() {
    }

    @Override
    public String toString() {
        return this.cor;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cor) {
            Cor c = (Cor) obj;
            return c.getCor().equals(this.cor);
        } else
            return false;
    }
        
    public Cor(String cor) {
        this.cor = cor;
    }

    /**
     * @return the cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(String cor) {
        this.cor = cor;
    }
    
}
