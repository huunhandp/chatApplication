package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.DefaultListModel;

import model.server;
import view.serverView;

public class controllerServer implements ActionListener{
private serverView serverView;
private server server;

public controllerServer(serverView serverView) {
	this.serverView = serverView;
	this.server = new server(serverView);
}


@Override
public void actionPerformed(ActionEvent e) {
	String cm = e.getActionCommand();
	
	if(cm.equals("START")) {
		try {
			server.go();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	
}



}
