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
		ChatClientThread thread = null;

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
			
			
			// 4. nickname
			System.out.print("닉네임>> ");
			String nickname = scanner.nextLine();			
			
			// 5. ChatClientThread start
			thread = new ChatClientThread(socket);
			// 6. join protocol
			thread.doJoin(nickname);
			thread.start();
			
			// 7. keyboard 입력 처리
			while(true) {
				//System.out.print(">>");
				if( scanner.hasNextLine() == false ) {
					continue;
				}
				String input = scanner.nextLine();
				
				if("quit".equals(input) == true) {
					// 8. quit protocol 처리 - quit보내야함
					thread.doQuit();
					break;
				} else {
					// 9. message protocol 처리 - message protocol 보내기
					thread.doMessage(input);
				}
			}
			
		} catch(SocketException e) {
			thread.doQuit();
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
