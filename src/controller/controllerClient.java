package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.client;
import view.clientView;

public class controllerClient implements ActionListener{
private clientView clientView;
private client client;

public controllerClient(clientView clientView) {
	this.clientView = clientView;
	this.client = new client(clientView);
}

@Override
public void actionPerformed(ActionEvent e) {
	String cm = e.getActionCommand();
	
	if(cm.equals("START")) {
		try {
			
			client.go();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}else if(cm.equals("SEND")) {
		client.goi();
	}
	
}


}
