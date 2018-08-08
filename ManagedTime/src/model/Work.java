package model;

public class Work {
	private String id;
	private String title;
	private String name;
	private String description;
	private String date_start;
	private String date_end;
	private String status;
	private int level;
	private int sequence;
	//Các phương thức thiết lập dữ liệu
	public void setId(String s) {
		id=s;
	}
	public void setTitle(String s) {
		title=s;
	}
	public void setName(String s) {
		name=s;
	}
	public void setDescription(String s) {
		description=s;
	}
	public void setDate_start(String s) {
		date_start=s;
	}
	public void setDate_end(String s) {
		date_end=s;
	}
	public void setStatus(String s) {
		status=s;
	}
	public void setLevel(int l) {
		level=l;
	}
	public void setSequence(int s) {
		sequence=s;
	}
	//Các phương thức lấy dữ liệu
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getDate_start() {
		return date_start;
	}
	public String getDate_end() {
		return date_end;
	}
	public String getStatus() {
		return status;
	}
	public int getLevel() {
		return level;
	}
	public int getSequence() {
		return sequence;
	}
}
