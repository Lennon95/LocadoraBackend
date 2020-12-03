package com.bcopstein.Entidades.Dominio.Calculator;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;
import java.time.LocalDate;
import java.util.Calendar;
import org.springframework.stereotype.Component;

@Component
public class SeguroPortoSeguro implements SeguroCalculator {

    @Override
    public float calcula(Cliente cliente, Carro carro, LocalDate inicio, LocalDate fim) {
       if(cliente == null || cliente.getDataNascimento() == null) {
            return carro.getModelo().getValor() * (float)0.25;
        } else {
            int anoNasc = cliente.getDataNascimento().getYear();
            int anoAtual = Calendar.getInstance().get(Calendar.YEAR);
            if(anoAtual - anoNasc > 30)  {
                return carro.getModelo().getValor() * (float)0.12;        
            } else {
                return carro.getModelo().getValor() * (float)0.02;        
            }
        }
    }
    
}
