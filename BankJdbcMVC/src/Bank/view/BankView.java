package Bank.view;

import java.util.Scanner;

public class BankView {

	private Scanner sc = new Scanner(System.in);

	public int showMenu() {

		System.out.println("------------------------------------------------------------------");
		System.out.println("Enter 1 for Open Account : ");
		System.out.println("Enter 2 for All Details (table) : ");
		System.out.println("Enter 3 for (Withdrwal) Debit Money : ");
		System.out.println("Enter 4 for Credit Money : ");
		System.out.println("Enter 5 for Transfer Money : ");
		System.out.println("Enter 6 for Exit : ");
		System.out.println("------------------------------------------------------------------");

		return sc.nextInt();
	}

	public String getUserName() {
		sc.nextLine();
		System.out.println("Enter name : ");
		return sc.nextLine();
	}

	public long getAccNo() {
		System.out.println("Enter Account Number : ");
		return sc.nextLong();
	}

	public double getBalance() {
		System.out.println("Enter Initial Balance : ");
		return sc.nextDouble();
	}
	
	public int getAmount() {
		System.out.println("Enter Amount : ");
		return sc.nextInt();
	}
	
	public int getFromAccNo() {
		System.out.println("Enter Sender Account Number : ");
		return sc.nextInt();
	}
	public int getToAccNo() {
		System.out.println("Enter Reciever Account Number : ");
		return sc.nextInt();
	}

}
