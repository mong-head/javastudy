package thread;

//multi-thread : digitThread, mainThread 함께 : 두 결과가 섞임
//sleep 사용하지 않을 때 result : abcde1234fghijklmnopqrstuvwxyz56789 (1~9:digitThread, a~z:main)
//sleep 사용 후 : (동시 실행 - sync맞춰짐)a1b2c3d4e56f7g8h9ijklmnopqrstuvwxyz

public class ThreadEx01 {

	public static void main(String[] args) {

		// DigitThread
		Thread digitThread = new DigitThread(); //객체 만듦 - 아직 thread만든건 아님
		digitThread.start(); //Thread 실행
		//new DigitThread().start(); //윗 줄들을 한 줄로
		
		// MainThread
		for(char c='a';c<='z';c++) {
			System.out.print(c);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
		
	}

}
