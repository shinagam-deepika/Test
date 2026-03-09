package Day1;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class OAuthTest {
	
	@Test
	public void token()
	{
		String response = given().log().all()
		.formParams("client_id","692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParams("client_secret","erZOWM9g3UtwNRj340YYaK_W")
		.formParams("grant_type","client_credentials")
		.formParams("scope","trust")
		.when().post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String accesstoken=js.getString("access_token");
		
		String res1=given()
		.queryParams("access_token", accesstoken)
		.when().get("https://rahulshettyacademy.com/oauthapi/getCourseDetails?access_token=lquuM4vkpTZXNnp25q9MYw==").asString();
		System.out.println(res1);
	}
}
