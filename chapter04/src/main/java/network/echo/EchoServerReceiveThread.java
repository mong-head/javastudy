package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;

public class EchoServerReceiveThread extends Thread {
	private Socket socket;

	public EchoServerReceiveThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		// thread로 실행될 코드
		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) (socket.getRemoteSocketAddress()); // socket.get~~하면
																											// InetAddress형
																											// return

		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
		int remoteHostPort = inetRemoteSocketAddress.getPort();
		EchoServer2.log("connected by client[" + remoteHostAddress + " : " + remoteHostPort + "]");

		try {
			// 4. IO Stream 받아오기
//			InputStream is = socket.getInputStream();
//			OutputStream os = socket.getOutputStream();	

			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);

			while (true) {
				// 4. data read
				String data = br.readLine();
				if (data == null) {
					EchoServer2.log("closed by client");
					break;
				}

				EchoServer2.log("received:" + data);

				// 5. data write
				// pw.print(data + "\n"); //\n : 요청구분하기 위한 경계
				pw.println(data); // 위와 동일
			}
		} catch (SocketException e) {
			EchoServer2.log("suddenly closed by client");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
