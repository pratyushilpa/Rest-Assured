package studentAPITest;

import org.testng.annotations.Test;

import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import baseTests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.PostAPIPojo;

public class SerTest extends BaseTest{

	@Test
	public void serTest1() {
		HeaderConfigs head = new HeaderConfigs();
		PostAPIPojo pojo = new PostAPIPojo(24,"serTest1","Shilpa S");
		System.out.println(pojo.toString());
		Response response = RestAssured.given().when().headers(head.defaultHeaders()).body(pojo).post(APIPath.Api_Path.CREATE_POSTS);
		System.out.println(response.getBody().asString());
		System.out.println(pojo.getAuthor());
		System.out.println(pojo.getTitle());
		System.out.println(pojo.getId());
	}
}
