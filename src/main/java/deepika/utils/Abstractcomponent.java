package deepika.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponent {
	
	public WebDriver driver;
	WebDriverWait wait;
	 
	public Abstractcomponent(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void waitForElementToAppear(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	@FindBy(id="react-burger-menu-btn")
	WebElement cartsummarybtn;
	
	public void cartsummary()
	{
		cartsummarybtn.click();
	}
}
