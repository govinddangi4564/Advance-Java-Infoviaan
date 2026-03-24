package main;

import controller.BookController;
import controller.FinesController;
import controller.IssueBookController;
import controller.StudentController;
import dao.BookDao;
import dao.FinesDao;
import dao.IssueBookDao;
import dao.StudentDao;
import view.MainView;

public class mainMethod {

	public static void main(String[] args) {

		MainView view = new MainView();
		BookDao bDao = new BookDao();
		StudentDao sDao = new StudentDao();
		IssueBookDao iDao = new IssueBookDao();
		FinesDao fDao = new FinesDao();

		BookController bController = new BookController(view, bDao);
		StudentController sController = new StudentController(view, sDao);
		IssueBookController iController = new IssueBookController(view, iDao);
		FinesController fController = new FinesController(view, fDao);

		while (true) {
			int choice = view.MainMenu();

			switch (choice) {

			case 1:
				bController.run();
				break;

			case 2:
				sController.run();
				break;

			case 3:
				iController.run();
				break;

			case 4:
				fController.run();
				break;

			case 5:
				System.out.println("Exit.");
				return;

			default:
				System.out.println("Invalid Choice.");
				break;
			}
		}
	}
}
