package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']") WebElement lnkMyaccount;

@FindBy(xpath ="//div[@class='panel header']//a[contains(text(),'Sign In')]") WebElement SignIn;


@FindBy(xpath = "//input[@id='search']") WebElement txtSearchbox;


@FindBy(xpath="//button[@title='Search']") WebElement btnSearch;


/*

 @FindBy(xpath="//input[@id='search']") WebElement txtSearchbox;


@FindBy(xpath="//label[@for='search']") WebElement btnSearch;

*/

public void clickMyAccount()
{
	lnkMyaccount.click();
}


public void clickSignIN()
{
	SignIn.click();
}


public void enterProductName(String pName)
{
	
	txtSearchbox.sendKeys(pName); 
}

public void clickSearch() 
{
	btnSearch.click();

}

//


}
