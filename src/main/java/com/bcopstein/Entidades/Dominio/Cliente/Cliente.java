package com.bcopstein.Entidades.Dominio.Cliente;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
    
    enum ESTADO_CIVIL {CASADO, SOLTEIRO, DIVORCIADO};

    @Id
    @GeneratedValue( strategy=GenerationType.AUTO )
    private long id;
    
    private String documento;
    private String nome;
    private String endereco;
    private int locacoesFeitas;
    private ESTADO_CIVIL estCivil;
    private LocalDate dataNascimento;

    public Cliente(){}

    public Cliente(String nome, String documento, String endereco, int locacoesFeitas, ESTADO_CIVIL estCivil, LocalDate dataNascimento) {
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getLocacoesFeitas() {
        return locacoesFeitas;
    }

    public void setLocacoesFeitas(int locacoesFeitas) {
        this.locacoesFeitas = locacoesFeitas;
    }

    public ESTADO_CIVIL getEstCivil() {
        return estCivil;
    }

    public void setEstCivil(ESTADO_CIVIL estCivil) {
        this.estCivil = estCivil;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}
