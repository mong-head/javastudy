package udp;

//client연결안되어있으니 TCP와 다르게 thread만들 필요가 없음
//대신 처리할 packet이 많으면 receive부분을 thread로 처리

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.util.Scanner;

public class UDPEchoClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = UDPEchoServer.PORT;
	private static final int BUFFER_SIZE = UDPEchoServer.BUFFER_SIZE;

	public static void main(String[] args) {
		DatagramSocket socket = null;
		Scanner scanner = null;
		try {
			// 0. Scanner 생성
			scanner = new Scanner(System.in);
			// 1. socket 생성
			socket = new DatagramSocket();

			while (true) {
				// 2. keyboard 입력 받기
				System.out.print("> ");
				String line = scanner.nextLine();
				if ("exit".equals(line)) {
					break;
				}
				// 3. write data
				byte[] sendData = line.getBytes("UTF-8");
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,
						new InetSocketAddress(SERVER_IP, SERVER_PORT));
				
				socket.send(sendPacket);
				
				// 4. data 읽기
				DatagramPacket receivePacket = new DatagramPacket(new byte[BUFFER_SIZE],BUFFER_SIZE);
				socket.receive(receivePacket); //blocking
				
				byte[] receiveData = receivePacket.getData();
				int length = receivePacket.getLength();
				String message = new String(receiveData,0,length,"utf-8");
				

				// 5. console 출력
				System.out.println("<" + message);
			}

		} catch (SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (scanner != null) {
				scanner.close();
			}
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}
	}

	private static void log(String log) {
		System.out.print("[EchoClient] " + log + "\n");
	}

}
