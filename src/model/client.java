package model;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import view.clientView;

public class client implements Runnable {
    private clientView clientView;
    private Socket socket;
    private DataOutputStream output;
    private DataInputStream input;
    private DefaultListModel<String> model;

    public client(clientView clientView) {
        model = new DefaultListModel<>();
        this.clientView = clientView;
    }

    public void go() {
        try {
            model.addElement("Client connecting.......");
            clientView.jlHienThiTinNhan.setModel(model);
            socket = new Socket("localhost", Integer.parseInt(clientView.textField.getText()));
            model.addElement("Client is connected");
            clientView.jlHienThiTinNhan.setModel(model);
            output = new DataOutputStream(socket.getOutputStream());
            input = new DataInputStream(socket.getInputStream());

            // Gửi tên người dùng đến server ngay khi kết nối
            String username = clientView.jTextFieldTen.getText();
            output.writeUTF(username);
            output.flush();

            // Nhận và hiển thị tin nhắn từ cơ sở dữ liệu
            List<String> messages = new ArrayList<>();
            while (input.available() > 0) {
                String msg = input.readUTF();
                messages.add(msg);
            }

            updateMessageList(messages);

            new Thread(client.this).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goi() {
        try {
        	String username = clientView.jTextFieldTen.getText();
            String message = clientView.jTextArea_nhapTinNhan.getText();
            String fomattedMessage = username+" : "+message;
            output.writeUTF(message);
            output.flush();
//            model.addElement(clientView.jTextFieldTen.getText() + ": " + message);
            model.addElement(fomattedMessage);
            clientView.jTextArea_nhapTinNhan.setText("");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                String message = input.readUTF();
                model.addElement(message);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateMessageList(List<String> messages) {
        for (String msg : messages) {
            model.addElement(msg);
        }
    }
}
