package aplication;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {
		
		//alterando o idioma padr�o, de portugues para o americano
		Locale.setDefault(Locale.US);
		//cria objeto do tipo Scanner por meio de onde � realizada a entrada de dados padr�o, ou seja, do teclado
		Scanner sc = new Scanner(System.in);
		
		
		System.out.println("Enter account data \n");
		System.out.println("Number: ");
		//armazenando o n�mero digitado pelo usu�rio ao atributo que foi digitado pelo usu�rio
		int number = sc.nextInt();
		//limpando buffer para que o compilador n�o pule a linha que armazena o nome do titular da conta
		sc.nextLine();
		System.out.println("Holder: ");
		//armazena no atributo o nome do titular da conta que foi  digitado pelo usu�rio
		String holder = sc.nextLine();
		System.out.println("Initial balance: ");
		//armazena no atributo o saldo inicital na conta que foi  digitado pelo usu�rio
		double balance = sc.nextDouble();
		System.out.println("Withdraw Limit: ");
		//armazena no atributo o valor limite para saque que foi digitado pelo usu�rio 
		double withdrawLimit = sc.nextDouble();
		
		//instanciando e inicializando o objeto account que recebe um new Account o qual � chamado passando por par�metro os atributos number, holder, newDeposit, withdrawLimit 
		Account account = new Account(number, holder, balance, withdrawLimit);
		
		System.out.println("\nEnter amount for withdraw: ");
		//armazena no atributo o valor do novo value digitado pelo usu�rio
		double value = sc.nextDouble();
		
		//bloco onde pode ocorrer alguma exce��o
		try {
		//atualiza o saldo da conta chamando o m�todo withdraw contido na classe Account atrav�s do objeto account, passando por parametro o atributo value que contem o valor do novo saque
		account.withdraw(value);
		
		//printando o novo saldo da conta
		System.out.println("\nNew balance: R$" + String.format("%.2f", account.getBalance()));
		}
		//executa este bloco catch caso tenha ocorrido alguma exce��o de saque inv�lido
		catch(DomainException e){
			System.out.println("Error in withdraw: " + e.getMessage());
		}
	//encerra o objeto por onde � realizada a entrada de dados padr�o 
	sc.close();
	}
	
}
