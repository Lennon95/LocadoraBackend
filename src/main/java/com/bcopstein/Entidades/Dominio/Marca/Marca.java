package com.bcopstein.Entidades.Dominio.Marca;

public class Marca {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long nroMarca;
    private String nome;
    private boolean isLuxo;

    public Marca() {
    }

    public Marca(String nome, boolean isLuxo) {
        this.nome = nome;
        this.isLuxo = isLuxo;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Marca) {
            return ((Marca) obj).getNome().equals(this.getNome());
        } else return false;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the isLuxo
     */
    public boolean isIsLuxo() {
        return isLuxo;
    }

    /**
     * @param isLuxo the isLuxo to set
     */
    public void setIsLuxo(boolean isLuxo) {
        this.isLuxo = isLuxo;
    }

    public Long getNroMarca() {
        return nroMarca;
    }

    public void setNroMarca(Long nroMarca) {
        this.nroMarca = nroMarca;
    }
}
