package prob04;

public class Depart extends Employee {
	private String department;
	
	public Depart(String name,int salary,String department) {
		super(name,salary);
		this.department = department;
	}
	public void getInformation() {
		System.out.printf("이름: %s\t연봉: %d\t부서: %s\n",
				getName(),getSalary(),department);
	}
}
