package com.bcopstein.Interfaces;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Interfaces.DTO.DevolucaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.DevolucaoDTO;
import com.bcopstein.Interfaces.DTO.LocacaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.LocacaoDTO;
import com.bcopstein.CasosDeUso.ControleLocacao;

import java.util.ArrayList;

import javax.naming.OperationNotSupportedException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    private ControleLocacao controle;

    @Autowired
    public LocacaoController(ControleLocacao controle) {
        this.controle = controle;
    }

    @GetMapping("/registrar")
    @CrossOrigin(origins = "*")
    public LocacaoConfirmacaoDTO registrarLocacao(LocacaoDTO locacao) throws OperationNotSupportedException {
        return this.controle.registrarLocacao(locacao);
    }

    @GetMapping("/devolucao")
    @CrossOrigin(origins = "*")
    public DevolucaoConfirmacaoDTO registrarDevolucao(DevolucaoDTO locacao) throws OperationNotSupportedException {
        return this.controle.registrarDevolucao(locacao);
    }    
}
