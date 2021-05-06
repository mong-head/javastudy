package thread;

//multi-thread : DigitThread, AlphabetThread

public class ThreadEx02 {

	public static void main(String[] args) {
		//Thread1 : digitThread
		Thread thread1 = new DigitThread();
		//Thread2 : alphabetThread
		Thread thread2 = new AlphabetThread();
	
		thread2.start();
		thread1.start();
	}

}
