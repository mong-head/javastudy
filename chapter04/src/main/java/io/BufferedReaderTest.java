package io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			//기반 스트림
			FileReader fr = new FileReader("./src/main/java/io/BufferedReaderTest.java");
			//보조 스트림(데코레이터)
			br = new BufferedReader(fr);
			
			String line = null;
			int idx = 1;
			while((line = br.readLine())!= null /*file의 끝은 null*/) {
				System.out.println((idx++)+" : "+line);
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+e);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
