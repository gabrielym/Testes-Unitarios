package main;

import model.Conta;

public class Main{
	  
	  public static void main(String[] args){
	    DeveDepositarNaContaSaldoZero();
	    DeveDepositarNaContaAtivadaComSaldoExistentePositivo();
	    DeveSacarDaContaAtivadaComSaldoPositivo();
	    NaoDeveSacarDaContaAtivadaSeOSaldoFicarNegativo();
	    NaoDeveDepositarNaContaDesativada();
	    NaoDeveSacarDaContaDesativada();
	  }

	  
	  private static void DeveDepositarNaContaSaldoZero(){
	    Conta conta;
	    double deposito;
	    boolean resultado;
	    System.out.println("\nDeve depositar na conta ativada com saldo zero.");

	    conta = new Conta();
	    conta.ativar();

	    System.out.println("Saldo:"+conta.getSaldo());

	    deposito=100.00;
	    resultado=conta.depositar(deposito); 

	    System.out.println("Conta Ativa?" +conta.isAtiva());
	    System.out.println("Depósito:" +deposito);
	    System.out.println("Saldo" +conta.getSaldo());
	    System.out.println("Resultado:" +resultado);

	    if((conta.getSaldo()==100.00) && resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	    
	  }

	   private static void DeveDepositarNaContaAtivadaComSaldoExistentePositivo(){
	    Conta conta;
	    double depositoInicial;
	    double deposito;
	    boolean resultado;
	    System.out.println("\nDeve depositar na conta ativada com saldo existente positivo");

	    conta = new Conta();
	    conta.ativar();

	    depositoInicial = 1.00;
	    resultado = conta.depositar(depositoInicial);

	    deposito = 100.00;
	    resultado = conta.depositar(deposito);

	    System.out.println("Deposito Inicial:"+depositoInicial);
	    System.out.println("Conta Ativa? "+conta.isAtiva());
	    System.out.println("Deposito:"+deposito);
	    System.out.println("Saldo:"+conta.getSaldo());
	    System.out.println("Resultado: "+resultado);

	    if((conta.getSaldo()==101.00) && resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	  }

	private static void 
	  DeveSacarDaContaAtivadaComSaldoPositivo(){
	    Conta conta;
	    double depositoInicial, saque;
	    boolean resultado;
	    System.out.println("\nDeve sacar da conta com saldo positivo");

	    conta = new Conta();
	    conta.ativar();

	    depositoInicial = 200.00;
	    resultado = conta.depositar(depositoInicial);

	    saque = 50.00;
	    resultado = conta.sacar(saque);

	    System.out.println("Depósito Inicial:"+depositoInicial);
	    System.out.println("Conta Ativa? "+conta.isAtiva());
	    System.out.println("Saque:"+saque);
	    System.out.println("Saldo:"+conta.getSaldo());
	    System.out.println("Resultado: "+resultado);

	    if((conta.getSaldo()==150.00) && resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	  }
	  

	  private static void NaoDeveSacarDaContaAtivadaSeOSaldoFicarNegativo(){
	    Conta conta;
	    double depositoInicial, saque;
	    boolean resultado;
	    System.out.println("\nNão deve sacar da conta ativada se o saldo ficar negativo.");

	    conta = new Conta();
	    conta.ativar();
	    //Deposito inicial
	    depositoInicial = 100.00;
	    conta.depositar(depositoInicial);

	    //Saque
	    saque = 150.00;
	    resultado = conta.sacar(saque);

	    System.out.println("Deposito Inicial" + depositoInicial);
	    System.out.println("Conta Ativa?" + conta.isAtiva());
	    System.out.println("Saque:" + saque);
	    System.out.println("Saldo" +conta.getSaldo());
	    System.out.println("Resultado:" +resultado);

	    if((conta.getSaldo()==100.00) && !resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	    
	  }


	  private static void NaoDeveDepositarNaContaDesativada(){
	    Conta conta;
	    double deposito;
	    boolean resultado;
	    
	    System.out.println("\nNao deve depositar na conta desativada");

	    conta = new Conta();
	    conta.desativar();

	    System.out.println("Saldo:"+conta.getSaldo());

	    deposito = 100.00;
	    resultado = conta.depositar(deposito);

	    System.out.println("Conta Ativa? "+conta.isAtiva());
	    System.out.println("Deposito:"+deposito);
	    System.out.println("Saldo:"+conta.getSaldo());
	    System.out.println("Resultado: "+resultado);

	    if((conta.getSaldo()==0.00) && !resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	      
	  }

	  private static void NaoDeveSacarDaContaDesativada(){
	    Conta conta;
	    double depositoInicial, saque;  
	    boolean resultado;
	    System.out.println("\nNão deve sacar da conta desativada.");

	    conta = new Conta();
	    
	    //Deposito inicial
	    conta.ativar();
	    depositoInicial = 100.00;
	    conta.depositar(depositoInicial);
	    conta.desativar();

	    //Saque
	    saque = 50.00;
	    resultado = conta.sacar(saque);

	    System.out.println("Deposito Inicial" + depositoInicial);
	    System.out.println("Conta Ativa?" + conta.isAtiva());
	    System.out.println("Saque:" + saque);
	    System.out.println("Saldo" +conta.getSaldo());
	    System.out.println("Resultado:" +resultado);

	    if((conta.getSaldo()==100.00) && !resultado){
	      System.out.println("PASSOU no teste!");
	    }else{
	      System.out.println("NAO PASSOU no teste!");
	    }
	    
	  }

	  
	  
	}