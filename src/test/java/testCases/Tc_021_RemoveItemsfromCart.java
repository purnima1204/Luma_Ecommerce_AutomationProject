package testCases;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_021_RemoveItemsfromCart {

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
		driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click(); // AddToCart 

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[@class='action showcart'])[1]")).click();
      Thread.sleep(2000);
        
        driver.findElement(By.xpath("//a[@title='Remove item']")).click();
       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert was present.");
        }      
	}
}
