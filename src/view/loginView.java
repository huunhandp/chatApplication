//package view;
//
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//import controller.controllerLogin;
//
//import javax.swing.JLabel;
//import java.awt.Font;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.Color;
//
//public class loginView extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel contentPane;
//	public JTextField jTextField_tenDangNhap;
//	private JButton jButtonDangNhap;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					loginView frame = new loginView();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public loginView() {
//		
//		controllerLogin controllerLogin = new controllerLogin(this); 
//		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 567, 407);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//
//		setContentPane(contentPane);
//		contentPane.setLayout(null);
//		
//		JLabel jLabelTenDangNhap = new JLabel("Tên đăng nhập");
//		jLabelTenDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		jLabelTenDangNhap.setBounds(10, 33, 115, 18);
//		contentPane.add(jLabelTenDangNhap);
//		
//		jTextField_tenDangNhap = new JTextField();
//		jTextField_tenDangNhap.setFont(new Font("Times New Roman", Font.ITALIC, 15));
//		jTextField_tenDangNhap.setBounds(149, 27, 243, 31);
//		contentPane.add(jTextField_tenDangNhap);
//		jTextField_tenDangNhap.setColumns(10);
//		
//		jButtonDangNhap = new JButton("Đăng nhập");
//		jButtonDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 15));
//		jButtonDangNhap.setForeground(new Color(0, 0, 0));
//		jButtonDangNhap.setBounds(193, 107, 115, 38);
//		contentPane.add(jButtonDangNhap);
//		jButtonDangNhap.addActionListener(controllerLogin);
//	}
//
//	public String getUsername() {
//		return jTextField_tenDangNhap.getText();
//	}
//}
