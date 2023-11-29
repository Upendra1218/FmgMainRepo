package com.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.PageObjects.CLPpage;
import com.PageObjects.productListingPage;

public class NavigateToAllPlp extends baseClass{

	
	
	@Test 
    public void navigateToAllPlp() throws InterruptedException {
    	
    	
       if(isBrowserLaunched){
    	   
       }
        
        test.info("Validate the Menus and submenus Navigation");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        // Find all the top-level menu elements on the webpage.
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@class,'nav-link dropdown')]"));
        
        // Get the total count of top-level menu elements.
        int count = elements.size();
        logger.info("Total menus count is " + count);
        
        for(int i =1;i<=count; i++) {
        // Create a random number generator.
      //  Random random = new Random();
        
        // Generate a random index to select a top-level menu item.
      //  int randomNumbermenu = random.nextInt(count) + 1;
      //  menu5 =randomNumbermenu;
        logger.info("Randomly selected menu number " + count);
        
        if(count==i) {
        	logger.info("random genrate is 8");
        	// Locate and hover over the randomly selected top-level menu item.
        	WebElement sales = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" +i + "]"));
        	String sale = sales.getText();
        	
        	test.pass("Successfully Navigate to the "+sale);
        	js.executeScript("arguments[0].click();", sales);
        	Thread.sleep(2000);
        	//sales.click();
        	//select a banner form the listed below
        	productListingPage hm = new productListingPage(driver);
        	hm.selectHeroBanner();

        	// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
        	List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        	List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));

        	if (plpPagecheck.size() > 0) {
        	    logger.info("PLP page is already loaded");
        	    // Initialize and execute the PLP page scenario to add a product to the cart
        	    //plpPage.addtocartplp();
        	} else if (pdpPagecheck.size() > 0) {
        	    logger.info("PDP page is already loaded");
        	   // pdpPage.addtoCartPDP();
        	} else {
        	    // Move to CLP to the PLP
        	    CLPpage clp = new CLPpage(driver);
        	    //clp.selectaClpRandomly();
        	}

        }
        else if(i==5){
        	
        }else if(i==7) {
        	logger.info("random genrate is 7");
        	navigateToAllPlp();
        }else {

        // Find all the submenu elements for the randomly selected top-level menu item.
        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[contains(@class,'nav-item dropdown')])[" + i + "]//a[contains(@class,'dropdown-link')]"));
        
        // Get the total count of submenu elements.
        int countdropdown = elementsofdrop.size();
        logger.info("Total number of sub menus associated with the hovered menu " + countdropdown);

        // Generate a random index to select a submenu item.
      //  int randomNumberitem = random.nextInt(countdropdown) + 1;
      //  logger.info("Randomly selected sub menu number " + randomNumberitem);
        
        
        	// Locate and hover over the randomly selected top-level menu item.
            WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + i + "]"));
            String menuText = NavigationRandomMenu.getText();
            Thread.sleep(5000L);
            Actions action = new Actions(driver);
            action.moveToElement(NavigationRandomMenu).perform();
            Thread.sleep(2000L);

            // Locate and click on the randomly selected submenu item using JavaScriptExecutor.
            WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[contains(@class,'nav-link dropdown')])[" + i + "]/following::a[@role='menuitem'])[" + i + "]"));
            String submenu = NavigationMenuitem.getText();
            test.pass("Successfully Navigate to the " +menuText+ " of "+submenu);
            js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
            Thread.sleep(5000L);

            // Check if "Add to Cart" buttons are present on the page.
//            List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
//            logger.info(addtoCartBtns.size());
         // Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
        	List<WebElement> plpPagecheck = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        	List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));

        	if (plpPagecheck.size() > 0) {
        	    logger.info("PLP page is already loaded");
        	    // Initialize and execute the PLP page scenario to add a product to the cart
        	    //plpPage.addtocartplp();
        	} else if (pdpPagecheck.size() > 0) {
        	    logger.info("PDP page is already loaded");
        	    //pdpPage.addtoCartPDP();
        	} else {
        	    // Move to CLP to the PLP
        	    CLPpage clp = new CLPpage(driver);
        	   // clp.selectaClpRandomly();
        	}
        }


              
        }
    	
    }
}
