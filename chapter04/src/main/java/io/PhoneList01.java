package io;
//scanner 내부

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class PhoneList01 {

	public static void main(String[] args) {
		BufferedReader br = null;
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

			// Date(file.lastModified()));
			
			System.out.println("====================전화번호====================");

			// 1. 기반 스트림
			FileInputStream fis = new FileInputStream(file);
			
			// 2. 보조 스트림1 (byte -> char)
			InputStreamReader isr = new InputStreamReader(fis);
			
			// 3. 보조 스트림2 (char -> String)
			br = new BufferedReader(isr);
			
			// 4. 처리
			String line = null;
			while((line = br.readLine())!= null) {
				StringTokenizer st = new StringTokenizer(line,"\t ");
				
				String[] print_ = {":","-","-",""};
				String[] tokens = new String[4];
				int idx = 0;
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					tokens[idx++] = token;
				}
				for(int i=0;i<tokens.length;i++) {
					System.out.print(tokens[i]+print_[i]);
				}
				System.out.println();
			
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("error: "+e);
		} catch (IOException e) {
			System.out.println("error: "+e);
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
