package helpers;

public class LoginHelper {

	public static String getUserByEmail(String email){
		String[] user = null;
		if(email.contains("@") && !email.isEmpty()){
			user = email.split("@");
		}
		return user[0];
		
	}
}
