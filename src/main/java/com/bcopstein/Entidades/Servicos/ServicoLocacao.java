package com.bcopstein.Entidades.Servicos;

import java.util.List;
import java.util.Collection;
import java.util.stream.Collectors;
import java.time.LocalDate;

import com.bcopstein.Entidades.SistLocacaoException;

import com.bcopstein.Entidades.Dominio.Carro.Carro;
import com.bcopstein.Entidades.Dominio.Locacao.Locacao;
import com.bcopstein.Entidades.Dominio.Cliente.Cliente;

import com.bcopstein.Entidades.Repositorio.Carros;
import com.bcopstein.Entidades.Repositorio.Clientes;
import com.bcopstein.Entidades.Repositorio.Locacoes;

import com.bcopstein.Entidades.Dominio.Calculator.SeguroCalculator;
import com.bcopstein.Entidades.Dominio.Calculator.DescontoCalculator;
import com.bcopstein.Entidades.Dominio.Calculator.CustoCalculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ServicoLocacao {
    private Carros carros;
    private Locacoes locacoes;
    private Clientes clientes;
    private SeguroCalculator segCalc;
    private DescontoCalculator descCalc;
    private CustoCalculator custoCalc;

    @Autowired
    public ServicoLocacao(Carros carros, Locacoes locacoes, Clientes clientes,
                          SeguroCalculator segCalc, DescontoCalculator descCalc,
                          CustoCalculator custoCalc) {
        this.carros = carros;
        this.locacoes = locacoes;
        this.clientes = clientes;
        this.segCalc = segCalc;
        this.descCalc = descCalc;
        this.custoCalc = custoCalc;
    }

    public float[] locarCarro(String placaCarro, String docCliente, LocalDate inicio, LocalDate fim) {
        Collection<Carro> cars = this.carros.pesquisa((Carro c) -> c.getPlaca() == placaCarro);
        if (cars.size() == 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.CARRO_NAO_ENCONTRADO);
        Carro carro = cars.toArray(new Carro[0])[0];

        Collection<Cliente> clts = this.clientes.pesquisa((Cliente c) -> c.getDocumento() == docCliente);
        if (clts.size() == 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.CLIENTE_NAO_ENCONTRADO);
        Cliente cliente = clts.toArray(new Cliente[0])[0];

        float[] custos = this.calculaCustos(carro, cliente, inicio, fim);

        Locacao locacao = new Locacao(carro, inicio, fim, false, null, custos[3], cliente);
        cliente.setLocacoesFeitas(cliente.getLocacoesFeitas() +1);

        this.locacoes.cadastra(locacao);
        this.clientes.atualiza(cliente);
        return custos;
    }

    public float[] calculaCustos(Carro carro, Cliente cliente, LocalDate inicio, LocalDate fim) {
        int dias = fim != null ? fim.compareTo(inicio) : 2;
        float[] dados = new float[4];
        dados[0] = this.custoCalc.calcula(cliente, carro, inicio, fim) * dias;
        dados[1] = this.segCalc.calcula(cliente, carro, inicio, fim);
        dados[2] = this.descCalc.calcula(cliente, carro, inicio, fim);
        dados[3] = ((dados[0] + dados[1]) - dados[2]);
        return dados;
    }
}