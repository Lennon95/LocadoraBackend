package com.bcopstein.CasosDeUso;

import com.bcopstein.Entidades.Servicos.ServicoLocacao;
import com.bcopstein.Entidades.Servicos.ServicoCatalogo;
import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Marca.Marca;
import com.bcopstein.Entidades.Dominio.Modelo.Modelo;

import com.bcopstein.Interfaces.DTO.FiltroDTO;
import com.bcopstein.Interfaces.DTO.CarrosDTO;

import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ControleCatalogo {
    private ServicoLocacao servicoLoc;
    private ServicoCatalogo servicoCat;

    @Autowired
    public ControleCatalogo(ServicoLocacao servicoLoc, ServicoCatalogo servicoCat) {
        this.servicoLoc = servicoLoc;
        this.servicoCat = servicoCat;
    }

    public Collection<CarrosDTO> carrosDisponiveis(FiltroDTO filtro) {
        List<Carro> carros = this.getListaCarros(filtro);
        ArrayList<CarrosDTO> result = new ArrayList<CarrosDTO>();

        LocalDate inicio = (filtro.getInicioLocacao() != null) ? LocalDate.parse(filtro.getInicioLocacao()) : null;
        LocalDate fim = (filtro.getFimLocacao() != null) ? LocalDate.parse(filtro.getFimLocacao()) : null;

        for (Carro carro : carros) {
            float[] custos = this.servicoLoc.calculaCustos(carro, null, inicio, fim);
            CarrosDTO carrosDTO = new CarrosDTO(carro, custos[0], custos[1], custos[2], custos[3]);
            result.add(carrosDTO);
        }
        return result;
    }

    private List<Carro> getListaCarros(FiltroDTO filtro) {
        if(filtro == null) {
            return this.servicoCat.listaCarrosDisponiveis(
                null,
                null,
                false,
                false,
                false,
                0,
                0
            );

        } else {
            return this.servicoCat.listaCarrosDisponiveis(
                LocalDate.parse(filtro.getInicioLocacao()),
                LocalDate.parse(filtro.getFimLocacao()),
                filtro.isArcondicionado(),
                filtro.isDirecao(),
                filtro.isCambio(),
                filtro.getIdmarca(),
                filtro.getIdmodelo()
            );
        }
    }

    public Collection<Marca> listaMarcas() {
        return this.servicoCat.listaMarcas();
    }

    public Collection<Modelo> listaModelosMarca(Long nroMarca) {
        return this.servicoCat.listaModelosMarca(nroMarca);
    }
}
