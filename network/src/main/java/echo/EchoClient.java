package echo;

//TCPClient 복붙; 다른거 찾아보기

//문제 : 다중처리 못함-single thread; 다중처리관련(multi-thread)은 thread package
//[server?]실행 : cmd에서 실행시켜보기
//cd E:\eclipse-workspace\javastudy\chapter04\target\classes
//java -cp . network.echo.EchoServer
//[client] 실행 : here; eclipse에서 실행

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class EchoClient {
	//private static final String SERVER_IP = "127.0.0.1";
	private static String SERVER_IP = "";
	
	public static void main(String[] args) {
		if(args.length==0) {
			System.out.println("실행방법 : Java EchoClient ServerIP");
			return;
		}
		SERVER_IP = args[0];	//eclipse : Run as - Run Configurations - argument : 192.168.254.40 주기
		
		Socket socket = null;
		Scanner scanner = null;
		try {
			// 0. Scanner 생성
			scanner = new Scanner(System.in);
			// 1. socket 생성
			 socket = new Socket();

			// 2. server connection
			socket.connect(new InetSocketAddress(SERVER_IP, EchoServer.PORT));
			log("connected");
			
			// 3. IO Stream 받아오기
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			
			while(true) {
				// 4. keyboard 입력 받기
				System.out.print("> ");
				String line = scanner.nextLine();
				if("exit".equals(line)) {
					break;
				}
				// 5. write data
				//pw.print(line+"\n"); //\n : 경계 (대신 println써도 됨) - 이거 안됨
				pw.println(line);
				
				// 6. read data
				String data = br.readLine();
				if(data == null) {
					log("closed by server");
					break;
				}
				
				// 7. console 출력
				System.out.println("<"+data);
				
			}
			
		} catch(SocketException e) {
			log("suddenly closed by server");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
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
		System.out.print("[EchoClient] "+log+"\n");
	}

}
