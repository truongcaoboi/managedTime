package view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.util.*;
import java.util.Date;
import java.sql.*;
import model.*;
import control.*;

public class PanelImportWork extends JPanel {
	private JTextField vc1;
	private JTextField vc2;
	private JTextField vc3;
	private JTextField vc4;
	private JTextField vc5;
	private JTextField note;

	/**
	 * Create the panel.
	 */
	public PanelImportWork() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 323, 185);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblGhiChusHm = new JLabel("Ghi ch\u00FA h\u00F4m nay");
		lblGhiChusHm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGhiChusHm.setBounds(86, 11, 159, 30);
		panel.add(lblGhiChusHm);
		
		JTextArea txtNote = new JTextArea();
		txtNote.setEditable(false);
		txtNote.setColumns(30);
		txtNote.setRows(10);
		txtNote.setFont(new Font("Monospaced", Font.PLAIN, 16));
		txtNote.setBounds(10, 43, 303, 131);
		panel.add(txtNote);
		
		JPanel pn = new JPanel();
		pn.setBounds(10, 207, 323, 491);
		add(pn);
		pn.setLayout(null);
		
		JLabel lblVicQuanTrng = new JLabel("Vi\u1EC7c quan tr\u1ECDng");
		lblVicQuanTrng.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblVicQuanTrng.setBounds(87, 11, 149, 30);
		pn.add(lblVicQuanTrng);
		
		vc1 = new JTextField();
		vc1.setEditable(false);
		vc1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vc1.setBounds(10, 52, 303, 43);
		vc1.setColumns(10);
		
		vc2 = new JTextField();
		vc2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vc2.setEditable(false);
		vc2.setColumns(10);
		vc2.setBounds(10, 122, 303, 43);
		
		vc3 = new JTextField();
		vc3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vc3.setEditable(false);
		vc3.setColumns(10);
		vc3.setBounds(10, 191, 303, 43);
		
		vc4 = new JTextField();
		vc4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vc4.setEditable(false);
		vc4.setColumns(10);
		vc4.setBounds(10, 263, 303, 43);
		
		vc5 = new JTextField();
		vc5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		vc5.setEditable(false);
		vc5.setColumns(10);
		vc5.setBounds(10, 337, 303, 43);
		
		Vector<JTextField> listCV=new Vector<JTextField>();
		listCV.add(vc1);
		listCV.add(vc2);
		listCV.add(vc3);
		listCV.add(vc4);
		listCV.add(vc5);
		
		note = new JTextField();
		note.setFont(new Font("Tahoma", Font.PLAIN, 16));
		note.setEditable(false);
		note.setColumns(10);
		note.setBounds(10, 405, 303, 43);
		String date=new ParseData().parseDateToString(new Date());
		String sql="select * from CongViec where date_end>=str_to_date(\'"+date+"\',\'%d/%m/%Y\') and (status=0 or status=1 or status=2)";
		Vector<Work> listWork=Display.getWork(sql);
		if(listWork.size()>5) {
			note.setText("Vẫn Còn");
			pn.add(note);
		}else {
			note.setText("");
			for(int i=0;i<listWork.size();i++) {
				JTextField txt=(JTextField)listCV.get(i);
				Work w=(Work)listWork.get(i);
				txt.setText(w.getName());
				pn.add(txt);
			}
		}
		sql="select * from GhiChu where date_exe=str_to_date(\'"+date+"\',\'%d/%m/%Y\')";
		//System.out.println(sql);
		Note n=Display.getNoteItem(sql);
		txtNote.setText(n.getContent());
	}
}
