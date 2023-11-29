package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.PageObjects.checkOutPage;
import com.PageObjects.guestUserLoginPage;
import com.testcases.baseClass;

public class shippingAndBillingAddress extends baseClass {
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	 public void clickContinueAsGuest() throws InterruptedException {
	        List<WebElement> continueasAGuest = driver.findElements(By.xpath("//input[@id='email-guest']"));
	        logger.info(continueasAGuest.size());

	        if (continueasAGuest.size() > 0) {
	        	 //if guest checkout label is displayed then only this if condition executes 
	        	 	if(driver.findElement(By.xpath("//input[@id='email-guest']")).isDisplayed()) {
			            guestUserLoginPage guestLoginPage = new guestUserLoginPage(driver);
			           
		                GuestCheckout gc = new GuestCheckout();
		                gc.clickContinueAsGuest();
			            guestLoginPage.clickOnContinueAsGuest();
			            logger.info("Guest user : continue's  as guest");	           
	        	 	}	          
	        }else {
	        	test.info("User is already in login");
	        }
	  
	    }

	    public void selectShippingAddress(checkOutPage cp) throws InterruptedException {
	    	
	    	//selecting shipping address for reg and guest user
	    	 List<WebElement> shippingAddressList = driver.findElements(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
	        
	        	//if user is registered then if condition executes
		        if(shippingAddressList.size()>0) {
		        	
		        	  //if user is register will have RecipientLabel  and  saveShippingAddressList 
		        	  
		        	  List<WebElement> saveShippingAddressList = driver.findElements(By.xpath("//input[@id='addShippingAddressToMyAccount-single-shipping']"));
		        	  	
		        	  //if  save address label is displayed then it is registered user
			        	  if(saveShippingAddressList.size()>0) {
			        		  WebElement shippingToDisplay = driver.findElement(By.xpath("(//h2[contains(text(),'Shipping Address')])[1]"));
			        		  
			        		  if(shippingToDisplay.isDisplayed()) {
				        		  test.info("User is Registered");
				        		  
				        		  WebElement recipientLabel = driver.findElement(By.xpath("//label[contains(text(),'Recipient')]"));
				        		  if( recipientLabel.isDisplayed() && saveShippingAddressList.size()>0) {
				        			  
				        			 // test.info("User is Registered and have saved address");
				        			 // savedAddress();
				        			  
				        			  // though user as saved address to enter  new addres then uncomment this
				        			     test.info("User have saved address but taking new address");
				        			     addNewAddress();
				        			    	        			     
				        			  //Enters name and address			        	
								        shippingAddressDetailsWithName(cp);	
								        	
								       //adds the addres to account
								        saveTheShippingAddress();	
				        			  
				        		
				        		  }else if(saveShippingAddressList.size()>0) {
				        			  test.info("User have no saved cards");
	
							          //Enters name and address			        	
								        	shippingAddressDetailsWithName(cp);	
								        	
								       //adds the addres to account
								        	saveTheShippingAddress();	
				        		  }
			        		  }
				        	}else {	
					        	//if user is guest this else part will execute 
			        			test.info("User is a Guest");
			        			
			        		//Enters name and address	
			        			shippingAddressDetailsWithName(cp);				        					
				        	}			        
		        }
	    }
	    
	   
	    public void selectBillingAddress(checkOutPage cp) throws InterruptedException {
	    	
	    	// Enters the billing address in checkout3 page ,enters billing user first name,last name and billingg addres with phone number
	    	 WebElement billingAddress = driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
	    	 
	    	 if(billingAddress.isDisplayed()) {    		  
	    		 WebElement billingName = driver.findElement(By.id("billingFirstName"));
	    		 if(billingName.isDisplayed()) {
	    			 
				    	Thread.sleep(1000);		    	
				        cp.setBillingFName();		
				        logger.info("Entered fname");
				        
				        Thread.sleep(1000);		
				        cp.setBillingLName();		
				        logger.info("Entered lname");	
				        
				        // enters billing address 
				        billingDetailsOnly();	
				        
				        cp.setBillingPhoneNum();		
				        logger.info("Entered phone number");		        
				        Thread.sleep(2000);
	    		 }
	    	 }	        
	    }
	    
	    public void clickOnContinueBilling(checkOutPage cp) throws InterruptedException {
	    	
	    	//if payment button is available then  then it clicks on payment button	    	
	        List<WebElement> ContinueBillingList = driver.findElements(By.cssSelector(".submit-shipping"));
	        if(ContinueBillingList.size()>0 ) {
	        	 Thread.sleep(2000);
	        	 JavascriptExecutor js = (JavascriptExecutor) driver;
	        	 WebElement ContinueBilling = driver.findElement(By.cssSelector(".submit-shipping"));
	        	 if(ContinueBilling.isEnabled()&& ContinueBilling.isDisplayed()) {
	        		 cp.clickcontinueToBillingButton(driver);
			        logger.info("Clicked on the continue billing button");
	        	 }
		       
	        }

	        // As we are taking the address from google suggestions ,for some Address we don't have city to resolve the city error we are changing the the address 
	        
	        List<WebElement> errorMessageInvalidCityList = driver.findElements(By.xpath("//div[@id='defaultCity']"));
	        
	        if(errorMessageInvalidCityList.size()>0) { 
	        	
		        WebElement errorMessageInvalidCity = driver.findElement(By.xpath("//div[@id='defaultCity']"));
		        
		        if(errorMessageInvalidCity.isDisplayed()) {
		        	
		        boolean isDisplayedinvalidcity = errorMessageInvalidCity.isDisplayed();
		        test.info("The error is " + errorMessageInvalidCity.getText() );

			        if(isDisplayedinvalidcity) {
			        	test.info("User entered the wrong city and we are entering the new address");
			        	test.pass("User entered the wrong city and we are entering the new address");         
			            logger.info("User entered the wrong city and we are entering the new address");
			            
			            shippingAddressDetailsOnly();
			            
			            cp.clickcontinueToBillingButton(driver);
			            logger.info("Clicked on the payment button 2nd time");
			        }
		       }
		        
		    } 
	     
	    }
	    
	  public void shippingAddressDetailsWithName(checkOutPage cp) throws InterruptedException {
		  
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname 
			  Thread.sleep(1000);	
			  WebElement firstName = driver.findElement(By.xpath("//input[@id='shippingFirstNamedefault']"));
			  
			if(firstName.isDisplayed()) {
			//	test.info("Adding New address though having the address");
		        cp.setFisrtName(fname);	
		        logger.info("Entered shipping fname");
		        test.pass("Entered shipping fname");
		        
		        Thread.sleep(1000);	
		        cp.setLastname(lname);		        
		        logger.info("Entered shipping lname");
		        test.pass("Entered shipping lname");
		     
		        //enters shpping address
		        shippingAddressDetailsOnly();
		        
		        Thread.sleep(2000);	
		        cp.setPhone(phonenumber);		        
		        logger.info("Entered phone number");
		        test.pass("Entered phone number");
		        Thread.sleep(2000);   
		        
			}
	  }
	  
	  
	  public void  savedAddress	() throws InterruptedException {
		  //click on recipent 
		  WebElement recipient = driver.findElement(By.id("shipmentSelector-default"));
		  recipient.click();
		  
		  Thread.sleep(1000);
		  List<WebElement> savedAddress = driver.findElements(By.xpath("//option[contains(@value,'ab_')]"));
		  int countOfSavedAddress = savedAddress.size();
		  // Generate a random index to select a random option
          int randomIndex = new Random().nextInt(countOfSavedAddress);

          // Select the random option
          WebElement randomSavedAddress = savedAddress.get(randomIndex);
          randomSavedAddress.click(); 
		  
		  
	  }
	  
	  public void addNewAddress() throws InterruptedException {
		//click on recipent 
		  WebElement recipient = driver.findElement(By.id("shipmentSelector-default"));
		  recipient.click();
		  
		  Thread.sleep(1000);
		  WebElement addNewAddress = driver.findElement(By.xpath("//option[@value='new']"));
		  addNewAddress.click();
	  }
	  
		  public void shippingAddressDetailsOnly() throws InterruptedException{
			  
			  //to get the random address -by sending the 3 numbers to address element for shipping address
			  
			  WebElement shippingAddress = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));
	      	
