package com.bcopstein.Interfaces.Persistencia.Clientes;

import java.util.List;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClientesH2BD_ITF extends CrudRepository<Cliente, String> {
    List<Cliente> findByDocumento(String doc);
    List<Cliente> findAll();
}