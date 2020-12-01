package com.bcopstein.Interfaces.Persistencia.Marcas;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Repositorio.Marcas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MarcasH2BD_IMPL implements Marcas {
    private MarcasH2BD_ITF marcasBD;

    @Autowired
    public MarcasH2BD_IMPL(MarcasH2BD_ITF marcasBD) {
        this.marcasBD = marcasBD;
    }

    @Override
    public void cadastra(Marca marca) {
        marcasBD.save(marca);
    }

    @Override
    public Marca recupera(Long nro) {
        return marcasBD.findByNroMarca(nro).get(0);
    }

    @Override
    public Collection<Marca> todos() {
        return marcasBD.findAll();
    }

    @Override
    public boolean existente(Long nro) {
        return marcasBD.existsById(nro);
    }

    @Override
    public Collection<Marca> pesquisa(Predicate<Marca> pred) {
        return marcasBD.findAll()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Marca marca) {
        marcasBD.save(marca);
    }

    @Override
    public void remove(Long nro) {
        marcasBD.deleteById(nro);
    }
}
