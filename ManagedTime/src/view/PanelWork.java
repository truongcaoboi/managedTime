package view;

import javax.swing.JPanel;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import control.Action;
import control.Display;
import control.ParseData;
import model.Work;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class PanelWork extends JPanel {
	private JTextField txtTittle;
	private JTextField txtName;
	private JTable table;
	private JTextField txtLev;
	private JTextField txtSeq;
	private JTextField txtSta;

	/**
	 * Create the panel.
	 */
	public PanelWork() {
		setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblTiu = new JLabel("Ti\u00EAu \u0111\u1EC1");
		lblTiu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblTiu.setBounds(25, 28, 90, 35);
		add(lblTiu);
		
		JLabel lblNiDung = new JLabel("N\u1ED9i dung");
		lblNiDung.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNiDung.setBounds(25, 86, 105, 35);
		add(lblNiDung);
		
		JLabel lblMT = new JLabel("Tr\u1EA1ng th\u00E1i");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMT.setBounds(25, 151, 118, 35);
		add(lblMT);
		
		JLabel lblHn = new JLabel("H\u1EA1n");
		lblHn.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblHn.setBounds(538, 28, 59, 35);
		add(lblHn);
		
		JLabel lblMc = new JLabel("M\u1EE9c \u0111\u1ED9");
		lblMc.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMc.setBounds(538, 86, 90, 35);
		add(lblMc);
		
		JLabel lblLpLi = new JLabel("L\u1EB7p l\u1EA1i");
		lblLpLi.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblLpLi.setBounds(538, 151, 90, 35);
		add(lblLpLi);
		
		txtTittle = new JTextField();
		txtTittle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTittle.setBounds(167, 28, 314, 35);
		add(txtTittle);
		txtTittle.setColumns(10);
		
		txtName = new JTextField();
		txtName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBounds(167, 86, 314, 35);
		add(txtName);
		
		JDateChooser dateChoose = new JDateChooser();
		dateChoose.setBounds(674, 28, 313, 35);
		add(dateChoose);
		
		JComboBox cbImp = new JComboBox();
		cbImp.setModel(new DefaultComboBoxModel(new String[] {"R\u1EA5t quan tr\u1ECDng", "Quan tr\u1ECDng", "B\u00ECnh Th\u01B0\u1EDDng", "Kh\u00F4ng quan tr\u1ECDng"}));
		cbImp.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbImp.setBounds(850, 86, 169, 32);
		add(cbImp);
		
		JComboBox cbTrgThai = new JComboBox();
		cbTrgThai.setModel(new DefaultComboBoxModel(new String[] {"Ch\u01B0a l\u00E0m", "B\u0103t \u0111\u1EA7u l\u00E0m", "\u0110ang l\u00E0m", "T\u1EA1m d\u1EEBng", "\u0110\u00E3 h\u1EE7y", "Ho\u00E0n th\u00E0nh"}));
		cbTrgThai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbTrgThai.setBounds(337, 153, 144, 32);
		add(cbTrgThai);
		
		JComboBox cbSeq = new JComboBox();
		cbSeq.setModel(new DefaultComboBoxModel(new String[] {"Th\u01B0\u1EDDng xuy\u00EAn", "Th\u1EC9nh tho\u1EA3ng", "Hi\u1EBFm khi"}));
		cbSeq.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbSeq.setBounds(850, 151, 169, 32);
		add(cbSeq);
		
		JLabel lblMT_1 = new JLabel("M\u00F4 t\u1EA3");
		lblMT_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblMT_1.setBounds(25, 227, 90, 35);
		add(lblMT_1);
		
		JTextArea txtDes = new JTextArea();
		txtDes.setColumns(30);
		txtDes.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txtDes.setRows(3);
		txtDes.setBounds(25, 273, 426, 110);
		add(txtDes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 394, 1027, 287);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x=table.getSelectedRow();
				if(x!=-1) {
					String id=table.getValueAt(x, 0).toString();
					String sql="select * from CongViec where id=\'"+id+"\'";
					Work k=Display.getWorkItem(sql);
					txtTittle.setText(k.getTitle());
					txtName.setText(k.getName());
					dateChoose.setDate(ParseData.parseDate(k.getDate_end()));
					txtDes.setText(k.getDescription());
					txtSta.setText(ParseData.parseToStatus(k.getStatus()));
					txtSeq.setText(ParseData.parseToSequence(k.getSequence()));
					txtLev.setText(ParseData.parseToLevel(k.getLevel()));
					new ParseData();
					dateChoose.setDate(ParseData.parseDate(k.getDate_end()));
				}
			}
		});
		table.setModel(Display.getTableWork());
		Action.setColor(table);
		table.setRowHeight(30);
		scrollPane.setViewportView(table);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tittle=txtTittle.getText();
				if(tittle==null||tittle.equals("")) {
					JOptionPane.showConfirmDialog(null, "Tiêu đề không được trống");
					return;
				}
				String content=txtName.getText();
				if(content.equals("")||content==null) {
					JOptionPane.showConfirmDialog(null, "Nội dung không được trống");
					return;
				}
				String des=txtDes.getText();
				int seq=cbSeq.getSelectedIndex();
				if(seq==-1) {
					seq=ParseData.parseSequence(txtSeq.getText());
				}
				int lev=cbImp.getSelectedIndex();
				if(lev==-1) {
					lev=ParseData.parseLevel(txtLev.getText());
				}
				int sta=cbTrgThai.getSelectedIndex();
				if(sta==-1) {
					sta=ParseData.parseStatus(txtSta.getText());
				}
				String date=new ParseData().parseDateToString(dateChoose.getDate());
				String id=Action.createId("CongViec");
				String sql="insert into CongViec(id,content,title,description,date_start,date_end,level,sequence,status) values("
						+ "\'"+id+"\',\'"+content+"\',\'"+tittle+"\',\'"+des+"\',\'2017/1/1\',str_to_date(\'"+date+"\',\'%d/%m/%Y\'),"
								+ lev+","+seq+","+sta+")";
				Display.execute(sql);
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				String row[]= {id,tittle,content,ParseData.parseToStatus(sta),ParseData.parseToLevel(lev)};
				model.addRow(row);
				Action.setColor(table);
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(487, 348, 89, 35);
		add(btnAdd);
		
		JButton btnDel = new JButton("Del");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=table.getSelectedRow();
				if(x!=-1) {
					String id=table.getValueAt(x, 0).toString();
					String sql="delete from CongViec where id=\'"+id+"\'";
					Display.execute(sql);
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.removeRow(x);
				}else {
					JOptionPane.showConfirmDialog(null, "Bạn phải chọn một công việc để sửa");
					return;
				}
			}
		});
		btnDel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDel.setBounds(587, 348, 89, 35);
		add(btnDel);
		
		JButton btnSet = new JButton("Set");
		btnSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x=table.getSelectedRow();
				if(x!=-1) {
					String id=table.getValueAt(x, 0).toString();
					String tittle=txtTittle.getText();
					if(tittle==null||tittle.equals("")) {
						JOptionPane.showConfirmDialog(null, "Tiêu đề không được trống");
						return;
					}
					String content=txtName.getText();
					if(content.equals("")||content==null) {
						JOptionPane.showConfirmDialog(null, "Nội dung không được trống");
						return;
					}
					String des=txtDes.getText();
					int seq=cbSeq.getSelectedIndex();
					if(seq==-1) {
						seq=ParseData.parseSequence(txtSeq.getText());
					}
					int lev=cbImp.getSelectedIndex();
					if(lev==-1) {
						lev=ParseData.parseLevel(txtLev.getText());
					}
					int sta=cbTrgThai.getSelectedIndex();
					if(sta==-1) {
						sta=ParseData.parseStatus(txtSta.getText());
					}
					String date=new ParseData().parseDateToString(dateChoose.getDate());
					String sql="update CongViec set title=\'"+tittle+"\',content=\'"+content+"\',description=\'"+des+"\',sequence="+seq+",level="+lev+",status="+sta+""
							+ ",date_end=str_to_date(\'"+date+"\',\'%d/%m/%Y\') where id=\'"+id+"\'";
					// System.out.println(sql);
					Display.execute(sql);
					table.setValueAt(tittle, x, 1);
					table.setValueAt(content, x, 2);
					table.setValueAt(ParseData.parseToStatus(sta), x, 3);
					table.setValueAt(ParseData.parseToLevel(lev), x, 4);
					Action.setColor(table);
				}else {
					JOptionPane.showConfirmDialog(null, "Bạn phải chọn một công việc để sửa");
				}
			}
		});
		btnSet.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSet.setBounds(686, 348, 89, 35);
		add(btnSet);
		
		txtLev = new JTextField();
		txtLev.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtLev.setColumns(10);
		txtLev.setBounds(674, 87, 158, 35);
		add(txtLev);
		
		txtSeq = new JTextField();
		txtSeq.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSeq.setColumns(10);
		txtSeq.setBounds(674, 151, 158, 35);
		add(txtSeq);
		
		txtSta = new JTextField();
		txtSta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtSta.setColumns(10);
		txtSta.setBounds(167, 151, 158, 35);
		add(txtSta);
		
		JButton btnLc = new JButton("Lọc");
				btnLc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLc.setBounds(786, 348, 89, 35);
		add(btnLc);
		
		JComboBox cbLoc = new JComboBox();
		cbLoc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cbLoc.setModel(new DefaultComboBoxModel(new String[] {"Ngày", "Tuần", "Tháng"}));
		cbLoc.setBounds(885, 348, 134, 35);
		add(cbLoc);
		
		btnLc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int x=cbLoc.getSelectedIndex();
				String date=new ParseData().parseDateToString(new Date());
				String sql="select * from CongViec where status=0 or status=1" + 
						 " or status=2 or status=3";
				if(x==0) {
					sql="select * from CongViec where date_end=str_to_date(\'"+date+"\',\'%d/%m/%Y\')";			
				}
				if(x==1) {
					sql="select * from CongViec where week(date_end)=week(str_to_date(\'"+date+"\',\'%d/%m/%Y\'))";
				}
				if(x==2) {
					sql="select * from CongViec where month(date_end)=month(str_to_date(\'"+date+"\',\'%d/%m/%Y\')) and year(date_end)=year(str_to_date(\'"+date+"\',\'%d/%m/%Y\'))";
				}
				//System.out.println(sql);
				table.setModel(Display.getTableWork(sql));
			}
		});


	}
}
