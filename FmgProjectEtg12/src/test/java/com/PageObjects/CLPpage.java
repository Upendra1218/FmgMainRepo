package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.Scenarios.menuSelction;
import com.testcases.baseClass;

public class CLPpage extends baseClass{


	    WebDriver lDriver;
	    //pageFactory constructor for this page
		public CLPpage(WebDriver rDriver ){
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
		}
		
		public void selectaClpRandomly() throws InterruptedException {
			Thread.sleep(5000);
		    // Find all elements that match the specified XPath expression.
		    List<WebElement> elementsofClp = driver.findElements(By.xpath("(//div[contains(@class,'category-tiles-container')]//div[contains(@class,'single-category-tile')])"));
		    
		    // Get the count of matched elements and log it.
		    int count = elementsofClp.size(); 
		    if(count>0) {
		    	// Create a random number generator.
			    Random random = new Random();
			    // Generate a random index to select a top-level menu item.
			    int randomNumberclp = random.nextInt(count) + 1;
			    logger.info(randomNumberclp);
			    Thread.sleep(2000);
			    // Check if a valid random number was generated.
			    if (randomNumberclp > 0) {
			        // Find the WebElement based on the random index and click it.
			        WebElement clickClp = driver.findElement(By.xpath("(//div[contains(@class,'category-tiles-container')]//div[contains(@class,'single-category-tile')])[" + randomNumberclp + "]"));
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickClp);
			        Thread.sleep(2000);
			        if(menu5==5) {
			        	js.executeScript("arguments[0].click();", clickClp);
			        }else {
			        	clickClp.click();
			        }
			        
			      
			      Thread.sleep(4000);
			      List<WebElement> noPlpPage = driver.findElements(By.xpath("//div[contains(@class,'zero-search-results')]"));
			      if(noPlpPage.size()>0) {
			    	  menuSelction.randommenu();
			      }
//		           WebElement pageTitle = driver.findElement(By.xpath("//h1[contains(@class, 'category-name')]"));
//                   String pageTitleText = pageTitle.getText();
//                   logger.info("menu of submenu title"+pageTitleText);
			    }
		    }else {
		    	menuSelction.randommenu();
		    }
		    
		    
		}

		
}
