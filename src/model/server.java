package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import database.messageDao;
import view.serverView;

public class server {
	private serverView serverView;
	private ServerSocket serverSocket;
	private ArrayList<clientHandler> clients;
	private DefaultListModel<String> model;
	private volatile boolean isRunning;

	public server(serverView serverView) {
		this.model = new DefaultListModel<>();
		this.serverView = serverView;
		this.clients = new ArrayList<>();
	}

	public void go() {
		new Thread(() -> {
			try {
				SwingUtilities.invokeLater(() -> {
					model.addElement("Server starting.......");
					serverView.jlHienThiTinNhan.setModel(model);
				});
				serverSocket = new ServerSocket(Integer.parseInt(serverView.jTextField_nhapPort.getText()));
				SwingUtilities.invokeLater(() -> {
					model.addElement("Server started");
					serverView.jlHienThiTinNhan.setModel(model);
				});
				isRunning = true;
				while (isRunning) {
					Socket socket = serverSocket.accept();
					clientHandler clientHandler = new clientHandler(socket);
					clients.add(clientHandler);
					SwingUtilities.invokeLater(() -> {
						model.addElement("Client connected: " + socket.getInetAddress());
						serverView.jlHienThiTinNhan.setModel(model);
					});
					new Thread(clientHandler).start();
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stopServer();
			}
		}).start();
	}

	private void stopServer() {
		try {
			isRunning = false;
			if (serverSocket != null && !serverSocket.isClosed()) {
				serverSocket.close();
			}
			SwingUtilities.invokeLater(() -> {
				model.addElement("Server stopped");
				serverView.jlHienThiTinNhan.setModel(model);
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private class clientHandler implements Runnable {
		private Socket socket;
		private DataInputStream input;
		private DataOutputStream output;
		private messageDao messageDao;
		private String username;

		public clientHandler(Socket socket) {
			this.socket = socket;
			try {
				this.input = new DataInputStream(socket.getInputStream());
				this.output = new DataOutputStream(socket.getOutputStream());
				this.messageDao = new messageDao();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				// Nhận tên người dùng từ client
				this.username = input.readUTF();

				List<String> messages = messageDao.getAllMessage();
				for (String message : messages) {
					output.writeUTF(message);
				}
				output.flush();

				while (true) {
					String message = input.readUTF();
					String msg = username + " : " + message;
					boardcastMessage(msg, this);
					messageDao.saveMessage(username, message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		private void sendMessage(String message) {
			try {
				output.writeUTF(message);
				output.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void boardcastMessage(String message, clientHandler sender) {
			for (clientHandler client : clients) {
				if (client != sender) {
					client.sendMessage(message);
				}
			}
		}
	}
}
