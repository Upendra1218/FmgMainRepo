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
     Float orderDiscountInROP = 0.0f;
     
  
    // in payment page
    public  void getShippingCost() {

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
    //order discount
    public  float orderDiscount() {
    	
        List<WebElement> orderDiscountInRopList = driver.findElements(By.xpath("//span[contains(text(),'Order Discount')]"));
        if(orderDiscountInRopList.size()>0) {
	        WebElement orderDiscountInRop = driver.findElement(By.xpath("//span[contains(@class,'order-discount-total')]"));
	        if(orderDiscountInRop.isDisplayed()) {
	   	        String orderDiscountText = orderDiscountInRop.getText();
	   	        String orderDiscountText1 = orderDiscountText.replaceAll("[^\\d.]+", "");
	   	        orderDiscountInROP = Float.parseFloat(orderDiscountText1);
	   	        logger.info("order discount is " + orderDiscountInROP);	  
	        }
        }
        return orderDiscountInROP;
    }
    
 // apply coupon
    public void applyCoupon() throws InterruptedException {
        boolean couponDisplay = false;

        // Click the radio button
        WebElement clickRadioButton = driver.findElement(By.id("gift-promo"));
        clickRadioButton.click();
        System.out.println("Clicked on the radio button");

        // Check if the coupon section is present on the page
        List<WebElement> couponDiv = driver.findElements(By.cssSelector(".coupons-and-promos"));
        List<WebElement> maxCoupon = driver.findElements(By.xpath("//div[contains(text(),'Unable to apply coupon. Maximum number of coupons is 1.')]"));

        if (couponDiv.size() > 0) {
            // Check if a coupon is already applied
            List<WebElement> couponAppliedDivDisplayList = driver.findElements(By.cssSelector(".applied"));
            if (couponAppliedDivDisplayList.size() > 0) {
                WebElement couponAppliedDivDisplay = driver.findElement(By.cssSelector(".applied"));
                couponDisplay = couponAppliedDivDisplay.isDisplayed();
            }

            if (couponDisplay) {
                test.info("Coupon is already applied in the cart page");
                logger.info("Coupon is already applied in the cart page");
            } else {
                test.info("Coupon is not applied in the cart page");
                logger.info("Coupon is not applied in the cart page");

                // Delay added to wait for the page to load
                Thread.sleep(1000);

                // Instantiate the viewCartPage class
                viewCartPage vcp = new viewCartPage(driver);

                // Apply the coupon
                vcp.applyCoupon();

                // Perform negative validation for the coupon in the cart
                vcp.negativeValidationForCouponInCart();

                // Attempt to apply another coupon to check the maximum limit
                vcp.applyCoupon();

                // Check if the maximum coupon limit is reached
                if (maxCoupon.size() > 0) {
                    test.info("Coupon is applied in the cart page, so the maximum limit of one coupon is reached");
                    logger.info("Coupon is applied in the cart page, so the maximum limit of one coupon is reached");
                }
            }
        }
    }
    
    // total product cost in review order page
    public void totalProductValidation() {
    	test.info("Verifying the total product");
    	logger.info(totalCost);
    	   Float totalCostAtCartPage = totalCost;
    	
       
       List<WebElement> productCostInRopList = driver.findElements(By.xpath("//span[@class='sub-total']"));
       if(productCostInRopList.size()>0) {
    	   WebElement productCostInRop = driver.findElement(By.xpath("//span[@class='sub-total']"));
    	   String productCostText = productCostInRop.getText();
	        String productCostText1 = productCostText.replaceAll("[^\\d.]+", "");
	        totalProductCostInROP = Float.parseFloat(productCostText1);
	        logger.info(" Total product price in ROP  is " + totalProductCostInROP);
	        logger.info(totalCostAtCartPage);
	        if (totalCostAtCartPage.equals(totalProductCostInROP)) {
	            test.pass("Total product cost at cart page is " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	            logger.info("Total product cost at cart page is  " + totalCostAtCartPage + " same as at review order page i.e, " + totalProductCostInROP);
	        } else {
	            test.fail("Total product cost at cart page is " + totalCostAtCartPage + " not same as at review order page i.e, " + totalProductCostInROP);
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

        expectedgrandTotalInROP = salesTaxtRop + totalProductCostInROP + shippingCostRop -giftCerificatePriceInROP-orderDiscountInROP;
        
        //convert float to string
        String expectedgrandTotalString = String.valueOf(expectedgrandTotalInROP);

        //Split the string using the dot as a delimiter
	    String[] parts = expectedgrandTotalString .split("\\.");

	    // Extract the integer part
	    String integerPart = parts[0];

	    // Convert the string to an integer
	    expectedgrandTotalInROP =  Float.parseFloat(integerPart);

        if (expectedgrandTotalInROP.equals(actualgrandTotalInROP)) {
            test.pass("Expected Grand total is " + expectedgrandTotalInROP + " same as i.e, " + actualgrandTotalInROP);
            logger.info("Expected Grand total is " + expectedgrandTotalInROP + " same as i.e, " + actualgrandTotalInROP);
        } else {
            test.fail("Expected Grand total is " + expectedgrandTotalInROP + " not same as i.e, " + actualgrandTotalInROP);
            logger.info("Expected Grand total is " + expectedgrandTotalInROP + " not same as i.e, " + actualgrandTotalInROP);
        }
    }
}
