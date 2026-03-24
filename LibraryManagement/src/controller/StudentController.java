package controller;

import java.util.List;

import dao.StudentDao;
import model.Student;
import view.MainView;

public class StudentController {
	public MainView view;
	public StudentDao dao;

	public StudentController(MainView view, StudentDao dao) {
		super();
		this.view = view;
		this.dao = dao;
	}

	public void run() {
		while (true) {
			int choice = view.studentMenu();
			switch (choice) {

			case 1: {
				String name = view.getStudentName();
				String email = view.getStudentEmail();
				String phno = view.getStudentPhone();

				Student st = new Student(name, email, phno);
				int i = dao.addStudent(st);

				if (i != 0) {
					System.out.println("Student successfully Registred..");
				} else {
					System.out.println("Something went wrong.");
				}

			}
				break;

			case 2: {
				List<Student> list = dao.viewStudent();

				System.out
						.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-18s %-20s %-20s\n", "Id", "Name", "Email", "Phone");
				System.out.println("---------------------------------------------------------------------------------");

				for (Student s : list) {
					System.out.printf("%-5s %-18s %-20s %-20s\n", s.getStudentId(), s.getStudentName(), s.getEmail(),
							s.getPhone());
				}
			}
				break;

			case 3: {
				String name = view.getStudentName();
				List<Student> list = dao.searchStudent(name);

				System.out
						.println("\n---------------------------------------------------------------------------------");
				System.out.printf("%-5s %-18s %-20s %-20s\n", "Id", "Name", "Email", "Phone");
				System.out.println("---------------------------------------------------------------------------------");

				for (Student s : list) {
					System.out.printf("%-5s %-18s %-20s %-20s\n", s.getStudentId(), s.getStudentName(), s.getEmail(),
							s.getPhone());
				}
			}
				break;

			case 4: {
				int id = view.getStudentId();
				view.getNextLine();
				String phno = view.getStudentPhone();

				int i = dao.updateStudent(id, phno);

				if (i != 0) {
					System.out.println("Record successfull updated..");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 5: {
				int id = view.getStudentId();

				int i = dao.deleteStudent(id);

				if (i != 0) {
					System.out.println("Student Record successfull Deleted..");
				} else {
					System.out.println("Something went wrong.");
				}
			}
				break;

			case 6:
				System.out.println("Exit.");
				return;

			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}

}
