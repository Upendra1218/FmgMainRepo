package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class loginPage extends baseClass{

    WebDriver lDriver;

    // Constructor for the loginPage class
    public loginPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    

    // Element for Sign In button
    @FindBy(className  = "login-section")
    WebElement hoverLogin;
    
    public void hoverOnCreateloginAcc(WebDriver driver){
    	test.info("Verify that the profile is howered");
    	Actions action = new Actions(driver);
        action.moveToElement(hoverLogin).perform();   
        test.pass("Succesfully howered the Pofile");
    }
    
    // Element for Sign In button
    @FindBy(className = "login-button")
    WebElement loginButton;

    // Method to click on the Sign In button
    public void clickOnLogin() {
    	loginButton.click();
    }

    // Element for email input field
    @FindBy(id = "login-form-email-modal-login")
    WebElement email;

    // Method to set the email input field
    public void setEmail(String name) {
        email.clear();
        email.sendKeys(name);
    }

    // Element for password input field
    @FindBy(id = "login-form-password-modal-login")
    WebElement Password;

    // Method to set the password input field
    public void setPassword(String password) {
        Password.clear();
        Password.sendKeys(password);
    }

    // Element for Login button
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLogin;

    // Method to click the Login button with a sleep
    public void clickSubmit() throws InterruptedException {
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Login button (JavaScript click)
    @FindBy(xpath = "//button[contains(text(), 'Login')]")
    WebElement btnLoginjs;

    // Method to click the Login button using JavaScript with a sleep
    public void clickSubmitjs(WebDriver driver) throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnLoginjs);
        btnLogin.click();
        Thread.sleep(10000);
    }

    // Element for Home page logo
    @FindBy(xpath = "(//img[@class='fmg-logo'])[1]")
    WebElement forHomePage;

    // Method to click on the Home page logo using JavaScript with a sleep
    public void clickOnLogo(WebDriver driver) throws InterruptedException {
        Thread.sleep(5000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", forHomePage);
    }
}
