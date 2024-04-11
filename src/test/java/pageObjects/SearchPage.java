package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage
{   

	public SearchPage(WebDriver driver)
	{
		super(driver);
	}



	@FindBy(xpath="//span[normalize-space()='Gear']") List<WebElement> dropdownProducts;

	@FindBy(xpath="//span[normalize-space()='Bags']") List<WebElement> bagsproducts;

	@FindBy(xpath = "//a[@class='product-item-link'][normalize-space()='Driven Backpack']") WebElement item;

	@FindBy(xpath = "//span[normalize-space()='Add to Cart']") WebElement AddToCartbutton;
	
	@FindBy(xpath="//div[contains(text(),'You added Driven Backpack to your shopping cart.')]") WebElement cnfMsg;
	
	@FindBy(xpath = "//a[@class='action showcart active']") WebElement cartlogo;
	
	@FindBy(xpath = "//button[@id='top-cart-btn-checkout']") WebElement proceedtocheckout;
	
	@FindBy(xpath = "//label[@for='cart-item-737815-qty']") WebElement quantity;
	
	
	
	public boolean isProductExist(String productName)
	{
		boolean flag=false;
		for(WebElement product:dropdownProducts)
		{				
			if(product.getAttribute("title").equals(productName))
			{
			flag=true;
			break;
			}
		}
		
		return flag;
	
	}
	
	public void selectProduct(String productName)
	{
		for(WebElement product:dropdownProducts)
		{				
			if(product.getAttribute("title").equals(productName))
			{
				product.click();
			}
		}
	
	}
	
	public void setQuantity(String qty)
	{
		quantity.clear();
		quantity.sendKeys(qty);
	}
	
	public void addToCart()
	{
		AddToCartbutton.click();
	}
	
	public boolean checkConfMsg()
	{
		try
		{
		return cnfMsg.isDisplayed();
		}
		catch(Exception e)
		{
			return false;
		}
	}	
	
}