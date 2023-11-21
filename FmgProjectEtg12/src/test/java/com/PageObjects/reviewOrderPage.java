package com.PageObjects;

import java.util.List;

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
    
    @FindBy(xpath ="//div[@class='reviewpage-custom']//button[contains(text(), 'Next: Review Order')]")
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
    	placetheorderBtn.click();
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
	
}
