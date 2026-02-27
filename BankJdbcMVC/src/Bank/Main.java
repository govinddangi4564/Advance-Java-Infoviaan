package Bank;

import Bank.controller.BankController;
import Bank.model.BankDao;
import Bank.view.BankView;

public class Main {
	public static void main(String[] args) {
		BankDao dao = new BankDao();
		BankView view = new BankView();
		
		BankController controller = new BankController(dao, view);
		
		controller.run();
	}

}
