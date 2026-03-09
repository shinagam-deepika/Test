package deepika.swaglabs;
import org.testng.Assert;
//import org.openqa.selenium.By;
import org.testng.annotations.Test;

import deepika.utils.Abstractcomponent;

public class logintest extends Basetest{
	
	@Test(priority=1)
	public void login() throws InterruptedException
	{
		
		loginpage lp = new loginpage(driver);
		lp.enterusername("standard_user");
		lp.enterpassword("secret_sauce");
		//Thread.sleep(5000);
		
		System.out.println("login successfull");
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//      Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//      System.out.println("Alert Text: " + alert.getText());
//      alert.accept();
//		driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
//		Thread.sleep(3000);
//		System.out.println("prod addedd");
//		
//		driver.findElement(By.cssSelector(".shopping_cart_link")).click();
//		Thread.sleep(3000); 
//		System.out.println("clicked on cart");
		
		
	}
	
	@Test(priority=2)
	public void addcart() throws InterruptedException
	{
		Productpage pp = new Productpage(driver);
		pp.addtocart();
		Thread.sleep(3000);
		System.out.println("prod addedd");
	}
	
	@Test(priority=3)
	public void addtocartbutton() throws InterruptedException
	{
		Cartpage cp = new Cartpage(driver);
		cp.crtpage();
		Thread.sleep(3000);
		System.out.println("cart page opened");
	}
	
	@Test(priority=4)
	public void checkoutpage() throws InterruptedException
	{
		Checkoutpage ckp = new Checkoutpage(driver);
		ckp.checkout();
		Thread.sleep(3000);
		System.out.println("check out page opened");
	}
	
	@Test(priority=5)
	public void checkoutdetails() throws InterruptedException
	{
		Checkoutdetailspage cdp = new Checkoutdetailspage(driver);
		cdp.enterfirstname("deepika");
		Thread.sleep(2000);
		cdp.enterlastname("shinagam");
		Thread.sleep(2000);
		cdp.enterpostalcode("530002");
		Thread.sleep(3000);
		System.out.println("details entered");
	}
	
	@Test(priority=6)
	public void finishpage() throws InterruptedException
	{
		Finishpage fp = new Finishpage(driver);
		fp.finish();
		Thread.sleep(3000);
		System.out.println("product ordered");
	}
	
	@Test(priority=7)
	public void orderconfirmation() throws InterruptedException
	{
		Orderconfirmationpage ocp = new Orderconfirmationpage(driver);
		ocp.ordercnftext();
		Thread.sleep(3000);
		System.out.println("order placed");
	}
	
	@Test(priority=8)
	public void backtohome() throws InterruptedException
	{
		Backtohomepage bhp = new Backtohomepage(driver);
		bhp.backhome();
		Thread.sleep(3000);
		System.out.println("back to home");
	}
	
	@Test(priority=9)
	public void addproducts() throws InterruptedException
	{
		Additemspage aip = new Additemspage(driver);
		aip.additems();
		Thread.sleep(2000);
		System.out.println("products addedd");
		addtocartbutton();
	}
	
	@Test(priority=10)
	public void removeproducts() throws InterruptedException
	{
		Removeitemspage rip = new Removeitemspage(driver);
		rip.remitems();
		Thread.sleep(2000);
		System.out.println("products removed");
		Assert.assertEquals(rip.cartproductscount(), 1, "products are not removed correctly");
		driver.navigate().back();
		Thread.sleep(3000);
	}
	
	@Test(priority=11)
	public void hamburgermenu() throws InterruptedException
	{
		Abstractcomponent cs = new Abstractcomponent(driver);
		cs.cartsummary();
		Thread.sleep(3000);
	}
	
	@Test(priority=12)
	public void aboutpage() throws InterruptedException
	{
		Aboutpage ap = new Aboutpage(driver);
		ap.about();
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(3000);
		System.out.println("navigated to back");
	}
	
	@Test(priority=13)
	public void prodsorting() throws InterruptedException
	{
		Productsortpage psp = new Productsortpage(driver);
		psp.selectbyvisibletext("Price (high to low)");
		Thread.sleep(3000);
		psp.selectbyvalue("lohi");
		Thread.sleep(3000);
		psp.selectbyindex(1);
		Thread.sleep(3000);
		System.out.println("sorted successfully");
		hamburgermenu();
		
	}
	
	@Test(priority=14)
	public void logoutthepage() throws InterruptedException
	{
		Logoutpage lp = new Logoutpage(driver);
		lp.logout();
		Thread.sleep(2000);
		System.out.println("logout successfull");
	}
}