	      	  Random random = new Random();
	      	  
	          int randomNumber =  123; // Generates a random number between 100 and 999      random.nextInt(900) + 100
	          address = String.valueOf(randomNumber);
	          Thread.sleep(1000);
	          shippingAddress.sendKeys(address);
	          
	          //to perform the keyboard activities
	          WebElement shipping = driver.switchTo().activeElement(); 
	          
	          Thread.sleep(1000);
	          shipping.sendKeys(Keys.ARROW_DOWN);
	          
	         // Thread.sleep(1000);
	          //shipping.sendKeys(Keys.ARROW_DOWN);
	          shipping.sendKeys(Keys.ENTER);
	          
	        //  System.out.println("The address entered is " +shipping.getText());
	          logger.info("Entered shipping address");
	          test.info("Entered shipping address");
		  
		  }
		  
		  public void billingDetailsOnly() throws InterruptedException {
			
			  	//to get the random address -by sending the 3 numbers to address element for billing address
			  	WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));		
			  
		        Random random = new Random();
		        
		        int randomNumber =567; // Generates a random number between 100 and 999		
		        //random.nextInt(900) + 100
		        address = String.valueOf(randomNumber);		
		        		
		        Address1.sendKeys(address);	
		        
		        //to perform the keyboard activities
		        WebElement Address11 = driver.switchTo().activeElement();
		        Thread.sleep(1000);
		        
		        Address11.sendKeys(Keys.ARROW_DOWN);		
		        Thread.sleep(1000);	
		        
		        Address11.sendKeys(Keys.ARROW_DOWN);		
		        Address11.sendKeys(Keys.ENTER);		
		        Thread.sleep(2000);	
		  }
		  
		  public void saveTheShippingAddress() {
			  
			  //if user is registered and entered new address then if user want to save the address then below condition executes
			  List<WebElement> saveShippingAddressList = driver.findElements(By.id("addShippingAddressToMyAccount-single-shipping"));
			  
			  if(saveShippingAddressList.size()>0) {
				  
					  WebElement saveShippingAddress = driver.findElement(By.id("addShippingAddressToMyAccount-single-shipping"));
					  
					  if(saveShippingAddress.isDisplayed()) {
						  
						  js.executeScript("arguments[0].click();",saveShippingAddress);
					  }
			  }

		  }	
		  
		  public void addNewAddress(checkOutPage cp) throws InterruptedException {
			  //though user have address 
			  WebElement addNewAddress = driver.findElement(By.xpath("(//button[contains(@class,'btn-add-new')])[1]"));
	      	if(addNewAddress.isDisplayed()) {
	      		
	      		JavascriptExecutor js = (JavascriptExecutor) driver;
	  	    	js.executeScript("arguments[0].click();",  addNewAddress);		
	  	    	
	  	    	//shipping address with name 
	  	    	shippingAddressDetailsWithName(cp);
	  	    	
	      	}
		  }
		  

			// Shipping method selection randomly
			    public  void selectShippingRandomly() throws InterruptedException {
			    	Thread.sleep(5000);
			        List<WebElement> TotalShippingMethods = driver.findElements(By.xpath("//div[contains(@class,'shipping-method-list')]//input"));
			        int countofShippingMethods = TotalShippingMethods.size();
			        if(countofShippingMethods>0) {
			        	logger.info("Total Shipping count is " + countofShippingMethods);
			            Random random = new Random();
			            int randomShippingMethod = random.nextInt(countofShippingMethods) + 1;
			            logger.info("Randomly selected shipping Method number " + randomShippingMethod);
			 
			            WebElement getNotApplicableAddress = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='shipping-cost'])[" + randomShippingMethod + "]"));
			            String sippingMethodAmount = getNotApplicableAddress.getText();
			            logger.info(sippingMethodAmount);
			            String expetedText = "N/A";
			            if (sippingMethodAmount.equals(expetedText)) {
			                logger.info("This Shipping method is not applicable");
			                selectShippingRandomly();
			            } else {
			                WebElement shippingMethod = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//input)[" + randomShippingMethod + "]"));
			                JavascriptExecutor js = (JavascriptExecutor) driver;
			                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMethod);
			                js.executeScript("arguments[0].click();", shippingMethod);
			 
			                WebElement shippingMethodNames = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='display-name'])[" + randomShippingMethod + "]"));
			                String shippingMethodName = shippingMethodNames.getText();
			                shippingMethodtitle = shippingMethodName;
			                prviousShippingMethod = shippingMethodName;
			 
			                WebElement shippingMethodDays = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='text-muted arrival-time'])[" + randomShippingMethod + "]"));
			                String sippingMethodDays = shippingMethodDays.getText();
			 
			                logger.info("Selected Shipping Method Name is "+shippingMethodName+" "+sippingMethodDays);
			                test.pass("Selected Shipping Method Name is "+shippingMethodName+" "+sippingMethodDays);    
			            }
			        }
			        
			    }
}
