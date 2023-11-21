package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.testcases.baseClass;

public class homePage extends baseClass{
    WebDriver lDriver;
    //pageFactory constructor for this page
	public homePage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
	//to get back to homepage 
		@FindBy(xpath = "//div[contains(@class,'navbar-brand')]//img[@class='fmg-logo']")
		WebElement forHomePage;
		public void clickOnLogo() throws InterruptedException {
			Thread.sleep(5000);
			  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", forHomePage);
			  JavascriptExecutor js = (JavascriptExecutor)driver;		
			 js.executeScript("arguments[0].click();", forHomePage);
		}		
		
	//cookies yes button.
	@FindBy(xpath = "//button[contains(text(),'Yes')]")
	WebElement consentTracking;
	public void clickconsentTracking() throws InterruptedException {
		List<WebElement> ct = driver.findElements(By.xpath("//button[contains(text(),'Yes')]"));
		if(ct.size()>0) {
			Thread.sleep(2000);
			consentTracking.click();
		}

	}
	//search bar
		@FindBy(xpath = "//input[@name='q']")
		WebElement searchBar;
		public void clickOnSearchBar(String typeSomething) throws InterruptedException {
			Thread.sleep(2000);
			searchBar.sendKeys(typeSomething);
		}
		//clicked on searched product
		@FindBy(xpath = " //span[@class='name']")
		WebElement searchProduct;
		public void clickOnSearchedProduct() throws InterruptedException {
			Thread.sleep(3000);
			searchProduct.click();
		}

		//getting a banner and slecect one
		public void selectHeroBanner() throws InterruptedException {
			List<WebElement> herobanners = driver.findElements(By.xpath("//div[@class='hero-banner']"));
			int count = herobanners.size();
		    logger.info(count);
		    	// Create a random number generator.
			    Random random = new Random();
			    // Generate a random index to select a top-level menu item.
			    int herobannerRandNumber = random.nextInt(count) + 1;
			    logger.info(herobannerRandNumber);
			    if(herobannerRandNumber>0){
			    	WebElement clickHeroBanner = driver.findElement(By.xpath("(//div[@class='hero-banner'])[" + herobannerRandNumber + "]"));
			        //clickClp.click();
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        logger.info("coming here");
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickHeroBanner);
			        Thread.sleep(2000);
			        clickHeroBanner.click();
			        //js.executeScript("arguments[0].click();", clickHeroBanner);
			    }
		}
		
	  public void homepageClickClp() throws InterruptedException {
		//move to clp to the plp
          CLPpage clp = new CLPpage(driver);
          clp.selectaClpRandomly();   
	  }
	
	//drop down my account
		@FindBy(xpath = "//div[contains(@class,'login-section')]")
		WebElement myAccount;
		public void clickOnMyAccount() throws InterruptedException {
			Actions action = new Actions(driver);
			Thread.sleep(2000);
			action.moveToElement(myAccount).build().perform();
			//myAccount.click();
		}
		//my orders
		@FindBy(xpath = "(//a[contains(text(),'My Orders')])[1]")
		WebElement myOrders;
		public void clickOnMyOrders() {
			myOrders.click();
		}
	
		//logout
		@FindBy(xpath = "(//a[contains(text(),'Logout')])[1]")
		WebElement logout;
		public void clickOnLogout() {
			logout.click();
		}
			
		
	//myfav icon
	@FindBy(xpath = "(//span[contains(text(),'Wishlist')])[1]")
	WebElement wishlist;
	public void clickOnWishlist(WebDriver driver) throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", wishlist);
	}
		
			


	
	 
	//validating the Home page
	//menus
	public void menus(WebDriver driver) throws InterruptedException {
		List<WebElement> navMenu = driver.findElements(By.xpath("//a[contains(@class,'nav-link dropdown')]"));
	    int count = navMenu.size();
	    if(count>0) {
          logger.info("Menus are displayed on the page.");
            
            test.pass("Menus are displayed on the page.");
        } else {
            logger.info("Menus are not displayed on the page.");
            
            test.fail("Menus are not displayed on the page.");
        }
	}

  //logo
  public  void logo(WebDriver driver) throws InterruptedException {
    WebElement Logo = driver.findElement(By.xpath("//div[contains(@class,'navbar-brand')]//img[@class='fmg-logo']"));
    test.info("Test Method: logo");
    // Check if the logo is displayed
    if (Logo.isDisplayed()) {
        logger.info("Logo is displayed on the page.");
        
        test.pass("Logo is displayed on the page.");
    } else {
        logger.info("Logo is not displayed on the page.");
        test.fail("Logo is not displayed on the page.");
    }
    Thread.sleep(2000);
 }
  
 //search bar
 public  void search(WebDriver driver) throws InterruptedException {
	 List<WebElement> serachList =driver.findElements(By.xpath("//input[@name='q']"));
	 if(serachList.size()>0) {
		 WebElement Search = driver.findElement(By.xpath("//input[@name='q']"));
		 test.info("Test Method: search");
	        // Check if the search input field is enabled
	        if (Search.isEnabled()) {
	            logger.info("Search input field is enabled.");
	            
	            test.pass("Search input field is enabled.");
	        } else {
	            logger.info("Search input field is not enabled.");
	           
	            test.fail("Search input field is not enabled.");
	        }
	        Thread.sleep(2000);
	 }
 }
 
 //mini cart
    public  void minicart(WebDriver driver) throws InterruptedException {
    	 // Find the MiniCart element using the provided XPath
        WebElement MiniCart = driver.findElement(By.xpath("//a[contains(@class, 'minicart')]"));
        test.info("Test Method: minicart");
        // Check if the MiniCart is displayed
        if (MiniCart.isDisplayed()) {
            logger.info("MiniCart is displayed on the page.");
            
            test.pass("MiniCart is displayed on the page.");
        } else {
            logger.info("MiniCart is not displayed on the page.");
            test.fail("MiniCart is not displayed on the page.");
        }
        Thread.sleep(2000);
    }
    
