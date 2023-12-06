package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.testcases.baseClass;

public class productDescriptionPage extends baseClass{

    WebDriver ldriver;

    public productDescriptionPage(WebDriver rdriver ){   
        ldriver=rdriver;
        PageFactory.initElements(rdriver, this);
    }
    
    //after adding the product is added to the cart and update the quantity value
    public void increasetheQuantiyinPDP() throws InterruptedException {
    	test.info("Verify that the quantity increase and click on the update button");
    	int intValueCount=0;
		int productCount = 150;
	    
	    Random random = new Random();
	    
	    int inputQuantiy = random.nextInt(productCount)+1;
	    logger.info("Product input quantity"+inputQuantiy);
    	
    	// Finding elements with a specific XPath for "Update Cart" button
		List<WebElement> pdpPagupdateBtn = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]//a[contains(@class, 'update-cart')]"));
		int displayedUpdateBtn = 0;

		// Counting the displayed "Update Cart" buttons
		for (WebElement item : pdpPagupdateBtn) {
			if (item.isDisplayed()) {
				displayedUpdateBtn++;
			}
		}

		// Logging the count of displayed "Update Cart" buttons
		logger.info(displayedUpdateBtn);

		// Checking if there is at least one displayed "Update Cart" button
		if (displayedUpdateBtn > 0) {
			
			// Find the quantity input field associated with the clicked button and set the quantity.
	        WebElement inctheQuantity = driver.findElement(By.xpath("//input[@name='quantity']"));
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
	        Thread.sleep(2000);
	        inctheQuantity.clear(); // Clear the existing value
	        Thread.sleep(2000);
	        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
	        Thread.sleep(1000);
	        
	        //prodcut is add to cart
	        WebElement clickUpdateBtn = driver.findElement(By.xpath("//div[contains(@class,'product-main-block')]//a[contains(@class, 'update-cart')]"));
	        // Scroll to the "Add to Cart" button and click it.
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        // Use JavaScript to scroll the element into the middle of the page view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickUpdateBtn);
	        Thread.sleep(1000);
	        js.executeScript("arguments[0].click();", clickUpdateBtn);
	        Thread.sleep(1000);
        
	 	   String valuecount = inctheQuantity.getAttribute("value");
	       logger.info(valuecount);
	        
	       // Convert the string to an integer
	       intValueCount = Integer.parseInt(valuecount);
	       logger.info(intValueCount);
	       test.pass("Successfully increase the quantiy and click on the update button");

		}
    }

  //WishList
  		public void selecttheWishlist() throws InterruptedException{
  			//for(int i =2;i<= 2;i++) {
  			// Get all the available options within the dropdown
  			test.info("Validate the wishList click");
  			List<WebElement> wishListBtn = driver.findElements(By.xpath("//i[@class= 'fa fa-stack-1x fa-heart-o']"));
  			
  			if(wishListBtn.size()>0){
  				WebElement wishlistPlp = driver.findElement(By.xpath("//a[@title= 'Favorites']"));
  				Thread.sleep(4000);
  				JavascriptExecutor executor = (JavascriptExecutor) driver;
  				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", wishlistPlp);
  				executor.executeScript("arguments[0].click();", wishlistPlp);
  				test.pass("Successfully the product is Favorates");
  				
  			}else {
  				WebElement wishlistPlp = driver.findElement(By.xpath("//a[@title= 'Favorites']"));
  				Thread.sleep(4000);
  				JavascriptExecutor executor = (JavascriptExecutor) driver;
  				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", wishlistPlp);
  				executor.executeScript("arguments[0].click();", wishlistPlp);
  				test.pass("Successfully the product is Removed from Favorates");
  			}
  			
  		}
	    
	    
    public static void haveAQuestion() throws InterruptedException {
		//have a question in pdp
	    	Faker faker = new Faker();
	    	List<WebElement> haveAquestionInPdpList = driver.findElements(By.xpath("//a[contains(text(),'Have a question about this item?')]"));
	    	if(haveAquestionInPdpList.size()>0) {
	    		JavascriptExecutor js = (JavascriptExecutor)driver;
	    		WebElement haveAquestionInPdp = driver.findElement(By.xpath("//a[contains(text(),'Have a question about this item?')]"));
	    		  js.executeScript("arguments[0].click();", haveAquestionInPdp);
	    		//haveAquestionInPdp.click();
	    		
	    		Thread.sleep(2000);
	    	// Locate and fill out the form fields
	           WebElement emailField = driver.findElement(By.id("email"));
	           String firstName = "akhila.m";
	           String email = firstName+ "@etg.digital"; // Change suffix as needed
	           System.out.println("Email id is " + email);
	           emailField.sendKeys(email );

	           WebElement firstNameField = driver.findElement(By.id("firstName"));
	           firstNameField.sendKeys(faker.name().firstName());
		
	           WebElement lastNameField = driver.findElement(By.id("lastName"));
	           lastNameField.sendKeys(faker.name().lastName());

	           WebElement questionField = driver.findElement(By.id("description"));
	           questionField.sendKeys("Your question or message");

	           // Submit the form
	           WebElement submitButton = driver.findElement(By.cssSelector("button.btn-product-info"));
	           submitButton.click();

	           // Optionally, you can wait for a confirmation message after submitting the form.
	           WebElement SuccessMessage = driver.findElement(By.xpath("//h2[contains(text(),'Thank you')]"));
	           String  actualSuccessMessage= SuccessMessage.getText();
	           System.out.println("Success Message: " + actualSuccessMessage);
	           
	           String expectedSuccessMessage = "Thank you";
	           	
	           if(actualSuccessMessage.equals(expectedSuccessMessage)) {
	        	   test.pass("Succesfully Submition of question results this  " +actualSuccessMessage);
	    		   logger.info("Succesfully Submition of question results this  " +actualSuccessMessage);
	           }else {
	        	   test.fail("No Submition of question results as expected like  " +actualSuccessMessage);
	    		   logger.info("No  Submition of question results as expected like " +actualSuccessMessage);
	           }
	           
	           
	           //close the pop up
	          // WebElement parentElement = driver.findElement(By.xpath("(//div[contains(@class,'modal-dialog-centered')])[2]"));
	           WebElement childCloseElement = driver.findElement(By.xpath("(//div[contains(@class,'modal-dialog-centered')])[2]//button[@class='close']"));
	       	  
	       	   js.executeScript("arguments[0].click();", childCloseElement);
	          // childCloseElement.click();
	    	}
	    	
	    	
	}
	

