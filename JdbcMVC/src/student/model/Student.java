package student.model;

// Entity class or table representation

public class Student {
	private String name;
	private int age;
	private int roll;

	public Student(String name, int age, int roll) {
		super();
		this.name = name;
		this.age = age;
		this.roll = roll;
	}

	public Student() {
		super();
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", roll=" + roll + "]";
	}

	
}
