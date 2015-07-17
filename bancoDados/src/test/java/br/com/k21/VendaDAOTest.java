package br.com.k21;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.dbunit.DBTestCase;
import org.junit.Test;

import br.com.k21.Vendedor;
import br.com.k21.dao.VendaDAO;
import br.com.k21.dao.VendedorDAO;
import br.com.k21.infra.BaseDBTest;

public class VendaDAOTest extends BaseDBTest {

	@Test
	public void testTotal_Para_Vendedor_Inexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 99;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2001;
		double resultado;
		double esperado = 0.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDeve_Trazer_O_Resultado_de_uma_venda_para_um_vendedor_no_ano() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 2;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 100.0;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDeve_Trazer_O_Resultado_para_um_vendedor_sem_venda() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 0.00;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}

	@Test
	public void testDeve_Trazer_O_Resultado_para_um_vendedor_com_duas_vendas() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 5;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2011;
		double resultado;
		double esperado = 250d;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDeve_Trazer_O_Resultado_para_um_vendedor_para_Ano_Inexistente() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 1;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2005;
		double resultado;
		double esperado = 0.00;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	@Test
	public void testDeve_Trazer_O_Resultado_para_um_vendedor_para_unico_ano() {
		// Arrange
		Vendedor vendedor = new Vendedor();
		int entradaIdVendedor = 7;
		vendedor.setId(entradaIdVendedor);
		int entradaAno = 2012;
		double resultado;
		double esperado = 140.00;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDeve_Trazer_O_Resultado_para_uma_venda_com_dois_vendedores() {
		// Arrange
		Vendedor vendedor1 = new Vendedor();
		int entradaIdVendedor = 6;
		vendedor1.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 100.00;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor1, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
	
	@Test
	public void testDeve_Trazer_O_Resultado_de_todas_As_Vendas_de_um_vendedor() {
		// Arrange
		Vendedor vendedor1 = new Vendedor();
		int entradaIdVendedor = 8;
		vendedor1.setId(entradaIdVendedor);
		int entradaAno = 2013;
		double resultado;
		double esperado = 400.00;
		
		// act
		VendaDAO.setEntityManager(emf.createEntityManager());
		resultado = VendaDAO.buscarTotalDeVendasPorVendedorEAno(vendedor1, entradaAno);
		
		// asserts
		assertEquals(esperado, resultado);
		
	}
}
