package io;
//Memory(input) to Memory(output) example
//추상클래스 : InputStream, OutputStream

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

public class IOExample {

	public static void main(String[] args) throws IOException {
		byte[] src = {1,2,3,4};
		byte[] dest = null;
		
		InputStream is = new ByteArrayInputStream(src); //InputStream : 추상
		OutputStream os = new ByteArrayOutputStream(); //OutputSteam : 추상
		
		//read & write
		int data = -1;
		while((data = is.read()) != -1 /*1byte read*/) {
			os.write(data); //write
		}
		
		dest = ((ByteArrayOutputStream)os).toByteArray(); //출력하기 위함
		System.out.println(Arrays.toString(src));
		System.out.println(Arrays.toString(dest));
	}

}

