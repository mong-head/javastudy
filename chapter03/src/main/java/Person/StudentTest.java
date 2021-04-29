package Person;

public class StudentTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		s1.setName("둘리");
		s1.setGrade(4);
		s1.setMajor("CS");
		
		Person p1 = s1; //upcasting(암시적)
		//Student s2 = p1; //error : downcasting (p1이 가리키고 있는게 다른 자식일 수도 있기 때문에 오류임) - 명시적으로 알려줘야함
		Student s2 = (Student)p1; //downcasting(명시적)
	}

}
