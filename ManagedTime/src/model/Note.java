package model;

public class Note {
	private String id;
	private String date;
	private String content;
	private String hour;
	private String phut;
	private String buoi;
	//Các phương thức thiết lập dữ liệu
	public void setId(String s) {
		id=s;
	}
	public void setDate(String s) {
		date=s;
	}
	public void setContent(String s) {
		content=s;
	}
	public void setHour(String s) {
		hour=s;
	}
	public void setPhut(String s) {
		phut=s;
	}
	
	//Các phương thức lấy dữ liệu
	public String getId() {
		return id;
	}
	public String getDate() {
		return date;
	}
	public String getContent() {
		return content;
	}
	public String getHour() {
		return hour;
	}
	public String getPhut() {
		return phut;
	}
	
}
