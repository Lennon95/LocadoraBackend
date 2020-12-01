package com.bcopstein.Interfaces.Persistencia.Clientes;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface CarrosH2BD_ITF extends CrudRepository<Cliente, Long> {
    List<Produto> findByDocumento(String doc);
    List<Produto> findAll();
}