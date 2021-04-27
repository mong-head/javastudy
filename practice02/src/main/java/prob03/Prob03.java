package prob03;

public class Prob03 {
	public static void main(String args[]) {
		char c[] = { 'T', 'h', 'i', 's', ' ', 'i', 's', ' ', 'a', ' ', 'p', 'e', 'n', 'c', 'i', 'l', '.' };

		// 원래 배열 원소 출력
		printCharArray(c);

		// 공백 문자 바꾸기
		replaceSpace(c);

		// 수정된 배열 원소 출력
		printCharArray(c);
	}
	public static void printCharArray(char a[]) {
		System.out.println(a);
	}
	public static void replaceSpace(char a[]) {
		int len = a.length;
		for(int i=0;i<len;i++) {
			if(a[i]==' ') a[i] = ',' ;
		}
	}

}
