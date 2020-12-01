package com.bcopstein.Entidades.Servicos;

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

public class ServicoCatalogo {
    private Carros carros;
    private Locacoes locacoes;
    private Marcas marcas;
    private Modelo modelos;

    public ServicoCatalogo(Carros carros, Locacoes locacoes, Marcas marcas, Modelos modelos) {
        this.carros = carros;
        this.locacoes = locacoes;
        this.marcas = marcas;
        this.modelos = modelos;
    }

    public List<Carro> listaCarrosDisponiveis(LocalDate inicioLocacao, LocalDate fimLocacao,
                                              boolean arcondicionado, boolean direcao,
                                              boolean cambio) {
        if (inicioLocacao.compareTo(fimLocacao) < 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.DATA_INVALIDA);
            
        List<Locacao> locs = this.locacoes
                                 .pesquisa((Locacao l) -> l.getInicio().compareTo(inicioLocacao) > 0 && l.getFim().compareTo(fimLocacao) < 0);

        List<Carro> carros = this.carros                                 
                                 .todos()
                                 .stream()
                                 .filter((Carro c) -> c.isArCondicionado() == arcondicionado)
                                 .filter((Carro c) -> c.isDirecao() == direcao)
                                 .filter((Carro c) -> c.isCambio() == direcao)
                                 .filter((Carro c) -> {
                                     foreach (Locacao loc: locs) {
                                        if (loc.getCarro().equals(c))
                                            return false;
                                     }
                                     return true;
                                 })
                                 .collect(Collectors.toList());
        return carros;
    }

    public List<Marca> listaMarcas() {
        return this.marcas.todos();
    }

    public List<Modelo> listaModelosMarca(Long nroMarca) {
        Collection<Marca> mcs = this.marcas.pesquisa((Marca m) -> m.getNroMarca() == nroMarca);
        if (mcs.size() == 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.MARCA_INEXISTENTE);

        return this.modelos.todos()
                           .stream()
                           .filter((Modelo m) -> m.getNroMarca() == nroMarca)
                           .collect(Collectors.toList());
    }
}