package com.bcopstein.CasosDeUso;

import com.bcopstein.Entidades.Servicos.ServicoLocacao;
import com.bcopstein.Entidades.Servicos.ServicoCatalogo;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;

import com.bcopstein.Interfaces.DTO.LocacaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.LocacaoDTO;
import com.bcopstein.Interfaces.DTO.DevolucaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.DevolucaoDTO;
import com.bcopstein.Entidades.SistLocacaoException;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.naming.OperationNotSupportedException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControleLocacao {
    private ServicoLocacao servicoLoc;
    private ServicoCatalogo servicoCat;

    @Autowired
    public ControleLocacao(ServicoLocacao servicoLoc, ServicoCatalogo servicoCat) {
        this.servicoLoc = servicoLoc;
        this.servicoCat = servicoCat;
    }

    public LocacaoConfirmacaoDTO registrarLocacao(LocacaoDTO locacao) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            LocalDate inicio = (locacao.getInicio() != null) ? LocalDate.parse(locacao.getInicio(), formatter) : null;
            LocalDate fim = (locacao.getFim() != null) ? LocalDate.parse(locacao.getFim(), formatter) : null;
            float[] custos = this.servicoLoc.locarCarro(
                                        locacao.getPlacaCarro(),
                                        locacao.getDocCliente(),
                                        inicio,
                                        fim);
            return new LocacaoConfirmacaoDTO(true, custos[1], custos[2], custos[0], custos[3], fim);

        } catch (SistLocacaoException exception) {
            return new LocacaoConfirmacaoDTO(false, 0.0f, 0.0f, 0.0f, 0.0f, null);
        }
    }

    public DevolucaoConfirmacaoDTO registrarDevolucao(DevolucaoDTO locacao) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("Operação não implementada.");
    }
}
