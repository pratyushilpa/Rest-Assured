package studentAPITest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiConfigs.APIPath;
import apiVerifications.APIVerification;
import baseTests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetAPITests extends BaseTest{
	@Test
	public void getAPITest() {
		//RestAssured.given().when().get(APIPath.Api_Path.GET_LIST_OF_POSTS).then().log().all().statusCode(200);
		test.log(LogStatus.INFO, "My Test is starting ........");
		
		Response response = RestAssured.given().when().get(APIPath.Api_Path.GET_LIST_OF_POSTS);
		/*test.log(LogStatus.INFO, response.getBody().asString());
		test.log(LogStatus.INFO, "My Status code is :" +response.getStatusCode());
		test.log(LogStatus.INFO, "My Status time is :" +response.getTime());*/
//		System.out.println(response.getBody().asString());
//		System.out.println(response.getStatusCode());
//		System.out.println(response.getCookies());
//		System.out.println(response.getTime());
		
		// Validating Json Object or Json Array
		
		/*JSONArray array = new JSONArray(response.getBody().asString());
		for(int i=0;i<array.length();i++) {
			//System.out.println(array.get(i));
			JSONObject obj = array.getJSONObject(i);
			test.log(LogStatus.INFO,"Validated values are "+obj.get("title"));
			//System.out.println("Title ::"+obj.get("title"));
		}
		test.log(LogStatus.PASS, "My Test is pass.....");
		test.log(LogStatus.INFO, "My Test is end.....");*/
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTimeValidation(response);
		APIVerification.responseKeyValidationFromArray(response, "title");
		test.log(LogStatus.INFO, "My Test is ended ........");
	}

}
