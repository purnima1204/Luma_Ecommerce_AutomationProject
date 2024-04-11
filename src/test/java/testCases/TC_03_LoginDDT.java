package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


public class TC_03_LoginDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void verify_loginDDT(String email, String password, String Result)
	{
		logger.info("**** Starting TC_03_LoginDDT *****");

		try
		{
			//Home page
			HomePage hp=new HomePage(driver);
			hp.clickMyAccount();
			hp.clickSignIN(); 
			


			//Login page
			LoginPage lp=new LoginPage(driver);
			logger.info("Entering valid email and password..");
			lp.setEmail(email);
			lp.setPassword(password);
			lp.clickLogin();
			
   

			//My Account Page
			MyAccountPage page =new MyAccountPage(driver);
			
		//page.clickDropdown();
			
		  //page.clickLogout();

			boolean targetPage= page.isMyAccountPageExists();

			//	Assert.assertEquals(targetPage, true,"Login failed");		

			if(Result.equalsIgnoreCase("Valid"))
			{
				if(targetPage == true)
				{   
					page.clickLogout();
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(Result.equalsIgnoreCase("Invalid"))
			{
				if(targetPage == true)
				{
					page.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
		}

		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("**** Finished TC_03_DDT ******");
	}
}


