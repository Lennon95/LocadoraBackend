package com.bcopstein.Interfaces.Persistencia.Modelos;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ModelosH2BD_ITF extends CrudRepository<Modelo, Long> {

    @Override
    public Optional<Modelo> findById(Long id);

    @Override
    public Iterable<Modelo> findAll();

    
}