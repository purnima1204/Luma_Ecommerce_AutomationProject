package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_02_LoginTest extends BaseClass{
	
	
	@Test(groups={"sanity","FirstTestNG"})
	
	public void verify_login()
	{
		logger.info("**** Starting TC_02_LoginTest  ****");
		logger.debug("capturing application debug logs....");
		
		try
		{
		//Home page
		HomePage hp=new HomePage(driver);
		hp.clickMyAccount();
		logger.info("clicked on myaccount link on the home page..");
		hp.clickSignIN(); 
		logger.info("clicked on SIGNIN link..");
		
		//Login page
		LoginPage lp=new LoginPage(driver);
		logger.info("Entering valid email and password..");
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		logger.info("clicked on login button..");
		
		//My Account Page
		MyAccountPage page =new MyAccountPage(driver);
				
		boolean targetPage= page.isMyAccountPageExists();
		
		Assert.assertEquals(targetPage, true,"Login failed");		
		
		}
		
		
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
		
		logger.info("**** Finished TC_02_LoginTest  ****");
	}
}
