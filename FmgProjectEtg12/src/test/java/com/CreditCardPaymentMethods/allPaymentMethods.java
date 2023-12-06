package com.CreditCardPaymentMethods;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.commonfunctionality.paymentMethods;
import com.testcases.baseClass;

public class allPaymentMethods extends baseClass {
	
	List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));

	
	paymentMethods pm = new paymentMethods();

	//brain tree
	List<WebElement> savedCardsBrainTree= driver.findElements(By.cssSelector("option.js_stored_card"));
	//to add new card though having card 
	List<WebElement> brainTree = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
	
	//BrainTree
	public void BrainTreeMethod() throws InterruptedException {

        
		if(continueasAGuest.size()>0) {
			
 		   //guest user payment
			pm.braintreeGuest12();
			

        }else {
        	//if user is registered and have saved cards then  this if will execute
//        	if(savedCardsBrainTree.size()>0) {
//        		
       		pm.savedCardsBrainTree();
//        	}else {
        		//new user without saved cards in account 
        	logger.info("three");
        		pm.brainTreeReguser();
        	//}
        	
        	
        }

	}
	

	public void addNewCardThoughExistingCards() throws InterruptedException {
		test.info("Adding new card to account though having the saved card.");
		if(brainTree.size()>0) {
			
			pm.addNewCardThoughExistingCardsInBrainTree();
		}
	}
}
