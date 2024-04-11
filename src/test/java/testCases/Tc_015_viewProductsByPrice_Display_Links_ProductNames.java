package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_015_viewProductsByPrice_Display_Links_ProductNames {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//span[normalize-space()='Women']")).click();


		driver.findElement(By.xpath("//a[contains(text(),'Tops')]")).click();



		driver.findElement(By.xpath("//div[normalize-space()='Price']")).click();

		WebElement pricerange = driver.findElement(By.xpath("//body[1]/div[2]/main[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[4]/div[2]/ol[1]/li[1]/a[1]"));

		pricerange.click();

		List<WebElement> products = driver.findElements(By.cssSelector(".product-item-link"));

		System.out.println("Availability products Are:");
		for (WebElement prod : products) 
		{

			String optionLabel = prod.getAttribute("href");

			String productName = optionLabel.substring(optionLabel.lastIndexOf('/') + 1, optionLabel.lastIndexOf('.'));
			System.out.println(productName + " -> " + optionLabel);


		}

	}
}
