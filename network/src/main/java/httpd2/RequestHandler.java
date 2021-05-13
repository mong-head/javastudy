package httpd2;

import java.io.BufferedReader;

//thread

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLConnection;


public class RequestHandler extends Thread {
	private Socket socket;
	private static final String DOCUMENT_ROOT = "/webapp"; //webapp - eclipse실행할 때 코드 
	
	public RequestHandler( Socket socket ) {
		this.socket = socket;
	}
	
	@Override
	public void run() {
		try {
			// get IOStream
			OutputStream os = socket.getOutputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8")); //요청 읽기 위함

			// logging Remote Host IP Address & Port
			InetSocketAddress inetSocketAddress = ( InetSocketAddress )socket.getRemoteSocketAddress();
			consoleLog( "connected from " + inetSocketAddress.getAddress().getHostAddress() + ":" + inetSocketAddress.getPort() );
			
			String request = null;
			while(true) {
				//read request
				String line = br.readLine();
				//browser가 연결 끊으면 그만 읽기
				if(line == null) {
					break;
				}
				
				//Requset Header만 읽음(내용은 안읽음)
				if("".equals(line)) {
					break;
				}
				
				//첫 번째 라인만 처리(GET / HTTP/1.1\n)
				if(request == null) {
					request = line;
					break;
				}
			}
			
			//request 처리
			String[] tokens = request.split(" ");
			//tokens[0] : method
			//tokens[1] : url
			//tokens[2] : protocol
			if("GET".equals(tokens[0])) {
				consoleLog("request: "+ tokens[1]); //token[1] : / or /favicon.ico 
				responseStaticResource(os,tokens[1],tokens[2]);
			} else { //method : POST, PUT, DELETE, HEAD, CONNECT
				/*Simple Http Server에서는 무시*/
				//bad request responce
				response400Error(os,tokens[1],tokens[2]); 
			}

			// 예제 응답입니다.
			// 서버 시작과 테스트를 마친 후, 주석 처리 합니다.
//			os.write( "HTTP/1.1 200 OK\r\n".getBytes( "UTF-8" ) );
//			os.write( "Content-Type:text/html; charset=utf-8\r\n".getBytes( "UTF-8" ) );
//			os.write( "\r\n".getBytes() ); //body임을 알려주기 위함으로 개행을 넣음 - 밑에는 이제 body내용
//			os.write( "<h1>이 페이지가 잘 보이면 실습과제 SimpleHttpServer를 시작할 준비가 된 것입니다.</h1>".getBytes( "UTF-8" ) );

		} catch( Exception ex ) {
			consoleLog( "error:" + ex );
		} finally {
			// clean-up
			try{
				if( socket != null && socket.isClosed() == false ) {
					socket.close();
				}
				
			} catch( IOException ex ) {
				consoleLog( "error:" + ex );
			}
		}			
	}



	private void responseStaticResource(OutputStream os, String url, String protocol) throws IOException {
		//welcome file set
		if("/".equals(url)) {
			//url이 default인 경우
			url = "/index.html";
		}
		
		InputStream is = RequestHandler.class.getClass().getResourceAsStream(DOCUMENT_ROOT + url);
		if(is == null) {
			response404Error(os,url,protocol);
			return;
		}
		
		String contentType = URLConnection.guessContentTypeFromName(DOCUMENT_ROOT+url);
		System.out.println("--->"+contentType);
		
		os.write( (protocol+" 200 OK\r\n").getBytes( "UTF-8" ) );
		os.write( ("Content-Type:"+contentType +"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		os.write( "\r\n".getBytes() ); //body임을 알려주기 위함으로 개행을 넣음 - 밑에는 이제 body내용
		
		int data = -1;
		while((data=is.read()) != -1) {
			os.write(data);
		}
		
	}
	
	private void response400Error(OutputStream os, String url, String protocol) throws IOException{
		// 응답 예시
		//HTTP/1.1 400 Bad Request\r\n
		//Content-Type:text/html; charset=utf-8\r\n
		//\r\n
		//HTML 에러 문서 (./webapp/error/400.html)

		InputStream is = RequestHandler.class.getClass().getResourceAsStream(DOCUMENT_ROOT+"/error/400.html");
		
		String contentType = URLConnection.guessContentTypeFromName(DOCUMENT_ROOT + "/error/400.html");
		
		os.write( (protocol+" 400 Bad Request\r\n").getBytes( "UTF-8" ) );
		os.write( ("Content-Type:"+contentType +"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		os.write( "\r\n".getBytes() ); //body임을 알려주기 위함으로 개행을 넣음 - 밑에는 이제 body내용
		
		int data = -1;
		while((data=is.read())!= -1) {
			os.write(data);
		}
	}
	private void response404Error(OutputStream os, String url, String protocol) throws IOException{
		// 응답 예시
		//HTTP/1.1 404 File Not Found\r\n
		//Content-Type:text/html; charset=utf-8\r\n
		//\r\n
		//HTML 에러 문서 (./webapp/error/404.html)
		url = "/error/404.html";
		
		InputStream is = RequestHandler.class.getClass().getResourceAsStream(DOCUMENT_ROOT+"/error/404.html");
		
		String contentType = URLConnection.guessContentTypeFromName(DOCUMENT_ROOT+"/error/404.html");
		
		os.write( (protocol+" 404 File Not Found\r\n").getBytes( "UTF-8" ) );
		os.write( ("Content-Type:"+contentType +"; charset=utf-8\r\n").getBytes( "UTF-8" ) );
		os.write( "\r\n".getBytes() ); //body임을 알려주기 위함으로 개행을 넣음 - 밑에는 이제 body내용
		
		int data = -1;
		while((data=is.read())!= -1) {
			os.write(data);
		}
	}

	public void consoleLog( String message ) {
		System.out.println( "[RequestHandler#" + getId() + "] " + message );
	}
}
