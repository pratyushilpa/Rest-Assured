package functionTesting;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.response.Response;


public class GetRequestAutomation {
	@Test
	public void getRequestAutomation() {
		RestAssured.baseURI = "https://reqres.in/api/users";
		 Response response = RestAssured.given().param("page", "2").when().get();
		 //System.out.println(response.getBody().asString());
		 System.out.println("get Status Code:: " +response.getStatusCode());
		 System.out.println("Content Type:: " +response.getContentType());
		 System.out.println("Response Time:: " +response.getTime());
		 System.out.println("Cookies:: " +response.getCookies());
		 
		System.out.println(response.prettyPrint());
		// approach-1 this is giving complete request body and response
		 /*RestAssured.given().param("page", "2")
		.when()
		.get()
		.then()
		.assertThat()
		.log()
		.all()
		.statusCode(200);*/
	}
}
