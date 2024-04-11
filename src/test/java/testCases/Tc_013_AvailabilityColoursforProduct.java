package testCases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_013_AvailabilityColoursforProduct {
	
	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.findElement(By.xpath("//span[normalize-space()='Women']")).click();
		
          driver.findElement(By.linkText("Selene Yoga Hoodie")).click();
          
          List<WebElement> colors = driver.findElements(By.cssSelector(".swatch-option.color"));

        System.out.println("Availability colours Are:");
          for (WebElement clr : colors) {
             
              String optionLabel = clr.getAttribute("option-label");
              
              System.out.println(optionLabel);
              
          }

}
}
