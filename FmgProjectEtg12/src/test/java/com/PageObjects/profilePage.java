package com.PageObjects;

import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testcases.baseClass;

public class profilePage extends baseClass{
	
WebDriver lDriver;
	
	public profilePage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Click my account 
	@FindBy(xpath="//img[@alt='person-icon']")
	WebElement myaccount;
	public void clickAccount(WebDriver driver) throws InterruptedException {
		test.info("Verify that my account link click");
		myaccount.click();
		test.pass("Successfully clicked on the MyAccount Link");
//		Actions action=new Actions(driver);
//    	action.moveToElement(myaccount).perform();
    	Thread.sleep(5000);
	}
	
	
	
	
	
	//EditButtonMyAccout
	@FindBy(xpath="//a[@class = 'btn btn-primary pull-right' and @aria-label ='Edit Profile']")
	WebElement EditPage;
	public void clickEditPage() throws InterruptedException{	
		test.info("Verify that Edit button click");
		EditPage.click();	
        Thread.sleep(5000);
        test.pass("Successfully clicked on the edit button");
	}
	
	//EditProfileInfomation
	//FirstName
	
	@FindBy(xpath="//input[@id='firstName']")
	WebElement FirstName;
	public void setFisrtName(String epfname ){	
		FirstName.clear();
		FirstName.sendKeys(epfname); 
		test.pass("Entered the First name");
	}
	//LastName
	@FindBy(xpath="//input[@id='lastName']")
	WebElement LastName;
	public void setLastname(String eplname ){
		LastName.clear();
		LastName.sendKeys(eplname);
		test.pass("Entered the last name");
	}
	//conformMail
	@FindBy(xpath="//input[@id='confirmEmail']")
	WebElement ConfirmEmail;
	public void setconfirmEmail(String epconfirmEmail ){
		ConfirmEmail.sendKeys(epconfirmEmail);
		test.pass("Enterd the Conformation mail");
	}
	//Password
	@FindBy(xpath="//input[@id='password']")
	WebElement password;
	public void setpassword(String eppassword){
		password.sendKeys(eppassword);
		test.pass("Entered the password");
	}
	
	//SaveButtoninEditpage
	@FindBy(xpath="//button[@name ='save']")
	WebElement SaveButtoninEditpage;
	public void clickSaveButtoninEditpage(WebDriver driver) throws InterruptedException{	
		test.info("Verify that save btuuton is clicked");
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", SaveButtoninEditpage);
		test.pass("Succcessfully Clicked on the save button");
        Thread.sleep(5000);
	}
	//CancelButtoninEditPage
	@FindBy(xpath="//a[contains(@class, 'cancel')]")
	WebElement cancelButtonInEditPage;
	public void clickcancelButtonInEditPage(WebDriver driver) throws InterruptedException{
		cancelButtonInEditPage.click();
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("arguments[0].click();", cancelButtonInEditPage);	
		
        Thread.sleep(5000);
	}
	
	
///////////////////////////////////////////////////////////////
	
