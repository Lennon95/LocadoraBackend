package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.time.LocalDate;
import org.springframework.stereotype.Component;

@Component
public class Precos2020 implements CustoCalculator{

    @Override
    public float calcula(Cliente cliente, Carro carro, LocalDate inicio, LocalDate fim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
