package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.paymentpPage;
import com.testcases.baseClass;

public class paymentMethods extends baseClass{
	
	paymentpPage pp = new paymentpPage(driver);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public  void braintreeGuest12() throws InterruptedException {

		test.info("Entering credit card details");
		pp.setcardholdername(driver);
		logger.info("entered card name");
		test.pass("entered card name");
		pp.setcardnumber(driver);
		logger.info("entered card number");
		test.pass("entered card number");
		pp.setcardcvv(driver);
		logger.info("entered cvv");
		test.pass("entered cvv");
		pp.setcardexp(driver);
		logger.info("entered exp");
		test.pass("entered exp");
}
	   //brain tree payment method of guest user
	public  void braintreeGuest() throws InterruptedException {

		List<WebElement> creditCardFormList= driver.findElements(By.xpath("//input[@id = 'cardholder-name']"));
		if(creditCardFormList.size()>0) {
			WebElement creditCardForm= driver.findElement(By.xpath("//input[@id = 'cardholder-name']"));
			if(creditCardForm.isDisplayed()) {
				test.info("Entering credit card details");
				pp.setcardholdername(driver);
				logger.info("entered card name");
				test.pass("entered card name");
				pp.setcardnumber(driver);
				logger.info("entered card number");
				test.pass("entered card number");
				pp.setcardcvv(driver);
				logger.info("entered cvv");
				test.pass("entered cvv");
				pp.setcardexp(driver);
				logger.info("entered exp");
				test.pass("entered exp");
			}
		}		
	}		
		//register user and select the new card and save the card
		public void brainTreeReguser() throws InterruptedException {

	    	pp.selectnewcardindropdown();  
			logger.info("Selectd the new card");
			test.pass("Selectd the new card");
			
			braintreeGuest();
			
		}
		
		public void savedCardsBrainTree() throws InterruptedException {
			//clicks on drop down
			WebElement savedCardsBrainTree= driver.findElement(By.cssSelector("option.js_stored_card"));
		
			JavascriptExecutor js = (JavascriptExecutor) driver;

	       
			WebElement savedCardsDropDown= driver.findElement(By.id("braintreeCreditCardList"));
			// savedCardsDropDown.click();
			
			//randomizing the saved cards
			List<WebElement> countOfSavedCardsInBrainTree= driver.findElements(By.cssSelector("option.js_stored_card"));
			
			if (!countOfSavedCardsInBrainTree.isEmpty()) {
				test.info("User have saved cards");
				
				/* 	Actions action = new Actions(driver);
		    	action.moveToElement(savedCardsDropDown).perform();
		    	Thread.sleep(5000);
		    	WebElement savedCardsInBrainTree= driver.findElement(By.cssSelector("option.js_stored_card"));
		    	savedCardsInBrainTree.click();
    		// Generate a random index within the bounds of the list size
				Select select = new Select(savedCardsBrainTree);

		     // Get all the options in the dropdown
		        List<WebElement> options = select.getOptions();
				
		     // Generate a random index to select an option
    		    Random rand = new Random();    		    
    		    int randomIndex = rand.nextInt(options.size());
    		   

    		  //Click the random WebElement
    		    Thread.sleep(1000);
    		    //js.executeScript("arguments[0].click();", countOfSavedCardsInBrainTree.get(randomIndex));	
    		    countOfSavedCardsInBrainTree.get(randomIndex).click();	 		   
    		    System.out.println("Selected random card");	*/
    		    
		    	}else {
		    		test.info("No used cards for user");
		    	//enters the card details
		    		braintreeGuest();
		    	}
			
		}
		public void brainTreeDropDown() throws InterruptedException {
			//drop new new
			pp.selectnewcardindropdown();
		}
		
		public void addNewCardThoughExistingCardsInBrainTree() throws InterruptedException {
			//clicks on new card drop down
			pp.selectnewcardindropdown();
			
			// enter the card details into input box
			braintreeGuest();
		}
		
		
		
}
