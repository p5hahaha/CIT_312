package test.HQL_Test;

import java.security.MessageDigest;

public class PasswordHasher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(encryptPassword("TestPassword"));

	}

	public static String encryptPassword( String password ) {
	    String encrypted = "";
	    long beginTime = System.currentTimeMillis();
	    try {
	        MessageDigest digest = MessageDigest.getInstance( "SHA-512" ); 
	        byte[] passwordBytes = password.getBytes( ); 

	        digest.reset( );
	        digest.update( passwordBytes );
	        byte[] message = digest.digest( );

	        StringBuffer hexString = new StringBuffer();
	        for ( int i=0; i < message.length; i++) 
	        {
	            hexString.append( Integer.toHexString(
	                0xFF & message[ i ] ) );
	        }
	        encrypted = hexString.toString();
	    }
	    catch( Exception e ) { }
	    long endTime = System.currentTimeMillis();
	    System.out.println("It took " + Long.toString(endTime - beginTime) + " to hash the password");
	    return encrypted; 
	}
}
