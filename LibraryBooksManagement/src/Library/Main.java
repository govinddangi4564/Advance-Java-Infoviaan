package Library;

import Library.controller.LibraryController;
import Library.model.LibraryDao;
import Library.view.LibraryView;

public class Main {
	public static void main(String[] args) {
		LibraryView view = new LibraryView();
		LibraryDao dao = new LibraryDao();

		LibraryController controller = new LibraryController(view, dao);

		controller.run();
	}
}
