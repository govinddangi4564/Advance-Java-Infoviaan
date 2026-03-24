package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private int studentId;
	private String studentName;
	private String email;
	private String phone;

	public Student(String studentName, String email, String phone) {
		super();
		this.studentName = studentName;
		this.email = email;
		this.phone = phone;
	}

}
