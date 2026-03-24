package controller;

import java.util.List;

import dao.FinesDao;
import model.Fines;
import view.MainView;

public class FinesController {

	public MainView view;
	public FinesDao dao;

	public FinesController(MainView view, FinesDao dao) {
		super();
		this.view = view;
		this.dao = dao;
	}

	public void run() {
		while (true) {
			int choice = view.finesMenu();

			switch (choice) {

			case 1: {
				int IssueId = view.getIssueId();

				int i = dao.calculateFine(IssueId);

				if (i != 0) {
					System.out.println("Fine Successfully Added.");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 2: {
				List<Fines> list = dao.viewAllFines();

				System.out.println(
						"\n---------------------------------------------------------------------------------------------------------------------");
				System.out.printf("%-10s %-18s %-18s %-18s %-18s %-18s %-8s\n", "Name", "Phone", "Title", "Author",
						"Due Date", "Return Date", "Fine");
				System.out.println(
						"---------------------------------------------------------------------------------------------------------------------");

				for (Fines f : list) {
					System.out.printf("%-10s %-18s %-18s %-18s %-18s %-18s %-8s\n", f.getName(), f.getPhone(), f.getTitle(),
							f.getAuthor(), f.getDueDate(), f.getReturnDate(), f.getFine());

				}
			}
				break;
			}
		}
	}

}
