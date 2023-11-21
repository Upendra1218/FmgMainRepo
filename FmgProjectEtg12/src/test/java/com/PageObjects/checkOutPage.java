package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;
import com.testcases.baseClass;

public class checkOutPage extends baseClass {
    WebDriver lDriver;
    
    // PageFactory constructor for this page
    public checkOutPage(WebDriver rDriver ){
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }
    
    // Edit button
    @FindBy(xpath="//input[@id='shippingFirstNamedefault']")
    WebElement editBtn;
    public void clickEditBtn(){    
        editBtn.click();
    }

    // Check out page xpaths, actionMethods, and passing data values
    // ShippingDetails
    // FirstName
    @FindBy(xpath="//input[@id='shippingFirstNamedefault']")
    WebElement FirstName;
    public void setFisrtName(String fname ){    
        FirstName.clear();
        FirstName.sendKeys(fname);
    }

    // LastName
    @FindBy(xpath="//input[@id='shippingLastNamedefault']")
    WebElement LastName;
    public void setLastname(String lname ){
        LastName.clear();
        LastName.sendKeys(lname);
    }

    // Address1
    @FindBy(xpath="//input[@id='shippingAddressOnedefault']")
    WebElement Address1;
    public void setAddress1() throws InterruptedException{
        Thread.sleep(3000);
        int randomNumber = 123; // Generates a random number between 100 and 999
        address = String.valueOf(randomNumber);
        Address1.sendKeys(address);
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        test.pass("Entered the Address from the auto-suggestions");
    }

    // City
    @FindBy(xpath="//input[@id ='shippingAddressCitydefault']")
    WebElement city;
    public void setcity(String cityname ){
        city.clear();
        city.sendKeys(cityname);
    }

    // Country
    @FindBy(xpath="//select[@id='shippingCountrydefault']")
    WebElement Country;
    public void setCountry() throws InterruptedException{
        Select countrySelect = new Select(Country);
        countrySelect.selectByIndex(1);
        Thread.sleep(1000);
    }

    // Province
    @FindBy(xpath="//select[@id='shippingStatedefault']")
    WebElement Province;
    public void setProvince(){
        Select ProvinceSelect = new Select(Province);
        ProvinceSelect.selectByIndex(3);
    }

    // ZipCode
    @FindBy(xpath="//input[@id='shippingZipCodedefault']")
    WebElement zipCode;
    public void setzipCode(String zipcode){    
        zipCode.clear();
        zipCode.sendKeys(zipcode);
    }

    // Phone
    @FindBy(css="#shippingPhoneNumberdefault")
    WebElement Phone;
    public void setPhone(String phonenumber ) throws InterruptedException{        
        Thread.sleep(1000);
        Phone.sendKeys("9876543212");
    }

    // For generating fake data for input fields
    Faker faker = new Faker();

    // Billing address when we add GC to the cart
    // Billing address firstName
    @FindBy(id="billingFirstName")
    WebElement billingFName;
    public void setBillingFName() {
        String yoursFakeName = faker.name().firstName();
        billingFName.sendKeys(yoursFakeName);
    }

    // Billing address lastName
    @FindBy(id="billingLastName")
    WebElement billingLName;
    public void setBillingLName() {
        String yoursFakeName = faker.name().lastName();
        billingLName.sendKeys(yoursFakeName);
    }

    // Billing address address column
    @FindBy(id="billingAddressOne")
    WebElement billingAddress;

    // Billing Phone Number
    @FindBy(id="phoneNumber")
    WebElement phoneNumber;
    public void setBillingPhoneNum() {
        String phoneNum = "9876543212";
        phoneNumber.sendKeys(phoneNum);
    }

