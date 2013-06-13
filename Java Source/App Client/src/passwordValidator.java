/**
 * 
 */
/**
 * @author 11T7
 *
 */

import org.testng.Assert;
import org.testng.annotations.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class passwordValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String PASSWORD_PATTERN = 
			"((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	
	public void PasswordValidator(){
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	/**
	 * Validate password with regular expression
	 * @param password password for validation
	 * @return true valid password, false invalid password
	 */
	public boolean validate(final String password){

		matcher = pattern.matcher(password);
		return matcher.matches();

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String temp = "abc123#A";
		boolean valid = passwordValidator.validate(temp);
		System.out.println("Password is valid : " + temp + " , " + valid);
	}

}
