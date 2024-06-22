package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.controllerServer;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

public class serverView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField jTextField_nhapPort;
	public JList jlHienThiTinNhan;
	public JTextArea jTextArea_nhapTinNhan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					serverView frame = new serverView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public serverView() {
		controllerServer controllerServer = new controller.controllerServer(this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 606, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PORT NO.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(15, 10, 81, 28);
		contentPane.add(lblNewLabel);
		
		jTextField_nhapPort = new JTextField();
		jTextField_nhapPort.setText("1000");
		jTextField_nhapPort.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jTextField_nhapPort.setBounds(106, 9, 369, 30);
		contentPane.add(jTextField_nhapPort);
		jTextField_nhapPort.setColumns(10);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStart.setBounds(487, 10, 105, 28);
		contentPane.add(btnStart);
		btnStart.addActionListener(controllerServer);
		
		jlHienThiTinNhan = new JList();
		jlHienThiTinNhan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jlHienThiTinNhan.setBounds(35, 69, 530, 254);
		contentPane.add(jlHienThiTinNhan);
		
//		JScrollPane jScrollPane = new JScrollPane(jlHienThiTinNhan);
//		jScrollPane.setBounds(25, 78, 530, 254);
//		contentPane.add(jScrollPane);
		
		
		
		jTextArea_nhapTinNhan = new JTextArea();
		jTextArea_nhapTinNhan.setBounds(35, 333, 453, 59);
		contentPane.add(jTextArea_nhapTinNhan);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSend.setBounds(498, 333, 94, 59);
		contentPane.add(btnSend);
		btnSend.addActionListener(controllerServer);
		
		
		JLabel jLabelServer = new JLabel("SERVER");
		jLabelServer.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabelServer.setBounds(15, 44, 81, 28);
		contentPane.add(jLabelServer);
	}
//public void updateMessageList(List<String> messages) {
//	DefaultListModel<String> model = new DefaultListModel<String>();
//	for (String msg : messages) {
//		model.addElement(msg);
//	}
//	jlHienThiTinNhan.setModel(model);
//}
}
