package br.com.k21;

public class CalculadorDeComissao {

	public static Double calcular(Double valorDaVenda) {
		return Math.floor((valorDaVenda * 0.05) * 100)/100;
	}

}
