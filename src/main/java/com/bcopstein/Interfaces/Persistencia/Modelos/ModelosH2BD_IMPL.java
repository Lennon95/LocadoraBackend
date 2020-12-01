package com.bcopstein.Interfaces.Persistencia.Modelos;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import com.bcopstein.Entidades.Repositorio.Modelos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ModelosH2BD_IMPL implements Modelos {
    private ModelosH2BD_ITF modelosBD;

    @Autowired
    public ModelosH2BD_IMPL(ModelosH2BD_ITF modelosBD) {
        this.modelosBD = modelosBD;
    }

    @Override
    public void cadastra(Modelo modelo) {
        modelosBD.save(modelo);
    }

    @Override
    public Modelo recupera(Long nro) {
        return modelosBD.findById(nro);
    }

    @Override
    public Collection<Modelo> todos() {
        return modelosBD.findAll();
    }

    @Override
    public boolean existente(Long nro) {
        return modelosBD.existsById(nro);
    }

    @Override
    public Collection<Modelo> pesquisa(Predicate<Modelo> pred) {
        return modelosBD.findAll()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Modelo modelo) {
        modelosBD.save(modelo);
    }

    @Override
    public void remove(Long nro) {
        modelosBD.deleteById(nro);
    }
}
