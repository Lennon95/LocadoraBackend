package com.bcopstein.Interfaces;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;
import com.bcopstein.Entidades.Servicos.ServicoCatalogo;
import com.bcopstein.CasosDeUso.ControleCatalogo;
import com.bcopstein.Interfaces.DTO.FiltroDTO;
import com.bcopstein.Interfaces.DTO.CarrosDTO;

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
    private ControleCatalogo catalogo;

    @Autowired
    public CatalogoController(ControleCatalogo catalogo) {
      this.catalogo = catalogo;
    }  

    @GetMapping("/carrosDisponiveis")
    @CrossOrigin(origins = "*")
    public Collection<CarrosDTO> carrosDisponiveis(FiltroDTO filtro) {
        return this.catalogo.carrosDisponiveis(filtro);             
    }
    
    @GetMapping("/marcas")
    @CrossOrigin(origins = "*")
    public Collection<Marca> listaMarcas() {
        return this.catalogo.listaMarcas();
    }

    @GetMapping("/modelos")
    @CrossOrigin(origins = "*")
    public Collection<Modelo> listaModelos(@RequestParam("id") Long nroMarca) {
        return this.catalogo.listaModelosMarca(nroMarca);
    }    
}
