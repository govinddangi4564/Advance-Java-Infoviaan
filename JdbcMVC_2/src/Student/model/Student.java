package Student.model;

public class Student {

	private int id;
	private String name;
	private int age;
	private String rollno;
	private int hindiMarks;
	private int englishMarks;
	private int mathsMarks;
	private double percentage;

	public Student(int id, String name, int age, String rollno, int hindiMarks, int englishMarks, int mathsMarks,
			Double percentage) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.rollno = rollno;
		this.hindiMarks = hindiMarks;
		this.englishMarks = englishMarks;
		this.mathsMarks = mathsMarks;
		this.percentage = percentage;
	}
	
	public Student(int id, String name, int age, String rollno, int hindiMarks, int englishMarks, int mathsMarks) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.rollno = rollno;
		this.hindiMarks = hindiMarks;
		this.englishMarks = englishMarks;
		this.mathsMarks = mathsMarks;
	}

	public Student(String name, int age, String rollno, int hindiMarks, int englishMarks, int mathsMarks) {
		super();
		this.name = name;
		this.age = age;
		this.rollno = rollno;
		this.hindiMarks = hindiMarks;
		this.englishMarks = englishMarks;
		this.mathsMarks = mathsMarks;
	}

	public Student() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public int getHindiMarks() {
		return hindiMarks;
	}

	public void setHindiMarks(int hindiMarks) {
		this.hindiMarks = hindiMarks;
	}

	public int getEnglishMarks() {
		return englishMarks;
	}

	public void setEnglishMarks(int englishMarks) {
		this.englishMarks = englishMarks;
	}

	public int getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public double getPercentage(double percentage) {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	@Override
	public String toString() {
		return id + "\t" + name + "\t" + age + "\t"+ rollno + "\t"
				+ hindiMarks + "\t" + englishMarks + "\t" + mathsMarks + "\t"
				+ percentage ;
	}
	
	
}
