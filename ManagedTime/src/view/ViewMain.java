package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.Navigation;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;

public class ViewMain extends JFrame implements Runnable {

	private JPanel contentPane;
	private JLabel lblGio;
	private JLabel lbMin;
	private JLabel lbSplit;
	private JLabel lbDay;
	private JLabel lblAm;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMain frame = new ViewMain();
					Thread t=new Thread(frame);
					t.start();
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
	public ViewMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1757, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(10, 92, 284, 709);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JPanel panelContent = new JPanel();
		
		JButton btnLLV = new JButton("Lịch làm việc");
		btnLLV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Navigation.goToWork(panelContent);
			}
		});
		btnLLV.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLLV.setBounds(10, 24, 264, 52);
		panelMenu.add(btnLLV);
		
		
		panelContent.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(0, 0, 0)));

		JButton btnTTCN = new JButton("Thông tin cá nhân");
		btnTTCN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Navigation.goToInfo(panelContent,User.getUser().getId());
			}
		});
		btnTTCN.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTTCN.setBounds(10, 98, 264, 52);
		panelMenu.add(btnTTCN);
		
		JButton btnDSLL = new JButton("Danh sách liên lạc");
		btnDSLL.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Navigation.goToContact(panelContent);
			}
		});
		btnDSLL.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDSLL.setBounds(10, 174, 264, 52);
		panelMenu.add(btnDSLL);
		
		JButton btnGhiChu = new JButton("Ghi chú");
		btnGhiChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Navigation.goToNote(panelContent);
			}
		});
		btnGhiChu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGhiChu.setBounds(10, 251, 264, 52);
		panelMenu.add(btnGhiChu);
		
		lblGio = new JLabel("00");
		lblGio.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblGio.setBounds(44, 334, 43, 52);
		panelMenu.add(lblGio);
		
		lbSplit = new JLabel(":");
		lbSplit.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lbSplit.setBounds(97, 331, 29, 52);
		panelMenu.add(lbSplit);
		
		lbMin = new JLabel("00");
		lbMin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbMin.setBounds(136, 335, 43, 52);
		panelMenu.add(lbMin);
		
		lblAm = new JLabel("AM");
		lblAm.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAm.setBounds(189, 335, 57, 52);
		panelMenu.add(lblAm);
		
		lbDay = new JLabel("AM");
		lbDay.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbDay.setBounds(51, 397, 185, 52);
		panelMenu.add(lbDay);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("..\\image\\tai-hinh-nen-hoat-hinh-de-thuong-cho-may-tinh-8.jpg"));
		label.setBounds(10, 447, 264, 231);
		panelMenu.add(label);
		
		panelContent.setBounds(304, 92, 1074, 709);
		contentPane.add(panelContent);
		panelContent.setLayout(null);
		PanelWork p=new PanelWork();
		p.setBounds(0,0,1074,709);
		panelContent.add(p);
		
		JPanel panelImporWork = new JPanel();
		panelImporWork.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				panelImporWork.removeAll();
				PanelImportWork im=new PanelImportWork();
				im.setBounds(0,0,343,709);
				panelImporWork.add(im);
				panelImporWork.revalidate();
				panelImporWork.repaint();
			}
		});
		panelImporWork.setBounds(1388, 92, 343, 709);
		contentPane.add(panelImporWork);
		panelImporWork.setLayout(null);
		PanelImportWork im=new PanelImportWork();
		im.setBounds(0, 0, 343, 709);
		panelImporWork.add(im);
		
		JLabel lblCngVicC = new JLabel("CÔNG VIỆC CÁ NHÂN");
		lblCngVicC.setForeground(new Color(0, 100, 0));
		lblCngVicC.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblCngVicC.setBounds(31, 11, 419, 62);
		contentPane.add(lblCngVicC);
		
		JLabel lblThinV = new JLabel("Thiên Vũ - Hiếu Trần");
		lblThinV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblThinV.setBounds(460, 41, 167, 25);
		contentPane.add(lblThinV);
		
		JLabel lblAccount = new JLabel("Hello "+User.getUser().getUsername());
		lblAccount.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblAccount.setBounds(1371, 26, 335, 40);
		contentPane.add(lblAccount);
		
		JLabel lblThngTinLin = new JLabel("Thông tin liên hệ: hotline 0971481922");
		lblThngTinLin.setForeground(new Color(255, 0, 0));
		lblThngTinLin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblThngTinLin.setBounds(748, 821, 244, 29);
		contentPane.add(lblThngTinLin);
		setLocationRelativeTo(null);
		setTitle("Quản lý công việc");
	}
	@Override
	public void run() {
		try {
		while(true) {
			
			Date thisdate=new Date();
			//System.out.println(thisdate);
			SimpleDateFormat output=new SimpleDateFormat("dd/MM/Y");
			lbDay.setText(output.format(thisdate));
			output=new SimpleDateFormat("hh");
			lblGio.setText(output.format(thisdate));
			output=new SimpleDateFormat("mm");
			lbMin.setText(output.format(thisdate));
			output=new SimpleDateFormat("a");
			lblAm.setText(output.format(thisdate));
			if(lbSplit.getText().equals(":")) {
				lbSplit.setText("");
			}else {
				lbSplit.setText(":");
			}
			Thread.sleep(1000);
		}}catch(Exception e) {}
	}
}
