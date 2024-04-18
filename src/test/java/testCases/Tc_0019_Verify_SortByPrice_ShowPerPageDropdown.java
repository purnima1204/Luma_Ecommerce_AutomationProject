package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_0019_Verify_SortByPrice_ShowPerPageDropdown {

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

	public void signIn() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]")).click();

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("purnima.sastry10@gmail.com");

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Admin@123");
		//signIn
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();

	}
	
	
	@Test(priority=1)

	public void HomePageTitle()
	{
		String title = driver.getTitle();
		System.out.println(title);
		assertEquals(title,"Home Page","Incorrect Title");
	}
	
	
	@Test(priority = 2)

	public void shopPants20percentOff() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		
		driver.findElement(By.xpath("//span[normalize-space()='Shop Pants']")).click();		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
	     WebElement staticsortBy = driver.findElement(By.xpath("(//select[@id='sorter'])[1]"));
	     Select dropdown = new Select(staticsortBy);
	     
	     dropdown.selectByVisibleText("Price");
		//move till middle of page
	     js.executeScript("window.scrollBy(0,3000)", "");
	     
	     WebElement showperPage = driver.findElement(By.xpath("(//select[@data-role='limiter'])[2]"));
	     Select dropdown1 = new Select(showperPage);
	     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	     dropdown1.selectByVisibleText("36");  
	     // move to initial position
	     js.executeScript("window.scrollBy(0,-document.body.scrollHeight)"); 
	}
	
	@Test(priority = 3)
	
	public void printproducts()
	{
		List<WebElement> products = driver.findElements(By.cssSelector(".product-item-link"));
		

		System.out.println(" Availability products Are : " + products.size() );
		
		System.out.println("--------------");
		for (WebElement prod : products) 
		{

			String optionLabel = prod.getAttribute("href");

			String productName = optionLabel.substring(optionLabel.lastIndexOf('/') + 1, optionLabel.lastIndexOf('.'));
			System.out.println(productName + "   ->  " + optionLabel);
			
		}
	}
}
