package com.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PaymentProccess.CheckOutProcessByPayPal;
import com.testcases.baseClass;

public class FooterSection extends baseClass{
	 
	@Test
	public void footerShopByCategoryies ()throws InterruptedException {
		
		//launching the browser and passing the url into it
			launchBrowsering lb = new launchBrowsering();
			
		
			
		List<WebElement> shopByCategoryInFooter = driver.findElements(By.cssSelector("div#shop-category li"));
		
		Thread.sleep(3000);
		// Check if the list is not empty
        if (!shopByCategoryInFooter.isEmpty()) {
        //scrolls to this element 	
          WebElement shopByCategoryInFooterScroll = driver.findElement(By.cssSelector("div#shop-category li"));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shopByCategoryInFooterScroll);	
   
          // lists the total elements 
          List<WebElement> elements = driver.findElements(By.xpath("//div[@id='shop-category']//li"));
          
          // Get the total count of top-level menu elements.
          int count = elements.size();
          if (count > 0) {
  	        // Create a random number generator.
  	        Random random = new Random();
  	        
  	        // Generate a random index to select a top-level menu item.
  	        int randomNumbermenu = random.nextInt(count) + 1;
  	
  	        // Find all the submenu elements for the randomly selected top-level menu item.
  	        WebElement elementsofdrop = driver.findElement(By.xpath("(//div[@id='shop-category']//li)[" + randomNumbermenu + "]"));
  	        System.out.println(elementsofdrop.getText());
  	     // elementsofdrop.click();
  	        Thread.sleep(2000);
  	      Actions action = new Actions(driver);
	        action.moveToElement(elementsofdrop).perform();
	  	    JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", elementsofdrop);
  	        
  	        
          }   
        }
	}
}
