package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Action;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblLogIn;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblUsername.setBounds(55, 131, 211, 68);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPassword.setBounds(55, 227, 211, 68);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField.setBounds(298, 131, 388, 68);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblLogIn = new JLabel("Log In");
		lblLogIn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblLogIn.setBounds(329, 29, 130, 68);
		contentPane.add(lblLogIn);
		
		JButton btnLogIn = new JButton("Log In");
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField.getText();
				if(username==null) {
					username="";
				}
				String password=lblPassword.getText();
				if(password==null) {
					password="";
				}
				if(Action.Login(username, password)) {
					ViewMain v=new ViewMain();
					Thread t=new Thread(v);
					setVisible(false);
					t.start();
					v.setVisible(true);
				}
			}
		});
		btnLogIn.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnLogIn.setBounds(299, 313, 180, 56);
		contentPane.add(btnLogIn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 227, 388, 68);
		contentPane.add(passwordField);
		setLocationRelativeTo(null);
	}
}
