package httpd;

//서버실행(eclipse에서 실행) 후 chrome browser에서 127.0.0.1:8888

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleHttpServer {
	private static final int PORT = 8888; //8088 : tomcat 용

	public static void main(String[] args) {

		ServerSocket serverSocket = null;

		try {
			// 1. Create Server Socket
			serverSocket = new ServerSocket();
			   
			// 2. Bind
			//String localhost = InetAddress.getLocalHost().getHostAddress();
			//serverSocket.bind( new InetSocketAddress( localhost, PORT ) );
			serverSocket.bind( new InetSocketAddress( "0.0.0.0", PORT ) );
			consolLog("starts...[port:"+ PORT+"]");

			while (true) {
				// 3. Wait for connecting ( accept )
				Socket socket = serverSocket.accept();

				// 4. Delegate Processing Request
				new RequestHandler(socket).start(); //보통 handler라는 이름 많이 씀
			}

		} catch (IOException ex) {
			consolLog("error:" + ex);
		} finally {
			// 5. 자원정리
			try {
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException ex) {
				consolLog("error:" + ex);
			}
		}
	}

	public static void consolLog(String message) {
		System.out.println("[HttpServer#" + Thread.currentThread().getId()  + "] " + message);
	}
}
