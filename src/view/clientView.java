package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controller.controllerClient;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextArea;

public class clientView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField;
	public JList jlHienThiTinNhan;
	public JTextArea jTextArea_nhapTinNhan;
	public JTextField jTextFieldTen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientView frame = new clientView();
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
	public clientView() {
		
		controllerClient controllerClient = new controllerClient(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 622, 448);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PORT NO.");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 10, 81, 28);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setText("1000");
		textField.setFont(new Font("Times New Roman", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(113, 8, 50, 30);
		contentPane.add(textField);
		
		JButton btnStart = new JButton("START");
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStart.setBounds(492, 10, 105, 28);
		contentPane.add(btnStart);
		btnStart.addActionListener(controllerClient);
		
		
		
		jlHienThiTinNhan = new JList();
		jlHienThiTinNhan.setFont(new Font("Times New Roman", Font.BOLD, 12));
		jlHienThiTinNhan.setBounds(25, 78, 530, 254);
//		contentPane.add(jlHienThiTinNhan);
		
		JScrollPane jScrollPane = new JScrollPane(jlHienThiTinNhan);
		jScrollPane.setBounds(25, 78, 530, 254);
		contentPane.add(jScrollPane);
		
		
		
		JLabel jLabelClient = new JLabel("Client");
		jLabelClient.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabelClient.setBounds(10, 48, 81, 28);
		contentPane.add(jLabelClient);
		
		jTextArea_nhapTinNhan = new JTextArea();
		jTextArea_nhapTinNhan.setBounds(25, 342, 453, 59);
		contentPane.add(jTextArea_nhapTinNhan);
		
		JButton btnSend = new JButton("SEND");
		btnSend.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSend.setBounds(492, 342, 94, 59);
		contentPane.add(btnSend);
		
		JLabel jLabelTen = new JLabel("Tên");
		jLabelTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jLabelTen.setBounds(196, 10, 105, 28);
		contentPane.add(jLabelTen);
		
		jTextFieldTen = new JTextField();
		jTextFieldTen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		jTextFieldTen.setColumns(10);
		jTextFieldTen.setBounds(251, 10, 231, 30);
		contentPane.add(jTextFieldTen);
		btnSend.addActionListener(controllerClient);
	}
	public String getUsername() {
		return jTextFieldTen.getText();
	}
}
