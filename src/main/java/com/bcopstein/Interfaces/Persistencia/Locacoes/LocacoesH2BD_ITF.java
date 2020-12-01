package com.bcopstein.Interfaces.Persistencia.Locacoes;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Locacao.Locacao;

import org.springframework.data.repository.CrudRepository;

public interface LocacoesH2BD_ITF extends CrudRepository<Locacao, Long> {
    List<Locacao> findAll();
}