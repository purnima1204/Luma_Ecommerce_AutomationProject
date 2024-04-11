package testCases;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_007_HomePageTitle {


	public static void main(String[] args) {


		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		System.out.println(driver.getTitle());

		if(driver.getTitle().contains("Home Page"))
		{
			System.out.println("HomePage Loads Successfully.....");
		}
		else
		{
			System.out.println("HomePage is Failed To Load....");
		}


		System.out.println(driver.getCurrentUrl());

		String URL = "https://magento.softwaretestingboard.com/";

		if(URL.equals(driver.getCurrentUrl()))
		{
			System.out.println("Links are same");
		}
		else
		{
			System.out.println("Links are different");
		}
	}

}
