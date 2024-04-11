package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_022_Verify_CompareProductsLink_PrintPage {

	
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

	public void HomePageTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
	}
	
	
	@Test(priority=1)

	public void signIn() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("purnima.sastry10@gmail.com");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Admin@123");
		//signIn
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();

	}
	
	
	@Test(priority = 2)
	
	public void CompareProducts()
	{
		driver.findElement(By.xpath("//a[@title='Compare Products']")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
	
		List<WebElement> products = driver.findElements(By.cssSelector(".product-item-name"));

		System.out.println(products.size());
			
		}	
		
	}
