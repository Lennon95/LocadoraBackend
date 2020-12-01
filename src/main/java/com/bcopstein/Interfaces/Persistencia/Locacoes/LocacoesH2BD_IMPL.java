package com.bcopstein.Interfaces.Persistencia.Locacoes;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Locacao.Locacao;
import com.bcopstein.Entidades.Repositorio.Locacoes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LocacoesH2BD_IMPL implements Locacoes {
    private LocacoesH2BD_ITF locacoesBD;

    @Autowired
    public LocacoesH2BD_IMPL(LocacoesH2BD_ITF locacoesBD) {
        this.locacoesBD = locacoesBD;
    }

    @Override
    public void cadastra(Locacao locacao) {
        locacoesBD.save(locacao);
    }

    @Override
    public Locacao recupera(Long nro) {
        return locacoesBD.findById(nro).get();
    }

    @Override
    public Collection<Locacao> todos() {
        return locacoesBD.findAll();
    }

    @Override
    public boolean existente(Long nro) {
        return locacoesBD.existsById(nro);
    }

    @Override
    public Collection<Locacao> pesquisa(Predicate<Locacao> pred) {
        return locacoesBD.findAll()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Locacao produto) {
        locacoesBD.save(produto);
    }

    @Override
    public void remove(Long nro) {
        locacoesBD.deleteById(nro);
    }
}
