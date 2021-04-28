package prob05;

public class Account {
	private String accountNo;
	private int balance;
	
	public Account(String a){
		this.accountNo = a;
		this.balance = 0;
		System.out.println(a+"계좌가 개설되었습니다.");
	}

	public void save(int s) {
		this.balance += s;
		System.out.println(accountNo+"계좌에 "+s+"만원이 입금되었습니다.");
	}
	public void deposit(int d) {
		this.balance -= d;
		System.out.println(accountNo+"계좌에 "+d+"만원이 출금되었습니다.");
	}
	
	public void setAccountNo(String ac) {
		this.accountNo = ac;
	}
	public String getAccountNo() {
		return this.accountNo;
	}
	public void setBalance(int b) {
		this.balance = b;
	}
	public int getBalance() {
		return this.balance;
	}
}
