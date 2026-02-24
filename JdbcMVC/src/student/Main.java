package student;

import student.controller.StudentController;
import student.model.StudentDao;
import student.view.StudentView;

public class Main {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		StudentView view = new StudentView();
		StudentController controller = new StudentController(dao, view);
		
		controller.run();
	}
}
