package control;
import java.util.*;
import java.sql.*;
import javax.swing.*;
public class Database {
	private static String driver="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/CVCN?autoReconnect=true&useSSL=false&useUnicode=yes&characterEncoding=UTF-8";
	private static String user="root";
	private static String pass="";
	public static Connection getConnect() {
		Connection con=null;
		try {
			//Class.forName(driver);
			con=DriverManager.getConnection(url,user,pass);
		}catch(Exception e) {
			con=null;
			JOptionPane.showMessageDialog(null,"Không tìm thấy driver","Error",JOptionPane.ERROR_MESSAGE);
		}
		return con;
	}
	public static void closeConnect(Connection con) {
		try {
			con.close();
		}catch(Exception e) {
			
		}
	}
	public static void closeStatement(Statement state)throws SQLException{
		state.close();
	}
	public static void closeResultSet(ResultSet rs)throws SQLException {
		rs.close();
	}
}
