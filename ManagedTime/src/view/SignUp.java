package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import control.Action;
import javax.swing.JPasswordField;

public class SignUp extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JPanel contentPane;
	private JTextField textField_2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 781,430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSignUp = new JLabel("Sign Up");
		lblSignUp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSignUp.setBounds(299, 33, 148, 57);
		contentPane.add(lblSignUp);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblUsername.setBounds(85, 129, 184, 57);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblPassword.setBounds(85, 217, 184, 57);
		contentPane.add(lblPassword);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textField_2.setBounds(312, 129, 385, 57);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String username=textField_2.getText();
				if(username==null) {
					username="";
				}
				if(!username.equals("")) {
					String password=lblPassword.getText();
					if(password==null) {
						password="";
					}
					Action.SignUp(username, password);
					ViewMain v=new ViewMain();
					Thread t=new Thread(v);
					setVisible(false);
					t.start();
					v.setVisible(true);			
				}else {
					JOptionPane.showConfirmDialog(null, "không được để trống tên tài khoản");
				}
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSignUp.setBounds(309, 311, 176, 57);
		contentPane.add(btnSignUp);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(312, 217, 385, 57);
		contentPane.add(passwordField);
		
		
		setLocationRelativeTo(null);
	}

}