    // Button for the continueToBillingButton
    @FindBy(xpath ="//button[contains(@class, 'submit-shipping')]")
    WebElement continueToBillingButton ;
    public void clickcontinueToBillingButton (WebDriver driver) throws InterruptedException {
        test.info("Validate the ContinueBilling Btn click");
        if(continueToBillingButton.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueToBillingButton);
            js.executeScript("arguments[0].click();", continueToBillingButton);
            test.pass("Successfully ContinueBilling Btn is Clicked");
            Thread.sleep(5000);
        }
    }

    // Add to my address when the registered user is checking out
    @FindBy(xpath = "(//input[@id='addShippingAddressToMyAccount'])[1]")
    WebElement addToMyAddress;
    public void clickaddToMyAddress(WebDriver driver) throws InterruptedException {
        addToMyAddress.click();
        Thread.sleep(5000);
    }

    // Shipping method selection randomly
    public void selectShippingRandomly() throws InterruptedException {
    	Thread.sleep(5000);
        List<WebElement> TotalShippingMethods = driver.findElements(By.xpath("//div[contains(@class,'shipping-method-list')]//input"));
        int countofShippingMethods = TotalShippingMethods.size();
        if(countofShippingMethods>0) {
        	logger.info("Total Shipping count is " + countofShippingMethods);
            Random random = new Random();
            int randomShippingMethod = random.nextInt(countofShippingMethods) + 1;
            logger.info("Randomly selected menu number " + randomShippingMethod);

            WebElement getNotApplicableAddress = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='shipping-cost'])[" + randomShippingMethod + "]"));
            String sippingMethodAmount = getNotApplicableAddress.getText();
            logger.info(sippingMethodAmount);
            String expetedText = "N/A";
            if (sippingMethodAmount.equals(expetedText)) {
                logger.info("This Shipping method is not applicable");
                selectShippingRandomly();
            } else {
                WebElement shippingMethod = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//input)[" + randomShippingMethod + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", shippingMethod);
                js.executeScript("arguments[0].click();", shippingMethod);

                WebElement shippingMethodNames = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='display-name'])[" + randomShippingMethod + "]"));
                String shippingMethodName = shippingMethodNames.getText();
                shippingMethodtitle = shippingMethodName;
                prviousShippingMethod = shippingMethodName;

                WebElement shippingMethodDays = driver.findElement(By.xpath("(//div[contains(@class,'shipping-method-list')]//span[@class='text-muted arrival-time'])[" + randomShippingMethod + "]"));
                String sippingMethodDays = shippingMethodDays.getText();

                logger.info("Selected Shipping Method Name is "+shippingMethodName+" "+sippingMethodDays);
                test.pass("Selected Shipping Method Name is "+shippingMethodName+" "+sippingMethodDays);    
            }
        }
        
    }

    // Edit address
    @FindBy(xpath="//input[@id='shippingAddressOnedefault']")
    WebElement editAddress1;
    public void seteditAddress1() throws InterruptedException{
        String address11 = editAddress1.getAttribute("value");
        prviousAddress = address11;
        logger.info(prviousAddress);

        Address1.clear();
       
        Random random = new Random();
        // Generate a random number between 120 and 125 (inclusive)
        int randomNumber = random.nextInt(6) + 120;
        
        Thread.sleep(3000);
        //int randomNumber = 145;
        address = String.valueOf(randomNumber);
        Address1.sendKeys(address);
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        Address11.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        test.pass("Entered the Address from the auto-suggestions");

        String addressafteredit = editAddress1.getAttribute("value");
        Address = addressafteredit;
        logger.info(Address);
    }

    // Get the mail details after edited
    @FindBy(xpath="//span[@class='customer-summary-email']")
    WebElement Email;
    public void getEmailFromCP() {
    	test.info("validate the email is Edited");
        String emailText = Email.getText();
        emailEdited = emailText;

        logger.info(prviousEmail);
        logger.info(email);
        logger.info(emailEdited);

        if(email.equals(emailEdited)) {
            logger.info(prviousEmail+" we have this mail previously, but edited is " +emailEdited);
            test.pass(prviousEmail+" we have this mail previously, but edited is " +emailEdited);
        } else {
            logger.info("Not Edited successfully");
        }
    }

    // Get the address details after edited
    @FindBy(xpath="//div[@class='summary-details shipping']//div[@class='address1']")
    WebElement address11;
    public void getAddressFromPaymentPage() {
    	test.info("validate the shipping address is Edited");
        String AddressText = address11.getText();
        AddressEdited = AddressText;

        logger.info(prviousAddress);
        logger.info(Address);
        logger.info(AddressEdited);

        if(AddressEdited != prviousAddress) {
            logger.info(prviousAddress+" Edited successfully shipping Address "+ AddressEdited);
            test.pass(prviousAddress+" Edited successfully shipping Address "+ AddressEdited);
        } else {
            logger.info("Not Edited successfully");
        }
    }

    // Get the shipping method details after edited
    @FindBy(xpath="//span[@class='shipping-method-title']")
    WebElement Shippingvalidation;
    public void getShippingvalidation() {
    	test.info("validate the shippingMethod is Edited");
        String ShippingvalidationText = Shippingvalidation.getText();
        shippingMethodEdited = ShippingvalidationText;

        logger.info(shippingMethodtitle);
        logger.info(shippingMethodEdited);

        if(shippingMethodtitle.equals(shippingMethodEdited)) {
            logger.info("Edited successfully Shipping Method "+shippingMethodEdited);
            test.pass("Edited successfully Shipping Method");
        } else {
            logger.info("Not Edited successfully");
        }
    }
}
