package studentAPITest;

import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import apiBuilders.PostAPIBuilder;
import apiConfigs.APIPath;
import apiConfigs.HeaderConfigs;
import apiVerifications.APIVerification;
import baseTests.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.JavaUtils;

public class PostAPITest extends BaseTest {
	@Test
	public void validPostApiTest() {
		test.log(LogStatus.INFO, "My Test has started");
		HeaderConfigs header = new HeaderConfigs();
		PostAPIBuilder builder = new PostAPIBuilder();
		
		// To generate Random integer value
		/*Random random = new Random();
		int randomNumber = random.nextInt(100);
		String id = Integer.toString(randomNumber);*/
		
		// random string value
		/*String randomString= RandomStringUtils.randomAlphabetic(5);
		System.out.println("Random Id is :" + randomNumber + "Random String value" + randomString);*/
		
		Response response = RestAssured.given().when().headers(header.defaultHeaders()).
				body(builder.postRequestBody(JavaUtils.randomNumber(),JavaUtils.generateString(),JavaUtils.generateString())).
				when().post(APIPath.Api_Path.CREATE_POSTS);
		/*System.out.println(response.getBody().asString());
		System.out.println(response.getStatusCode());*/
		APIVerification.responseKeyValidationFromJsonObject(response, "title");
		APIVerification.responseCodeValidation(response, 200);
		APIVerification.responseTimeValidation(response);
		test.log(LogStatus.INFO, "My Test has ended");
	}

}
