package Student.view;

import java.util.Scanner;

public class StudentView {

	private Scanner sc = new Scanner(System.in);

	public int showMenu() {
		System.out.println("Enter 1 for insertion : ");
		System.out.println("Enter 2 for updation : ");
		System.out.println("Enter 3 for deletion : ");
		System.out.println("Enter 4 for read : ");
		System.out.println("Enter 5 for sort by percentage : ");
		System.out.println("Enter 6 for sort by rollNo : ");
		System.out.println("Enter 7 for exit : ");

		return sc.nextInt();
	}

	public String getStudentName() {
		System.out.println("Enter name : ");
		return sc.nextLine();
	}
	
	public void getNextLine() {
		sc.nextLine();
	}

	public int getStudentAge() {
		System.out.println("Enter age : ");
		return sc.nextInt();
	}

	public String getStudentRoll() {
		sc.nextLine();
		System.out.println("Enter rollno : ");
		return sc.nextLine();
	}

	public int getStudentHM() {
		System.out.println("Enter Hindi marks : ");
		return sc.nextInt();
	}

	public int getStudentEM() {
		System.out.println("Enter English Marks : ");
		return sc.nextInt();
	}

	public int getStudentMM() {
		System.out.println("Enter Maths Marks : ");
		return sc.nextInt();
	}

}
