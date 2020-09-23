package functionTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;

public class PostRequestAutomation {
	
@Test
public void postRequestAutomation() {
	RestAssured.baseURI = "https://reqres.in/api/users";
	String json = "{\r\n" + 
			"    \"name\": \"morpheus\",\r\n" + 
			"    \"job\": \"leader\"\r\n" + 
			"}";
	RestAssured.given().body(json).post().then().log().all().assertThat().statusCode(201);
	
	
}
}
