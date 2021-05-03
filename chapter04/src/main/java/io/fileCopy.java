package io;
//추상클래스 : InputStream, OutputStream

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class fileCopy {

	public static void main(String[] args) {
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream("dooly.jpg");
			os = new FileOutputStream("dooly.copy.jpg"); 
			
			int data = -1;
			while((data = is.read()) != -1 /*1byte read*/) {
				os.write(data); //write
			}
		} catch (FileNotFoundException e) {
			System.out.println("file not found: "+ e);
		} catch (IOException e) {
			System.out.println("error : "+e);
		} finally {
			//자원정리
			try {
				if(is != null) {
					is.close();					
				}
				if(os != null) {
					os.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
