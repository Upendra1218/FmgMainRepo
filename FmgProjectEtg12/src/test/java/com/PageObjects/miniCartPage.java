package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class miniCartPage extends baseClass{

    WebDriver lDriver;

    // Constructor for the miniCartPage class
    public miniCartPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Element for Cart Button
    @FindBy(xpath = "//div[@class='minicart-total']")
    WebElement CartButton;
    // Method to click on the Cart Button
    public void hoverOnCartButton(WebDriver driver) throws InterruptedException {
        // Create an Actions object to perform hover action
    	test.info("vaidate the minicart Hovered");
    	//Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(CartButton).perform();
        Thread.sleep(1000);
        test.pass("Successfully the minicart is Hovered");
        
    }

    // Element for Cart Button (JavaScript click)
    @FindBy(xpath = "//a[@class='minicart-link']")
    WebElement CartButtonjs;

    // Method to click on the Cart Button using JavaScript
    public void clickcartbuttonjs(WebDriver driver) throws InterruptedException {
        // Use JavaScript to click the Cart Button
        CartButtonjs.click();
    }

    // Element for View Cart Button
    @FindBy(xpath = "//a[contains(text(),'View Cart')]")
    WebElement viewCartButton;

    // Method to click on the View Cart Button
    public void clickviewCartButton(WebDriver driver) throws InterruptedException {
    	test.info("vaidate the viewCart click");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", viewCartButton);
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCartButton);
        test.pass("Successfully the Viewcart Clicked");
        //viewCartButton.click();
        Thread.sleep(2000);
        if (viewCartButton.isDisplayed()) {
            // Scroll to the View Cart Button and then click it using JavaScript
            viewCartButton.click();
        }
    }

    // Element for Checkout Button
    @FindBy(xpath = "//a[contains(@class,'checkout-btn')]")
    WebElement Checkout;

    // Method to click on the Checkout Button
    public void clickCheckout() throws InterruptedException {
        Checkout.click();
        Thread.sleep(5000);
    }

	
}
