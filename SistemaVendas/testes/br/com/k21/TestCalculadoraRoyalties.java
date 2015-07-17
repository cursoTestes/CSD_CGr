package br.com.k21;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.k21.dao.VendaRepository;
import br.com.k21.modelo.Venda;

public class TestCalculadoraRoyalties {
	
	private static final int ID_DO_VENDEDOR = 1;
	private static final int ID_DA_VENDA = 1;
	private VendaRepository vendaRepository;
	private CalculadorDeComissao calculadorDeComissao;

	@Before
	public void init()
	{
		vendaRepository = mock(VendaRepository.class);
		calculadorDeComissao = mock(CalculadorDeComissao.class);
	}
	
	@Test
	public void calculo_para_um_mes_sem_vendas() {
		Double esperado = 0.00;
		int mes = 1;
		int ano = 2014;
		
		List<Venda> vendas = Arrays.asList();
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		
		CalculadoraDeRoyalties calculadoraDeRoyalties = new CalculadoraDeRoyalties(calculadorDeComissao, vendaRepository);
		Double totalDeRoyalties = calculadoraDeRoyalties.calcular(mes, ano);
		
		assertEquals(esperado, totalDeRoyalties);
	}
	
	@Test
	public void deve_calcular_royalties_para_uma_venda() throws Exception {
		Double esperado = 19d;
		int mes = 2;
		int ano = 2014;
		double valorDaVenda = 100.00;
		
		when(calculadorDeComissao.calcular(valorDaVenda)).thenReturn(5.00);
		
		List<Venda> vendas = Arrays.asList(new Venda(ID_DA_VENDA, ID_DO_VENDEDOR, mes, ano, valorDaVenda));
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		
		CalculadoraDeRoyalties calculadoraDeRoyalties = new CalculadoraDeRoyalties(calculadorDeComissao, vendaRepository);
		Double totalDeRoyalties = calculadoraDeRoyalties.calcular(mes, ano);
		
		assertEquals(esperado, totalDeRoyalties);
	}
	
	@Test
	public void deve_calcular_royalties_para_duas_vendas() throws Exception {
		Double esperado = 40d;
		int mes = 2;
		int ano = 2014;
		double valorDaVenda = 100.00;
		
		when(calculadorDeComissao.calcular(valorDaVenda)).thenReturn(0.0);
		
		List<Venda> vendas = Arrays.asList(new Venda(ID_DA_VENDA, ID_DO_VENDEDOR, mes, ano, valorDaVenda),new Venda(ID_DA_VENDA, ID_DO_VENDEDOR, mes, ano, valorDaVenda));
		when(vendaRepository.obterVendasPorMesEAno(ano, mes)).thenReturn(vendas);
		
		CalculadoraDeRoyalties calculadoraDeRoyalties = new CalculadoraDeRoyalties(calculadorDeComissao, vendaRepository);
		Double totalDeRoyalties = calculadoraDeRoyalties.calcular(mes, ano);
		
		assertEquals(esperado, totalDeRoyalties);
		verify(calculadorDeComissao, times(2)).calcular(anyDouble());
	}
}