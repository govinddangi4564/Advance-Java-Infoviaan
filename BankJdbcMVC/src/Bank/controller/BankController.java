package Bank.controller;

import java.util.List;

import Bank.model.Bank;
import Bank.model.BankDao;
import Bank.view.BankView;

public class BankController {
	public BankView view;
	public BankDao dao;

	public BankController(BankDao dao, BankView view) {
		super();
		this.dao = dao;
		this.view = view;
	}

	public void run() {
		while (true) {
			int choice = view.showMenu();

			switch (choice) {

			// insert

			case 1: {
				String name = view.getUserName();
				long accNo = view.getAccNo();
				double balance = view.getBalance();

				Bank bk = new Bank(name, accNo, balance);

				int i = dao.insert(bk);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			// read

			case 2: {
				List<Bank> list = dao.read();
				list.forEach((a) -> System.out.println(a));
				System.out.println();
			}
				break;

			// withdrawal(debit)

			case 3: {
				long accNo = view.getAccNo();
				int amount = view.getAmount();

				Bank bk = new Bank(accNo, amount);

				int i = dao.debit(bk);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			// Credit

			case 4: {
				long accNo = view.getAccNo();
				int amount = view.getAmount();

				Bank bk = new Bank(accNo, amount);

				int i = dao.credit(bk);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			// Transfer

			case 5: {
			    long fromAccNo = view.getFromAccNo();
			    long toAccNo = view.getToAccNo();
			    int amount = view.getAmount();

			    Bank bk = new Bank(fromAccNo, toAccNo, amount);

			    int result = dao.transfer(bk);
			    System.out.println(result != 0 ? "Success" : "Something went wrong.");
			}
			break;

			case 6:
				System.out.println("Exit..");
				return;

			default:
				System.out.println("Exit..");
				return;

			}
		}
	}
}
