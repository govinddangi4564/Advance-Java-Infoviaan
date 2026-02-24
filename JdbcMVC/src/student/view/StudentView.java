package student.view;

import java.util.Scanner;

public class StudentView {
	private Scanner sc = new Scanner(System.in);
	
	public int showMenu() {
		System.out.println("Enter 1 for insert");
		System.out.println("Enter 2 for update");
		System.out.println("Enter 3 for delete");
		System.out.println("Enter 4 for read");
		System.out.println("Enter 5 for exit");
		System.out.println("Enter 6 for short by rollno.");
		System.out.println("---------------------------------");
		
		return sc.nextInt();
	}
	
	public String getStudentName() {
		sc.nextLine();
		System.out.println("Enter name : ");
		return sc.nextLine();
	}
	
	public int getStudentAge() {
		System.out.println("Enter age : ");
		return sc.nextInt();
	}
	
	public int getStudentRoll() {
		System.out.println("Enter rollno : ");
		return sc.nextInt();
	}
}
