package Day1;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequests {
	
	@Test
	public void getuser()
	{
		given()
		
		.when()
		    .get("https://fakerestapi.azurewebsites.net/api/v1/Books")
		.then()
		    .statusCode(200)
		    .body("[1].id",equalTo(2))
		    .log().all();
	}
	
//	@Test
//	public void createuser()
//	{
//		HashMap data = new HashMap();
//		data.put("isbn","278152670861");
//		data.put("title", "helloworld");
//		
//		given()
//		    .contentType("application/json")
//		    .body(data)
//		.when()
//		    .post("https://bookstore.toolsqa.com/BookStore/v1/Books")
//		 .then()
//		     .statusCode(201)
//		     .log().all();
//	}
}
