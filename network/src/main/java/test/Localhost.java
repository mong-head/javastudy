package test;

//ipconfig 관련

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {
		try {
			
			InetAddress inetAddress = InetAddress.getLocalHost();
			String hostName = inetAddress.getHostName(); // 컴퓨터이름; domain이랑 다른거임
			String hostAddress = inetAddress.getHostAddress();
			System.out.println(hostName);
			System.out.println(hostAddress); 
			
			byte[] addresses = inetAddress.getAddress();
			for(byte address : addresses) {
				System.out.print(address & 0x000000ff); //앞쪽 sign bit 살린거 빼고 2 byte에 담긴 그대로 만들기 위함 (ex. ffffffc0 -> 000000c0)
				System.out.print(".");
//				System.out.print(Integer.toBinaryString(address));
//				System.out.println();
			}
			
			
		} catch (UnknownHostException e) {
			
		}

	}

}
