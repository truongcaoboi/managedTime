package control;
import model.*;

import java.util.Random;
import java.util.Vector;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class Action {
	private static final String kitu[]= {"0","1","2","3","4","5","6","7","8","9","q","w"
			,"e","r","t","y","u","i","o","p","a","s","d","f","g","h","j","k","l","z","x",
			"c","v","b","n","m","Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G",
			"H","J","K","L","Z","X","C","V","B","N","M"};
	public static boolean Login(String username,String password) {
		User u=User.getUser();
		String checkUser=u.getUsername();
		String checkPass=u.getCheckPassWork();
		//System.out.println(checkPass);
		if(checkUser.equals(username)) {
			if(!checkPass.equals(password)) {
				JOptionPane.showConfirmDialog(null,"Sai mật khẩu");
				return false;
			}
		}else {
			JOptionPane.showConfirmDialog(null,"Sai tên đăng nhập");
			return false;
		}
		return true;
	}
	public static void SignUp(String username,String password) {
		User u=new User();
		u.setUsername(username);
		u.setCheckPassWork(password);
		User.setAccount(u);
		String sql="insert into Account(id,username,password) values(\'user\',\'"
				+ username+"\',\'"+password+"\')";
		Display.execute(sql);
		sql="insert into Humans(id,name,address,job,company,birth,gender,groupHumans,nickname,iden_no)"
				+ "values(\'user\',\'name\',\'address\',\'job\',\'company\',\'1970/1/1\',2,4,\'nickname\',\'0\')";
		Display.execute(sql);
	}
	public static String createId(String table) {
		int k=0;
		String id="";
		Vector<String> listId=new Vector<String>();
		Random rd=new Random();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery("select id from "+table);
			while(rs.next()) {
				listId.add(rs.getString("id"));
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
			while(true) {
				id="";
				for(int i=0;i<10;i++) {
					int x=Math.abs(rd.nextInt())%62;
					id=id+kitu[x];
				}
				k=0;
				for(int i=0;i<listId.size();i++) {
					String s=(String)listId.get(i);
					if(s.equals(id)) {
						k++;
						break;
					}
				}
				if(k==0) {
					return id;
				}
			}
		}catch(Exception e) {
			
		}
		
		return id;
	}
	public static void addEmail(DefaultTableModel model,String user,String type,String email) {
		try {
			String sql="insert into Email(id,user,type,email)"
					+ "values(\'"+Action.createId("Email")+"\',\'"+user
							+ "\',\'"+type+"\',\'"+email+"\')";
			Display.execute(sql);
		}catch(Exception ex) {
			
		}
		String row[]= {type,email};
		model.addRow(row);
	}
	public static void updateEmail(JTable table,String user,String type,String email) {
		int x=table.getSelectedRow();
		if(x==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn email cần sửa");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		try {
			String oldType=table.getValueAt(x, 0).toString();
			String oldEmail=table.getValueAt(x, 1).toString();
			String sql="update Email set type=\'"+type+"\', email=\'"+email+
					"\' where type=\'"+oldType+"\' and email=\'"+oldEmail+"\' and user=\'"+user+"\'";
			Display.execute(sql);
		}catch(Exception ex) {}
		model.setValueAt(type, x, 0);
		model.setValueAt(email, x, 1);
	}
	public static void deleteEmail(JTable table,String user) {
		int x=table.getSelectedRow();
		if(x==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn email cần xóa");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		try {
			String oldType=table.getValueAt(x, 0).toString();
			String oldEmail=table.getValueAt(x, 1).toString();
			String sql="delete from Email where type=\'"+oldType+"\' and email=\'"+oldEmail+"\' and user=\'"+user+"\'";
			Display.execute(sql);
		}catch(Exception ex) {}
		model.removeRow(x);
	}
	public static void addPhone(DefaultTableModel model,String user,String type,String phone) {
		try {
			String sql="insert into Phone(id,user,type,phone)"
					+ "values(\'"+Action.createId("Phone")+"\',\'"+user
							+ "\',\'"+type+"\',\'"+phone+"\')";
			Display.execute(sql);
			String row[]= {type,phone};
			model.addRow(row);
		}catch(Exception ex) {
			
		}
		
	}
	public static void updatePhone(JTable table,String user,String type,String phone) {
		int x=table.getSelectedRow();
		if(x==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn số điện thoại cần sửa");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		try {
			String oldType=table.getValueAt(x, 0).toString();
			String oldPhone=table.getValueAt(x, 1).toString();
			String sql="update Phone set type=\'"+type+"\', phone=\'"+phone+
					"\' where type=\'"+oldType+"\' and phone=\'"+oldPhone+"\' and user=\'"+user+"\'";
			Display.execute(sql);
			model.setValueAt(type, x, 0);
			model.setValueAt(phone, x, 1);
		}catch(Exception ex) {}
		
	}
	public static void deletePhone(JTable table,String user) {
		int x=table.getSelectedRow();
		if(x==-1) {
			JOptionPane.showMessageDialog(null, "Bạn chưa chọn số điện thoại cần xóa");
			return;
		}
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		try {
			String oldType=table.getValueAt(x, 0).toString();
			String oldPhone=table.getValueAt(x, 1).toString();
			String sql="delete from Phone where type=\'"+oldType+"\' and phone=\'"+oldPhone+"\' and user=\'"+user+"\'";
			Display.execute(sql);
			model.removeRow(x);
		}catch(Exception ex) {}
		
	}
	public static void updateHumans(String id,String name,String add,String nick,String job,String date,String gen,int gr,String com) {
		String sql="update Humans set name=\'"+name+"\',"+
	"address=\'"+add+"\',job=\'"+job+"\',company=\'"+com+"\',"
			+ "gender=\'"+gen+"\',groupHumans="+gr+","
					+ "nickname=\'"+nick+"\',birth=str_to_date(\'"+date+"\',\'%d/%m/%Y\') where id=\'"+id+"\'";
		System.out.println(sql);
		Display.execute(sql);
	}
	public static void addHumans(String id,String name,String nick,String job,String com,String date,String add,String email,String phone) {
		
		String sql="insert into Humans(id,name,nickname,job,company,birth,groupHumans,address,gender,iden_no) values"
		+ "(\'"+id+"\',"
		+ "\'"+name+"\',\'"+nick+"\',\'"+job+"\',\'"+com+"\',"
		+"str_to_date(\'"+date+"\',\'%d/%m/%Y\'),4,\'"+add+"\',\'Không\',\'0\')";
		//System.out.println(sql);
		Display.execute(sql);
		sql="insert into Email(id,user,type,email) values(\'"+Action.createId("Email")+""
				+ "\',\'"+id+"\',\'moi\',\'"+email+"\')";
		Display.execute(sql);
		sql="insert into Phone(id,user,type,phone) values(\'"+Action.createId("Phone")+""
				+ "\',\'"+id+"\',\'moi\',\'"+phone+"\')";
		Display.execute(sql);
	}
	public static void setColor(JTable table) {
		/*int x=table.getRowCount();
		DefaultTableModel model=(DefaultTableModel)table.getModel();
		for(int i=0;i<x;i++) {
			String lv=table.getValueAt(i, 4).toString();
			if(lv=="Rất quan trọng") {
				
			}
		}*/
	}
	public static void addNote(String date,String hour,String min,String content) {
		String sql="insert into GhiChu(id,date_exe,content,gio,phut) values(\'"
		+ Action.createId("GhiChu")+"\',str_to_date(\'"+date+"\',\'%d/%m/%Y\')"
		+ ",\'"+content+"\',\'"+hour+"\',\'"+min+"\')";
		//System.out.println(sql);
		Display.execute(sql);
	}
	public static void updateNote(String date,String hour,String min,String content) {
		String sql="update GhiChu set gio=\'"+hour+"\',phut=\'"+min+
				"\',content=\'"+content+"\' where date_exe=str_to_date(\'"+date+"\',\'%d/%m/%Y\')";
		//System.out.println(sql);
		Display.execute(sql);
	}
}
