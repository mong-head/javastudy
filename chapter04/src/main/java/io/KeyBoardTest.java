package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
//scanner내부 모습

public class KeyBoardTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//1. 기반 스트림 - 만들 필요는 없음;이미 있어서 (표준입력, stdin,Ststem.in)
			//2. 보조 스트림1 ((3개의 바이트받음)byte|byte|byte -> (하나의 character로)char)
			InputStreamReader isr = new InputStreamReader(System.in,"utf-8");
			//3. 보조 스트림2 (char1|char2|char3|\n -> string(char1char2char3))
			br = new BufferedReader(isr);
			
			String line = null;
			while((line = br.readLine())!= null) {
				if("quit".equals(line)) {
					break;
				}
				System.out.println(line);
			}
				
		} catch (UnsupportedEncodingException e) {
			System.out.println("error: "+e);
		} catch (IOException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(br != null) { //null point exception 피하기 위함
					br.close();					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
