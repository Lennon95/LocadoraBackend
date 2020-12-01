package com.bcopstein.Interfaces.Persistencia.Modelos;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;

import org.springframework.data.repository.CrudRepository;

public interface ModelosH2BD_ITF extends CrudRepository<Modelo, Long> {
    List<Modelo> findByNroModelo(Long nro);
    List<Modelo> findAll();
}