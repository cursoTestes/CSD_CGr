package br.com.k21;

import java.util.List;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class CalculadoraDeRoyalties {
	
	private CalculadorDeComissao calculadorDeComissao;
	private VendaRepository vendaRepository;

	public CalculadoraDeRoyalties(CalculadorDeComissao calculadorDeComissao,
			VendaRepository vendaRepository) {
				this.calculadorDeComissao = calculadorDeComissao;
				this.vendaRepository = vendaRepository;
	}

	public Double calcular(int mes, int ano) {
		List<Venda> vendasPorMesEAno = vendaRepository.obterVendasPorMesEAno(ano, mes);
		Double totalDeVendasSemComissao = totalizarVendas(vendasPorMesEAno);
		Double totalDeRoyalties = totalDeVendasSemComissao *0.2;
		
		return totalDeRoyalties;
	}

	private Double totalizarVendas(List<Venda> vendasPorMesEAno) {
		Double total = 0d;
		
		for (Venda venda : vendasPorMesEAno) {
			Double valorComissao = calculadorDeComissao.calcular(venda.getValor());
			total += (venda.getValor() - valorComissao);
		}
		
		return total;
	}
	
}
