package deepika.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Checkoutdetailspage {
	
	public WebDriver driver;
	
	public Checkoutdetailspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="first-name")
	WebElement firstname;
	
	@FindBy(id="last-name")
	WebElement lastname;
	
	@FindBy(id="postal-code")
	WebElement postalcode;
	
	@FindBy(id="continue")
	WebElement continuebtn;
	
	public void enterfirstname(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void enterlastname(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void enterpostalcode(String code)
	{
		postalcode.sendKeys(code);
		continuebtn.click();
	}
}