	//ChangePasswordpageDetails
	//ChangePassword
	@FindBy(xpath="//a[@class = 'pull-right btn btn-primary' and @aria-label ='Change Password']")
	WebElement ChangePassword;
	public void clickChangePassword() throws InterruptedException{
		test.info("Verify that Change password button");
		ChangePassword.click();	
        Thread.sleep(5000);
        test.pass("Successfully clicked on the Change password button");
	}
	//currentPassword
	@FindBy(xpath="//input[@id='currentPassword']")
	WebElement currentPassword;
	public void setcurrentPassword(String epcurrentPassword){
		currentPassword.sendKeys(epcurrentPassword);
		test.pass("Entered the Current password");
	}
	//newpw
	@FindBy(xpath="//input[@id='newPassword']")
	WebElement newPassword;
	public void setnewPassword(String epnewPassword){
		newPassword.sendKeys(epnewPassword);
		test.pass("Entered the new password");
	}
	//conformNewPassword
	@FindBy(xpath="//input[@id='newPasswordConfirm']")
	WebElement newPasswordConfirm;
	public void setnewPasswordConfirm(String epnewPasswordConfirm){
		newPasswordConfirm.sendKeys(epnewPasswordConfirm);
		test.pass("Entered the New conformation password");
	}
    //savebuttonPasswordChange
	@FindBy(xpath="//button[@name ='save']")
	WebElement savebuttonPasswordChange;
	public void clicksavebuttonPasswordChange(WebDriver driver) throws InterruptedException{	
		test.info("Verify that save button of the Change password");
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", savebuttonPasswordChange);
		test.pass("successfully clicked on the save button of Change password");
        Thread.sleep(5000);
        
	}
	//cancelButtoninPasswordChangePage
	@FindBy(xpath="//a[@class = 'btn btn-block btn-outline-primary']")
	WebElement cancelButtonInPCP;
	public void clickcancelButtonInPCP(WebDriver driver) throws InterruptedException{	
		cancelButtonInPCP.click();
		test.pass("");
//		JavascriptExecutor js = (JavascriptExecutor) driver; 
//		js.executeScript("arguments[0].click();", cancelButtonInPCP);	
        Thread.sleep(5000);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////	
	
	//AddNewAddress
	@FindBy(xpath = "//a[@class = 'pull-right btn btn-primary' and @aria-label ='Add New Address']")
	WebElement AddNewAddress;
	public void clickAddNewAddress() throws InterruptedException{	
		test.info("Verify that add new address button");
		AddNewAddress.click();	
		test.pass("Successfully clicked on the Add address button");
        Thread.sleep(5000);
	}
	   //AddressTitle
    @FindBy(xpath="//input[@id='addressId']")
	WebElement AddressTitle;
	public void setAddressTitle(String NewAddressTitle ){
		AddressTitle.sendKeys(NewAddressTitle);
		test.pass("Entered the address Title");
	}
	//FirstName
    @FindBy(xpath="//input[@id='firstName']")
	WebElement FirstNameofAddress;
	public void setFirstNameofAddress(String NAFirstName ){
		FirstNameofAddress.sendKeys(NAFirstName);
		test.pass("Entered the first Name ");
	}
	//LastName
    @FindBy(xpath="//input[@id='lastName']")
	WebElement LastNameofAddress;
	public void setLastNameofAddress(String NALastName ){
		LastNameofAddress.sendKeys(NALastName);
		test.pass("Entered the last Name");
	}
	
	//Address1
    @FindBy(xpath="//input[@id='address1']")
	WebElement Address1NewAddress;
	public void setAddress1NewAddress( ) throws InterruptedException{
		Random random = new Random();
        // Generate a random number between 120 and 125 (inclusive)
        int randomNumber = random.nextInt(6) + 130;
        
        Thread.sleep(3000);
        //int randomNumber = 145;
        address = String.valueOf(randomNumber);
        Address1NewAddress.sendKeys(address);
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        test.pass("Entered the Address from the auto-suggestions");
	}
	//country
    @FindBy(xpath="//select[@id='country']")
	WebElement SelectCountry;
	public void SelectCountry() throws InterruptedException{
	 Select countrySelect = new Select(SelectCountry);
		countrySelect.selectByIndex(1);
		Thread.sleep(1000);
	}
	//state
	@FindBy(xpath="//select[@id='state']")
	WebElement SelectState;
	public void SelectState(){
	 	Select StateSelect = new Select(SelectState);
        StateSelect.selectByIndex(5);
	}
	
	@FindBy(xpath="//form[@id='dwfrm_address']//input[@id='phone']")
	WebElement phoneNumberInput;
	public void phonenumber() {
		phoneNumberInput.sendKeys("5555555555");
		test.pass("Entered the phone Number");
	}
	
	//save button
	@FindBy(xpath="//button[contains(@class, 'save')]")
	WebElement saveButton ;
	public void saveButton(WebDriver driver) throws InterruptedException {
		test.info("Verify that Save button of Add new Address");
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", saveButton);	
		test.pass("Successfully clicked on the save button of the Add new address");
		//saveButton.click();
	}
	
/////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	//ViewOrderHistory
	@FindBy(xpath = "//a[@class = 'btn btn-outline-primary' and @aria-label ='View Order History']")
	WebElement ViewOrderHistory;
	public void clickViewOrderHistory(WebDriver driver) throws InterruptedException{
		
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", ViewOrderHistory);	
		//ViewOrderHistory.click();	
        Thread.sleep(5000);
	}
	//ReturntomyAccount
	@FindBy(xpath = "//a[@class ='myaccount-backlink']")
	WebElement ReturntomyAccount;
	public void clickReturntomyAccount(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", ReturntomyAccount);
		//ReturntomyAccount.click();	
        Thread.sleep(5000);
	}
	
	//ReturntomyAccountinViewOrder
	@FindBy(xpath = "//a[@class ='normal']")
	WebElement ReturntomyAccountinViewOrder;
	public void clickReturntomyAccountinViewOrder(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", ReturntomyAccountinViewOrder);
		//ReturntomyAccount.click();	
        Thread.sleep(5000);
	}
	
	//Scroll down
	public void scrolldown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	}

	
///////////////////////////////////////////////////////////////////////////////////////
	//addCreditcards
	@FindBy(xpath="//button[@class ='card-link braintreeAddNewCard']")
	WebElement addCreditCard;
	public void clickaddCreditCard() throws InterruptedException{	
		test.info("verify that add credit card add button");
		addCreditCard.click();
		test.pass("Successfully Add crdit card button is clicked");
        Thread.sleep(5000);
	}

