package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class FileReaderTest {

	public static void main(String[] args) {
		Reader in = null;
		InputStream is = null; //비교용(byte와 char사이)
		
		try {
			in = new FileReader("1234.txt");
			
			//read : char 단위
			System.out.println("** Character read");
			int data = -1; //"가": 3byte, int: 4byte
			int count = 0;
			while((data=in.read())!= -1) {
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println("FileReader count: "+count + "\n"); //총 몇 번 읽었는 지
			
			is = new FileInputStream("1234.txt");
			
			//read : byte 단위
			System.out.println("** Byte read");
			data = -1; //"가": 3byte, int: 4byte
			count = 0;
			while((data=is.read())!= -1) {
				System.out.print((char)data); //깨져서 출력됨(한 바이트자체는 의미가 없는 값)
				count++;
			}
			System.out.println();
			System.out.println("FileInputStream count: "+count); //21번(3byte*7)
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+e);
		} catch (IOException e) {
			System.out.println("error: "+e);
		} finally {
			try {
				if(in!=null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
			try {
				if(is!=null) {
					is.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	}

}


