package com.bcopstein.Interfaces.Persistencia.Carros;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Repositorio.Carros;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarrosH2BD_IMPL implements Carros {
    private CarrosH2BD_ITF carrosBD;

    @Autowired
    public CarrosH2BD_IMPL(CarrosH2BD_ITF carrosBD){
        this.carrosBD = carrosBD;
    }

    @Override
    public void cadastra(Carro carro) {
        carrosBD.save(carro);
    }

    @Override
    public Carro recupera(String chave) {
        return carrosBD.findByPlaca(chave).get(0);
    }

    @Override
    public Collection<Carro> todos() {
        return carrosBD.findAll();
    }

    @Override
    public boolean existente(String placa) {
        return carrosBD.existsById(placa);
    }

    @Override
    public Collection<Carro> pesquisa(Predicate<Carro> pred) {
        return carrosBD.findAll()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Carro produto) {
        carrosBD.save(produto);
    }

    @Override
    public void remove(String placa) {
        carrosBD.deleteById(placa);
    }
}
