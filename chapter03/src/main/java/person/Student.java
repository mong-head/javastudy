package person;

public class Student extends Person {
	private int grade;
	private String major;
	
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public Student() {
		super(); //자식 클래스에서 부모클래스의 생성자를 명시하지 않는다면 자동으로 이거 삽입(위치는 항상 제일 위)
		System.out.println("Student() called");
	}
}
