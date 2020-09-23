package studentAPITest;

import org.testng.annotations.Test;

import pojo.Credentials;
import utils.JavaUtils;

public class LoginTest {
	
	@Test
	public void loginTest() {
		Credentials loginCred = JavaUtils.base64Encode("admin", "admin123");
		System.out.println(loginCred);
	}

}
