package apiVerifications;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;
import utils.ExtentReportListener;

public class APIVerification extends ExtentReportListener{
	public static void responseCodeValidation(Response response, int statusCode) {
		
		try {
			Assert.assertEquals(statusCode, response.getStatusCode());
			test.log(LogStatus.PASS, "Successfully validated status code and status code is =" + response.getStatusCode());
			
		}
		catch(AssertionError e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
			test.log(LogStatus.FAIL, "Expected status code is ::" +statusCode+", instead of getting::"+response.getStatusCode());
		}
		catch(Exception e ) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	public static void responseKeyValidationFromArray(Response response, String key) {
		try {
			// Validating Json Object or Json Array
			
			JSONArray array = new JSONArray(response.getBody().asString());
			for(int i=0;i<array.length();i++) {
				//System.out.println(array.get(i));
				JSONObject obj = array.getJSONObject(i);
				test.log(LogStatus.INFO,"Validated values are "+obj.get(key));
				//System.out.println("Title ::"+obj.get("title"));
			}	
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	public static void responseKeyValidationFromJsonObject(Response response,String key) {
		try {
			JSONObject json = new JSONObject(response.getBody().asString());
			if(json.has(key) && json.get(key)!=null) {
				test.log(LogStatus.PASS, "Successfully validated value of " + key + " it is " + json.get(key));
			}
			else {
				test.log(LogStatus.FAIL, "Key is not available");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}
	public static void responseTimeValidation(Response response) {
		try {
			long time = response.getTime();
			test.log(LogStatus.INFO, "Api response time is ::" + time);
		}
		catch(Exception e) {
			test.log(LogStatus.FAIL, e.fillInStackTrace());
		}
	}

}
