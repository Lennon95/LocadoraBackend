package com.bcopstein.Interfaces.Persistencia.Carros;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Carro.Carro;

import org.springframework.data.repository.CrudRepository;

public interface CarrosH2BD_ITF extends CrudRepository<Carro, String> {
    List<Carro> findByPlaca(String placa);
    List<Carro> findAll();
}