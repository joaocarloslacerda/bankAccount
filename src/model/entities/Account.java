package model.entities;

import model.exception.DomainException;

public class Account {
	
	//declarando atributos da classe
	private Integer number;
	private String holder;
	//inicializando o atributo balance com saldo 0.0 pois este � o saldo inicial da conta, ou seja, antes do titular realizar o primeiro dep�sito
	private Double balance = 0.0;
	private Double withdrawLimit;
	
	//criando o construtor padr�o
	public Account() {
	}
	
	//criando construtor personalizado com base nos atributos recebidos por par�metro
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		//atributo balance da classe Account recebe o retorno da fun��o deposit que tem como par�metro o atributo balance da classe Main
		this.balance = deposit(balance);
		this.withdrawLimit = withdrawLimit;
	}
	
	//retornando o atributo number
	public Integer getNumber() {
		return number;
	}
	
	//setando um n�mero para a conta
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	//retornando o atributo holder
	public String getHolder() {
		return holder;
	}
	
	//setando um nome para a conta
	public void setHolder(String holder) {
		this.holder = holder;
	}
	
	//retornando o atributo balance
	public Double getBalance() {
		return balance;
	}
	
	//retornando o atributo withdrawLimit
	public Double getWithdrawLimit() {
		return withdrawLimit;
	}
	
	//setando um limite de saque
	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	//m�todo por onde s�o realizados os dep�sitos na conta
	public Double deposit(Double balance) {
		return this.balance += balance;
	}
	
	//m�todo por onde s�o realizados os saques
	public void withdraw(Double value) {
		//chama o m�todo que valida o valor solicitado para saque
		validateWithdraw(value);
		//se n�o ocorrer nenhuma das exce��es ele realiza o saque na conta
		this.balance -= value;
	}
	
	//m�todo que valida o valor solicitado para saque
	private void validateWithdraw(Double value) {
		//lan�a a exce��o caso o saldo da conta seja menor que o valor solicitado para o saque
		if(balance < value) {
			throw new DomainException("Not enough balance");
		}
		//lan�a a exce��o caso o valor solicitado para saque seja maior que o valor limite permitido para saque
		if(value > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
	}
	
}
