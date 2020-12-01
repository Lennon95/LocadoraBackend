package com.bcopstein;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Carro.Marca;
import com.bcopstein.Entidades.Dominio.Carro.Modelo;
import com.bcopstein.Interfaces.DTO.FiltroDTO;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    
    @GetMapping("/carrosDisponiveis")
    @CrossOrigin(origins = "*")
    public ArrayList<Carro> carrosDisponiveis(FiltroDTO filtro) {
        ArrayList<Carro> list = null;
        
        return list;
    }
    
    @GetMapping("/marcas")
    @CrossOrigin(origins = "*")
    public ArrayList<Marca> listaMarcas() {
        ArrayList<Marca> list = null;
        
        return list;
    }
    
    
    @GetMapping("/modelos")
    @CrossOrigin(origins = "*")
    public ArrayList<Modelo> listaModelos(Marca marca) {
        ArrayList<Modelo> list = null;
        
        return list;
    }
    
    
}
