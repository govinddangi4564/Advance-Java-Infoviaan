package Student.controller;

import java.util.List;

import Student.model.Student;
import Student.model.StudentDao;
import Student.view.StudentView;

public class StudentController {
	public StudentView view;
	public StudentDao dao;

	public StudentController(StudentDao dao, StudentView view) {
		super();
		this.dao = dao;
		this.view = view;
	}

	public void run() {
		while (true) {
			int choice = view.showMenu();

			switch (choice) {

			case 1: {
				view.getNextLine();
				String name = view.getStudentName();
				int age = view.getStudentAge();
				String roll = view.getStudentRoll();
				int hM = view.getStudentHM();
				int eM = view.getStudentEM();
				int mM = view.getStudentMM();

				Student st = new Student(name, age, roll, hM, eM, mM);

				int i = dao.insert(st);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 2: {
				String roll = view.getStudentRoll();
				String name = view.getStudentName();

				Student st = new Student();
				st.setName(name);
				st.setRollno(roll);

				int i = dao.update(st);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 3: {
				String roll = view.getStudentRoll();
				int i = dao.delete(roll);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 4: {
				List<Student> list = dao.read();
				list.forEach((a) -> System.out.println(a));
				System.out.println();
			}
				break;

			case 5: {
				List<Student> list = dao.sortByPer();
				list.forEach((a) -> System.out.println(a));
				System.out.println();
			}
				break;

			case 6: {
				List<Student> list = dao.sortByRoll();
				list.forEach((a) -> System.out.println(a));
				System.out.println();
			}
				break;

			default:
				System.out.println("Exit.");
				return;
			}
		}
	}
}
