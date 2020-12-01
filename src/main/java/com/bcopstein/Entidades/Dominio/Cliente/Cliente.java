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
    private int locacoesfeitas;
    private ESTADO_CIVIL estcivil;
    private LocalDate datanascimento;

    public Cliente(){}

    public Cliente(String nome, String documento, String endereco, int locacoesfeitas, ESTADO_CIVIL estcivil, LocalDate datanascimento) {
        this.nome = nome;
        this.documento = documento;
        this.endereco = endereco;
        this.locacoesfeitas = locacoesfeitas;
        this.estcivil = estcivil;
        this.datanascimento = datanascimento;
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
        return locacoesfeitas;
    }

    public void setLocacoesFeitas(int locacoesFeitas) {
        this.locacoesfeitas = locacoesFeitas;
    }

    public ESTADO_CIVIL getEstCivil() {
        return estcivil;
    }

    public void setEstCivil(ESTADO_CIVIL estCivil) {
        this.estcivil = estCivil;
    }

    public LocalDate getDataNascimento() {
        return datanascimento;
    }

    public void setDataNascimento(LocalDate datanascimento) {
        this.datanascimento = datanascimento;
    }
}
