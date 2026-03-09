package deepika.swaglabs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import deepika.utils.Abstractcomponent;

public class loginpage extends Abstractcomponent{
	
	public WebDriver driver;
	
	public loginpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="user-name")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(id="login-button")
	WebElement loginbtn;
	
	public void enterusername(String user)
	{
		
		username.sendKeys(user);
	}
	
	public void enterpassword(String pass)
	{
		password.sendKeys(pass);
		waitForElementToAppear(loginbtn);
		loginbtn.click();
	}
}
