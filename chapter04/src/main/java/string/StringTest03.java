package string;

public class StringTest03 {
	public static void main(String[] args) {
		String s = "aBcABCabcAbc";
		
		System.out.println(s.length());
		System.out.println(s.charAt(2));
		System.out.println(s.indexOf("abc"));
		System.out.println(s.indexOf("abc",3));
		System.out.println(s.indexOf("abc",7));
		System.out.println(s.substring(3));
		System.out.println(s.substring(3,5));
		
		String s2 = "          ab       cd         ";
		String s3 = "efg,hijk,lmn,opqr";
		
		String s4 = s2.concat(s3);
		System.out.println(s4);
		
		System.out.println("----"+s2.trim()+"----");
		System.out.println("----"+s2.replaceAll(" ","")+"----");
		
		//정규표현식
		String p = "b1000a";
		if(p.matches("\\d+")) {
			int price = Integer.parseInt(p);
			System.out.println(price);
		} else {
			System.out.println("유효한 금액이 아닙니다.");
		}
		String[] tokens = s3.split(",");
		for(String token: tokens) {
			System.out.println(token);
		}
		String[] tokens2 = s3.split(" ");
		for(String token: tokens2) {
			System.out.println(token);
		}
		
		StringBuffer sb = new StringBuffer(""); //mutable
		sb.append("Hello ");
		sb.append("World ");
		sb.append("Java ");
		sb.append(1.8);
		String sb_s = sb.toString();
		//String sb_s = new StringBuffer("").append("Hello ").append("World ").append("Java ").append(1.8).toString(); 
		System.out.println(sb_s);
		
		//주의 : 문자열 + 연산을 하지 말아야 할 때 
//		String s7 = "";
//		for(int i=0;i<1000000;i++) {
//			s7 = s7 + i;
//			//s7 = new StringBuffer(s7).append(i).toString(); 와 같음
//		}
		StringBuffer s7 = new StringBuffer("");
		for(int i=0;i<1000000;i++) {
			s7.append(i);
		}
		String n = s7.toString();
	}
}
