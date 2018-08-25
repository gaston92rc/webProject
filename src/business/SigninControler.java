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
	
	public boolean deleteUser(User user) {
		for (User u : mockUser) {
			if (u.equals(user)) {
				System.out.println("Lo encontre");
				mockUser.remove(user);
				return true;
			}
		}
		System.out.println("No lo encontre");
		return false;
	}
	
	public User getUserByUsername(String username){
		for(User u : mockUser){
			if(u.getUsuario().equals(username)){
				System.out.println("Lo encontre");
				return u;
			}
			
		}
		System.out.println("No lo encontre");
		return null;
	}
	
}
