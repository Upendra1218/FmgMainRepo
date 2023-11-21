package com.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logOut {

    WebDriver lDriver;

    // Constructor for the logOut class
    public logOut(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Element for Logout link
    @FindBy(xpath = "//a[@href='https://utsf.firemountain.org/on/demandware.store/Sites-fireMountainGems-Site/default/Login-Logout']")
    WebElement logout;

    // Method to click on the Logout link using JavaScript
    public void clicklogout(WebDriver driver) {
        // Use JavaScript to click on the Logout link
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", logout);

        // Alternatively, you can also use the regular click method:
        // logout.click();
    }
}
