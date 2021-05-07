package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.List;

public class ChatServerThread extends Thread {

	private Socket socket;
	private String nickname;
	private List<Writer> writer_pool;
	
	public ChatServerThread(Socket socket,List<Writer> writer_pool) {
		this.socket = socket;
		this.writer_pool = writer_pool;
	}
	@Override
	public void run() {
		
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			//1. remote Host Information
			InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress)(socket.getRemoteSocketAddress());
			String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
			int remoteHostPort = inetRemoteSocketAddress.getPort();
			ChatServer.log("connected by client["+remoteHostAddress+":"+remoteHostPort+"]");
			
			//2. stream 받아오기
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"));
			
			while(true) {
				//3. data read
				String request = br.readLine();
				if(request == null) {
					ChatServer.log("closed by client");
					doQuit(pw);
					break;
				}
				
				ChatServer.log("received:" + request);
				
				//4. protocol 분석
				String[] tokens = request.split(" ");
				
				if("join".equals(tokens[0])) {
					doJoin(tokens[1],pw);
				} else if("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if("quit".equals(tokens[0])) {
					doQuit(pw);
					return;
				} else {
					ChatServer.log("error:알 수 없는 요청("+tokens[0]+")");
				}
			}
		} catch (SocketException e) {
			ChatServer.log("suddenly closed by client");
			doQuit(pw);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			doQuit(pw);
		} catch (IOException e) {
			e.printStackTrace();
			doQuit(pw);
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
	private void addWriter(Writer writer) {
		//synchronized : 여러 thread가 자원공유시 동기화
		synchronized(writer_pool) {
			writer_pool.add(writer);			
		}
	}
	private void broadcast(String data) {
		synchronized(writer_pool) {
			for(Writer writer : writer_pool) {
				PrintWriter pw = (PrintWriter)writer;
				pw.println(data);
				pw.flush(); //pw default로 false가 되어있기에 명시적으로 flush함수를 써주어서 버퍼비우기
			}
		}
	}
	private void removeWriter(Writer writer) {
		synchronized(writer_pool) {
			writer_pool.remove(writer);
		}
	}
	//join protocol
	private void doJoin(String nickname, Writer writer) {
		this.nickname = nickname;
		
		broadcast(nickname + "님이 입장하였습니다.");
		
		//writer pool에 저장
		addWriter(writer);
		
		//ack - 참여 성공을 클라이언트에게 알려줌
		PrintWriter pw = (PrintWriter)writer;
		pw.println("성공적으로 방에 입장하였습니다.");
		pw.flush();
		
	}
	//message protocol
	private void doMessage(String message) {
		Decoder decoder = Base64.getDecoder(); 
		byte[] decodedMessage = decoder.decode(message);

		broadcast(nickname+"님 : "+ new String(decodedMessage));
	}
	//quit protocol
	private void doQuit(Writer writer) {
		removeWriter(writer);
		
		broadcast(nickname + "님이 퇴장하였습니다.");
	}
}
