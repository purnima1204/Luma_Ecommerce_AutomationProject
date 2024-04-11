package pageObjects;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}


@FindBy(xpath="//input[@id='firstname']")                   WebElement firstName;
@FindBy(xpath="//input[@id='lastname']")                    WebElement lastName;
@FindBy(xpath="//input[@id='email_address']")               WebElement Email;
@FindBy(xpath="//input[@id='password']")                    WebElement password;
@FindBy(xpath="//input[@id='password-confirmation']")       WebElement confirmPassword;
@FindBy(xpath="//button[@title='Create an Account']")       WebElement createAnAccount;
	
@FindBy(css=".message-success.success.message")             WebElement msgConfirmation;

	// css = "div[data-bind='html: $parent.prepareMessageForHtml(message.text)']"

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);

	}
	        //button[@title='Create an Account']//span[contains(text(),'Create an Account')]
	public void setLastName(String lname) {
		lastName.sendKeys(lname);

	}

	public void setEmail(String email) {
		Email.sendKeys(email);

	}

	public void setPassword(String pwd) {
		password.sendKeys(pwd);

	}

	public void setConfirmPassword(String pwd) {
		confirmPassword.sendKeys(pwd);

	}

	public void CreateAccount() {

		createAnAccount.click();
		
		/*
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(CreateAccount)).click();
		
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
	   js.executeScript("arguments[0].click();", CreateAccount);
		
        */	

	}
	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
}

