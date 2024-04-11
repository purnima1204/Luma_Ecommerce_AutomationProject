package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);                             
	}

	@FindBy(xpath= "//span[@class='base']")     // MyAccount Page heading
	WebElement msgHeading;
	
	@FindBy(xpath = "//span[@class='customer-name active']//button[@type='button']") WebElement dropdown;
	
	@FindBy(xpath = "//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")  WebElement lnkLogout;
	

	public boolean isMyAccountPageExists()   // MyAccount Page heading display status
	{
		try {
			return (msgHeading.isDisplayed());
		} catch (Exception e) {
			return (false);
		}
	}
	
	public void clickDropdown()
	{
		dropdown.click();
	}

	public void clickLogout() {
		lnkLogout.click();

	}
	
}

