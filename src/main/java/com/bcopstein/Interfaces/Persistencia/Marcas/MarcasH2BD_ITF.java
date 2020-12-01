package com.bcopstein.Interfaces.Persistencia.Marcas;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface MarcasH2BD_ITF extends CrudRepository<Marca, Long> {

    @Override
    public Optional<Marca> findById(Long id);
    
}