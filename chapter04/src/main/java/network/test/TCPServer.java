package network.test;

//client : xshell쪽
//server : here

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			//1. server socket 생성
			serverSocket = new ServerSocket();
			
			//2. 바인딩(Binding)
			//		socket 의 InetSocketAddress ( IPAddress + Port)
			//		IPAddress : 자기 주소가 아닌 상대편 주소(통신할 곳 주소)
			//					0.0.0.0 ; 모든 IP 연결 허용한다는 말(보내는 쪽의 주소가 열린 주소)
			serverSocket.bind(new InetSocketAddress("0.0.0.0",5000)); //(ip,port)
			
			//3. accept
			//		client 연결 요청 기다림
			//		xshell; telnet 127.0.0.1 5000 하면 연결
			Socket socket = serverSocket.accept(); //blocking : 대기상태다가 연결되면 밑 줄 진행
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)(socket.getRemoteSocketAddress()); //socket.get~~하면 InetAddress형 return
			
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			System.out.printf("[server] connected by client[%s : %d]\n",remoteHostAddress, remoteHostPort);
			
			try {
				InputStream is = socket.getInputStream();
				OutputStream os = socket.getOutputStream();	
				
				while(true) {
					//4. data read
					byte[] buffer = new byte[256]; //client쪽 읽은거 저장하는거? received buffer인건가?
					int readByteCount = is.read(buffer); //blocking; 무한 루프 해도 상관없는 이유
					
					if(readByteCount == -1) {
						//client 정상 종료(close() 호출)
						//telnet; ctrl + alt + ] -> disconnect
						System.out.println("[server] closed by client");
						break;
					}
					String data = new String(buffer,0,readByteCount,"utf-8"); //읽은데까지만 string으로 바꿈
					System.out.println("[server] received:"+data);
					
					//5. data write
					os.write(data.getBytes("utf-8"));
				}
			} catch(SocketException e) {
				System.out.println("[server] suddenly closed by client");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
