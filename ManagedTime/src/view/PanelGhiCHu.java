package view;

import javax.swing.JPanel;
import control.*;
import model.*;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class PanelGhiCHu extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelGhiCHu() {
		setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);
		
		JLabel lblNgy = new JLabel("Ng\u00E0y");
		lblNgy.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNgy.setBounds(26, 28, 101, 47);
		add(lblNgy);
		
		JLabel lblGiNhc = new JLabel("Gi\u1EDD nh\u1EAFc");
		lblGiNhc.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblGiNhc.setBounds(26, 104, 141, 47);
		add(lblGiNhc);
		
		JDateChooser dateChooser = new JDateChooser();
		
		dateChooser.setBounds(211, 28, 355, 47);
		add(dateChooser);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.PLAIN, 45));
		label.setBounds(314, 104, 30, 47);
		add(label);
		
		JSpinner min = new JSpinner();
		min.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		min.setFont(new Font("Tahoma", Font.PLAIN, 25));
		min.setBounds(334, 104, 82, 47);
		add(min);
		
		JTextArea txtContent = new JTextArea();
		txtContent.setColumns(50);
		txtContent.setRows(10);
		txtContent.setFont(new Font("Monospaced", Font.PLAIN, 25));
		txtContent.setBounds(26, 239, 825, 435);
		add(txtContent);
		
		JButton btnThm = new JButton("Th\u00EAm");
		
		btnThm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnThm.setBounds(883, 249, 163, 47);
		add(btnThm);
		
		JButton btnSa = new JButton("S\u1EEDa");
		
		btnSa.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnSa.setBounds(883, 335, 163, 47);
		add(btnSa);
		
		JLabel lblNiDungGhi = new JLabel("N\u1ED9i dung ghi ch\u00FA");
		lblNiDungGhi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNiDungGhi.setBounds(26, 181, 263, 47);
		add(lblNiDungGhi);
		
		JSpinner chooseHour = new JSpinner();
		chooseHour.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		chooseHour.setFont(new Font("Tahoma", Font.PLAIN, 25));
		chooseHour.setBounds(228, 104, 82, 47);
		add(chooseHour);
		
		btnThm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=new ParseData().parseDateToString(dateChooser.getDate());
				if(date=="1/1/2017") {
					JOptionPane.showConfirmDialog(null, "Hãy chọn ngày trước khi thêm");
					return;
				}
				String hour=chooseHour.getValue().toString();
				//String h=chooseHour.getValue().toString();
				//System.out.println(Integer.parseInt(h));
				String content=txtContent.getText();
				if(content.equals("")||content==null) {
					JOptionPane.showConfirmDialog(null, "Hãy thêm ghi chú trước khi thêm");
					return;
				}
				String txtmin=min.getValue().toString();
				Action.addNote(date, hour, txtmin, content);
				JOptionPane.showConfirmDialog(null, "success","info",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		btnSa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String date=new ParseData().parseDateToString(dateChooser.getDate());
				if(date=="1/1/2017") {
					JOptionPane.showConfirmDialog(null, "Hãy chọn ngày trước khi sửa");
					return;
				}
				String hour=chooseHour.getValue().toString();
				String content=txtContent.getText();
				String txtmin=min.getValue().toString();
				Action.updateNote(date, hour, txtmin, content);
				JOptionPane.showConfirmDialog(null, "success","info",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		dateChooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent arg0) {
				String date=new ParseData().parseDateToString(dateChooser.getDate());
				String sql="select * from GhiChu where date_exe=str_to_date(\'"+date+"\',\'%d/%m/%Y\')";
				//System.out.println(sql);
				Note n=Display.getNoteItem(sql);
				String content=n.getContent();
				if(content!=null) {
					btnThm.setEnabled(false);
				}else {
					btnThm.setEnabled(true);
				}
				String gio=n.getHour();
				String phut=n.getPhut();
				//System.out.println(gio+phut);
				txtContent.setText(content);
				try {
					int x=Integer.parseInt(gio);
					int y=Integer.parseInt(phut);
					chooseHour.setValue(x);
					min.setValue(y);
				}catch(Exception ex) {
					
				}
				
			}
		});
	}
}
