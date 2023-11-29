package com.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.CLPpage;


public class tc__NavigationEachMenuOneItemGuestUser extends baseClass{
	
	SoftAssert softAssert = new SoftAssert();

    @Test
    public void Navigation() throws InterruptedException {
    	
    	//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		

    	// Find all the top-level menu items.
        List<WebElement> countofMenus = driver.findElements(By.xpath("//a[contains(@class,'nav-link dropdown')]"));

        // Loop through each top-level menu item.
        for (int i = 1; i <= countofMenus.size()-2; ++i) {
            
            // Find all the submenu items for the current top-level menu item.
            List<WebElement> noelementsofdrop = driver.findElements(By.xpath("(//li[contains(@class,'nav-item dropdown')])[" + i + "]//a[@class='dropdown-link']"));

            // Loop through each submenu item.
            for (int j = 1; j <= noelementsofdrop.size(); ++j) {
                Thread.sleep(5000);

                // Locate and hover over the current top-level menu item.
                WebElement NavigationMenu = driver.findElement(By.xpath("(//a[contains(@class,'nav-link dropdown')])[" + i + "]"));
                Thread.sleep(5000);
                Actions action = new Actions(driver);
                action.moveToElement(NavigationMenu).perform();
                Thread.sleep(5000L);

                // Locate and click on the current submenu item using JavaScriptExecutor.
                WebElement NavigationMenuitem = driver.findElement(By.xpath("((//a[contains(@class,'nav-link dropdown')])[" + i + "]/following::a[@role='menuitem'])[" + j + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", new Object[] { NavigationMenuitem });
                Thread.sleep(5000L);
                
                List<WebElement> plpPage = driver.findElements(By.xpath("//div[contains(@class, 'product-items-container')]"));
                
                if (plpPage.size() > 0 ) {
                    logger.info("PLP page is already loaded");
                    WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'category-name')]"));
                    String pageTitleText = pageTitle.getText();
                    logger.info(i+"menu of submenu title"+pageTitleText);
                } else {
                    // Move to CLP to the PLP
                    CLPpage clp = new CLPpage(driver);
                    clp.selectaClpRandomly();
                }
            }
        }

    }

}
