package com.PageObjects;


import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.testcases.baseClass;

public class reviewOrderPage extends baseClass{
	
WebDriver lDriver;
	
	public reviewOrderPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	
	@FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPage;
    public void clickonReviewOrder(WebDriver driver) throws InterruptedException {	 
    	test.info("Validate the Review order button click");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", reviewOrderPage);
    	js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    	Thread.sleep(5000);
    	reviewOrderPage.click();
    	
    	test.pass("Successfully Review order btn Clicked");
    	Thread.sleep(2000);
    }
    
    @FindBy(xpath ="//button[contains(text(), 'Next: Review Order')]")
	WebElement reviewOrderPagepaypal;
    public void clickonReviewOrderPaypal() throws InterruptedException {	 
    	test.info("Validate the Review order button click");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("window.scrollBy(0, 500);");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", reviewOrderPagepaypal);
    	js.executeScript("arguments[0].click();",reviewOrderPagepaypal);
    }
  
    
    //In checkout page if the it will check the button of revieworder and place order buttons
	@FindBy(xpath ="(//button[contains(@class,' place-order')])[1]")
	WebElement placetheorderBtn;
    public void clickonplaceorderwithJsExuter(WebDriver driver) throws InterruptedException {
    	Thread.sleep(2000);
    	test.info("validate the place order click");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	if(placetheorderBtn.isDisplayed()) {
    		
        try {
        	placetheorderBtn.click();
        	logger.info("normal click");
        	Thread.sleep(5000);
	        } catch (Exception e) {
	            // Handle the exception (e.g., log the error, take a screenshot, etc.)
	            System.err.println("Exception caught: " + e.getMessage());
	            js.executeScript("arguments[0].click();", placetheorderBtn);
	            logger.info("JavaScript click");
	        }
    	}

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(placetheorderBtn));
//		element.click();
//    	placetheorderBtn.click();
    	test.pass("Successfully place order btn Clicked");
    } 
    
    @FindBy(xpath ="(//button[contains(@class,' place-order')])[2]")
	WebElement placetheorderBtnpaypal;
    public void clickonplaceorderwithpaypal(WebDriver driver) throws InterruptedException {
    	Thread.sleep(2000);
    	test.info("validate the place order click paypal");
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", placetheorderBtnpaypal);
    	js.executeScript("arguments[0].click();", placetheorderBtnpaypal);
    	test.pass("Successfully place order btn Clicked paypal");
    	
    } 
    


    @FindBy(xpath ="//a[contains(text(), 'Continue Shopping')]")
	WebElement continueShoppingBtn;
    public void clickoncontinueShoppingBtn(WebDriver driver) throws InterruptedException {
    	Thread.sleep(2000);
    	test.info("validate the continueShoppingBtn click");
    	JavascriptExecutor js = (JavascriptExecutor) driver; 
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", continueShoppingBtn);
    	js.executeScript("arguments[0].click();", continueShoppingBtn);
    	//continueShoppingBtn.click();
    	test.pass("Successfully place order btn Clicked continueShoppingBtn");
    	
    } 
    
  //click on the product link in the view cart page
    public void clickProductLinkROP() throws InterruptedException {
    	
    	List<WebElement> productLinks = driver.findElements(By.xpath("//a[@class='line-item-text']"));
		 // Get the total count of top-level menu elements.
        int count = productLinks.size();
        // Create a random number generator.
        Random random = new Random();
        // Generate a random index to select a top-level menu item.
        int randomProdcutlink = random.nextInt(count) + 1;
        logger.info(randomProdcutlink);
        
     // Use WebDriverWait to wait for the element to be clickable
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10) );
        
        WebElement movetoWishListLink = driver.findElement(By.xpath("( //a[@class='line-item-text'])[" + randomProdcutlink + "]"));

        // Replace the sleep with WebDriverWait
        //WebElement moveToWishListLink = wait.until(ExpectedConditions.elementToBeClickable(movetoWishListLink));

        movetoWishListLink.click();
        
//		Thread.sleep(2000);
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("arguments[0].click();", movetoWishListLink);
		
		Thread.sleep(3000);
		
		//validate the pdp page is loaded\
		List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));
		if (pdpPagecheck.size() > 0) {
			logger.info("Pdp page is succesfully loaded");
		}
		
    }
    
    
 
    
    
    
    
    
	
}
