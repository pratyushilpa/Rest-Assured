package deserializingTest;

import java.util.List;

import org.testng.annotations.Test;

import deserializingPojo.DataPOJO;
import deserializingPojo.ListUsersPOJO;
import io.restassured.RestAssured;

public class DeserializingTest {
	@Test
	public void deserTest() {
		RestAssured.baseURI ="https://reqres.in/api/users?page=2";
		//ListUsersPOJO listPojo = new ListUsersPOJO(); we are creating duplicate object in this step so commenting out
		
		ListUsersPOJO listPojo = RestAssured.given().when().get().as(ListUsersPOJO.class);
		//System.out.println(listPojo.toString());
		System.out.println("List" +listPojo.getData());
		List<DataPOJO> list = listPojo.getData();
		list.stream().map(l->l.getFirst_name());
		for(int i=0;i<list.size();i++) {
			System.out.println("This is my first "+i+"element"+list.get(i));
		}
	}
}
