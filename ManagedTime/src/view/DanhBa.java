package view;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import control.*;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
public class DanhBa extends JPanel {
	private JTextField txtName;
	private JTextField txtnick;
	private JTextField txtjob;
	private JTextField txtcom;
	private JTextField txtadd;
	private JTextField txtphone;
	private JTextField txtemail;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public DanhBa(JPanel parent) {
		setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 1054, 315);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblname = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblname.setBounds(10, 11, 93, 35);
		panel.add(lblname);
		
		JLabel lblNickName = new JLabel("Nick Name");
		lblNickName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNickName.setBounds(10, 72, 103, 35);
		panel.add(lblNickName);
		
		JLabel lblNghNghip = new JLabel("Ngh\u1EC1 nghi\u1EC7p");
		lblNghNghip.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNghNghip.setBounds(10, 134, 120, 35);
		panel.add(lblNghNghip);
		
		JLabel lblCQuan = new JLabel("C\u01A1 quan");
		lblCQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCQuan.setBounds(10, 195, 93, 35);
		panel.add(lblCQuan);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgySinh.setBounds(530, 11, 93, 35);
		panel.add(lblNgySinh);
		
		JLabel lblGiiTnh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiiTnh.setBounds(530, 72, 93, 35);
		panel.add(lblGiiTnh);
		
		JLabel lblinThoi = new JLabel("\u0110i\u1EC7n tho\u1EA1i");
		lblinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblinThoi.setBounds(530, 134, 93, 35);
		panel.add(lblinThoi);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(530, 195, 93, 35);
		panel.add(lblEmail);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setBounds(151, 11, 294, 35);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtnick = new JTextField();
		txtnick.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtnick.setColumns(10);
		txtnick.setBounds(151, 72, 294, 35);
		panel.add(txtnick);
		
		txtjob = new JTextField();
		txtjob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtjob.setColumns(10);
		txtjob.setBounds(151, 134, 294, 35);
		panel.add(txtjob);
		
		txtcom = new JTextField();
		txtcom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtcom.setColumns(10);
		txtcom.setBounds(151, 195, 294, 35);
		panel.add(txtcom);
		
		txtadd = new JTextField();
		txtadd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtadd.setColumns(10);
		txtadd.setBounds(671, 72, 294, 35);
		panel.add(txtadd);
		
		txtphone = new JTextField();
		txtphone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtphone.setColumns(10);
		txtphone.setBounds(671, 134, 294, 35);
		panel.add(txtphone);
		
		txtemail = new JTextField();
		txtemail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtemail.setColumns(10);
		txtemail.setBounds(671, 195, 294, 35);
		panel.add(txtemail);
		
		JDateChooser datebirth = new JDateChooser();
		datebirth.setBounds(671, 11, 294, 35);
		panel.add(datebirth);
		
		JButton btnThm = new JButton("Th\u00EAm");
		
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnThm.setBounds(530, 252, 141, 52);
		panel.add(btnThm);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 30));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bạn bè", "Gia đình", "Cơ quan", "Khách hàng", "Không", "Tất cả"}));
		comboBox.setBounds(272, 337, 177, 46);
		add(comboBox);
		
		JButton btnChiTit = new JButton("Chi ti\u1EBFt");
		btnChiTit.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnChiTit.setBounds(687, 337, 150, 46);
		add(btnChiTit);
		
		JLabel lblBLc = new JLabel("B\u1ED9 l\u1ECDc");
		lblBLc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblBLc.setBounds(164, 337, 98, 46);
		add(lblBLc);
		
		JButton btnLc = new JButton("L\u1ECDc");
		btnLc.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnLc.setBounds(493, 337, 150, 46);
		add(btnLc);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 418, 1027, 280);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(Display.getTableHumans(-1));
		table.setBounds(224, 489, 1, 1);
		table.getColumnModel().getColumn(0).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(300);
		table.getColumnModel().getColumn(3).setPreferredWidth(300);
		table.setRowHeight(25);
		table.setFont(new Font("Tahoma", Font.PLAIN, 20));

		scrollPane.setViewportView(table);;
		btnChiTit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()!=-1) {;
					String user=table.getValueAt(table.getSelectedRow(), 0).toString();
					parent.removeAll();
					PanelTTCN p=new PanelTTCN(user);
					p.setBounds(0, 0, 1074, 709);
					parent.add(p);
					parent.revalidate();
					parent.repaint();
				}else {
					JOptionPane.showConfirmDialog(null, "Bạn phải chọn một người trong danh sách trước","Note",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

		btnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gr=comboBox.getSelectedIndex();
				table.setModel(Display.getTableHumans(gr));
			}
		});
		
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=txtName.getText();
				String nick=txtnick.getText();
				String job=txtjob.getText();
				String com=txtcom.getText();
				String date=new ParseData().parseDateToString(datebirth.getDate());
				String add=txtadd.getText();
				String email= txtemail.getText();
				String phone=txtphone.getText();
				if(name==null||name.equals("")) {
					System.out.println("vl");
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				if(nick==null||nick.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(job==null||job.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(com==null||com.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(date==null||date.equals("")||date.equals("loi")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(add==null||add.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(email==null||email.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}

				if(phone==null||phone.equals("")) {
					JOptionPane.showConfirmDialog(null, "Bạn phải nhập đầy đủ thôngtin","Note",JOptionPane.INFORMATION_MESSAGE);
					return;
				}
				String id=Action.createId("Humans");
				Action.addHumans(id,name, nick, job, com, date, add, email, phone);
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String row[]= {id,nick,email,phone};
				model.addRow(row);
			}
		});
	}
}
