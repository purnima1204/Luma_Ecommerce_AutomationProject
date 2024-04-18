package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_024_VerifyProduct_ByGender_Material {
	
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
	
	@Test(priority = 2)
	
	public void selectWomen() throws InterruptedException
	{
		driver.findElement(By.xpath("//span[normalize-space()='Women']")).click();
		
		boolean Women = driver.findElement(By.xpath("//span[@class='base']")).isDisplayed();
		
		assertTrue(Women, "Women");
		//click on Jackets
		driver.findElement(By.xpath("//a[contains(text(),'Jackets')]")).click();
		
		driver.findElement(By.xpath("//div[normalize-space()='Color']")).click();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		//select color on left panel -- Black
		driver.findElement(By.xpath("//a[@aria-label='Black']//div[contains(@class,'swatch-option color')]")).click();
		//click material on left panel -- CoolTech™
		driver.findElement(By.xpath("//div[normalize-space()='Material']")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'CoolTech™')]")).click();
	}
	
	@Test(priority=3)
	public void tearDown()
	{
		driver.quit();
	}

}
