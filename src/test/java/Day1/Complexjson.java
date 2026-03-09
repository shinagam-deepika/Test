package Day1;

import org.testng.Assert;
import org.testng.annotations.Test;

import file.Request_body;
import io.restassured.path.json.JsonPath;

public class Complexjson {
	
	@Test
	public void courseprice()
	{
		JsonPath js = new JsonPath(Request_body.courses());
		
		//print num of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);
		
		//print purchase amount
		int pramount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pramount);
		
		//print title of the first course//getString()
		String titleof_firstcourse = js.get("courses[0].title");
		System.out.println(titleof_firstcourse);
		
		//print all title and their respective prices
		for(int i=0;i<count;i++)
		{
			String course_titles = js.get("courses["+i+"].title");
			int prices = js.get("courses["+i+"].price");
			System.out.println(course_titles+" "+prices);
		}
		
		//print the copies where title is RPA
		for(int i=0;i<count;i++)
		{
			String course_titles = js.get("courses["+i+"].title");
			if(course_titles.equalsIgnoreCase("RPA"))
			{
				int copies = js.get("courses["+i+"].copies");
				System.out.println(copies);
				break;
			}
		}
		
		//print the sum of cources 
		int sum=0;
		for(int i=0;i<count;i++)
		{
			int price = js.getInt("courses["+i+"].price");
			int copies = js.getInt("courses["+i+"].copies");
			int total = price*copies;
			sum=sum+total;
		}
		System.out.println(sum);
		Assert.assertEquals(sum, pramount);
	}
	
}
