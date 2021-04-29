package exception;

/*
 * 
 * @author : yujin
 * 
 * unchecked exception
 * */

public class ExceptionTest {

	public static void main(String[] args) {
		int a = 10;
		int b = 10 - a;
		
		System.out.println("some code...1");
		try {
			System.out.println("some code...2");
			int result = (1+2+3)/b;
			System.out.println("some code...3");			
		} catch(ArithmeticException e) {
			//1. 사과
			System.out.println("죄송합니다.");
			//2. 로깅 - 파일로 저장
			System.out.println("error:"+e);
			//3. 정상 종료
			//System.exit(0); //위험 - finally도 안함
			return; //finally는 실행됨
			
			//뭘해야할 지 모르는 경우
			//e.printStackTrace();
		} finally {
			//무조건 실행
			//자원 정리 코드 있음
			System.out.println("some code...finally(정상 종료)");			
		}
		System.out.println("some code...5");

	}

}
