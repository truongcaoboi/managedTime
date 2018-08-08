package view;

import javax.swing.JPanel;
import model.*;
import control.Action;
import control.Display;
import control.ParseData;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.util.Date;
import java.beans.PropertyChangeEvent;
import com.toedter.calendar.JDateChooser;

public class PrivateInfo extends JPanel {
	private JTextField txtId;
	private JTextField txtName;
	private JTextField txtNick;
	private JTextField txtAdd;
	private JTextField txtJob;
	private JTextField txtGen;
	private JTextField txtGrp;
	private JTextField txtCom;

	/**
	 * Create the panel.
	 */
	public PrivateInfo(String id) {
		String sql="select * from Humans where id=\'"+id+"\'";
		Humans h=Display.getHumans(sql);

		setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblId.setBounds(10, 26, 58, 43);
		add(lblId);
		
		JLabel lblHVTn = new JLabel("H\u1ECD v\u00E0 t\u00EAn");
		lblHVTn.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblHVTn.setBounds(10, 80, 121, 43);
		add(lblHVTn);
		
		JLabel lblNickName = new JLabel("Nick Name");
		lblNickName.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNickName.setBounds(10, 148, 134, 43);
		add(lblNickName);
		
		JLabel lblaCh = new JLabel("\u0110\u1ECBa ch\u1EC9");
		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblaCh.setBounds(10, 209, 134, 43);
		add(lblaCh);
		
		JLabel lblGiiTnh = new JLabel("Gi\u1EDBi t\u00EDnh");
		lblGiiTnh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblGiiTnh.setBounds(543, 26, 134, 43);
		add(lblGiiTnh);
		
		JLabel lblNhm = new JLabel("Nh\u00F3m");
		lblNhm.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNhm.setBounds(543, 80, 134, 43);
		add(lblNhm);
		
		JLabel lblNgySinh = new JLabel("Ng\u00E0y sinh");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNgySinh.setBounds(543, 148, 134, 43);
		add(lblNgySinh);
		
		JLabel lblCQuan = new JLabel("C\u01A1 quan");
		lblCQuan.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCQuan.setBounds(543, 209, 134, 43);
		add(lblCQuan);
		
		JButton btnup = new JButton("S\u1EEDa \u0111\u1ED5i");
		
		btnup.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnup.setBounds(704, 263, 202, 57);
		add(btnup);
		
		JLabel lblNghNghip = new JLabel("Ngh\u1EC1 nghi\u1EC7p");
		lblNghNghip.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNghNghip.setBounds(10, 277, 134, 43);
		add(lblNghNghip);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtId.setBounds(171, 31, 313, 37);
		add(txtId);
		txtId.setColumns(10);
		txtId.setText(h.getId());
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(171, 86, 313, 37);
		add(txtName);
		txtName.setText(h.getFullName());
		
		txtNick = new JTextField();
		txtNick.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtNick.setColumns(10);
		txtNick.setBounds(171, 148, 313, 37);
		add(txtNick);
		txtNick.setText(h.getNickname());
		
		txtAdd = new JTextField();
		txtAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtAdd.setColumns(10);
		txtAdd.setBounds(171, 209, 313, 37);
		add(txtAdd);
		txtAdd.setText(h.getAddress());
		
		txtJob = new JTextField();
		txtJob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtJob.setColumns(10);
		txtJob.setBounds(171, 277, 313, 37);
		add(txtJob);
		txtJob.setText(h.getJob());
		
		txtGen = new JTextField();
		txtGen.setEditable(false);
		txtGen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGen.setColumns(10);
		txtGen.setBounds(687, 26, 152, 37);
		add(txtGen);
		txtGen.setText(h.getGender());
		
		txtGrp = new JTextField();
		txtGrp.setEditable(false);
		txtGrp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtGrp.setColumns(10);
		txtGrp.setBounds(687, 86, 152, 37);
		add(txtGrp);
		txtGrp.setText(ParseData.parseToGroup(h.getGroup()));
		
		txtCom = new JTextField();
		txtCom.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtCom.setColumns(10);
		txtCom.setBounds(687, 215, 313, 37);
		add(txtCom);
		txtCom.setText(h.getCompany());
		
		JComboBox boxGen = new JComboBox();
		boxGen.setModel(new DefaultComboBoxModel(new String[] {"Nam", "N\u1EEF", "Kh\u00F4ng"}));
		boxGen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boxGen.setBounds(849, 26, 151, 37);
		add(boxGen);
		
		JComboBox boxGrp = new JComboBox();
		boxGrp.setModel(new DefaultComboBoxModel(new String[] {"B\u1EA1n b\u00E8", "Gia \u0111\u00ECnh", "C\u01A1 quan", "Kh\u00E1ch h\u00E0ng", "Kh\u00F4ng"}));
		boxGrp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		boxGrp.setBounds(849, 88, 151, 35);
		add(boxGrp);
		
		JDateChooser dateBirth = new JDateChooser();
		dateBirth.setBounds(687, 154, 313, 37);
		add(dateBirth);
		dateBirth.setDate(ParseData.parseDate(h.getBirth()));
		btnup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=txtName.getText();
				String add=txtAdd.getText();
				String nick=txtNick.getText();
				String job=txtJob.getText();
				int gen=boxGen.getSelectedIndex();
				String g="";
				if(gen==0) {
					g="Nam";
				}else {
					if(gen==1) {
						g="Nữ";
					}else {
						if(gen==2) {
							g="Không";
						}else {
							g=txtGen.getText();
						}
					}
				}
				int gr=ParseData.parseToGRP(txtGrp.getText());
				if(boxGrp.getSelectedIndex()!=-1) {
					gr=boxGrp.getSelectedIndex();
				}
				String birth=new ParseData().parseDateToString(dateBirth.getDate());
				System.out.println(birth);
				String com=txtCom.getText();
				Action.updateHumans(id, name, add, nick, job, birth, g, gr, com);
				txtGen.setText(g);
				txtGrp.setText(ParseData.parseToGroup(gr));
			}
		});
	}
}
