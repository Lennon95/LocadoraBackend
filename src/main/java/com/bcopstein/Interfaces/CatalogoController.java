package com.bcopstein.Interfaces;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import com.bcopstein.Entidades.Servicos.ServicoCatalogo;
import com.bcopstein.Interfaces.DTO.FiltroDTO;

import java.util.Collection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

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
    public Collection<Carro> carrosDisponiveis(FiltroDTO filtro) {
        
        if(filtro == null) {
            return this.servico.listaCarrosDisponiveis(
                null,
                null,
                false,
                false,
                false,
                0,
                0
            );
        } else {
            return this.servico.listaCarrosDisponiveis(
                filtro.getInicioLocacao(),
                filtro.getFimLocacao(),
                filtro.isArcondicionado(),
                filtro.isDirecao(),
                filtro.isCambio(),
                filtro.getIdmarca(),
                filtro.getIdmodelo()
            );
        }
        
    }
    
    @GetMapping("/marcas")
    @CrossOrigin(origins = "*")
    public Collection<Marca> listaMarcas() {
        return this.servico.listaMarcas();
    }
    
    
    @GetMapping("/modelos")
    @CrossOrigin(origins = "*")
    public Collection<Modelo> listaModelos(@RequestParam("id") Long nroMarca) {
        return this.servico.listaModelosMarca(nroMarca);
    }
    
    
}
