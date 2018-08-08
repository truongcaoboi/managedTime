package control;
import model.*;
import view.DanhBa;
import view.PanelTTCN;

import java.util.*;
import java.sql.*;
import javax.swing.*;
public class Navigation {
	public static void start() {
		User u=new User().getUser();
		String username=u.getUsername();
		String checkPass=u.getCheckPassWork();
		if(username.equals("")) {
			
		}
	}
	public static void goToInfo(JPanel parent,String user) {
		PanelTTCN p=new PanelTTCN(user);
		p.setBounds(0, 0, 1074, 709);
		parent.removeAll();
		parent.add(p);
		parent.revalidate();
		parent.repaint();
	}
	public static void goToContact(JPanel parent) {
		DanhBa d=new DanhBa(parent);
		d.setBounds(0,0,1074,709);
		parent.removeAll();
		parent.add(d);
		parent.revalidate();
		parent.repaint();
	}
}
