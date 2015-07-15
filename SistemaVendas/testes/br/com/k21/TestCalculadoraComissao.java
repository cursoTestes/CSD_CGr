package br.com.k21;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCalculadoraComissao {

	@Test
	public void a_comissao_deve_ser_5_por_cento_do_valor_da_venda_quando_o_valor_for_menor_que_10000() {
		Double valorDaVenda = 1000.00;
		Double valorEsperado = 50.00;
		
		Double valorDaComissao = CalculadorDeComissao.calcular(valorDaVenda);

		assertEquals(valorEsperado, valorDaComissao);
	}
	
	@Test
	public void a_comissao_deve_ser_5_por_cento_do_valor_da_venda_quando_o_valor_for_1_50() throws Exception {
		Double valorDaVenda = 1.50;
		Double valorEsperado = 0.07;
		
		Double valorDaComissao = CalculadorDeComissao.calcular(valorDaVenda);
		
		assertEquals(valorEsperado, valorDaComissao);
	}
	
	@Test
	public void a_comissao_deve_ser_5_por_cento_do_valor_da_venda_quando_o_valor_for_igual_a_10000() {
		Double valorDaVenda = 10000.00;
		Double valorEsperado = 500.00;
		
		Double valorDaComissao = CalculadorDeComissao.calcular(valorDaVenda);

		assertEquals(valorEsperado, valorDaComissao);
	}
	
}