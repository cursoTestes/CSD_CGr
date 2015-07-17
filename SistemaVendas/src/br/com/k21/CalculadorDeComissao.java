package br.com.k21;

public class CalculadorDeComissao {

	public Double calcular(Double valorDaVenda) {
		return Math.floor((valorDaVenda * 0.05) * 100)/100;
	}

}
