package com.Validations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class CartPageValidation extends baseClass{

	public void cartPage(WebDriver driver) {
		
		  List<WebElement> countOfProductsInCart = driver.findElements(By.xpath("//div[contains(@class,'card product-info ')]"));
		  for(int i= 1 ;i<= countOfProductsInCart.size();i++) {
			  
			  List<WebElement> deliveryToAddressList = driver.findElements(By.id("delivery-options-home"));
			  
			  List<WebElement> storePickUpList = driver.findElements(By.id("delivery-options-store"));
			  
			
			  
			  if(deliveryToAddressList.size()>0 ||  storePickUpList.size()>0 ) {
				  
				  test.info("Pick up store is only for Stripe and cyber source only");
				  WebElement deliveryToAddress = driver.findElement(By.id("delivery-options-home"));			  
				  WebElement storePickUp = driver.findElement(By.id("delivery-options-store"));
				  
				  if(deliveryToAddress.isEnabled() && deliveryToAddress.isSelected() ){
					  
				  	  test.info("Delivery to address is enabled");
					  WebElement groundShippingMethod = driver.findElement(By.xpath("//option[contains(text(),'Ground ( 7-10 Business Days )')]"));
					  WebElement expressShippingMethod = driver.findElement(By.xpath("//option[contains(text(),'Express ( 2-3 Business Days )')]"));
					  
					  boolean displayGroundShippingMethod= groundShippingMethod.isDisplayed();
					  boolean displayExpressShippingMethod= expressShippingMethod.isDisplayed();
					  if( displayGroundShippingMethod || displayExpressShippingMethod ) {
						  
						  test.pass("Shipping method is changing to ground or express");
					  }else {
						  test.fail("Shipping method is not changing to ground or express though delivery to address is enabled for prodcuts");
					  }
				  
				  }else if(storePickUp.isSelected()) {
					  
					  test.info("Store pick up enabled ");
					  WebElement storePickUpShipping = driver.findElement(By.xpath("//option[contains(text(),'Store Pickup')]"));				  
					  boolean displayStoreShippingMethod= storePickUpShipping.isDisplayed();
					  if(displayStoreShippingMethod) {
						  test.pass(" Shipping method is changing to Store pick up When a single or more products are in Store pick up without any delivery to address products");
					  }else {
						  test.fail("Shipping method is not changing to Store pick up When a single or more products are in Store pick up without any delivery to address products");
					  }
				  }
			}else {
				  List<WebElement>  subscriptionList = driver.findElements(By.cssSelector(".product-subscription"));
			}
			  
			  //if()
		  }  
	}
}
