package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String a){
		this.accountNo = a;
		this.balance = 0;
	}

	public void save(int s) {
		this.balance += s;
	}
	public void deposit(int d) {
		this.balance -= d;
	}
	
	public void setAccountNo(String ac) {
		this.accountNo = ac;
	}
	public String getAccountNo() {
		return this.accountNo;
	}
	public void setBalance(String b) {
		this.balance = b;
	}
	public String getBalance() {
		return this.balance;
	}
}
