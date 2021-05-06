package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatClient {
	private static final String SERVER_IP = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			// 0. Scanner 생성
			scanner = new Scanner(System.in);

			// 1. socket 생성
			socket = new Socket();

			// 2. server connection
			socket.connect(new InetSocketAddress(SERVER_IP, ChatServer.PORT));
			log("connected");
			
//			// 3. reader/writer 생성
//			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
//			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			
			// 5. ChatClientThread start
			ChatClientThread thread = new ChatClientThread(socket);
			thread.start();
			
			// 4. join protocol
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();			
			thread.doJoin(nickname);
			
			// 6. keyboard 입력 처리
			while(true) {
				System.out.print(">>");
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					// 7. quit protocol 처리 - quit보내야함
					thread.doQuit();
					break;
				} else {
					// 8. message protocol 처리 - message protocol 보내기
					thread.doMessage(input);
				}
			}
			
		} catch(SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 자원 정리
			try {
				if(scanner != null) {
					scanner.close();
				}
				if(socket != null && socket.isClosed() == false) {
					socket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[ChatClient]"+log);
	}

}
