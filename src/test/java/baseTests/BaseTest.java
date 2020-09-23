package baseTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import utils.ExtentReportListener;
import utils.FileAndEnv;

@Listeners(ExtentReportListener.class)
public class BaseTest extends ExtentReportListener {
	/*@Test
	public void utilsTest() {
		int a =10;
		int b =20;
		int sum = a+b;
		System.out.println(FileAndEnv.envAndFile());
		System.out.println(FileAndEnv.envAndFile().get("ServerURL"));
		test.log(LogStatus.INFO, "Test has started...");
		test.log(LogStatus.PASS, "Test has pass...");
		test.log(LogStatus.PASS, "My Sum value is "+sum);
		test.log(LogStatus.INFO, "Test has been completed...");
		
	}*/
	@BeforeClass
	public void baseTest() {
		System.out.println("FileAndEnv.envAndFile().get(\"ServerURL\")::" +FileAndEnv.envAndFile().get("ServerURL"));
		RestAssured.baseURI =FileAndEnv.envAndFile().get("ServerURL");
		
	}

}
