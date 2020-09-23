package utils;

import java.util.Base64;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;

import pojo.Credentials;




public class JavaUtils {
	
	public static Credentials base64Encode(final String username , final String password) {
		String cred = username + ":" + password;
		try {
			cred = Base64.getEncoder().encodeToString(cred.getBytes());
			System.out.println(cred);
		}
		catch(Exception e) {
			
		}
		Credentials loginCred = new Credentials();
		loginCred.setCredentials(cred);
		return loginCred;
		
	}
	public static String randomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		String id = Integer.toString(randomNumber);
		
		return id;	
	}
	public static String generateString() {
		String randomString = RandomStringUtils.randomAlphabetic(10);
		return randomString;
	}

	public static void main(String args) {
		JavaUtils utils = new JavaUtils();
		utils.base64Encode("admin", "admin123");
		
	}
}
