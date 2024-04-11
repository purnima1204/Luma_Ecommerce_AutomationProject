package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_0018_AddToCartBeforeSIGIN_Verifying_AddToWishList { 

	// Karmen Yoga Pant

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

	@Test(priority = 0)

	public void productSelection() throws InterruptedException
	{
		driver.findElement(By.id("search")).sendKeys("Karmen Yoga Pant");
		driver.findElement(By.xpath("//button[@title='Search']")).click();

		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");

		driver.findElement(By.linkText("Karmen Yoga Pant")).click();
		driver.findElement(By.xpath("(//div[@id='option-label-size-143-item-171'])[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='option-label-color-93-item-49'])[1]")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='qty']")).clear();
		driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("1");

		driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();

		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//span[normalize-space()='Add to Wish List']")).click();
		
	}
	
	@Test(priority = 1)
	
	public void wishList() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("purnima.sastry10@gmail.com");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//input[@id='pass']")).sendKeys("Admin@123");
		//signIn
		driver.findElement(By.xpath("//fieldset[@class='fieldset login']//button[@id='send2']")).click();
		
		System.out.println(driver.getCurrentUrl() + " ---->  " + driver.getTitle());

}
}
