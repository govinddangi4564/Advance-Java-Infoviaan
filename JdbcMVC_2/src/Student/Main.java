package Student;

import Student.controller.StudentController;
import Student.model.StudentDao;
import Student.view.StudentView;

public class Main {
	public static void main(String[] args) {
		StudentDao dao = new StudentDao();
		StudentView view = new StudentView();
		
		StudentController controller = new StudentController(dao, view);
		
		controller.run();
	}

}
