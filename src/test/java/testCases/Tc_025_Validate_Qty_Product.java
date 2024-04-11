package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_025_Validate_Qty_Product {
	public WebDriver driver;
	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(); // 1. Launch browser

		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/"); // Navigate to 'https://magento.softwaretestingboard.com/'

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}
	@Test(priority=1)
	public void HomePagetitleVerification()
	{
		String title= driver.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
		
	}
	
	@Test(priority=2)
	public void Product_Quantity() throws InterruptedException
	{
		// select product from the any category
		driver.findElement(By.xpath("//span[text()='Women']")).click();
		
		// verify page navigated to women's page
				
		boolean women_page = driver.findElement(By.xpath("//*[@id=\"page-title-heading\"]/span")).isDisplayed();
		assertTrue(women_page,"Women");
				
		JavascriptExecutor js = (JavascriptExecutor) driver; // scroll down to see products
		js.executeScript("window.scrollBy(0,2000)", "");
				
		// Hover on any product and click on it.
				
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img")).click();
		
		JavascriptExecutor jss = (JavascriptExecutor) driver; 
		// scroll down to see products
		jss.executeScript("window.scrollBy(0,500)", "");
		
		// select and size, color and quantity and click "Add to cart"
		
		driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")).click();
		driver.findElement(By.xpath("//div[@id='option-label-color-93-item-56']")).click();
		driver.findElement(By.id("qty")).clear();
		driver.findElement(By.id("qty")).sendKeys("19000"); //  The maximum you may purchase is 10000.
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='qty-error']")).getText()); // The maximum you may purchase is 10000.
	}
	
	@Test(priority=3)
	
	public void tearDown()
	{
		driver.quit();
		
	}
	
}
