package com.testcases;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.FreeCatalog;


public class Footer extends baseClass{

	 @Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	public void footer() throws InterruptedException {
		  
	       
       if(isBrowserLaunched){
        
			
		//subscription
			subscription();
		
		//pagination of about us
			clickOnAboutUs();
		
		//allAssortablePricing	
			allAssortablePricingPagination();
			
		//contact us pagination
			//contactUsPagination();
		
		//free catalog footer
			freeCatalogFromFooter();
			
		//Precious Metal Pricing
			preciousMetalPricingInformation();
			
		//privacyPolicy
			 privacyPolicy();
			 
		//Returns and Exchanges
			 returnsandExchanges();
			 
		//shippingInformation
			 shippingInformation();
			 
		//special orders
			 specialorders();
       }
	}
	
	public void subscription() {
		//submit the subscription		
		//Faker faker = new Faker();
        String fakeEmail ="akhila.m";
        String email = fakeEmail+ "@etg.digital";
        
      
        WebElement subscriptionField = driver.findElement(By.id("dwfrm_mcsubscribe_email"));
        subscriptionField.sendKeys(email );
        test.info("Entered email in subscription");
        
        WebElement clickSubscription = driver.findElement(By.xpath("//button[contains(@class,'subscribe-email')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubscription);
    	js.executeScript("arguments[0].click();",clickSubscription);
        test.info("Submitted the email in subscription");
        
       // Thread.sleep(6000);
        //addtoCartValidation.validatingSubscription(driver);
	}
	
	public void  clickOnAboutUs() throws InterruptedException {
		  Thread.sleep(5000);
		  WebElement aboutUsLink= driver.findElement(By.xpath("//a[contains(text(),'About Us')]"));
		  JavascriptExecutor js = (JavascriptExecutor) driver;
	    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
	    	js.executeScript("arguments[0].click();",aboutUsLink);
		  //aboutUsLink.click();
		  test.info("Verifying the pagination of about us"); 
		  Thread.sleep(2000);
		  //page naviagtion of about us
		  WebElement aboutUsPagination= driver.findElement(By.xpath("//div[contains(text(),'About Us')]"));
		  String actualPagination = aboutUsPagination.getText();
		  String expectedPagination="About Us";
		  
		  if(actualPagination.equals(expectedPagination)) {		
			  		test.pass("Successfully naviagted to about us page");
			        logger.info("Successfully naviagted to about us page");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }		 
	}	
	
	
	public void allAssortablePricingPagination() {
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement assortablePricingLink= driver.findElement(By.xpath("//a[@title='All-Assortable Pricing']"));
		 js.executeScript("arguments[0].click();",assortablePricingLink);
		  
		  //page naviagtion of about us
		 test.info("Verifying the pagination of All Assortable Pricing"); 
		  WebElement assortablePricingPagination= driver.findElement(By.xpath("//h1[contains(text(),'All Assortable Pricing')]"));
		  String actualPagination = assortablePricingPagination.getText();
		  String expectedPagination= "All Assortable Pricing";
		  
		  if(actualPagination.equals(expectedPagination)) {		
			  		test.pass("Successfully naviagted to AssortablePricing page");
			        logger.info("Successfully naviagted to  AssortablePricing page");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }	
	}
	
	public void contactUsPagination() throws InterruptedException {
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement contactUsLink= driver.findElement(By.xpath("//a[@title='Contact Us']"));
		 js.executeScript("arguments[0].click();",contactUsLink);
		  
		  //page naviagtion of contact us 
		  WebElement contactUsPagination= driver.findElement(By.xpath("//h1[contains(text(),'Contact Us')]"));
		  String actualPagination = contactUsPagination.getText();
		  String expectedPagination= "Contact Us";
		  
		  test.info("Verifying the pagination of contact Us"); 
		  if(actualPagination.equals(expectedPagination)) {		
			  		test.pass("Successfully naviagted to Contact Us");
			        logger.info("Successfully naviagted to Contact Us");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }	
		  
		  //question in fmg
		  WebElement questionsInfmg= driver.findElement(By.xpath("//a[contains(text(),'Questions@firemtn.com')]"));
		  questionsInfmg.click();
		  
		  Thread.sleep(3000);
		  //page naviagtion of contact us 
		  WebElement questionPagination= driver.findElement(By.xpath(" //h1[contains(text(),'Questions')]"));
		  String actualQuestionPagination = questionPagination.getText();
		  String expectedQuestionPagination="Questions";
		  
		  if(actualQuestionPagination.equals(expectedQuestionPagination)) {		
			  		test.pass("Successfully naviagted to Questions");
			        logger.info("Successfully naviagted to Questions");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }	
		  
	
		   Thread.sleep(5000);
		// If the component is within an iframe, switch to it
		   driver.switchTo().frame("iframe-id-or-name");

		   // Interact with the elements inside the iframe

		   // Switch back to the default content
		   driver.switchTo().defaultContent();
		  // Find and interact with the elements.
		   WebElement parentField = driver.findElement(By.id("LightningComponentid"));
		   
		   WebElement categoryField = parentField.findElement(By.xpath("(//span[@class='slds-truncate'])[1]"));
	        categoryField.click();
	        
	     //Find the dropdown element by its class (you can use other locators)
	        WebElement dropdownElement = driver.findElement(By.cssSelector("lightning-base-combobox"));

	        // Create a Select object if the dropdown is a <select> element
	        Select dropdown = new Select(dropdownElement);

	        // Get all the options within the dropdown
	        List<WebElement> options = dropdown.getOptions();

	        // Generate a random index to select an option
	        Random rand = new Random();
	        int randomIndex = rand.nextInt(options.size());

	        // Select the random option
	        dropdown.selectByIndex(randomIndex);

	        // You can then select an option from the dropdown list if available.
	        String fakeEmail ="akhila.m";
	        String email = fakeEmail+ "@etg.digital";
	        WebElement emailField = driver.findElement(By.id("input-21"));
	        emailField.sendKeys(email);

	        WebElement orderField = driver.findElement(By.id("input-31"));
	        orderField.sendKeys("R000011848");

	        WebElement nameField = driver.findElement(By.id("input-37"));
	        nameField.sendKeys("John Doe");

	        WebElement questionCommentField = driver.findElement(By.id("input-46"));
	        questionCommentField.sendKeys("This is a test question/comment.");

	        // You can also handle file uploads, but it's a bit more complex. 
	        // You'll need to use the input type="file" element and sendKeys to set the file path.

	        // Submit the form.
	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Send')]"));
	        submitButton.click();
	}
	
	public void freeCatalogFromFooter() throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement freeCatalog = driver.findElement(By.xpath("//a[@title='Free Catalog']"));
			js.executeScript("arguments[0].click();",freeCatalog);
		 
			
		 FreeCatalog catalog= new  FreeCatalog();
		 catalog.freeCatalogPage();
		 
		 
	}
	
	public void preciousMetalPricingInformation() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement metalPricingLink = driver.findElement(By.xpath("//a[@title='Precious Metal Pricing Information']"));
		 js.executeScript("arguments[0].click();",metalPricingLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
		 test.info("Verifying the pagination of Precious Metal Pricing"); 
		 WebElement metalPricingPage = driver.findElement(By.xpath("//h1[contains(text(),'Precious Metal Pricing')]"));
		 
		
		  String actualmetalPricinPagination =metalPricingPage.getText();
		  String expectedmetalPricinPagination="Precious Metal Pricing";
		  
		  if(actualmetalPricinPagination.equals(expectedmetalPricinPagination)) {		
			  		test.pass("Successfully naviagted to metalPricingPage ");
			        logger.info("Successfully naviagted to metalPricingPage");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedmetalPricinPagination + " " + "  but found" + " " +actualmetalPricinPagination+ " ");
			        logger.info("Click failed");
			    }	

	}
	public void privacyPolicy() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[@title='Privacy Policy']"));
		 js.executeScript("arguments[0].click();",privacyPolicyLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
		 test.info("Verifying the pagination of Privacy Policy "); 
		 WebElement privacyPolicyPage = driver.findElement(By.xpath(" //h1[contains(text(),'Privacy Policy')]"));
		 
		
		  String actualprivacyPolicyPagination =privacyPolicyPage.getText();
		  String expectedprivacyPolicyPagination= "Privacy Policy";
		  
		  if(actualprivacyPolicyPagination.equals(expectedprivacyPolicyPagination)) {		
			  		test.pass("Successfully naviagted to  Privacy Policy Page ");
			        logger.info("Successfully naviagted to Privacy Policy Page");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedprivacyPolicyPagination + " " + "  but found" + " " +actualprivacyPolicyPagination+ " ");
			        logger.info("Click failed");
			    }	
	}
	
	public void productSafety() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement  productSafetyLink = driver.findElement(By.xpath("//a[contains(text(),'Product Safety')]"));
		 js.executeScript("arguments[0].click();", productSafetyLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
		 test.info("Verifying the pagination of Product Safety and Restrictions"); 
		 WebElement productSafetyPage = driver.findElement(By.xpath(" //h1[contains(text(),'Product Safety and Restrictions')]"));
		 
		
		  String actualproductSafetyPagination =productSafetyPage.getText();
		  String expectedproductSafetyPagination= "Product Safety and Restrictions";
		  
		  if(actualproductSafetyPagination.equals( expectedproductSafetyPagination)) {		
			  		test.pass("Successfully naviagted to Product Safety and Restrictions page");
			        logger.info("Successfully naviagted to Product Safety and Restrictions page");
			    } else {
			        test.fail( "The pagination does not match expected " +  expectedproductSafetyPagination + " " + "  but found" + " " +actualproductSafetyPagination+ " ");
			        logger.info("Click failed");
			    }	
	}
	
	public void returnsandExchanges() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement  returnsandExchangesLink = driver.findElement(By.xpath("//a[contains(text(),'Returns and Exchanges')]"));
		 js.executeScript("arguments[0].click();", returnsandExchangesLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
		 test.info("Verifying the pagination of Returns and Exchanges"); 
		 WebElement returnsandExchangesPage = driver.findElement(By.xpath("//h1[contains(text(),'Returns and Exchanges')]"));
		 
		
		  String actualreturnsandExchangesPagination =returnsandExchangesPage.getText();
		  String expectedreturnsandExchangesPagePagination= "Returns and Exchanges";
		  
		  if(actualreturnsandExchangesPagination.equals(expectedreturnsandExchangesPagePagination)) {		
			  		test.pass("Successfully naviagted to Returns and Exchanges page");
			        logger.info("Successfully naviagted to Returns and Exchanges page");
			    } else {
			        test.fail( "The pagination does not match expected " +  expectedreturnsandExchangesPagePagination + " " + "  but found" + " " +actualreturnsandExchangesPagination+ " ");
			        logger.info("Click failed");
			    }	
	}
	
	public void shippingInformation() throws InterruptedException {
		
	
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement  shippingInformationLink = driver.findElement(By.xpath("(//a[contains(text(),'Shipping Information')])[2]"));
		 js.executeScript("arguments[0].click();", shippingInformationLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
			test.info("Verifying the pagination of Shipping Information"); 
		 WebElement shippingInformationPage = driver.findElement(By.xpath("//h1[contains(text(), 'Shipping Information')]"));
		 
		
		  String actualshippingInformationPagination =shippingInformationPage.getText();
		  String expectedshippingInformationPagination=  "Shipping Information";
		  
		  if(actualshippingInformationPagination.equals(expectedshippingInformationPagination)) {		
			  		test.pass("Successfully naviagted to Shipping Informationpage");
			        logger.info("Successfully naviagted to Shipping Information page");
			    } else {
			        test.fail( "The pagination does not match expected " +  expectedshippingInformationPagination + " " + "  but found" + " " +actualshippingInformationPagination+ " ");
			        logger.info("Click failed");
			    }	
	}
	

	public void specialorders() throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement  specialordersLink = driver.findElement(By.xpath("//a[contains(text(),'Special orders')]"));
		 js.executeScript("arguments[0].click();", specialordersLink );
		 Thread.sleep(2000);
		 
		 //pagination of special order
		 test.info("Verifying the pagination of Special Order");
		 WebElement specialordersPage = driver.findElement(By.xpath("//span[contains(text(),'Special Order FAQs')]"));
		 
		
		  String actualSpecialordersPagination =specialordersPage.getText();
		  String expectedSpecialordersPagination=  "Special Order FAQs";
		  
		  if(actualSpecialordersPagination.equals(expectedSpecialordersPagination)) {		
			  		test.pass("Successfully naviagted to Special Order  page");
			        logger.info("Successfully naviagted to Special Order  page");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedSpecialordersPagination + " " + "  but found" + " " +actualSpecialordersPagination+ " ");
			        logger.info("Click failed");
			    }	
		  
		  // navigates to platinum page
			  WebElement  platinumPartnerLink = driver.findElement(By.xpath("//a [contains(text(),'Platinum Partners Program')]"));
			  js.executeScript("arguments[0].click();",  platinumPartnerLink );
		  
		  
			  //pagination of metal pricing
				 WebElement platinumPartnerPage = driver.findElement(By.xpath("//h1[contains(text(), 'Fire Mountain Gems and Beads’ Platinum Partner’s Program')]"));
				 
				
				  String actualplatinumPartnerPagination =platinumPartnerPage.getText();
				  String expectedplatinumPartnersPagination=  "Fire Mountain Gems and Beads’ Platinum Partner’s Program";
				  
				  if(actualplatinumPartnerPagination.equals(expectedplatinumPartnersPagination)) {		
					  		test.pass("Successfully naviagted to platinum Partner page");
					        logger.info("Successfully naviagted to platinum Partner Page");
					    } else {
					        test.fail( "The pagination does not match expected " + expectedplatinumPartnersPagination + " " + "  but found" + " " +actualplatinumPartnerPagination+ " ");
					        logger.info("Click failed");
					    }	
				  
		}
	
	
}

	
