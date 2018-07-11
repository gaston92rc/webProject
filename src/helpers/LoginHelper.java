package helpers;

public class LoginHelper {

	public static String getUserByEmail(String email){
		String[] user = null;
		try {
			if(email.contains("@") && !email.isEmpty()){
				user = email.split("@");
			}
			return user[0];
		} catch (Exception e) {
			System.err.println("ERROR: "+e.getStackTrace());
			return null;
		}
		
		
	}
}
