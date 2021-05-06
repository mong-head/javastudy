package chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	public static final int PORT = 5555;
	public static List<Writer> writer_pool;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		writer_pool = new ArrayList<Writer>();
		
		try {
			//1. server socket 생성
			serverSocket = new ServerSocket();
			
			//2. binding
			//String hostAddress = InetAddress.getLocalHost().getHostAddress();
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT));
			log("starts...[port:" + PORT + "]");
			
			//3. accept (요청 대기)
			while(true) {
				Socket socket = serverSocket.accept();
				new ChatServerThread(socket,writer_pool).start();
			}
			
		} catch (IOException e) {
			System.out.println("error :"+e);
		} finally {
			try {
				if((serverSocket != null)&&serverSocket.isClosed()) {
					serverSocket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		

	}

	public static void log(String log) {
		System.out.print("[ChatServer]"+log+"\n");
		
	}

}
