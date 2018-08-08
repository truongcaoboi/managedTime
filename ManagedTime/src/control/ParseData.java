package control;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ParseData {
	private SimpleDateFormat output1=new SimpleDateFormat("dd/MM/Y");
	private SimpleDateFormat output2=new SimpleDateFormat("dd/MM/Y HH:mm");
	public String parseDateToString(java.util.Date date) {
		String s="loi";
		try {
			s=output1.format(date);
		}catch(Exception ex) {
			s="1/1/1970";
		}
		return s;
	}
	public String parseToDatetime(java.util.Date date) {
		String s="loi";
		try {
			s=output1.format(date);
		}catch(Exception ex) {
			
		}
		return s;
	}
	public static String parseToGroup(int x) {
		if(x==0) {
			return "Bạn bè";
		}
		if(x==1) {
			return "Gia đình";
		}
		if(x==2) {
			return "Cơ quan";
		}
		if(x==3) {
			return "Khách hàng";
		}
		if(x==4) {
			return "Không";
		}
		return "";
	}
	public static String parseToLevel(int x) {
		if(x==0) {
			return "Rất quan trọng";
		}
		if(x==1) {
			return "Quan trọng";
		}
		if(x==2) {
			return "Bình thường";
		}
		if(x==3) {
			return "Không quan trọng";
		}
		return "";
	}
	public static int parseLevel(String s) {
		if(s.equals("Rất quan trọng")) {
			return 0;
		}
		if(s.equals("Quan trọng")) {
			return 1;
		}
		if(s.equals("Bình thường")) {
			return 2;
		}
		if(s.equals("Không quan trọng")) {
			return 3;
		}
		return 0;
	}
	public static String parseToSequence(int x) {
		if(x==0) {
			return "Thường xuyên";
		}
		if(x==1) {
			return "Thỉnh thoảng";
		}
		if(x==2) {
			return "Hiếm khi";
		}
		return "";
	}
	public static int parseSequence(String s) {
		if(s.equals("Thường xuyên")) {
			return 0;
		}
		if(s.equals("Thỉnh thoảng")) {
			return 1;
		}
		if(s.equals("Hiếm khi")) {
			return 2;
		}
		return 0;
	}
	public static String parseToStatus(int x) {
		if(x==0) {
			return "Chưa làm";
		}
		if(x==1) {
			return "Bắt đầu làm";
		}
		if(x==2) {
			return "Đang làm";
		}
		if(x==3) {
			return "Tạm dừng";
		}
		if(x==4) {
			return "Đã hủy";
		}
		if(x==5) {
			return "Hoàn thành";
		}
		return "";
	}
	public static int parseStatus(String s) {
		if(s.equals("Chưa làm")) {
			return 0;
		}
		if(s.equals("Bắt đầu làm")) {
			return 1;
		}
		if(s.equals("Đang làm")) {
			return 2;
		}
		if(s.equals("Tạm dừng")) {
			return 3;
		}
		if(s.equals("Đã hủy")) {
			return 4;
		}
		if(s.equals("Hoàn thành")) {
			return 5;
		}
		return 0;
	}
	public static int parseToGRP(String g) {
		if(g.equals("Bạn bè")) {
			return 0;
		}
		if(g.equals("Gia đình")) {
			return 1;
		}
		if(g.equals("Cơ quan")) {
			return 2;
		}
		if(g.equals("Khách hàng")) {
			return 3;
		}
		return 4;
		
	}
	public static Date parseDate(String s){
		if(s==null||s.equals("")) {
			s="1/1/1970";
		}
		//System.out.println(s);
		SimpleDateFormat input=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		try {
			 date=input.parse(s);
			 //System.out.println(input.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
