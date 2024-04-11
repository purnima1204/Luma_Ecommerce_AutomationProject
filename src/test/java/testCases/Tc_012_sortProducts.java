package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_012_sortProducts {


	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//span[normalize-space()='Women']")).click();
		

		List<WebElement> priceElements = driver.findElements(By.xpath("//span[@class='price']"));

	
		List<Double> prices = new ArrayList<>();

		for (WebElement element : priceElements) 
		{
			String priceText = element.getText().replaceAll("[^0-9.]+", "");
			double price = Double.parseDouble(priceText);
			prices.add(price);
		}

		Collections.sort(prices);
		
		System.out.println("Sorted Prices in Ascending order:");
		for (double price : prices) {
			System.out.println(price );
		}
		
		Collections.reverse(prices);

		
		System.out.println("Sorted Prices in Descending order:");
		for (double price : prices) {
			System.out.println(price);
		}

	}

}