//    //wishList
//    public  void wishlist(WebDriver driver) throws InterruptedException {
//    	
//    WebElement WishList = driver.findElement(By.xpath("(//span[@class = 'sr-only' and text() ='Wishlist'])[1]"));
//  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",WishList);
//    if (WishList.isDisplayed()) {
//    	logger.info("Wishlist is displayed on the page.");
//    } else {
//    	logger.info("Wishlist is not displayed on the page.");
//    }
//    Thread.sleep(2000);
//    }
    
    //profile
    public  void profile(WebDriver driver) throws InterruptedException {
    	 List<WebElement> profileList = driver.findElements(By.xpath("//div[contains(@class,'login-section')]"));	
    	 if(profileList.size()>0) {
			    WebElement Profile = driver.findElement(By.xpath("//div[contains(@class,'login-section')]"));
			    test.info("Test Method: profile");
		        // Check if the Profile (Sign In) is displayed
		        if (Profile.isDisplayed()) {
		            logger.info("Profile (Sign In) is displayed on the page.");
		            
		            test.pass("Profile (Sign In) is displayed on the page.");
		        } else {
		            logger.info("Profile (Sign In) is not displayed on the page.");
		           
		            test.fail("Profile (Sign In) is not displayed on the page.");
		        }
		        Thread.sleep(2000);
    	 }
    }
    
    //herobanner
    public  void banners(WebDriver driver) {
   	 List<WebElement> bannerslist = driver.findElements(By.xpath("//div[@class='hero-banner']"));
   	 if(bannerslist.size()>0) {
		    	logger.info("banners is displayed on the page.");
		    	test.pass("banners is displayed on the page.");
		    	
   	 } else {
		    	logger.info("banners is not displayed on the page.");
		    	test.fail("banners is displayed on the page.");
		    }
   	 }
    
    //clps in home page
    public  void clps(WebDriver driver) {
      	 List<WebElement> clpslist = driver.findElements(By.xpath("(//div[contains(@class,'category-tiles-container')]//div[contains(@class,'single-category-tile')])"));
      	 if(clpslist.size()>0) {
   		    	logger.info("clps is displayed on the page.");
   		    	test.pass("clps is not displayed on the page.");
      	 } else {
   		    	logger.info("clps is not displayed on the page.");
   		    	test.fail("clps is notdisplayed on the page.");
   		    }
      	 }
   
    
    //footer
    public  void footer(WebDriver driver) {
    	 List<WebElement> footerlist = driver.findElements(By.xpath("//footer[@id='footercontent']"));
    	 if(footerlist.size()>0) {
		    WebElement Footer = driver.findElement(By.xpath("//footer[@id='footercontent']"));
		    test.info("Test Method: footer");
	        // Check if the Footer is displayed
	        if (Footer.isDisplayed()) {
	            logger.info("Footer is displayed on the page.");
	            
	            test.pass("Footer is displayed on the page.");
	        } else {
	            logger.info("Footer is not displayed on the page.");
	          
	            test.fail("Footer is not displayed on the page.");
	        }
    	 }
    }
			
		
}
