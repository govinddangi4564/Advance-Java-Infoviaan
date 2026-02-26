package student.controller;

import java.util.List;

import student.model.Student;
import student.model.StudentDao;
import student.view.StudentView;

public class StudentController {

	public StudentDao dao;
	public StudentView view;

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
				String name = view.getStudentName();
				int age = view.getStudentAge();
				int roll = view.getStudentRoll();

				Student st = new Student(name, age, roll);
				int i = dao.insert(st);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 2: {
				int roll = view.getStudentRoll();
				String name = view.getStudentName();

				Student st = new Student();
				st.setRoll(roll);
				st.setName(name);

				int i = dao.update(roll, name);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 3: {
				int rollno = view.getStudentRoll();
				int i = dao.delete(rollno);
				System.out.println(i != 0 ? "Success" : "Something went wrong.");
			}
				break;

			case 4: {
				List<Student> list = dao.read();
				list.forEach((a) -> System.out.println(a));
				System.out.println();
			}
				break;

			case 5:
				System.out.println("Exit.");
				return;

			case 6: {
				List<Student> list = dao.read();
				list.sort((a, b) -> a.getRoll() - b.getRoll());
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
