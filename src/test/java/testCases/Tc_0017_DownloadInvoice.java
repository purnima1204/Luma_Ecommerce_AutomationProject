package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_0017_DownloadInvoice {

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

		Thread.sleep(2000);

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("purnima.sastry10@gmail.com");

		Thread.sleep(2000);
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

	@Test(priority=2)

	public void product() throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,2000)", "");
		
		Thread.sleep(2000);

		driver.findElement(By.linkText("Hero Hoodie")).click();
		
		WebElement size = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-167']")); // M size
		size.click();
		
		WebElement blackcolour = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
		
		blackcolour.click();
		driver.findElement(By.xpath("//input[@id='qty']")).clear();
		driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click(); // AddToCart Button
		//Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//a[@class='action showcart']")).click();
		
		driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click(); // checkout button
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[normalize-space()='Next']")).click(); // Next button
		
		Thread.sleep(4000);
		// scroll till place order button is able to click
		
		js.executeScript("window.scrollBy(0,2000)", "");
		driver.findElement(By.xpath("//span[normalize-space()='Place Order']")).click(); // placeorder
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//a[@class='action print']")).click(); // print window
		
		Thread.sleep(5000);
		
		System.out.println(driver.getTitle()); // success page Title after order is placed
	}
}
