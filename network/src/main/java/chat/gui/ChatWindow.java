package chat.gui;

import java.awt.BorderLayout; //awt : window 창 관련 프로그램
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Base64;
import java.util.Base64.Encoder;

import chat.ChatClientThread;

public class ChatWindow {

	private Frame frame; // 띄우는 창 관련
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	private String nickname;
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private ChatClientThread thread;

	public ChatWindow(Socket socket, String nickname) {
		frame = new Frame(nickname);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		this.nickname = nickname;
		this.socket = socket;
	}

	public void show() {
		/*
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			// anonymous class
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});
//		//함수형 프로그래밍
//		buttonSend.addActionListener (actionEvent -> {
//			//lambda 
//			sendMessage();
//		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				// enter 입력시
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}

		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
				// System.exit(0);
			}
		});
		frame.setVisible(true);
		frame.pack();

		/*
		 * 2. IOStream 생성
		 */
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // flush:true
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * 3. Chat Client Thread 생성(Receive Thread)
		 */
		thread = new ChatClientThread(socket, nickname);
		thread.start();
	}

	private void finish() {
		// System.out.println("소켓닫기 or 방나가기 프로토콜 구현");
		try {
			if (socket != null && socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			System.out.println(nickname+"님이 퇴장하였습니다.");
			System.exit(0);			
		}
	}

	private void sendMessage() {
		String message = textField.getText();
		// to server
		thread.doMessage(message);

		// 화면
		updateTextArea(nickname + " : " + message);

		textField.setText(""); // 지우고
		textField.requestFocus(); // 커서 옮기기
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	// 내부에 만듦
	public class ChatClientThread extends Thread {
		public Socket socket;
		private String nickname;
		private BufferedReader br;
		private PrintWriter pw;

		public ChatClientThread(Socket socket, String nickname) {

			try {
				this.socket = socket;
				this.nickname = nickname;

				// reader,writer 생성
				br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true); // flush : true

			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {

			updateTextArea(nickname + "님이 입장하였습니다.");

		}

		public void doMessage(String message) {
			Encoder encoder = Base64.getEncoder();
			byte[] encodedMessage = encoder.encode(message.getBytes());

			pw.println("message " + new String(encodedMessage)); // message부분은 base64로 encoding해야함
			pw.flush();
		}
	}
}
