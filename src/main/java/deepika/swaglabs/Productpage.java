package deepika.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Productpage {
	
	public WebDriver driver;
	
	public Productpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	WebElement addtocartbtn;
	
	public void addtocart()
	{
		addtocartbtn.click();
	}
}
