package model;

public class Phone {
	private String id;
	private String user;
	private String type;
	private String phone;
	//Các phương thức thiết lập dữ liệu
	public void setId(String id) {
		this.id=id;
	}
	public void setUser(String s) {
		user=s;
	}
	public void setType(String s) {
		type=s;
	}
	public void setPhone(String s) {
		phone=s;
	}
	//Các phương thức lấy dữ liệu
	public String getId() {
		return id;
	}
	public String getUser() {
		return user;
	}
	public String getType() {
		return type;
	}
	public String getPhone() {
		return phone;
	}
}
