package com.bcopstein;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Interfaces.DTO.DevolucaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.DevolucaoDTO;
import com.bcopstein.Interfaces.DTO.DevolucaoSubtotalDTO;
import com.bcopstein.Interfaces.DTO.FiltroDTO;
import com.bcopstein.Interfaces.DTO.LocacaoConfirmacaoDTO;
import com.bcopstein.Interfaces.DTO.LocacaoDTO;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locacao")
public class LocacaoController {
    
    @GetMapping("/registrar")
    @CrossOrigin(origins = "*")
    public LocacaoConfirmacaoDTO registrarLocacao(LocacaoDTO locacao) {
        LocacaoConfirmacaoDTO conf = new LocacaoConfirmacaoDTO();
        
        return conf;
    }
    
    @GetMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public DevolucaoSubtotalDTO devolucaoSubtotal(DevolucaoDTO locacao) {
        DevolucaoSubtotalDTO conf = new DevolucaoSubtotalDTO();
        
        return conf;
    }
    
    @GetMapping("/devolucao")
    @CrossOrigin(origins = "*")
    public DevolucaoConfirmacaoDTO registrarDevolucao(DevolucaoDTO locacao) {
        DevolucaoConfirmacaoDTO conf = new DevolucaoConfirmacaoDTO();
        
        return conf;
    }
    
    
    
}
