package Day1;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import file.Request_body;
import file.Reusable_method;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Dynamicjson {
	
	//Dynamically build json payload with external data inputs
	@Test(dataProvider="data")
	public void addbook(String isbn,String aisle)
	{
		RestAssured.baseURI="http://216.10.245.166";
		String response = given().header("Content-Type","application/json").
		body(Request_body.Books(isbn, aisle))
		.when().post("Library/Addbook.php")
		.then().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath js = Reusable_method.rawtojson(response);
		String id = js.get("ID");
		System.out.println(id);
	}
	
	//Parameterize the API Tests with multiple data sets
	@DataProvider
	public Object[][] data()
	{
		return new Object[][] {{"sccsc","67654"},{"nynngn","64535"},{"gbghb","2343"}}; 
	}
}
