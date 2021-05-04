package thread;

//thread 2가지 방식
// 1. extends Thread : digitThread, alphabetThread 관련
// 2. implements Runnable : UppercaseAlphabet 관련; thread 상속 받지 않고, Runnable interface implement
//result : A1aBb2Cc3Dd4Ee5Ff6Gg7Hh8Ii9JjKkLlMmNnOoPpqQrRSsTtUuVvWwXxYyZz
public class ThreadEx03 {

	public static void main(String[] args) {
		// Thread1 : digitThread; Thread
		Thread thread1 = new DigitThread();
		// Thread2 : alphabetThread; Thread
		Thread thread2 = new AlphabetThread();
		// Thread3 : UppercaseAlphabet; Runnable 
		Thread thread3 = new Thread(new UppercaseAlphabetRunnableImpl());
		
		thread2.start();
		thread1.start();
		thread3.start();

	}

}
