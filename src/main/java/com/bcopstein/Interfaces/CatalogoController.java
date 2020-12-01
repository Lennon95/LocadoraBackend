package com.bcopstein.Interfaces;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import com.bcopstein.Entidades.Servicos.ServicoCatalogo;
import com.bcopstein.Interfaces.DTO.FiltroDTO;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalogo")
public class CatalogoController {
    private ServicoCatalogo servico;

    @Autowired
    public CatalogoController(ServicoCatalogo servico) {
      this.servico = servico;
    }  

    @GetMapping("/carrosDisponiveis")
    @CrossOrigin(origins = "*")
    public ArrayList<Carro> carrosDisponiveis(FiltroDTO filtro) {
        return this.servico.listaCarrosDisponiveis(filtro.getInicioLocacao(), filtro.getFimLocacao());
    }
    
    @GetMapping("/marcas")
    @CrossOrigin(origins = "*")
    public ArrayList<Marca> listaMarcas() {
        ArrayList<Marca> list = null;
        
        return list;
    }
    
    
    @GetMapping("/modelos")
    @CrossOrigin(origins = "*")
    public ArrayList<Modelo> listaModelos(Long nroMarca) {
        ArrayList<Modelo> list = null;
        
        return list;
    }
    
    
}
