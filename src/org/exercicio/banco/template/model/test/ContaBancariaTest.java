package org.exercicio.banco.template.model.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.exercicio.banco.template.model.ContaBancaria;
import org.junit.Assert;
import org.junit.Test;

public class ContaBancariaTest {


	
	@Test
	public void sacarTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		c1.depositar(1000);
		c1.sacar(100);
		Assert.assertEquals(c1.getSaldo(), 900, 0);
	}
	
	@Test
	public void sacarContaFechadaTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Conta inativa.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.fecharConta();
		c1.sacar(100);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void sacarSaldoInsuficienteTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Saldo insuficiente.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.sacar(100);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void sacarValorInvalidoTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Valor inválido para saque.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.sacar(-100);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void depositarValorTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		c1.depositar(1000);
		Assert.assertEquals(c1.getSaldo(), 1000, 0);
	}
	
	@Test
	public void depositarValorInvalidoTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Valor invalido para deposito.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.depositar(-100);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void fecharContaJaEncerradaTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Conta ja inativa.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.fecharConta();
		c1.fecharConta();
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void fecharContaComSaldoTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		String errorContaInativa = "Conta com saldo. Nao eh possivel fecha-la.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.depositar(100);
		c1.fecharConta();
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void realizarTransferenciaTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		ContaBancaria c2= new ContaBancaria(2, "Joao");
		c1.depositar(100);
		c1.realizarTransferencia(50, c2);
		Assert.assertEquals(50, c2.getSaldo(), 0);
	}
	
	@Test
	public void realizarTransferenciaSaldoInsuficienteTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		ContaBancaria c2= new ContaBancaria(2, "Joao");
		String errorContaInativa = "Saldo insuficiente para transferencia.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.depositar(100);
		c1.realizarTransferencia(110, c2);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	
	@Test
	public void realizarTransferenciaContaDestinoInativaTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		ContaBancaria c2= new ContaBancaria(2, "Joao");
		String errorContaInativa = "Conta de destino inativa.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.depositar(100);
		c2.fecharConta();
		c1.realizarTransferencia(50, c2);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
	
	@Test
	public void realizarTransferenciaContaOrigemInativaTest() {
		ContaBancaria c1= new ContaBancaria(1, "Gustavo");
		ContaBancaria c2= new ContaBancaria(2, "Joao");
		String errorContaInativa = "Conta de origem inativa.";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		PrintStream old = System.out;
		System.setOut(ps);
		c1.fecharConta();
		c1.realizarTransferencia(50, c2);
		System.setOut(old);
		Assert.assertTrue(errorContaInativa.equals(baos.toString()));
	}
}
