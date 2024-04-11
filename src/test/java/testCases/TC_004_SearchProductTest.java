package testCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import testBase.BaseClass;

public class TC_004_SearchProductTest extends BaseClass {
	

	
	
	@Test
	public void verify_productSearch() throws InterruptedException {
		logger.info(" Starting TC_004_SearchProductTest ");

		try {
			
			HomePage hm=new HomePage(driver);
			
			hm.enterProductName("Driven Backpack");
			
			hm.clickSearch();
			
			SearchPage sp=new SearchPage(driver);
			sp.isProductExist("Driven Backpack");

			Assert.assertEquals(sp.isProductExist("Driven Backpack"),true);

		} catch (Exception e) {
			Assert.fail();
		}

		logger.info(" Finished TC_004_SearchProductTest ");

	}
	
}
