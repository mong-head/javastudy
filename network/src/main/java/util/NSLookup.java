package util;

//nslookup 구현

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.print(">>");
				String line = scanner.nextLine();

				if ("exit".equals(line)) {
					break;
				}
				
				InetAddress[] inetAddresses = InetAddress.getAllByName(line);// 도메인에 해당하는 ip 여러개일 수 있음 (round Robin - domain 분산)
				for(InetAddress inetAddress: inetAddresses) {
					System.out.println(line + " : " + inetAddress.getHostAddress());
				}
			} catch (UnknownHostException e) {
				System.out.println("unknown host");
			}
		}
		scanner.close();

	}

}
