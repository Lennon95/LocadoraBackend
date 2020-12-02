package com.bcopstein.Entidades.Servicos;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.concurrent.atomic.AtomicReference;
import java.time.LocalDate;

import com.bcopstein.Entidades.SistLocacaoException;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Locacao.Locacao;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;

import com.bcopstein.Entidades.Repositorio.Carros;
import com.bcopstein.Entidades.Repositorio.Locacoes;
import com.bcopstein.Entidades.Repositorio.Marcas;
import com.bcopstein.Entidades.Repositorio.Modelos;

import org.hibernate.action.internal.CollectionAction;
import org.springframework.stereotype.Component;

import ch.qos.logback.core.joran.conditional.ElseAction;

@Component
public class ServicoCatalogo {
    private Carros carros;
    private Locacoes locacoes;
    private Marcas marcas;
    private Modelos modelos;

    public ServicoCatalogo(Carros carros, Locacoes locacoes, Marcas marcas, Modelos modelos) {
        this.carros = carros;
        this.locacoes = locacoes;
        this.marcas = marcas;
        this.modelos = modelos;
    }

    public List<Carro> listaCarrosDisponiveis(LocalDate inicioLocacao, LocalDate fimLocacao,
                                              boolean arcondicionado, boolean direcao,
                                              boolean cambio,
                                              long idmarca, 
                                              long idmodelo) {
                                                  
        final Collection<Locacao> locs;
        if (inicioLocacao != null && fimLocacao != null) {
            locs = this.locacoes.pesquisa((Locacao l) -> l.getInicio().compareTo(inicioLocacao) > 0 && l.getFim().compareTo(fimLocacao) < 0);
        } else {
            locs = new ArrayList<Locacao>();
        }

        List<Carro> carros = this.carros
                                 .todos()
                                 .stream()
                                 .filter((Carro c) -> c.isArcondicionado() == arcondicionado)
                                 .filter((Carro c) -> c.isDirecao() == direcao)
                                 .filter((Carro c) -> c.isCambioautomatico() == cambio)
                                 .filter((Carro c) -> idmarca == 0 || c.getMarca().getId() == idmarca)
                                 .filter((Carro c) -> idmodelo == 0 || c.getModelo().getId() == idmodelo)
                                 .filter((Carro c) -> {
                                    for (Locacao loc: locs) {
                                       if (loc.getCarro().equals(c))
                                           return false;
                                    }
                                    return true;
                                 })
                                 .collect(Collectors.toList());
        return carros;
    }

    public List<Marca> listaMarcas() {
        return this.marcas.todos().stream().collect(Collectors.toList());
    }

    public List<Modelo> listaModelosMarca(Long nroMarca) {
        Collection<Marca> mcs = this.marcas.pesquisa((Marca m) -> m.getId() == nroMarca);
        return this.modelos.todos()
                           .stream()
                           .filter((Modelo m) -> m.getMarca().getId() == nroMarca)
                           .collect(Collectors.toList());
    }

    public boolean isCarroDisponivelData(Carro carro, LocalDate inicioLocacao,
                                         LocalDate fimLocacao) {

        Collection<Locacao> locs = this.locacoes.pesquisa((Locacao l) -> l.getInicio().compareTo(inicioLocacao) > 0 && l.getFim().compareTo(fimLocacao) < 0);
        for (Locacao loc: locs) {
            if (loc.getCarro().equals(carro))
                return false;
        }

        return true;
    }
}