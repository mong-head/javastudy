package test;

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
import java.net.SocketTimeoutException;

public class TCPClient {
	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;

	public static void main(String[] args) {
		Socket socket = null;
		try {
			// 1. socket 생성
			socket = new Socket();
			 
			// 1-1. socket buffer size 확인
			int receiveBufferSize = socket.getReceiveBufferSize();
			int sendBufferSize = socket.getSendBufferSize();
			System.out.printf("[client] (변경 전)receive buffer size : %d, send buffer size : %d\n",receiveBufferSize, sendBufferSize);
			
			// 1-2. socket buffer size 변경
			socket.setReceiveBufferSize(1024 * 10);
			socket.setSendBufferSize(1024 * 10);
			receiveBufferSize = socket.getReceiveBufferSize();
			sendBufferSize = socket.getSendBufferSize();
			System.out.printf("[client] (변경 후)receive buffer size : %d, send buffer size : %d\n",receiveBufferSize, sendBufferSize);
			
			// 1-3. SO_NODELAY(Nagle Algorithm off - 대용량 파일을 빨리 올리고 싶은 경우만 사용)
			socket.setTcpNoDelay(true); //보통은 끄는게 좋음
			
			// 1-4. SO_TIMEOUT
			socket.setSoTimeout(1000); //1초 기다림
			
			
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
		} catch(SocketTimeoutException e) {
			System.out.println("[client] time out");
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