	//BrainTree credit card  of xpaths, actionMethods and passing card details
		//braintree newcarddropdown 
		@FindBy(xpath ="//select[@id='braintreeCreditCardList']")
	    WebElement newcard;
		public void selectnewcardindropdown() throws InterruptedException {
	    Select newcardselect = new Select(newcard);
	    newcardselect.selectByIndex(0);
	    Thread.sleep(3000);
	    
		}
		//Braintree cardname
		@FindBy(xpath ="//input[@id = 'cardholder-name']")
		WebElement entercname;
	    public void setcardholdername(WebDriver driver) throws InterruptedException {
	    	Thread.sleep(1000);
	    //	if(entercname.isDisplayed()) {
		    	driver.switchTo().frame("braintree-hosted-field-cardholderName");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercname);
		    	entercname.sendKeys("Test123");
		    	driver.switchTo().defaultContent();
		    	test.pass("Successfully entered the name of user on card");
	    	///}
	    }
	    //Braintree cardnumber 
		@FindBy(xpath ="//input[@id = 'credit-card-number']")
		WebElement entercnumber;
	    public void setcardnumber(WebDriver driver) throws InterruptedException {
	    	//if(entercnumber.isDisplayed()) {
		    	driver.switchTo().frame("braintree-hosted-field-number");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercnumber);
		    	String[] cardNumbers = {
		    			
		               "378282246310005",
		                "371449635398431",
		     	      // "36259600000004",
		     	       //"6011000991300009",
		     	       //"3530111333300000",
		     	      // "6304000000000000",
		     	       "5555555555554444",	        
		     	      "2223000048400011",
		     	     /*
		     	       "4005519200000004",
		     	       "4009348888881881",
		     	       "4012000033330026",
		     	       "4012000077777777",
		     	       "4012888888881881",	        
		     	       "4217651111111119",
		     	       "4500600000000061",*/
		     	       //"6243030000000001",     	     
		     	       //"6223164991230014"
		                // Add more card numbers here
		    			  "4111111111111111"
		            };

	    	// Generate a random index to select a card number
			        Random rand = new Random();
			        int randomIndex = rand.nextInt(cardNumbers.length);
			        // Send the randomly selected card number
			        entercnumber.sendKeys(cardNumbers[randomIndex]);
			    	
			    	driver.switchTo().defaultContent();
			    	test.pass("Successfully Entered the Card Number");
	    	//}
	    }
	    //Braintree cvv
		@FindBy(xpath ="//input[@id = 'cvv']")
		WebElement entercvv;
	    public void setcardcvv(WebDriver driver) throws InterruptedException {
	    	//if(entercvv.isDisplayed()) {
		    	driver.switchTo().frame("braintree-hosted-field-cvv");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  entercvv);
		    	entercvv.sendKeys("7839");
		    	driver.switchTo().defaultContent();
		    	test.pass("Successfully Entered the CVV Number");
	    	//}
	    }
	    //Braintree exp
		@FindBy(xpath ="//input[@id = 'expiration']")
		WebElement enterexp;
	    public void setcardexp(WebDriver driver) throws InterruptedException {	
	    	//if(enterexp.isDisplayed()) {
		    	driver.switchTo().frame("braintree-hosted-field-expirationDate");
		    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enterexp);
		    	enterexp.sendKeys("1230");
		    	driver.switchTo().defaultContent();
		    	test.pass("Successfully Entered the Exp Number");
	    	//}
	    }
    
    //savebutton
	@FindBy(xpath="//button[@name ='save']")
	WebElement savebuttoncc;
	public void clicksavebuttoncc(WebDriver driver) throws InterruptedException{	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("arguments[0].click();", savebuttoncc);	
        Thread.sleep(5000);
        test.pass("Sucessfully clicked on the Save button of save Credit card");
	}
	
	
	
}
