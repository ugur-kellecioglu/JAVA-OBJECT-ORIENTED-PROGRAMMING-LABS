package lab2;

import java.util.*;

//AUTHOR UÐUR KELLECÝOÐLU 17.10.2020 9:51
// Finish time: 11.01
// total time: 1h10min

public class MainProgram {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		String input = "";
		ArrayList<Bank> banks = new ArrayList<Bank>();
		ArrayList<Person> persons = new ArrayList<Person>();
		ArrayList<BankAccount> bank_accounts = new ArrayList<BankAccount>();
		int person_count = 0;
		int bank_count = 0;
		int bank_account_count = 0;
		do {
			System.out.println("Enter a command: ");
			input = keyboard.nextLine();
			String[] cmd = input.split("\\s+");
	 		String fnc = cmd[0];
	 		Address ad;
	 		//createPerson
	 		if(fnc.equals("createPerson")) {
	 			ad = new Address(cmd[4], cmd[5], cmd[6], cmd[7]);
	 			persons.add(new Person(cmd[1], cmd[2], ad, cmd[3]));
	 			System.out.println(persons.get(person_count));
	 			person_count++;
	 		}
	 		
	 		if(fnc.equals("createBank")) {
	 			ad = new Address(cmd[2], cmd[3], cmd[4], cmd[5]);
	 			banks.add(new Bank(cmd[1], ad));
	 			System.out.println(banks.get(bank_count));
	 			bank_count++;
	 		}
	 		
	 		if(fnc.equals("createBankAccount")) {
	 		
	 			Bank bank = banks.get(Integer.parseInt(cmd[2]));
	 			Person person = persons.get(Integer.parseInt(cmd[1]));
	 			bank_accounts.add(new BankAccount(bank, person, Double.parseDouble(cmd[3]), Integer.parseInt(cmd[4])));
	 			System.out.println("Bank Account Information:");
	 			System.out.println(bank_accounts.get(bank_account_count));
	 			System.out.println(bank.toString());
	 			System.out.println(person.toString());
	 			bank_account_count++;
	 		}
	 		if(fnc.equals("withdraw")) {
	 			int count = 0;
	 			for(BankAccount acc: bank_accounts) {
	 				if(acc.getAccountNumber() == Integer.parseInt(cmd[1])) {
	 					Bank bank = acc.getBank();
	 					Person person = acc.getOwner();
	 					double new_balance = acc.withdraw(Double.parseDouble(cmd[2]));
	 					if (new_balance != -1) {
	 						acc.setBalance(new_balance);
	 						System.out.println("Bank Account Information:");
	 			 			System.out.println(bank_accounts.get(count));
	 			 			System.out.println(bank.toString());
	 			 			System.out.println(person.toString());
	 					}
	 					else {
	 						System.out.println("Cannot withdraw a bigger amount than balance.");
	 					}
	 				}
	 				count++;
	 			}
	 		}
	 		
	 		if(fnc.equals("deposit")) {
	 			int count = 0;
	 			for(BankAccount acc: bank_accounts) {
	 				if (acc.getAccountNumber() == Integer.parseInt(cmd[1]))
	 				{
	 					Bank bank = acc.getBank();
	 					Person person = acc.getOwner();
	 					double new_balance = acc.deposit(Double.parseDouble(cmd[2]));
	 					acc.setBalance(new_balance);
	 					acc.setBalance(new_balance);
 						System.out.println("Bank Account Information:");
 			 			System.out.println(bank_accounts.get(count));
 			 			System.out.println(bank.toString());
 			 			System.out.println(person.toString());
	 				}
	 				count++;
	 			}
	 		}
	 		if(fnc.equals("getAccountNumbers")) {
	 			Bank bank = banks.get(Integer.parseInt(cmd[1]));
	 			for (BankAccount acc: bank_accounts) {
	 				
	 				if (acc.getBank() == bank) {
	 					System.out.println("Account number: " + acc.getAccountNumber());
	 					Person person = acc.getOwner();
	 					System.out.println(person.toString());
	 				}
	 			}
	 		}
		}
		while(!input.equals("Q"));

	}

}
