package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.util.Date;

public interface Calculator {
    public float calcula(Cliente cliente, Carro carro, Date inicio, Date fim);
}
