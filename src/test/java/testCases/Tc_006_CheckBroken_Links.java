package testCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_006_CheckBroken_Links {

	public static void main(String[] args) throws InterruptedException, IOException {

		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		List <WebElement> mylinks = driver.findElements(By.tagName("a"));

		System.out.println(" Total Links:" + mylinks.size());

		int brokenlinks = 0;

		for(WebElement links : mylinks )
		{
			String hrefAttributevalue = links.getAttribute("href");

			if(hrefAttributevalue == null || hrefAttributevalue.isEmpty())
			{
				System.out.println("href attribute value is  empty");
				continue;
			}

			URL linkurl = new URL(hrefAttributevalue);

			HttpURLConnection conn = 	(HttpURLConnection)linkurl.openConnection();

			conn.connect();

			if(conn.getResponseCode() >= 400)
			{
				System.out.println(hrefAttributevalue+  " "  + "--->it is a broken Link");
				brokenlinks++;
			}
			else
			{
				System.out.println(hrefAttributevalue + " " + "--->Not a broken link");
			}

		}
		
		System.out.println(" Total broken links " + brokenlinks);

	}
}
