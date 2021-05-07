package udp;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPTimeClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int BUFFER_SIZE = 1024;
	private static final int SERVER_PORT = UDPTimeServer.PORT;

	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		
		try {
			System.out.println("client 실행");
			// 1. socekt 생성
			socket = new DatagramSocket();
			
			// 2. write data 
			DatagramPacket sendPacket = new DatagramPacket("".getBytes("UTF-8"), 0, new InetSocketAddress(SERVER_IP, SERVER_PORT));
			socket.send(sendPacket);
			
			// 3. data 읽기
			DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
			socket.receive(receivePacket); //blocking
			
			byte[] receiveData = receivePacket.getData();
			int length = receivePacket.getLength();
			String now = new String(receiveData,0,length,"utf-8");
			
			// 4. console 출력
			System.out.println(now); //날짜 출력
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

}
