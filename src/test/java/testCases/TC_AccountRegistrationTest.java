package testCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TC_AccountRegistrationTest extends BaseClass{
	
	
	@Test(groups= {"regression","FirstTestNG"})
	public void verify_account_registration()
	{
		logger.info("***** Starting TC_AccountRegistrationTest *****");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("**** Clicked On Create an AccountLink ****");
		
		logger.info("------- Entering Customer Details -------");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		/*
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");
		
		String password = randomAlphaNumeric();
		regpage.setPassword(password);
		regpage.setConfirmPassword(password);
		*/
		
		regpage.setFirstName(p.getProperty("FirstName"));
		regpage.setLastName(p.getProperty("LastName"));
		regpage.setEmail(p.getProperty("email"));
		regpage.setPassword(p.getProperty("password"));
		regpage.setConfirmPassword(p.getProperty("ConfirmPassword"));
		
		
		regpage.CreateAccount();
		logger.info("Clicked on Create an AccountButton");

		String confirmationMessage = regpage.getConfirmationMsg();
		
		logger.info(" Validating Expecting MSG ");
		
		
		Assert.assertEquals(confirmationMessage, "Thank you for registering with Main Website Store.");
		
		
		
		
		 // ---------- AssertionPass----------
		if(confirmationMessage.equals("Thank you for registering with Main Website Store."))
		{
			logger.info("Test Pass..");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("Test Fail...");
			Assert.fail();
		}
		
		/*
		  ---------- Assertion Fails ----------
		if(confirmationMessage.equals("Thank you for registering with Main Website Store.."))
		{
			logger.info("Test Pass..");
			Assert.assertTrue(true);
		}
		
		else
		{
			logger.error("Test Fail...");
			Assert.fail();
		}
		
		*/
		
		
		/* Making the assertion fail
		Assert.assertEquals(confirmationMessage, "Thank you for registering with Main Website Store..");
		*/
		
		
		
		}
		catch(Exception e)
		{
			logger.error("Test Failed");
			Assert.fail();
		}
		
		logger.info("******* Finished TC_AccountRegistrationTest **********");
		
	}
		
}





