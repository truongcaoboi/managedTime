package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import control.Action;
import control.Display;
import model.User;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.Color;

public class PanelTTCN extends JPanel {
	private JTable tableEmail;
	private JTable tablePhone;
	private String name;
	private JTextField typeEmail;
	private JTextField email;
	private JTextField typePhone;
	private JTextField Phone;
	/**
	 * Create the panel.
	 */
	public PanelTTCN(String id) {
		setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		name=id;
		setLayout(null);
		
		JScrollPane scrollPaneEmail = new JScrollPane();
		scrollPaneEmail.setBounds(35, 535, 497, 136);
		add(scrollPaneEmail);
		
		tableEmail = new JTable();
		tableEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x=tableEmail.getSelectedRow();
				if(x!=-1) {
					typeEmail.setText(tableEmail.getValueAt(x, 0).toString());
					email.setText(tableEmail.getValueAt(x, 1).toString());
				}else {
					typeEmail.setText("");
					email.setText("");
				}
			}
		});
		tableEmail.setModel(Display.getTableEmail(id));
		tableEmail.getColumnModel().getColumn(0).setPreferredWidth(100);
		tableEmail.getColumnModel().getColumn(1).setPreferredWidth(200);
		tableEmail.setRowHeight(25);
		tableEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPaneEmail.setViewportView(tableEmail);
		
		JScrollPane scrollPanePhone = new JScrollPane();
		scrollPanePhone.setBounds(542, 535, 497, 136);
		add(scrollPanePhone);
		
		tablePhone = new JTable();
		tablePhone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int x=tablePhone.getSelectedRow();
				if(x!=-1) {
					typePhone.setText(tablePhone.getValueAt(x, 0).toString());
					Phone.setText(tablePhone.getValueAt(x, 1).toString());
				}else {
					typePhone.setText("");
					Phone.setText("");
				}
			}
		});

		tablePhone.setModel(Display.getTablePhone(id));
		tablePhone.getColumnModel().getColumn(0).setPreferredWidth(150);
		tablePhone.getColumnModel().getColumn(1).setPreferredWidth(200);
		tablePhone.setRowHeight(25);
		tablePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPanePhone.setViewportView(tablePhone);
		
		JButton btnAddEmail = new JButton("ADD-E");
		btnAddEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=typeEmail.getText();
				if(type!=null && !type.equals("")) {
					String textemail=email.getText();
					if(textemail!=null && !textemail.equals("")){
						Action.addEmail((DefaultTableModel)tableEmail.getModel(), id, type, textemail);
					}
				}
			}
		});
		btnAddEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddEmail.setBounds(35, 374, 110, 36);
		add(btnAddEmail);
		
		JButton btnUpdateEmail = new JButton("UPDATE-E");
		btnUpdateEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=typeEmail.getText();
				String txtEmail=email.getText();
				if((type!=null && !type.equals(""))||(txtEmail!=null && !txtEmail.equals(""))) {
					Action.updateEmail(tableEmail, id, type, txtEmail);
				}
			}
		});
		btnUpdateEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdateEmail.setBounds(167, 374, 132, 36);
		add(btnUpdateEmail);
		
		JButton btnDeleteEmail = new JButton("DELETE-E");
		btnDeleteEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Action.deleteEmail(tableEmail, id);
			}
		});
		btnDeleteEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeleteEmail.setBounds(331, 374, 124, 36);
		add(btnDeleteEmail);
		
		JButton btnAddPhone = new JButton("ADD-P");
		btnAddPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=typePhone.getText();
				if(type!=null && !type.equals("")) {
					String textPhone=Phone.getText();
					if(textPhone!=null && !textPhone.equals("")){
						Action.addPhone((DefaultTableModel)tablePhone.getModel(), id, type, textPhone);
					}
				}
			}
		});
		btnAddPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAddPhone.setBounds(542, 374, 114, 36);
		add(btnAddPhone);
		
		JButton btnUpdatePhone = new JButton("UPDATE-P");
		btnUpdatePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type=typePhone.getText();
				String txtPhone=Phone.getText();
				if((type!=null && !type.equals(""))||(txtPhone!=null && !txtPhone.equals(""))) {
					Action.updatePhone(tablePhone, id, type, txtPhone);
				}
			}
		});
		btnUpdatePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnUpdatePhone.setBounds(677, 374, 138, 36);
		add(btnUpdatePhone);
		
		JButton btnDeletePhone = new JButton("DELETE-P");
		btnDeletePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Action.deletePhone(tablePhone, id);

			}
		});
		btnDeletePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDeletePhone.setBounds(836, 374, 132, 36);
		add(btnDeletePhone);
		
		JLabel lblLoaijEmail = new JLabel("Loại Email");
		lblLoaijEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoaijEmail.setBounds(35, 431, 110, 25);
		add(lblLoaijEmail);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(35, 481, 110, 25);
		add(lblEmail);
		
		typeEmail = new JTextField();
		typeEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typeEmail.setBounds(159, 421, 308, 36);
		add(typeEmail);
		typeEmail.setColumns(10);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 20));
		email.setColumns(10);
		email.setBounds(159, 470, 308, 36);
		add(email);
		
		JLabel lblLoiPhone = new JLabel("Loại Phone");
		lblLoiPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLoiPhone.setBounds(542, 426, 110, 34);
		add(lblLoiPhone);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(542, 472, 110, 34);
		add(lblPhone);
		
		typePhone = new JTextField();
		typePhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		typePhone.setColumns(10);
		typePhone.setBounds(677, 426, 308, 36);
		add(typePhone);
		
		Phone = new JTextField();
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Phone.setColumns(10);
		Phone.setBounds(677, 470, 308, 36);
		add(Phone);
		
		PrivateInfo panelPrivateInfo = new PrivateInfo(id);
		panelPrivateInfo.setBounds(10, 11, 1054, 331);
		add(panelPrivateInfo);
		
	}
}
