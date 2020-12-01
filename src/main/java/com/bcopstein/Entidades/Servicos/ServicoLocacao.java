package com.bcopstein.Entidades.Servicos;

import java.util.List;
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

    public function locarCarro(String placaCarro, String docCliente, LocalDate inicio, LocalDate fim) {
        Collection<Carro> cars = this.carros.pesquisa((Carro c) -> c.getPlaca() == placaCarro);
        if (cars.size() == 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.CARRO_NAO_ENCONTRADO);

        Collection<Cliente> clts = this.clientes.pesquisa((Cliente c) -> c.getDocumento() == docCliente);
        if (clts.size() == 0)
            throw new SistLocacaoException(SistLocacaoException.Causa.CLIENTE_NAO_ENCONTRADO);
    }
}