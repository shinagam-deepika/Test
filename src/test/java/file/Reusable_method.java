package file;

import io.restassured.path.json.JsonPath;

public class Reusable_method {
	
	public static JsonPath rawtojson(String response)
	{
		JsonPath js1 = new JsonPath(response);
		return js1;
	}
}
