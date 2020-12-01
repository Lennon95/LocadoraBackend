package com.bcopstein.Entidades.Dominio.Cliente;

import java.util.Date;

public class Cliente {
    
    enum ESTADO_CIVIL {CASADO, SOLTEIRO, DIVORCIADO};
    
    private String nome;
    private String documento;
    private String endereco;
    private int locacoesFeitas;
    private ESTADO_CIVIL estCivil;
    private Date dataNascimento;

    public Cliente() {
    }

    public Cliente(String nome, String documento, String endereco, int locacoesFeitas, ESTADO_CIVIL estCivil, Date dataNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.locacoesFeitas = locacoesFeitas;
        this.estCivil = estCivil;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return this.getNome();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Cliente) {
             return ((Cliente) obj).getNome().equals(this.getNome());
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
     * @return the documento
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * @param documento the documento to set
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the locacoesFeitas
     */
    public int getLocacoesFeitas() {
        return locacoesFeitas;
    }

    /**
     * @param locacoesFeitas the locacoesFeitas to set
     */
    public void setLocacoesFeitas(int locacoesFeitas) {
        this.locacoesFeitas = locacoesFeitas;
    }

    /**
     * @return the estCivil
     */
    public ESTADO_CIVIL getEstCivil() {
        return estCivil;
    }

    /**
     * @param estCivil the estCivil to set
     */
    public void setEstCivil(ESTADO_CIVIL estCivil) {
        this.estCivil = estCivil;
    }

    /**
     * @return the dataNascimento
     */
    public Date getDataNascimento() {
        return dataNascimento;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
    
    
}
