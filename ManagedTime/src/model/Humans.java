package model;

import java.util.Vector;

public class Humans {
	private String id;
	private String fullName;
	private String birth;
	private String address;
	private String iden_no;
	private Vector<Email> email=null;
	private Vector<Phone> phone=null;
	private String company;
	private String gender;
	private String job;
	private int group;
	private String nickname;
	//Các phương thức thiết lập dữ liệu
	public void setId(String s) {
		id=s;
	}
	public void setFullName(String s) {
		fullName=s;
	}
	public void setBirth(String s) {
		birth=s;
	}
	public void setAddress(String s) {
		address=s;
	}
	public void setIden_no(String s) {
		iden_no=s;
	}
	public void addEmail(Email e) {
		if(email==null) {
			email=new Vector<Email>();
			email.addElement(e);
		}else {
			email.add(e);
		}
	}
	public void addPhone(Phone p) {
		if(phone==null) {
			phone=new Vector<Phone>();
			phone.add(p);
		}else {
			phone.add(p);
		}
	}
	public void setEmail(Vector<Email> e) {
		email=e;
	}
	public void setPhone(Vector<Phone> p) {
		phone=p;
	}
	public void setCompany(String s) {
		company=s;
	}
	public void setJob(String s) {
		job=s;
	}
	public void setGender(String s) {
		gender=s;
	}
	public void setGroup(int x) {
		group=x;
	}
	public void setNickname(String s) {
		nickname=s;
	}
	//Các phương thức lấy dữ liệu
	public String getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getBirth() {
		return birth;
	}
	public String getAddress() {
		return address;
	}
	public String getIden_no() {
		return iden_no;
	}
	public Vector<Email> getEmail() {
		return email;
	}
	public Vector<Phone> getPhone() {
		return phone;
	}
	public String getCompany() {
		return company;
	}
	public String getJob() {
		return job;
	}
	public String getGender() {
		return gender;
	}
	public int getGroup() {
		return group;
	}
	public String getNickname() {
		return nickname;
	}
}
