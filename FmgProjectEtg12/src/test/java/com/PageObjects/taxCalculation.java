package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class taxCalculation extends baseClass {

     Float shippingCostInPaymentPage = 0.0f;
     Float shippingCostRop = 0.0f;
     Float salesTaxtRop = 0.0f;
     Float totalProductCostInROP = 0.0f;
     Float actualgrandTotalInROP = 0.0f;
     Float expectedgrandTotalInROP = 0.0f;
     Float giftCerificatePriceInROP = 0.0f;

     
  
    // in payment page
    public  void getShippingCost() {
    	
//        // shipping cost at payment page
//        WebElement shippingmethod = driver.findElement(By.xpath("//p[contains(@class,'shipping-method-price')]"));
//        String shippingmethodText = shippingmethod.getText();
//        String assortablePriceText1 = shippingmethodText.replaceAll("[^\\d.]+", "");
//        shippingCostInPaymentPage = Float.parseFloat(assortablePriceText1);
//        logger.info("shipping cost price in pp is " + shippingCostInPaymentPage);

        // get shipping at review order page
        WebElement shippingCostInRop = driver.findElement(By.xpath("//span[contains(@class,'shipping-total-cost')]"));
        String shippingCostText = shippingCostInRop.getText();
        String shippingCostTextText1 = shippingCostText.replaceAll("[^\\d.]+", "");
        shippingCostRop = Float.parseFloat(shippingCostTextText1);
        logger.info("shipping cost in rop price is " + shippingCostRop);
    }

    // sales tax
    public  float salesTax() {
        WebElement salesTaxInRop = driver.findElement(By.xpath("//span[@class='tax-total']"));
        String salesTaxText = salesTaxInRop.getText();
        String assortablePriceText1 = salesTaxText.replaceAll("[^\\d.]+", "");
        salesTaxtRop = Float.parseFloat(assortablePriceText1);
        logger.info("sales price is " + salesTaxtRop);
        return salesTaxtRop;
    }

 // sales tax
    public  float giftCerificatePrice() {
       List<WebElement> giftCerificateElement = driver.findElements(By.xpath("//span[contains(text(),'Gift Certificates')]"));
       if(giftCerificateElement.size()>0) {
    	   WebElement giftCerificateElementDisplay = driver.findElement(By.xpath("//span[contains(text(),'Gift Certificates')]"));
    	   if(giftCerificateElementDisplay.isDisplayed()) {
		        WebElement giftCerificatePriceInRop = driver.findElement(By.xpath("//span[@class='gift-certificate-total']"));
		        String giftCerificatePriceText = giftCerificatePriceInRop.getText();
		        String giftCerificatePriceText1 = giftCerificatePriceText.replaceAll("[^\\d.]+", "");
		        giftCerificatePriceInROP = Float.parseFloat(giftCerificatePriceText1);
		        logger.info("sales price is " + giftCerificatePriceInROP);     
    	   }
       }
       return giftCerificatePriceInROP;
    }
    // total product cost in cart page
      viewCartPage vcp = new viewCartPage(driver);
       Float totalCostAtCartPage =vcp.totalCost;
     
   
    
    // total product cost in review order page
    public void totalProductValidation() {
    	test.info("Verifying the total product");
       
       List<WebElement> productCostInRopList = driver.findElements(By.xpath("//span[@class='sub-total']"));
       if(productCostInRopList.size()>0) {
    	   WebElement productCostInRop = driver.findElement(By.xpath("//span[@class='sub-total']"));
    	   String productCostText = productCostInRop.getText();
	        String productCostText1 = productCostText.replaceAll("[^\\d.]+", "");
	        totalProductCostInROP = Float.parseFloat(productCostText1);
	        logger.info(" Total product price in ROP  is " + totalProductCostInROP);
	        logger.info(totalCostAtCartPage);
	        if (totalCostAtCartPage.equals(totalProductCostInROP)) {
	            //test.pass("Total product cost at cart page is " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	            logger.info("Total product cost at cart page is  " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	        } else {
	            //test.fail("Total product cost at cart page is " + totalCostAtCartPage + " not same as at review order page i.e, " + totalProductCostInROP);
	            logger.info("Total product cost at cart page is  " + totalCostAtCartPage + " not same as at review order page i.e, " + totalProductCostInROP);
	        }      
       }else {
    	   WebElement productCostInRop = driver.findElement(By.xpath("//p[contains(@class,'subtotal-price')]//span"));
    	   String productCostText = productCostInRop.getText();
	        String productCostText1 = productCostText.replaceAll("[^\\d.]+", "");
	        totalProductCostInROP = Float.parseFloat(productCostText1);
	        logger.info(" Total product price in ROP  is " + totalProductCostInROP);
	
	        if (totalCostAtCartPage.equals(totalProductCostInROP)) {
	            test.pass("Total product cost at cart page is " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	            logger.info("Total product cost at cart page is  " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	        } else {
	            test.fail("Total product cost at cart page is " + totalCostAtCartPage + " not same as at review order page i.e, " + totalProductCostInROP);
	            logger.info("Total product cost at cart page is  " + totalCostAtCartPage + " not same as at review order page i.e, " + totalProductCostInROP);
	        } 
       }
    }

    public void grandTotalValidation() {
    	test.info("Verifying the grand total price");
    	salesTax();
    	getShippingCost();
    	giftCerificatePrice();
        WebElement grandTotalInRop = driver.findElement(By.xpath("//span[@class='grand-total-sum']"));
        String grandTotalText = grandTotalInRop.getText();
        String grandTotalText1 = grandTotalText.replaceAll("[^\\d.]+", "");
        
        // Split the string using the dot as a delimiter
	    String[] parts1 = grandTotalText1  .split("\\.");

	    // Extract the integer part
	    String integerPart1 = parts1[0];

	    // Convert the string to an integer
	    actualgrandTotalInROP =  Float.parseFloat(integerPart1);
        
	   
        logger.info("The grand total price is " + actualgrandTotalInROP);

        expectedgrandTotalInROP = salesTaxtRop + totalProductCostInROP + shippingCostRop -giftCerificatePriceInROP;
        
        //convert float to string
        String expectedgrandTotalString = String.valueOf(expectedgrandTotalInROP);

        //Split the string using the dot as a delimiter
	    String[] parts = expectedgrandTotalString .split("\\.");

	    // Extract the integer part
	    String integerPart = parts[0];

	    // Convert the string to an integer
	    expectedgrandTotalInROP =  Float.parseFloat(integerPart);

        if (expectedgrandTotalInROP.equals(actualgrandTotalInROP)) {
            //test.pass("Expected Grand total is " + expectedgrandTotalInROP + " same as i.e, " + actualgrandTotalInROP);
            logger.info("Expected Grand total is " + expectedgrandTotalInROP + " same as i.e, " + actualgrandTotalInROP);
        } else {
            //test.fail("Expected Grand total is " + expectedgrandTotalInROP + " not same as i.e, " + actualgrandTotalInROP);
            logger.info("Expected Grand total is " + expectedgrandTotalInROP + " not same as i.e, " + actualgrandTotalInROP);
        }
    }
}
