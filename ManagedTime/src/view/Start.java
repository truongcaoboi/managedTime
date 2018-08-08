package view;
import java.util.*;
import javax.swing.*;
import model.*;
import control.*;
public class Start {
	public static void main(String args[]) {
		try {
			User.setAccount(Display.getAccount());
			if(User.getUser().getUsername()!="") {
				Login l=new Login();
				l.setVisible(true);
			}else {
				SignUp s=new SignUp();
				s.setVisible(true);
			}
		}catch(Exception e) {
			
		}
	}
}
