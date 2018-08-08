package control;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import model.*;
public class Display {
	public static Vector<Humans> getContacts(String sql){
		Vector<Humans> contacts=new Vector<Humans>();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				Humans h=new Humans();
				h.setAddress(rs.getString("address"));
				h.setBirth(new ParseData().parseDateToString(rs.getDate("birth")));
				h.setCompany(rs.getString("company"));
				h.setFullName(rs.getString("name"));
				h.setId(rs.getString("id"));
				h.setIden_no(rs.getString("iden_no"));
				String user=rs.getString("id");
				String sql1="select * from Email where user=\'"+user+"\'";
				String sql2="select * from Phone where user=\'"+user+"\'";
				h.setEmail(Display.getEmail(sql1));
				h.setPhone(Display.getPhone(sql2));
				h.setJob(rs.getString("job"));
				h.setGender(rs.getString("gender"));
				h.setGroup(rs.getInt("groupHumans"));
				h.setNickname(rs.getString("nickname"));
				contacts.add(h);
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(SQLException e) {
			
		}
		return contacts;
	}
	public static Humans getHumans(String sql){
		Humans h=new Humans();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				
				h.setAddress(rs.getString("address"));
				h.setBirth(new ParseData().parseDateToString(rs.getDate("birth")));
				h.setCompany(rs.getString("company"));
				h.setFullName(rs.getString("name"));
				h.setId(rs.getString("id"));
				h.setIden_no(rs.getString("iden_no"));
				String user=rs.getString("id");
				h.setJob(rs.getString("job"));
				h.setGender(rs.getString("gender"));
				h.setGroup(rs.getInt("groupHumans"));
				h.setNickname(rs.getString("nickname"));
				
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(SQLException e) {
			System.out.println("loi roi");
		}
		return h;
	}
	public static Vector<Email> getEmail(String sql){
		Vector<Email> email=new Vector<Email>();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				Email e=new Email();
				e.setEmail(rs.getString("email"));
				e.setType(rs.getString("type"));
				e.setId(rs.getString("id"));
				e.setUser(rs.getString("user"));
				email.add(e);
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}
		catch(SQLException e) {
			
		}
		return email;
	}
	public static Vector<Phone> getPhone(String sql){
		Vector<Phone> phone=new Vector<Phone>();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				Phone p=new Phone();
				p.setPhone(rs.getString("phone"));
				p.setType(rs.getString("type"));
				p.setId(rs.getString("id"));
				p.setUser(rs.getString("user"));
				phone.add(p);
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}
		catch(SQLException e) {
			
		}
		return phone;
	}
	public static Vector<Work> getWork(String sql){
		Vector<Work> listWork=new Vector<Work>();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				Work w=new Work();
				w.setDate_start(new ParseData().parseDateToString(rs.getDate("date_start")));
				w.setDate_end(new ParseData().parseDateToString(rs.getDate("date_end")));
				w.setDescription(rs.getString("description"));
				w.setId(rs.getString("id"));
				w.setLevel(rs.getInt("level"));
				w.setName(rs.getString("name"));
				w.setStatus(rs.getString("status"));
				w.setSequence(rs.getInt("sequence"));
				w.setTitle(rs.getString("title"));
				listWork.add(w);
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(Exception e) {
			
		}
		return listWork;
	}
	public static Vector<Note> getNote(String sql){
		Vector<Note> listNote=new Vector<Note>();
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			ResultSet rs=state.executeQuery(sql);
			while(rs.next()) {
				Note n=new Note();
				n.setContent(rs.getString("content"));
				n.setDate(new ParseData().parseDateToString(rs.getDate("date")));
				n.setId(rs.getString("id"));
				listNote.add(n);
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(Exception e){
			
		}
		return listNote;
	}
	public static void execute(String sql) {
		try {
			Connection con=Database.getConnect();
			Statement state=con.createStatement();
			boolean rs=state.execute(sql);
			//Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null,"Thao tác lỗi","Error",JOptionPane.ERROR_MESSAGE);
		}		
	}
	public static User getAccount() {
		User u=new User();
		Connection con=null;
		try {
			con=Database.getConnect();
			Statement state = con.createStatement();
			ResultSet rs=state.executeQuery("select * from Account where id=\'user\'");
			while(rs.next()) {
				u.setCheckPassWork(rs.getString("password"));
				u.setUsername(rs.getString("username"));
				u.setEmail(Display.getEmail("select * from Email where user=\'user\'"));
				u.setPhone(Display.getPhone("select * from Phone where user=\'user\'"));
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			state=con.createStatement();
			rs=state.executeQuery("select * from Humans where id=\'user\'");
			while(rs.next()) {
				u.setId(rs.getString("id"));
				u.setAddress(rs.getString("address"));
				u.setBirth(new ParseData().parseDateToString(rs.getDate("birth")));
				u.setCompany(rs.getString("company"));
				u.setFullName(rs.getString("name"));
				u.setIden_no(rs.getString("iden_no"));
				u.setJob(rs.getString("job"));
			}
			Database.closeResultSet(rs);
			Database.closeStatement(state);
			Database.closeConnect(con);
		}catch(Exception e) {}
		return u;
	}
	public static DefaultTableModel getTableEmail(String user) {
		Vector<Email> listEmail=new Vector<Email>();
		DefaultTableModel model=new DefaultTableModel(new Object[][] {},new String[]{"Loại","Email"}) ;
		try {
			String sql="select * from Email where user=\'"+user+"\'";
			listEmail=Display.getEmail(sql);
			for(int i=0;i<listEmail.size();i++) {
				Email e=(Email)listEmail.get(i);
				String row[]= {e.getType(),e.getEmail()};
				model.addRow(row);
			}
		}catch(Exception ex) {}
		return model;
	}
	public static DefaultTableModel getTablePhone(String user) {
		Vector<Phone> listPhone=new Vector<Phone>();
		DefaultTableModel model=new DefaultTableModel(new Object[][] {},new String[]{"Loại","Số điện thoại"}) ;
		try {
			String sql="select * from Phone where user=\'"+user+"\'";
			listPhone=Display.getPhone(sql);
			for(int i=0;i<listPhone.size();i++) {
				Phone p=(Phone)listPhone.get(i);
				String row[]= {p.getType(),p.getPhone()};
				model.addRow(row);
			}
		}catch(Exception ex) {}
		return model;
	}
	public static DefaultTableModel getTableHumans(int gr) {
		DefaultTableModel model=new DefaultTableModel(new Object[][] {},new String[] {"id","nickname","Số điện thoại","Email"});
		String sql="";
		if(gr==-1||gr==5) {
			sql="select * from Humans";
		}else{
			sql="select * from Humans where groupHumans="+gr;
		}
		//System.out.println(sql);
		Vector<Humans> listHumans=Display.getContacts(sql);
		for(int i=0;i<listHumans.size();i++) {
			Humans h=(Humans)listHumans.get(i);
			String id=h.getId();
			String nickname=h.getNickname();
			String email="";
			String phone="";
			if(h.getEmail().size()!=0) {
				email=h.getEmail().get(0).getEmail();
			}
			if(h.getPhone().size()!=0) {
				phone=h.getPhone().get(0).getPhone();
			}
			String row[]= {id,nickname,email,phone};
			model.addRow(row);
		}
		return model;
	}
}
