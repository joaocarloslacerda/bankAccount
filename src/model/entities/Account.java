package model.entities;

import model.exception.DomainException;

public class Account {
	
	//declarando atributos da classe
	private Integer number;
	private String holder;
	//inicializando o atributo balance com saldo 0.0 pois este é o saldo inicial da conta, ou seja, antes do titular realizar o primeiro depósito
	private Double balance = 0.0;
	private Double withdrawLimit;
	
	//criando o construtor padrão
	public Account() {
	}
	
	//criando construtor personalizado com base nos atributos recebidos por parâmetro
	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		//atributo balance da classe Account recebe o retorno da função deposit que tem como parâmetro o atributo balance da classe Main
		this.balance = deposit(balance);
		this.withdrawLimit = withdrawLimit;
	}
	
	//retornando o atributo number
	public Integer getNumber() {
		return number;
	}
	
	//setando um número para a conta
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
	
	//método por onde são realizados os depósitos na conta
	public Double deposit(Double balance) {
		return this.balance += balance;
	}
	
	//método por onde são realizados os saques
	public void withdraw(Double value) {
		//chama o método que valida o valor solicitado para saque
		validateWithdraw(value);
		//se não ocorrer nenhuma das exceções ele realiza o saque na conta
		this.balance -= value;
	}
	
	//método que valida o valor solicitado para saque
	private void validateWithdraw(Double value) {
		//lança a exceção caso o saldo da conta seja menor que o valor solicitado para o saque
		if(balance < value) {
			throw new DomainException("Not enough balance");
		}
		//lança a exceção caso o valor solicitado para saque seja maior que o valor limite permitido para saque
		if(value > withdrawLimit) {
			throw new DomainException("The amount exceeds withdraw limit");
		}
	}
	
}
