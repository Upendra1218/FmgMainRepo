package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TotalCalculation {

	public void totalCalculation(WebDriver driver) {
		

	     List<WebElement> paymentDetails = driver.findElements(By.xpath("(//h2[contains(text(),'Payment Details')])[2]"));
	     if(paymentDetails.size()>0) {
	    	 WebElement paymentDetailsDisplay = driver.findElement(By.xpath("(//h2[contains(text(),'Payment Details')])[2]"));
	    	 if(paymentDetailsDisplay.isDisplayed()) {
					//total prodcut
					taxCalculation shippingMtd = new taxCalculation();
					shippingMtd.totalProductValidation();
			    		 
					 // granD TOTAL 
					shippingMtd.grandTotalValidation();
	    	 }
	     }
	}
}
