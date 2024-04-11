package testCases;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import testBase.BaseClass;

public class Tc_16_ProductSearch_MaterialDropdown
{
	public WebDriver driver;

	@BeforeClass
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver(); // 1. Launch browser

		driver.manage().window().maximize();
		driver.get("https://magento.softwaretestingboard.com/"); // Navigate to url 'https://magento.softwaretestingboard.com/'

	}

	@Test(priority=1)
	public void HomePagetitleVerification() {
		String title = driver.getTitle(); // Verify that home page is visible successfully
		System.out.println(title);
		assertEquals(title, "Home Page", "Incorrect Title");
	}

	@Test(priority=2)
	public void View_Products_Material()
	{
		driver.findElement(By.xpath("//span[text()='Gear']")).click();

		// verify user navigated to Gear's page and verify category's are visible on left side bar.

		// verify page navigated to Gear's page

		boolean Gear=driver.findElement(By.xpath("(//span[text()='Gear'])[2]")).isDisplayed();
		assertTrue(Gear,"Gear");

		//verify category's are visible on left side bar.

		boolean verify_cate= driver.findElement(By.xpath("//dt[text()='Category']")).isDisplayed();
		assertTrue(verify_cate,"Category");

		//click on any category under Gear's page for ex: Bags

		driver.findElement(By.xpath("(//a[text()='Bags'])[1]")).click();

		//verify that category is displayed and confirmed test "Bags"

		boolean Tops= driver.findElement(By.xpath("(//span[text()='Bags'])[2]")).isDisplayed();
		assertTrue(Tops,"Bags");


		driver.findElement(By.xpath("(//div[@class='filter-options-title'])[4]")).click();
		driver.findElement(By.xpath("//*[@id=\"narrow-by-list\"]/div[4]/div[2]/ol/li[7]/a")).click();


		boolean Material= driver.findElement(By.xpath("//*[@id=\"layered-filter-block\"]/div[2]/div[1]/ol/li/span[1]")).isDisplayed();
		assertTrue(Material,"MaterialPolyester");

		List<WebElement> products = driver.findElements(By.cssSelector(".product-item-link"));

		System.out.println("Availability products Are:");

		for (WebElement prod : products) 
		{

			String optionLabel = prod.getAttribute("href");

			String productName = optionLabel.substring(optionLabel.lastIndexOf('/') + 1, optionLabel.lastIndexOf('.'));
			System.out.println( productName + " ========> " + optionLabel);


		}
		


	}
}
