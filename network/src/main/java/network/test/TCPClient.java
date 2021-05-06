package network.test;

//[server?]실행 : cmd에서 실행시켜보기
//cd E:\eclipse-workspace\javastudy\chapter04\target\classes
//java -cp . network.test.TCPServer
//[client] 실행 : here; eclipse에서 실행

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// 1. socket 생성
			 socket = new Socket();

			// 2. server connection
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			System.out.println("[client] connected");
			
			// 3. IO Stream 받아오기
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();
			
			// 4. write
			String data = "Hello world\n";
			os.write(data.getBytes("utf-8"));
			
			// 5. read
			byte[] buffer = new byte[255];
			int readByteCount = is.read(buffer); //blocking
			if(readByteCount == -1) {
				System.out.println("[client] closed by server");
				return;
			}
			
			data = new String(buffer, 0 ,readByteCount, "utf-8");
			System.out.println("[client] received:"+data);
		} catch(SocketException e) {
			System.out.println("[client] suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(socket != null && socket.isClosed() == false) {
					socket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
