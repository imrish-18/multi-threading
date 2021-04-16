package Threads;

import java.util.Scanner;

class Account 
{
	int bal;
	public  Account(int bal)
	{
		this.bal=bal;
		
	}
	public boolean isSufficientBal(int w) {
		if(bal>w)
			return true;
		else  
			return false;
	}
	
	public void withDraw(int amt)
	{
		bal=bal-amt;
		System.out.println("withDraw money is "+amt);
		System.out.println("your account balance is "+bal);
		
		
	}
}

class Customer extends Thread
{
	
	private Account account;
	private String name;
	public Customer(Account account,String name) {
		this.account=account;
		this.name=name;
	}
	public void run()
	{
		
		Scanner sc=new Scanner(System.in);
		synchronized(account){
		System.out.println(name+"  enter the amount to be withdraw");
		int amount =sc.nextInt();
		if(account.isSufficientBal(amount))
		{
			account.withDraw(amount);
		}
		else 
			System.out.println("inSufficient Balance");
		}
		
	}
	
}
public class CustomerBanking {

	public static void main(String[] args) {
		Account account=new Account(1000);
		Customer c=new Customer(account,"james");
		Customer customer=new Customer(account,"root");
		c.start();
		customer.start();
		

	}

}
