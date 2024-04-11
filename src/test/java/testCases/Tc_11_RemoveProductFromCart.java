package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseClass;

public class Tc_11_RemoveProductFromCart extends BaseClass {
	
	
	
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(); 

		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/"); 

	}
	
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= driver.getTitle(); 
		System.out.println(title);
		assertEquals(title,"Home Page");
		
	}
	
	@Test(priority=2)
	public void Remove_Product_cart() throws InterruptedException
	{
		
		
		driver.findElement(By.xpath("//span[text()='Women']")).click();
				
		// Verify Page is navigated to womens page
				
		boolean women_page=driver.findElement(By.xpath("//*[@id=\"page-title-heading\"]/span")).isDisplayed();
		assertTrue(women_page,"Women");
				
		JavascriptExecutor js = (JavascriptExecutor) driver; // scroll down to see products
		js.executeScript("window.scrollBy(0,2000)", "");
				
		// Hover & click 
				
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img")).click();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver; // scroll down to see products
		js1.executeScript("window.scrollBy(0,500)", "");
		
		// select and size, color and quantity and click "Add to cart"
		
		driver.findElement(By.id("option-label-size-143-item-167")).click();
		driver.findElement(By.id("option-label-color-93-item-50")).click();
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		Thread.sleep(3000);
		
		//click on cart button
		
		driver.findElement(By.xpath("(//span[@class='counter qty'])[1]")).click();
		driver.findElement(By.xpath("//span[text()='View and Edit Cart']")).click();
		
		//verify user navigated to cart page and remove product
		
		
		boolean verify_cart=driver.findElement(By.xpath("//span[text()='Shopping Cart']")).isDisplayed();
		assertTrue(verify_cart,"Shopping Cart");
				
		JavascriptExecutor js2 = (JavascriptExecutor) driver; // scroll down to see product
		js2.executeScript("window.scrollBy(0,500)", "");
		
		driver.findElement(By.xpath("//*[@id=\"shopping-cart-table\"]/tbody/tr[2]/td/div/a[2]")).click();
	
		
				
	}

}
