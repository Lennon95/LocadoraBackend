package com.bcopstein.Interfaces.InjecaoConfig;

import com.bcopstein.Entidades.Dominio.Calculator.CustoCalculator;
import com.bcopstein.Entidades.Dominio.Calculator.SeguroBradesco;
import com.bcopstein.Entidades.Dominio.Calculator.SeguroCalculator;
import com.bcopstein.Entidades.Dominio.Calculator.Descontos2020;
import com.bcopstein.Entidades.Dominio.Calculator.DescontoCalculator;
import com.bcopstein.Entidades.Dominio.Calculator.Precos2020;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorCalculator{
    
    @Bean
    @Primary
    public CustoCalculator custoPadrao() {
        return new Precos2020();
    }
 
    @Bean
    @Primary
    public SeguroCalculator seguroPadrao() {
        return new SeguroBradesco();
    }
 
    @Bean
    @Primary
    public DescontoCalculator descontoPadrao() {
        return new Descontos2020();
    }
}
