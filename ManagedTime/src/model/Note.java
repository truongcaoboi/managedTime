package model;

public class Note {
	private String id;
	private String date;
	private String content;
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
}
