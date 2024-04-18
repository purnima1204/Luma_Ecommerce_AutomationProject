package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_020_Validate_BreadCrumbs {
	
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
		assertEquals(title,"Home Page","Incorrect Title"); // Home Page
	}
	
	@Test(priority = 2)
	
	public void validateBreadcrumbs()
	{
		driver.findElement(By.xpath("//a[@id='ui-id-3']//span[1]")).click(); // what's New
		System.out.println(driver.getTitle()); // what's New
		System.out.println(driver.findElement(By.xpath("//div[@class='breadcrumbs']")).getText()); //  Home  ->  what's New
	}

}
