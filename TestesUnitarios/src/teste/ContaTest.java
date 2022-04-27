package teste;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import model.Conta;

public class ContaTest {
	
	private Conta conta;
	private double depositoInicial, deposito, saque;
	private boolean resultado;
	
	@BeforeEach
	public void AtivarConta() {
		conta = new Conta();
		conta.ativar();
	}

	@Test
	@DisplayName("Deve depositar na conta ativada com saldo zero")
	public void DeveDepositarNaContaAtivadaComSaldoZero() {

	    deposito=100.00;
	    resultado=conta.depositar(deposito); 

	    Assertions.assertEquals(100.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(resultado);

	}
	
	@Test
	@DisplayName("Deve depositar na conta ativada com saldo existente positivo")
	public void DeveDepositarNaContaAtivadaComSaldoExistentePositivo() {

	    depositoInicial = 1.00;
	    resultado = conta.depositar(depositoInicial);

	    deposito = 100.00;
	    resultado = conta.depositar(deposito);

	    Assertions.assertEquals(101.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(resultado);
	   
	}
	
	@Test
	@DisplayName("Deve sacar da conta ativada com saldo positivo")
	public void DeveSacarDaContaAtivadaComSaldoPositivo() {
		
	    depositoInicial = 200.00;
	    resultado = conta.depositar(depositoInicial);

	    saque = 50.00;
	    resultado = conta.sacar(saque);
	    
	    Assertions.assertEquals(150.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(resultado);
	   
	}
	
	@Test
	@DisplayName("Nao deve sacar da conta ativada se o saldo ficar negativo.")
	public void NaoDeveSacarDaContaAtivadaSeOSaldoFicarNegativo(){
		
	    depositoInicial = 100.00;
	    conta.depositar(depositoInicial);

	    
	    saque = 150.00;
	    resultado = conta.sacar(saque);

	    
	    Assertions.assertEquals(100.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(!resultado);
	   
	}
	
	
	@Test
	@DisplayName("Nao deve depositar na conta desativada.")
	public void NaoDeveDepositarNaContaDesativada(){
	    conta.desativar();

	    
	    deposito = 100.00;
	    resultado = conta.depositar(deposito);

	    
	    Assertions.assertEquals(0.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(!resultado);
	   
	}
	
	@Test
	@DisplayName("Nao deve sacar na conta desativada.")
	public void NaoDeveSacarDaContaDesativada(){

		depositoInicial = 100.00;
	    conta.depositar(depositoInicial);
	    conta.desativar();

	    saque = 50.00;
	    resultado = conta.sacar(saque);

	   
	    Assertions.assertEquals(100.00, conta.getSaldo(), 0.001);
	    Assertions.assertTrue(!resultado);
	   
	}
	
	
}
