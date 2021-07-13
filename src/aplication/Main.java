package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {
		
		//alterando o idioma padrão, de portugues para o americano
		Locale.setDefault(Locale.US);
		//cria objeto do tipo Scanner por meio de onde é realizada a entrada de dados padrão, ou seja, do teclado
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data \n");
		System.out.println("Number: ");
		//armazenando o número digitado pelo usuário ao atributo que foi digitado pelo usuário
		int number = sc.nextInt();
		//limpando buffer para que o compilador não pule a linha que armazena o nome do titular da conta
		sc.nextLine();
		System.out.println("Holder: ");
		//armazena no atributo o nome do titular da conta que foi  digitado pelo usuário
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		//armazena no atributo o saldo inicital na conta que foi  digitado pelo usuário
		double balance = sc.nextDouble();
		System.out.println("Withdraw Limit: ");
		//armazena no atributo o valor limite para saque que foi digitado pelo usuário 
		double withdrawLimit = sc.nextDouble();
		
		//instanciando e inicializando o objeto account que recebe um new Account o qual é chamado passando por parâmetro os atributos number, holder, newDeposit, withdrawLimit 
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("\nEnter amount for withdraw: ");
		//armazena no atributo o valor do novo value digitado pelo usuário
		double value = sc.nextDouble();
		
		//bloco onde pode ocorrer alguma exceção
		try {
		//atualiza o saldo da conta chamando o método withdraw contido na classe Account através do objeto account, passando por parametro o atributo value que contem o valor do novo saque
		account.withdraw(value);
		
		//printando o novo saldo da conta
		System.out.println("\nNew balance: R$" + String.format("%.2f", account.getBalance()));
		}
		//executa este bloco catch caso tenha ocorrido alguma exceção de saque inválido
		catch(DomainException e){
			System.out.println("Error in withdraw: " + e.getMessage());
		}
	//encerra o objeto por onde é realizada a entrada de dados padrão 
	sc.close();
	}
	
}
