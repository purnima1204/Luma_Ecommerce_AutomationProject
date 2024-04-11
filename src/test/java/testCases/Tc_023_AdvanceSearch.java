package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_023_AdvanceSearch { 
	// Selene Yoga Hoodie
	
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
	
	@Test(priority=0)
	
	public void advanceSearch() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,2000)", "");
		
		driver.findElement(By.linkText("Advanced Search")).click();
		
		System.out.println(driver.getTitle()); // Advance Search
		// search the product
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Selene Yoga Hoodie");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("button[class='action search primary']")).click();
		
		System.out.println(driver.getTitle()); // Advanced Search Results
	}
	
	@Test(priority=3)
	public void tearDown()
	{
		driver.quit();
	}

}
