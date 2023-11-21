package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.commonfunctionality.addtoCartValidation;
import com.github.javafaker.Faker;

public class GiftCertificate {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public GiftCertificate(WebDriver rDriver) {
		this.lDriver = rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//gift card of xpaths, actionMethods and passing data and adding the gift card to cart
	
	//gift card
	@FindBy(className  = "gift-certificate")
	WebElement giftCardElement;
	
	//gift card
	@FindBy(className  = "premega-nav-block")
	List<WebElement> giftCardElementList;
	
	//amount
	@FindBy(xpath = "//div[@class='giftvalue-update']")
	WebElement amount;
	//Action Method
	public void clickAmount() {
	    amount.click();
	    List<WebElement> dropdown = amountDropdown.findElements(By.tagName("li"));
	    int randomIndex = new Random().nextInt(dropdown.size());
	    dropdown.get(randomIndex).click();
	    System.out.println("Selected from dropdown");
	}
	
	//amounnt drop down
	@FindBy(xpath = "//ul[@class='gift-amount']")
	WebElement amountDropdown;
	
	//friends name
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipient']")
	WebElement friendsNameElement;
	//Action Method
	public void enterFriendsName(String friendsName) {
		friendsNameElement.clear();
	    friendsNameElement.sendKeys(friendsName);
	}
	
	//yoursname
	@FindBy(xpath = "//input[@id='giftcert_purchase_from']")
	WebElement fromName;
	//Action Method
	public void enterFromName(String enterName) {
		fromName.clear();	  
	    fromName.sendKeys(enterName);
	}
	
	//Friend Name
	@FindBy(xpath = "//input[@id='giftcert_purchase_recipientEmail']")
	WebElement friendsMail;
	public void enterFriendsMail(String email1) {
		friendsMail.clear();
	    friendsMail.sendKeys(email1);
	}
	
	//confirm friend mail
	@FindBy(xpath = "//input[@id='giftcert_purchase_confirmRecipientEmail']")
	WebElement confirmFriendsMail;
	public void enterConfirmFriendsMail(String email2) {
		confirmFriendsMail.clear();
	    confirmFriendsMail.sendKeys(email2);
	}
	
	@FindBy(xpath = "//button[@class='btn btn-block btn-primary addto-cartbtn']")
	WebElement addToCart;
	public void addToCartButton() {
		addToCart.click();
	}
	
	Faker faker =new Faker();

    //Gift card entering details
	public void clickOnGiftCard(WebDriver driver) throws InterruptedException {
		
		if(giftCardElementList.size()>0) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
	        js.executeScript("arguments[0].click();", 	giftCardElement);
	        //amount
	    	//Thread.sleep(1000);
	        if(amount.isDisplayed()) {
		    	amount.click();
		    	//dropdown
		        List<WebElement> dropdown= amountDropdown.findElements(By.tagName("li"));
		        int randomIndex = new Random().nextInt(dropdown.size());
		        dropdown.get(randomIndex).click();
		        System.out.println("Selected from dropdown");
		        
		        // friendsname
		        String fakeName1 = faker.name().fullName();
		        friendsNameElement.sendKeys(fakeName1);
		
		        //yours name
		        String yoursFakeName = faker.name().fullName();
		        fromName.sendKeys(yoursFakeName);
		        
		        //friends mail
		        String fakeEmail = faker.internet().emailAddress();
		        friendsMail.sendKeys(fakeEmail);
		
		        confirmFriendsMail.sendKeys(fakeEmail);
		     
		        Thread.sleep(2000);
		        //addToCart.click();
		        js.executeScript("arguments[0].click();", 	addToCart);
		
		        //validating the gift card is add to the cart
			    addtoCartValidation.validatingGiftCardAddtoCart(driver);
		        
		        Thread.sleep(3000);
	        }
		}
	}
	
	public void giftCertificatePage(WebDriver driver) throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", 	giftCardElement);
        //amount
    	Thread.sleep(3000);
    	amount.click();
    	//dropdown
        List<WebElement> dropdown= amountDropdown.findElements(By.tagName("li"));
        int randomIndex = new Random().nextInt(dropdown.size());
        dropdown.get(randomIndex).click();
        System.out.println("Selected from dropdown");
	}
	
	
}
