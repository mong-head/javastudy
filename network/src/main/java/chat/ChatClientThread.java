package chat;

//cd E:\eclipse-workspace\javastudy\network\target\classes
//java -cp . chat.ChatClient
//java -cp . chat.ChatServer

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;

public class ChatClientThread extends Thread{
	
	private Socket socket;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	public ChatClientThread(Socket socket) {
		this.socket = socket;
		try {
			//reader,writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		try {
			while(true) {
				String message = br.readLine();
				if(message == null) {
					return;
				}
				System.out.println(message);				
			}
			
		} catch (IOException e) {
			System.out.println("error: "+e);
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
	public void doQuit() {
		pw.println("quit ");
		pw.flush();
	}
	public void doMessage(String message) {
		Encoder encoder = Base64.getEncoder();
		byte[] encodedMessage = encoder.encode(message.getBytes());

		pw.println("message "+new String(encodedMessage)); //message부분은 base64로 encoding해야함
		pw.flush();
	}
	public void doJoin(String nickname) {

		try {
			pw.println("join "+nickname); //보내고
			pw.flush();
			String ack = br.readLine(); // 받음
			if ("JOIN:OK".equals(ack)) {
				System.out.println("성공적으로 입장하였습니다.");
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
