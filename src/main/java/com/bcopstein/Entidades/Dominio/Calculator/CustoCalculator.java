package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.time.LocalDate;

public interface CustoCalculator extends Calculator {
    @Override
    public float calcula(Cliente cliente, Carro carro, LocalDate inicio, LocalDate fim);
}
