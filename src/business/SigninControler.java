package business;

import java.util.ArrayList;
import java.util.List;

import entities.User;
import helpers.LoginHelper;

public class SigninControler {
	static String email = "gaston@cuesta.com";
	static String user = LoginHelper.getUserByEmail(email);
	static String pass = "123";
	
	public static List<User> mockUser = new ArrayList<User>(){
		{
			add(new User(user,email,pass));
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
