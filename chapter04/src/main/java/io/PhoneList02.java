package io;
//scanner로 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

public class PhoneList02 {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			// File class : file 기본정보 담겨있음(언제 만들어졌는지 등등)
			File file = new File("phone.txt");

			if (!file.exists()) { // try catch 없어도 이런게 가능
				System.out.println("file not found");
				return;
			}

			System.out.println("==============File Information===============");
			System.out.println(file.getAbsolutePath());
			System.out.println(file.length() + "bytes");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String lastModifiedDate = sdf.format(new Date(file.lastModified()));
			System.out.println(lastModifiedDate);

			System.out.println("====================전화번호====================");
			
			scanner = new Scanner(file);
			while(scanner.hasNextLine()) {
				String name = scanner.next();
				String phone[] = new String[3]; 
				for(int i=0;i<3;i++) {
					phone[i] = scanner.next();
				}
				System.out.printf("%s:%s-%s-%s\n",name,phone[0],phone[1],phone[2]);
			}
			
		} catch (IOException e) {
			System.out.println("error: "+e);
		} finally {
			if(scanner != null) {
				scanner.close();
			}
		}

	}

}
