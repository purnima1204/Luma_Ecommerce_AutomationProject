package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_008_FooterLinks {
	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		driver.findElement(By.linkText("Search Terms")).click();
		driver.findElement(By.linkText("Privacy and Cookie Policy")).click();
		driver.findElement(By.linkText("Advanced Search")).click();
	}
}
