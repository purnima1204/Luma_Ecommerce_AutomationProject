package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_005_ScrollingPage {
	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		JavascriptExecutor js = (JavascriptExecutor)driver;

		
		// scroll by pixel

		js.executeScript("window.scrollBy(0,3000)", "");

		System.out.println(js.executeScript("return window.pageYOffset; "));

		

/*
		// scroll till element is present

		WebElement product = driver.findElement(By.xpath("//a[@title='Push It Messenger Bag']"));

		js.executeScript("arguements[0].scrollIntoView();", product);

		System.out.println(js.executeScript("return window.pageYOffset; "));
		
		*/

		/*
		// scroll till end of page

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset; "));


		Thread.sleep(2000);
		// initial position

		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

	}

		 */

	}
}
