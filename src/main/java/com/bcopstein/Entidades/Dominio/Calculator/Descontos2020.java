package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Descontos2020 implements DescontoCalculator {

    @Override
    public float calcula(Cliente cliente, Carro carro, LocalDate inicio, LocalDate fim) {
        return carro.getModelo().getValor() * (float)0.10;
    }

    
}
