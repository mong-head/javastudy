package network.echo;

//multi-thread
//cmd server, eclipse client, cmd client

//client : xshell쪽
//server : here
//TCPServer 코드 복붙 - 몇몇 고침; 다른 점 찾으며 다시 공부하기


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer2 {
	public static final int PORT = 7000;

	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			// 1. server socket 생성
			serverSocket = new ServerSocket();

			// 2. 바인딩(Binding)
			// socket 의 InetSocketAddress ( IPAddress + Port)
			// IPAddress : 자기 주소가 아닌 상대편 주소(통신할 곳 주소)
			// 0.0.0.0 ; 모든 IP 연결 허용한다는 말(보내는 쪽의 주소가 열린 주소)
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT)); // (ip,port)
			log("starts...[port:" + PORT + "]");

			// 3. accept
			// client 연결 요청 기다림
			// xshell; telnet 127.0.0.1 7000 하면 연결
			// 보통 서버는 client하나 끝났다고 안끝남
			while(true) {
				Socket socket = serverSocket.accept(); // blocking : 대기상태다가 연결되면 밑 줄 진행
				Thread thread = new EchoServerReceiveThread(socket);
				thread.start();			
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 소켓을 두 번 닫으면 안 됨.
				if (serverSocket != null && serverSocket.isClosed() == false) {
					serverSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void log(String log) {
		System.out.print("[EchoServer2] " + log + "\n");
	}
}
