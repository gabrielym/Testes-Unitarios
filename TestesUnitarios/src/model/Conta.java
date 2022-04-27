package model;

public class Conta{
  protected double saldo;
  protected boolean ativa;

  public boolean isAtiva(){
    return ativa;
  }

  public void ativar(){
    ativa = true;
  }

  public void desativar(){
  ativa = false;
  }
  
  public boolean depositar(double valor){
    
    if(!isAtiva()){
      return false;
    }
    
    saldo += valor;

    return true;
  }

  public boolean sacar(double valor){
    
    if(!isAtiva()){
      return false;
    }

    if(valor<=getSaldo()){
      saldo -= valor;
      return true;
    }else{
      return false;
    }
  }
  
  public double getSaldo(){
    return saldo;
  }
}