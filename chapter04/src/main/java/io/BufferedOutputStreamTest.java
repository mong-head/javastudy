package io;
//보조stream

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

	public static void main(String[] args) {
		BufferedOutputStream bos = null;
		try {
			//decoration: 상속하는 방법으로 안하고 runtime때에 확장시키는 방식으로 함
			//기반 스트림
			FileOutputStream fis = new FileOutputStream("test.txt");
			//보조 스트림
			bos = new BufferedOutputStream(fis);
			
			for(int i='a';i<'z';i++) {
				bos.write(i);
			}
		} catch (FileNotFoundException e) {
			System.out.println("can not open: "+ e);
		} catch (IOException e) {
			System.out.println("error: "+e);
		} finally {
			//자원정리
			try {
				if(bos != null) {
					bos.close();					
				}
			} catch (IOException e) {
				System.out.println("error: "+e);
			}
		}
	}

}

