package business;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xml.internal.security.utils.HelperNodeList;

import entities.User;
import helpers.LoginHelper;

public class SigninControler {
	static String email = "gaston92.rc@hotmail.com";
	static String user = LoginHelper.getUserByEmail(email);
	
	public static List<User> mockUser = new ArrayList<User>(){
		{
			add(new User(user,email,"123456"));
		}
	};
	
	public User getUser(User user){
		for (User u : mockUser){
			if(u.equals(user) && u.getPassword().equals(user.getPassword())){
				return u;
			}
		}
		return null;
	}
	

}
