package lab2;

public class BankAccount {
	private Bank bank;
	private Person owner;
	private double balance;
	private int accountNumber;
	
	public BankAccount(Bank bank, Person owner, double balance, int accountNumber) {
		
		this.bank = bank;
		this.owner = owner;
		this.balance = balance;
		this.accountNumber = accountNumber;
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public double withdraw(double amount) {
		if (this.balance < amount)
		{
			return -1;
		}
		else {
			this.balance -= amount;
			return balance;
		}
	}
	
	public double deposit(double amount) {
		
		this.balance += amount;
		return this.balance;
	}
	
	public String toString() {
		return "Balance= " + this.balance + "\nAccount Number= " + this.accountNumber;
	}
	
}
