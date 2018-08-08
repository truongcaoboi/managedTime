package model;
import java.util.*;

import control.Database;

import java.sql.*;
public class User extends Humans {
	private static User account=null;
	private static String username="";
	private String password="";
	private static String checkPassword="";
	//Các phương thức thiết lập dữ liệu
	public static void setAccount(User u) {
		account=u;
	}
	public void setUsername(String s) {
		username=s;
	}
	public void setPassword(String s) {
		password=s;
	}
	public void setCheckPassWork(String s) {
		checkPassword=s;
	}
	//Các phương thức lấy dữ liệu
	public static User getUser() {
		return account;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getCheckPassWork() {
		return checkPassword;
	}
	//Phương thức kiểm tra có mật khẩu hay không
	public static boolean havePass() {
		if(checkPassword=="") {
			return false;
		}else {
			return true;
		}
	}
	//Phương thức kiểm tra có tài khoản hay không
	public static boolean haveUser() {
		if(username=="") {
			return false;
		}else {
			return true;
		}
	}
	//Phương thức xác thực đăng nhập
	public boolean checkLogin() {
		if(password.equals(checkPassword)) {
			password="";
			return true;
		}else {
			password="";
			return false;
		}
	}
	
}
