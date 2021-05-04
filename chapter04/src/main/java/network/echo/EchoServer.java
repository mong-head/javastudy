package network.echo;

import java.io.BufferedReader;

//client : xshell쪽
//server : here

//TCPServer 코드 복붙 - 몇몇 고침; 다른 점 찾으며 다시 공부하기

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
	public static final int PORT = 7000;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. server socket 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(Binding)
			//		socket 의 InetSocketAddress ( IPAddress + Port)
			//		IPAddress : 자기 주소가 아닌 상대편 주소(통신할 곳 주소)
			//					0.0.0.0 ; 모든 IP 연결 허용한다는 말(보내는 쪽의 주소가 열린 주소)
			serverSocket.bind(new InetSocketAddress("0.0.0.0",PORT)); //(ip,port)
			log("starts...[port:"+PORT+"]");
			
			//3. accept
			//		client 연결 요청 기다림
			//		xshell; telnet 127.0.0.1 5000 하면 연결
			Socket socket = serverSocket.accept(); //blocking : 대기상태다가 연결되면 밑 줄 진행
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)(socket.getRemoteSocketAddress()); //socket.get~~하면 InetAddress형 return
			
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			log("connected by client["+ remoteHostAddress + " : " + remoteHostPort + "]");
			
			try {
				//4. IO Stream 받아오기
//				InputStream is = socket.getInputStream();
//				OutputStream os = socket.getOutputStream();	
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
				
				while(true) {
					//4. data read
					String data = br.readLine();
					if(data == null) {
						log("closed by client");
						break;
					}
					
					log("received:"+data);
					
					//5. data write
					//pw.print(data + "\n"); //\n : 요청구분하기 위한 경계
					pw.println(data); //위와 동일
				}
			} catch(SocketException e) {
				log("suddenly closed by client");
			} catch(IOException e){
				e.printStackTrace();
			} finally {
				try {
					if(socket != null && socket.isClosed() == false) {
						socket.close();											
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				//소켓을 두 번 닫으면 안 됨.
				if(serverSocket != null && serverSocket.isClosed()== false ) {
					serverSocket.close();					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	private static void log(String log) {
		System.out.print("[EchoServer] "+log+"\n");
	}
}
