package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class TierPrice extends baseClass {

	public void tierPriceAndColor() throws InterruptedException {
		
		//hover the cart
		miniCartPage mc = new miniCartPage(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)", "");
		Thread.sleep(4000);
	   //Click on the cart button in the minicart
        mc.hoverOnCartButton(driver);
        Thread.sleep(2000);
        
        // tier price and color
        onlyTier();
	
	}
	
	public void onlyTier() {
		// locate the element of qunaity in mincart
		 WebElement miniCartQuantity = driver.findElement(By.xpath("//span[contains(@class,'minicart-quantity')]"));	
		 String countOfProducts= miniCartQuantity.getText();
		 int productsCount = Integer.parseInt(countOfProducts);
		 	if(productsCount>0) {
					// Convert the string to an int
				     int quantityInCart = Integer.parseInt(countOfProducts);
				     
				    List<WebElement> colorParentDivList = driver.findElements(By.xpath("//div[@class='current-tier']"));
				    if(colorParentDivList.size()>0) {
					    WebElement colorParentDiv = driver.findElement(By.xpath("//div[@class='current-tier']"));					   					    
						if(quantityInCart<14) {
							//located the color 
				   	    	WebElement ColorElement = colorParentDiv.findElement(By.xpath("//span[@class='tier-blue']"));
				   	    	
				   	    	String actualColor = ColorElement.getText();
				   	    	logger.info(actualColor);
				   	    	
				   	    	// locating the price 
				   	    	WebElement priceElement = driver.findElement(By.xpath("//div[@class='assorted-price']//span[@class='tier-blue']"));
				   	    	//expected color
				   	    	String expectedColor= "blue";	
				   	    	//comapring the colors
				   	    	if(actualColor.equals(expectedColor)) {
						    	    test.pass("No Discount is available for blue so price is " +priceElement.getText() );
						    	    logger.info("No Discount is available for blue so price is " +priceElement.getText());
				   	    	}
				       }else if(quantityInCart<49) {
					        	WebElement ColorElement = colorParentDiv.findElement(By.xpath("//span[@class='tier-green']"));
						    	String actualColor = ColorElement.getText();
						    	logger.info(actualColor);
						    	
						    	String expectedColor= "green";	
						    	// locating the price 
						    	WebElement priceElement = driver.findElement(By.xpath("//div[@class='assorted-price']//span[@class='tier-green']"));
						    	if(actualColor.equals(expectedColor)) {
						    	    test.pass("The Discount is available for green is " +priceElement.getText());
						    	    logger.info("The Discount is available for green is " +priceElement.getText());
						    	}
				       }else if(quantityInCart<99) {
					        	WebElement ColorElement = colorParentDiv.findElement(By.xpath("//span[@class='tier-pink']"));
						    	String actualColor = ColorElement.getText();
						    	logger.info(actualColor);
						    	
						    	String expectedColor= "pink";	
						    	// locating the price 
						    	WebElement priceElement =driver.findElement(By.xpath("//div[@class='assorted-price']//span[@class='tier-pink']"));
						    	if(actualColor.equals(expectedColor)) {
						    	    test.pass("The Discount is available for pink is " +priceElement.getText());
						    	    logger.info("The Discount is available for pink is " +priceElement.getText());
						    	}
				       }else {
					        	WebElement ColorElement = colorParentDiv.findElement(By.xpath("//span[@class='tier-black']"));
						    	String actualColor = ColorElement.getText();
						    	logger.info(actualColor);
						    	
						    	String expectedColor= "black";	
						    	// locating the price 
						    	WebElement priceElement = driver.findElement(By.xpath("//div[@class='assorted-price']//span[@class='tier-black']"));
						    	if(actualColor.equals(expectedColor)) {
						    	    test.pass("The Discount is available for pink is " +priceElement.getText());
						    	    logger.info("The Discount is available for pink is " +priceElement.getText());
						    	}
				       		}
				    }
				    	WebElement subTotalPriceOnHoveredCart = driver.findElement(By.xpath("(//div[@class='price'])[1]//b"));
					    String subTotalString =subTotalPriceOnHoveredCart.getText();
					    System.out.println(subTotalString);
					    String unitPriceValue = subTotalString.replaceAll("[^\\d.]+", "");
					    subTotalCost = Float.parseFloat(unitPriceValue);
					    logger.info("Sub total cost displayed when hovered on cart icon is " +subTotalCost);
					    test.info("Sub total cost displayed when hovered on cart icon is " +subTotalCost);
				    
				 }else {
					 test.info("No products in cart ");
				 }
	}
}
