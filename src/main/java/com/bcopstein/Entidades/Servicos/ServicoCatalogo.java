package com.bcopstein.Entidades.Servicos;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
                                              boolean cambio) {
        
        if(inicioLocacao == null || fimLocacao == null) {
             return this.carros.todos().stream().collect(Collectors.toList());
        }
        
        if (inicioLocacao.compareTo(fimLocacao) < 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.DATA_INVALIDA);
            
        Collection<Locacao> locs = this.locacoes
                                 .pesquisa((Locacao l) -> l.getInicio().compareTo(inicioLocacao) > 0 && l.getFim().compareTo(fimLocacao) < 0);

        List<Carro> carros = this.carros                                 
                                 .todos()
                                 .stream()
                                 .filter((Carro c) -> c.isArCondicionado() == arcondicionado)
                                 .filter((Carro c) -> c.isDirecao() == direcao)
                                 .filter((Carro c) -> c.isCambioAutomatico() == direcao)
                                 .filter((Carro c) -> {
                                     for (Locacao loc: locs) {
                                        if (loc.getCarro().getId() == c.getId())
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
}