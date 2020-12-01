package com.bcopstein.Interfaces.Persistencia.Clientes;

import java.util.Collection;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import com.bcopstein.Entidades.Repositorio.Clientes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClientesH2BD_IMPL implements Clientes {
    private ClientesH2BD_ITF clientesBD;

    @Autowired
    public ClientesH2BD_IMPL(ClientesH2BD_ITF clientesBD) {
        this.clientesBD = clientesBD;
    }

    @Override
    public void cadastra(Cliente cliente) {
        clientesBD.save(cliente);
    }

    @Override
    public Cliente recupera(String documento) {
        return clientesBD.findByDocumento(documento).get(0);
    }

    @Override
    public Collection<Cliente> todos() {
        return clientesBD.findAll();
    }

    @Override
    public boolean existente(String doc) {
        return clientesBD.existsById(doc);
    }

    @Override
    public Collection<Cliente> pesquisa(Predicate<Cliente> pred) {
        return clientesBD.findAll()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
    }

    @Override
    public void atualiza(Cliente cliente) {
        clientesBD.save(cliente);
    }

    @Override
    public void remove(String documento) {
        clientesBD.deleteById(documento);
    }
}