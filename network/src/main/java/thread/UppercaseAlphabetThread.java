package thread;

//thread를 상속받지 않는 경우
//
public class UppercaseAlphabetThread {
	public void print() {
		for(char c = 'A';c <= 'Z'; c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}	
