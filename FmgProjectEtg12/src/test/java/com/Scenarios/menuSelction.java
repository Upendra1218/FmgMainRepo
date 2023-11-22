package com.Scenarios;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.PageObjects.CLPpage;
import com.PageObjects.homePage;
import com.PageObjects.productListingPage;
import com.testcases.baseClass;

public class menuSelction extends baseClass {

    public static void menues() throws InterruptedException {
    	
        randommenu();

        // Find all the "Add to Cart" buttons on the page.
        List<WebElement> plpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
        logger.info(plpPage.size());
        
        if (plpPage.size() > 0) {
            logger.info("PLP page is already loaded");
        } else {
            menues();
        }
    }

    public static void randommenu() throws InterruptedException {
    	
    	test.info("Validate the Menus and submenus Navigation");
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        // Find all the top-level menu elements on the webpage.
        List<WebElement> elements = driver.findElements(By.xpath("//a[contains(@class,'nav-link dropdown')]"));
        
        // Get the total count of top-level menu elements.
        int count = elements.size();
        logger.info("Total menus count is " + count);
        
        // Create a random number generator.
        Random random = new Random();
        
        // Generate a random index to select a top-level menu item.
        int randomNumbermenu = random.nextInt(count) + 1;
        menu5 =randomNumbermenu;
        logger.info("Randomly selected menu number " + randomNumbermenu);
        
        if(count==randomNumbermenu) {
        	logger.info("random genrate is 8");
        	// Locate and hover over the randomly selected top-level menu item.
        	WebElement sales = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
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
        	    plpPage.addtocartplp();
        	} else if (pdpPagecheck.size() > 0) {
        	    logger.info("PDP page is already loaded");
        	    pdpPage.addtoCartPDP();
        	} else {
        	    // Move to CLP to the PLP
        	    CLPpage clp = new CLPpage(driver);
        	    clp.selectaClpRandomly();
        	}

        }else if(randomNumbermenu==5){
        	
        }else if(randomNumbermenu==7) {
        	logger.info("random genrate is 7");
        	randommenu();
        }else {

        // Find all the submenu elements for the randomly selected top-level menu item.
        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[contains(@class,'nav-item dropdown')])[" + randomNumbermenu + "]//a[contains(@class,'dropdown-link')]"));
        
        // Get the total count of submenu elements.
        int countdropdown = elementsofdrop.size();
        logger.info("Total number of sub menus associated with the hovered menu " + countdropdown);

        // Generate a random index to select a submenu item.
        int randomNumberitem = random.nextInt(countdropdown) + 1;
        logger.info("Randomly selected sub menu number " + randomNumberitem);
        
        
        	// Locate and hover over the randomly selected top-level menu item.
            WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]"));
            String menuText = NavigationRandomMenu.getText();
            Thread.sleep(5000L);
            Actions action = new Actions(driver);
            action.moveToElement(NavigationRandomMenu).perform();
            Thread.sleep(2000L);

            // Locate and click on the randomly selected submenu item using JavaScriptExecutor.
            WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[contains(@class,'nav-link dropdown')])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
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
        	    clp.selectaClpRandomly();
        	}
        }

        
    }
}