//validatin of prodcut name			
		public  void productNameValidation() {		
 	    	List<WebElement> productNameInPdpList = driver.findElements(By.cssSelector("h1.product-name"));
 	    	if(productNameInPdpList.size()>0) {
 	    		WebElement productNameInPdp = driver.findElement(By.cssSelector("h1.product-name"));
 	    		if(productNameInPdp.isDisplayed()) {
 	    			String productName= productNameInPdp.getText();
 	    			    logger.info("Product Name is displayed on the page and prodcut name is " +productName );
 	    	            test.pass("Product Name is displayed on the page and prodcut name is " +productName );
 	    		}else {
 	    			 logger.info("Product Name is not displayed on the page.");
 	                 test.fail("Product Name is not displayed on the page.");
 	    		}
 	    	}
 	    	
		}
		
    // Validation for product image
    public  void productImageValidation(WebDriver driver) {
        WebElement productImage = driver.findElement(By.xpath("//img[contains(@class,'img-fluid')]"));
        if (productImage.isDisplayed()) {
            logger.info("Product Image is displayed on the page.");
            test.pass("Product Image is displayed on the page.");
        } else {
            logger.info("Product Image is not displayed on the page.");
            test.fail("Product Image is not displayed on the page.");
        }
    }

  

    // Validation for product "Add to Cart" button
    public  void productAddtocartButtonValidation(WebDriver driver) {
        WebElement productAddtoCartButton = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));
        if (productAddtoCartButton.isDisplayed()) {
            logger.info("Product 'Add to Cart' button is displayed on the page.");
            test.pass("Product 'Add to Cart' button is displayed on the page.");
        } else {
            logger.info("Product 'Add to Cart' button is not displayed on the page.");
            test.fail("Product 'Add to Cart' button is not displayed on the page.");
        }
    }

   public void prodcutInformation() {
	   WebElement productInformation = driver.findElement(By.cssSelector("div.product-custom-attributes"));
	   String productInformationText= productInformation.getText();
	   if(productInformation.isDisplayed()) {
		   test.pass("Product Informatin is displayed on the pdp  page and information is  " +productInformationText);
		   logger.info("Product Informatin is displayed on the pdp  page and information is  " +productInformationText);
	   }else {
		   test.fail("Product Informatin is not displayed on the pdp  page and information is  " );
		   logger.info("Product Informatin is not displayed on the pdp  page and information is  " );
	   }
   }
   
 //TIER details
 		public static void tierPricesInPdp() throws InterruptedException {
 			 test.info("Verify that  tier price changes and discount applies in PDP Page");
 			 List<WebElement> quantityInput = driver.findElements(By.xpath("//input[@name='quantity']"));
 			 int productQuantityCount = quantityInput.size();
 			 int productCount = 150;
 			// Create a random number generator.
 		    Random random = new Random();
 	        // Generate a random index to select an "Add to Cart" button.
 		    int randomquantityInput = random.nextInt(productQuantityCount) + 1;
 		    int inputQuantiy = random.nextInt(productCount)+1;
 		    logger.info("Product input quantity"+inputQuantiy);
 		    // Find the quantity input field associated with the clicked button and set the quantity.
 	        WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomquantityInput + "]"));
 	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
 	        Thread.sleep(2000);
 	        inctheQuantity.clear(); // Clear the existing value
 	        Thread.sleep(2000);
 	        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
 	        Thread.sleep(1000);
 	        
 	 	   String valuecount = inctheQuantity.getAttribute("value");
 	       logger.info(valuecount);
 	    // Convert the string to an integer
 	       int intValueCount = Integer.parseInt(valuecount);
 	       logger.info(intValueCount);

 	        
 	        //prodcut is add to cart
 	        WebElement clickAddtoCartBtn = driver.findElement(By.xpath("//span[contains(text(),'Add to Cart')]"));    	       
 	        JavascriptExecutor js = (JavascriptExecutor) driver; 
 	        
 	       try {
 	            // Perform some action on the element
 	    	  clickAddtoCartBtn.click();
 	        } catch (Exception e) {
 	            // Handle the exception (e.g., log the error, take a screenshot, etc.)
 	            System.err.println("Exception caught: " + e.getMessage());
 	           js.executeScript("arguments[0].click();", clickAddtoCartBtn);
 	        }
 	        
 	       
 	        Thread.sleep(1000);
 	        
 	       List<WebElement> tierDiv = driver.findElements(By.xpath("//div[@class='pricebooks']"));  
 	       if(tierDiv.size()>0) {
 	    	   test.info("Tier prices are displayed on pdp");
	 	        if(intValueCount<14) {
	 	        	// Find all color buttons that are enabled
	 	    	    List<WebElement> priceChangeBartier1 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']"));
	 	    	    if(priceChangeBartier1.size()>0) {
	 	    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']//div[@class='price']"));
	 	    	    	String price = priceDiscount.getText();
	 	    	    	logger.info(price);
	 	    	    	
	 	    	    test.pass("The Discount is on the Blue one "+price);
	 	    	    logger.info("The Discount is on the Blue one "+price);
	 	    	    }
	 	        }else if(intValueCount<49) {
	 	    	    List<WebElement> priceChangeBartier2 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']"));
	 	    	    if(priceChangeBartier2.size()>0) {
	 	    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']//div[@class='price']"));
	 	    	    	String price = priceDiscount.getText();
	 	    	    	logger.info(price);
	 	    	    test.pass("The Discount is on the Green one " +price);
	 	    	    logger.info("The Discount is on the Green one " +price);
	 	    	    }
	 	        }else if(intValueCount<99) {
	 	    	    List<WebElement> priceChangeBartier3 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']"));
	 	    	    if(priceChangeBartier3.size()>0) {
	 	    	    	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']//div[@class='price']"));
	 	    	    	String price = priceDiscount.getText();
	 	    	    	logger.info(price);
	 	    	    test.pass("The Discount is on the pink "+price);
	 	    	    logger.info("The Discount is on the pink "+price);
	 	    	    }
	 	        }else {
	 	        	WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier4-prices active']//div[@class='price']"));
	 		    	String price = priceDiscount.getText();
	 		    	logger.info(price);
	 	        	test.pass("The Discount is on the Black one "+price);
	 	        	logger.info("The Discount is on the Black one " +price);
	 	        }
 	       }else {
 	    	   test.info("No tier div is displayed on pdp ");
 	       }
 		}
 		 public static void NoTierSelectionInPdp() {
 			 
 			 test.info("No Tier selction in PDP page ");
	        }
}
