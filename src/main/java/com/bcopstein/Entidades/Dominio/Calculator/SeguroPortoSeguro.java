package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class SeguroPortoSeguro implements SeguroCalculator {

    @Override
    public float calcula(Cliente cliente, Carro carro, Date inicio, Date fim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
