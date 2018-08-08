package control;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class ParseData {
	private SimpleDateFormat output1=new SimpleDateFormat("dd/MM/Y");
	private SimpleDateFormat output2=new SimpleDateFormat("dd/MM/Y HH:mm:ss");
	public String parseDateToString(java.util.Date date) {
		String s="loi";
		try {
			s=output1.format(date);
		}catch(Exception ex) {
			
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
		if(x==1) {
			return "Đặc biệt quan trọng";
		}
		if(x==2) {
			return "Quan trọng";
		}
		if(x==3) {
			return "Bình thường";
		}
		if(x==4) {
			return "Tự do thoải mái";
		}
		return "";
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
		System.out.println(s);
		SimpleDateFormat input=new SimpleDateFormat("dd/MM/yyyy");
		Date date=new Date();
		try {
			 date=input.parse(s);
			 System.out.println(input.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
}
