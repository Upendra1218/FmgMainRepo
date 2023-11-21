package com.Validations;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.testcases.baseClass;

public class NavigationProcessWithValidation extends baseClass {
    WebDriver lDriver;

    public NavigationProcessWithValidation(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // This method navigates through all the menus and submenu items on a web page.
    public void goingThroughAlltheMenus(WebDriver driver) throws InterruptedException {
        
        // Find all the top-level menu items.
        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));

        // Loop through each top-level menu item.
        for (int i = 1; i <= countofMenus.size(); ++i) {
            
            // Find all the submenu items for the current top-level menu item.
            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + i + "]//a[@class='dropdown-link']"));

            // Loop through each submenu item.
            for (int j = 1; j <= noelementsofdrop.size(); ++j) {
                Thread.sleep(5000);

                // Locate and hover over the current top-level menu item.
                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]"));
                Thread.sleep(5000);
                Actions action = new Actions(driver);
                action.moveToElement(NavigationMenu).perform();
                Thread.sleep(5000L);

                // Locate and click on the current submenu item using JavaScriptExecutor.
                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", new Object[] { NavigationMenuitem });
                Thread.sleep(5000L);

                // Check the page title to determine which category was clicked.
                List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
                List<WebElement> womensplp = driver.findElements(By.xpath("(//a[contains(text(), 'Womens')])[3]"));
                List<WebElement> menplp = driver.findElements(By.xpath("(//a[contains(text(), 'Mens')])[3]"));
                List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));

                if (newArrivalplp.size() > 0) {
                    // Handle the case when "New Arrivals" category is clicked.
                    String[] newArrivalsCategory = { "WOMENS", "MENS", "ELECTRONICS" };
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("Verify that New Arrivals of  " + pageTitleText + " ");
                    if (pageTitleText.equals(newArrivalsCategory[j - 1])) {
                        test.pass("Successfully clicked on the New Arrivals of  " + pageTitleText + " ");
                        logger.info("Click Success New Arrivals of  " + pageTitleText + "");
                    }
                } else if (womensplp.size() > 0) {
                    // Handle the case when "Womens" category is clicked.
                    String[] womensCategory = { "OUTFITS", "TOPS", "DRESSES", "BOTTOMS", "JACKETS & COATS", "FEELING RED", "EARRINGS", "BRACELETS", "NECKLACES", "SCARVES", "SHOES" };
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("Verify that Womens of  " + pageTitleText + " ");
                    if (pageTitleText.equals(womensCategory[j - 1])) {
                        test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
                        logger.info("Click Success Womens of  " + pageTitleText + "");
                    }
                } else if (menplp.size() > 0) {
                    // Handle the case when "Mens" category is clicked.
                    String[] mensCategory = { "SUITS", "JACKETS & COATS", "DRESS SHIRTS", "SHORTS", "PANTS", "TIES", "GLOVES", "LUGGAGE" };
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("Verify that Mens of  " + pageTitleText + " ");
                    if (pageTitleText.equals(mensCategory[j - 1])) {
                        test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
                        logger.info("Click Success Mens of  " + pageTitleText + "");
                    }
                } else {
                    // Handle the case when "Electronics" category is clicked.
                    String[] electronicsCategory = { "TELEVISIONS", "DIGITAL CAMERAS", "IPOD & MP3 PLAYERS", "GPS NAVIGATION", "GAMING" };
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
                    String pageTitleText = pageTitle.getText();
                    test.info("Verify that Electronics of  " + pageTitleText + " ");
                    if (pageTitleText.equals(electronicsCategory[j - 1])) {
                        test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
                        logger.info("Click Success Electronics of  " + pageTitleText + "");
                    }
                }
            }
        }
    }
    
    public void selectRandomMenu(WebDriver driver) throws InterruptedException {

        // Find all the top-level menu elements on the webpage.
        List<WebElement> elements = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
        
        // Get the total count of top-level menu elements.
        int count = elements.size();
        if (count > 0) {
	        // Create a random number generator.
	        Random random = new Random();
	        
	        // Generate a random index to select a top-level menu item.
	        int randomNumbermenu = random.nextInt(count) + 1;
	
	        // Find all the submenu elements for the randomly selected top-level menu item.
	        List<WebElement> elementsofdrop = driver.findElements(By.xpath("(//li[@class='nav-item dropdown'])[" + randomNumbermenu + "]//a[@class='dropdown-link']"));
	        
	        // Get the total count of submenu elements.
	        int countdropdown = elementsofdrop.size();
	        
	        // Generate a random index to select a submenu item.
	        int randomNumberitem = random.nextInt(countdropdown) + 1;
	
	        // Locate and hover over the randomly selected top-level menu item.
	        WebElement NavigationRandomMenu = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]"));
	        Thread.sleep(5000L);
	        Actions action = new Actions(driver);
	        action.moveToElement(NavigationRandomMenu).perform();
	        Thread.sleep(5000L);
	
	        // Locate and click on the randomly selected submenu item using JavaScriptExecutor.
	        WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1'])[" + randomNumbermenu + "]/following::a[@role='menuitem'])[" + randomNumberitem + "]"));
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", new Object[]{NavigationMenuitem});
	        Thread.sleep(10000L);
	
	        // Check the page title to determine which category was clicked.
	        List<WebElement> newArrivalplp = driver.findElements(By.xpath("(//a[contains(text(), 'New Arrivals')])[2]"));
	        List<WebElement> womensplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Women')]"));
	        List<WebElement> menplp = driver.findElements(By.xpath("//li[@class='breadcrumb-item']/a[contains(text(), 'Men')]"));
	        List<WebElement> electronicsplp = driver.findElements(By.xpath("(//a[contains(text(), 'Electronics')])[3]"));
	
	        // Check which category is displayed based on the page title and random submenu item.
	        if (newArrivalplp.size() > 0) {
	            // Handle the case when "New Arrivals" category is clicked.
	            String[] newArrivalsCategory = {"WOMENS", "MENS", "ELECTRONICS"};
	            WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	            String pageTitleText = pageTitle.getText();
	            test.info("Verify that New Arrivals of  " + pageTitleText + " ");
	            if (pageTitleText.equals(newArrivalsCategory[randomNumberitem - 1])) {
	                test.pass("Successfully clicked on the New Arrivals of  " + pageTitleText + " ");
	                logger.info("Click Success New Arrivals of  " + pageTitleText + "");
	            }
	            
	        } else if (womensplp.size() > 0) {
	            // Handle the case when "Womens" category is clicked.
	            String[] womensCategory = {"OUTFITS", "TOPS", "DRESSES", "BOTTOMS", "JACKETS & COATS", "FEELING RED", "EARRINGS", "BRACELETS", "NECKLACES", "SCARVES", "SHOES"};
	            WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	            String pageTitleText = pageTitle.getText();
	            test.info("Verify that Womens of  " + pageTitleText + " ");
	            if (pageTitleText.equals(womensCategory[randomNumberitem - 1])) {
	                test.pass("Successfully clicked on the Womens of  " + pageTitleText + " ");
	                logger.info("Click Success Womens of  " + pageTitleText + "");
	            }
	        } else if (menplp.size() > 0) {
	            // Handle the case when "Mens" category is clicked.
	            String[] mensCategory = {"SUITS", "JACKETS & COATS", "DRESS SHIRTS", "SHORTS", "PANTS", "TIES", "GLOVES", "LUGGAGE"};
	            WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	            String pageTitleText = pageTitle.getText();
	            test.info("Verify that Mens of  " + pageTitleText + " ");
	            if (pageTitleText.equals(mensCategory[randomNumberitem - 1])) {
	                test.pass("Successfully clicked on the Mens of  " + pageTitleText + " ");
	                logger.info("Click Success Mens of  " + pageTitleText + "");
	            }
	        } else {
	            // Handle the case when "Electronics" category is clicked.
	            String[] electronicsCategory = {"TELEVISIONS", "DIGITAL CAMERAS", "IPOD & MP3 PLAYERS", "GPS NAVIGATION", "GAMING"};
	            WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
	        	String pageTitleText = pageTitle.getText();
	        	test.info("verify that Electronics of  " + pageTitleText + " ");
	        	if (pageTitleText.equals(electronicsCategory[randomNumberitem-1])) {
	        		test.pass("Successfully clicked on the Electronics of  " + pageTitleText + " ");
	                logger.info("click Success Electronics of  " + pageTitleText + "");
	        	}
	        }
        }  
    } 
    
}
