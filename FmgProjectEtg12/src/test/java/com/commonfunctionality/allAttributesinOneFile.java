package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PageObjects.NavigationProcess;
import com.PageObjects.productDescriptionPage;
import com.PageObjects.productListingPage;
import com.PageObjects.viewCartPage;
import com.Scenarios.pdpPage;
import com.testcases.baseClass;

public class allAttributesinOneFile extends baseClass{
	
	
	public static  void selectTheAttributesInPdp(WebDriver driver) throws InterruptedException {
		
		//selecting attributes from the  pdp page by checking the condition 
		allAttributes();
		Thread.sleep(2000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
     
	
	//checking the  add to cart enabled and  in stock
    		List<WebElement> Stocksize = driver.findElements(By.xpath("//span[contains(text(),'Sold Out')]"));
     		test.info("Verify that the product is avaliable");
     	    // Check if the element is present
     	    if (Stocksize.size() <= 0) {
     	    	test.pass("The product is avaliable");
     	    	
     	    	List<WebElement> addtoCartButton = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]"));
     	    
     	    	//product Name
     	    	productDescriptionPage pdp = new productDescriptionPage(driver);
     	    	pdp.productNameValidation();
     			 
     	    	//addtocartbutton is enabled
     	    	test.info("Verify that the product is avaliable");
     	    	if(addtoCartButton.size()>0) {
     	    		test.info("Verify that the add to cart button");
     	    		logger.info("add to cart  button enabled");
     	    		WebElement addtoCartButtonClick = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));     
     	            js.executeScript("arguments[0].click();", addtoCartButtonClick);
     	            test.pass("Successfully clicked on the add to cart button");
     	    		Thread.sleep(2000);
     	    	}
      
     	    }else {
    	 
    	 	//if the prodcut is outof stock then it will search for new prodcut by selecting random menu and random product
     	    	logger.info("Product is out of stock so searching for new product So it is displaying is Notify me ");	  
     	    	test.info("Product is out of stock so searching for new product So it is displaying is Notify me ");	    	
        	 	
    	 	
     	    	WebElement notifyMe = driver.findElement(By.xpath("//input[contains(@class,'notify-product-input')]")); 
     	    	WebElement notifyMeButton = driver.findElement(By.xpath("//button[contains(@class,'notify-product-button')]"));
     	    	
     	    	//invalid message in pdp page for notify me 
     	    	inValidErrorMsgInNotifyMe();
     	    	
     	    	// notifing the outstock to user
     	    	notifyMe.sendKeys("akhila.m@etg.digital");
     	    	notifyMeButton.click();
     	    	
     	    // Select a random menu item
     	    	NavigationProcess navProcess = new NavigationProcess(driver);
		           // Select a random menu item
	        	 navProcess.selectRandomMenu(driver);
		           
		           //Selects random product
		           productListingPage.selectRandomProduct();
		           
		   		   //adding produuct to cart
		           allAttributesinOneFile.selectTheAttributesInPdp(driver);
     	    }	    
	    }
	
	public static void inValidErrorMsgInNotifyMe() {
		// loacting notify m button and input field
			WebElement notifyMe = driver.findElement(By.xpath("//input[contains(@class,'notify-product-input')]")); 
	    	WebElement notifyMeButton = driver.findElement(By.xpath("//button[contains(@class,'notify-product-button')]"));
	    	notifyMe.sendKeys("");
	    	notifyMeButton.click();
	    	
	    	WebElement invalidMailError = driver.findElement(By.xpath("(//div[contains(text(),'Please enter a valid email address.')])[1]"));
	    	Boolean invalidMailErrorText= invalidMailError.isDisplayed();
	    	if(invalidMailErrorText) {
	    		test.pass("Error message is displayed for no email is entered or for invalid email id");
	    		logger.info("Error message is displayed for no email is entered or for invalid email id");
	    	}else {
	    		test.fail("No Error message is displayed for no email is entered or for invalid email id");
	    		logger.info(" NO Error message is displayed for no email is entered or for invalid email id");
	    	}
	}

	public static void allAttributes() throws InterruptedException {
		
		//fetching the package size 
			List <WebElement> packageSizeList= driver.findElements(By.id("package-qty-feet-1"));
			System.out.println("The package size  " +packageSizeList.size());

		 	// checkoing the availbility of package size and randomizing the varities and selecting them
		 		if(packageSizeList.size()>0) {			
		 			if (!packageSizeList.isEmpty()) { 							
		 				List<WebElement> elementList = driver.findElements(By.cssSelector(".slick-slide.slick-active .single-custom-attribute"));
		 				Random random = new Random();
		 				int randomIndex = random.nextInt(elementList.size());
		 				WebElement randomElement = elementList.get(randomIndex);
		 				randomElement.click();
		 			      
		 			}
			}
	}

}


