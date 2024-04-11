package testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_009_010_ActionsMouseHover_Selecting_option_Header_AddingproductTocart {
	
	
	public static void main(String[] args) throws InterruptedException
	{


		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

	  
		driver.get("https://magento.softwaretestingboard.com/");

		driver.manage().window().maximize();
		

	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    
	    
	    //Selecting women option using Actions
	        Actions action = new Actions(driver);
	        WebElement Women = driver.findElement(By.xpath(".//nav//ul//li[2]"));
	        action.moveToElement(Women).build().perform();
	        Thread.sleep(4000);
	        WebElement Women_Tops = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]"));
	        action.moveToElement(Women_Tops).build().perform();
	        Thread.sleep(4000);
	        WebElement Jacket = driver.findElement(By.xpath(".//nav//ul//li[2]//ul//li[1]//ul//li[1]"));
	        action.moveToElement(Jacket).click().perform();
	        Thread.sleep(4000);
	        
	        driver.findElement(By.xpath("//a[normalize-space()='Juno Jacket']")).click();
	        
	        
	        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-168']")).click();
	        
	        Thread.sleep(2000);
	        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-50']")).click();
	        
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//input[@id='qty']")).clear();
	        
	        Thread.sleep(2000);
	        
	        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
	        
	        driver.findElement(By.xpath("//span[normalize-space()='Add to Cart']")).click();
	        
	        Thread.sleep(5000);
	        
	        String msg = "You added Juno Jacket to your shopping cart.";
	        
	        if(msg.equals("You added Juno Jacket to your shopping cart."))
	        {
	        	System.out.println("product Added to cart...");
	        }
	        
	        else
	        {
	        	System.out.println("Product Not added");
	        }   

	}
}

