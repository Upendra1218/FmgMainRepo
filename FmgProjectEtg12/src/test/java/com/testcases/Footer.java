package com.testcases;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.FreeCatalog;


public class Footer extends baseClass{

	// Test method that depends on the successful launch of the Chrome browser
	@Test(dependsOnMethods = { "com.Launchingbrowser.launchBrowsering.chromeBrowser" })
	public void footer() throws InterruptedException {
	    // Check if the browser is successfully launched
	    if (isBrowserLaunched) {
	        // Check if the test is for regression or smoke
	        if (RegressionTestCase) {
	            // Perform subscription action
	            subscription();
	            
	            // Verify the pagination of the "About Us" page
	            clickOnAboutUs();
	            
	            // Verify the pagination of "All Assortable Pricing" page
	            allAssortablePricingPagination();
	            
	            // Uncomment the following line if there is a method for "contactUsPagination" and implement it
	            // contactUsPagination();
	            
	            // Perform the action related to the free catalog in the footer
	            freeCatalogFromFooter();
	            
	            // Verify the pagination of "Precious Metal Pricing" page
	            preciousMetalPricingInformation();
	            
	            // Verify the pagination of the "Privacy Policy" page
	            privacyPolicy();
	            
	            // Verify the pagination of "Returns and Exchanges" page
	            returnsandExchanges();
	            
	            // Verify the pagination of "Shipping Information" page
	            shippingInformation();
	            
	            // Verify the pagination of "Special Orders" and "Platinum Partners Program" pages
	            specialorders();
	        } else {
	            // If it's a smoke test, log information and perform random link navigation in the footer
	            logger.info("This is a smoke test");
	            randomLinkInFooter();
	        }
	    }
	}

	
	 public void subscription() {
			// Submit the subscription		
			// Uncomment the following line if using Faker library
			// Faker faker = new Faker();
			
	        // Generate a fake email for subscription
	        String fakeEmail ="akhila.m";
	        
	        // Concatenate a domain to the fake email
	        String email = fakeEmail + "@etg.digital";
	        
	        // Locate the subscription email input field on the web page
	        WebElement subscriptionField = driver.findElement(By.id("dwfrm_mcsubscribe_email"));
	        
	        // Enter the generated email into the subscription field
	        subscriptionField.sendKeys(email);
	        test.info("Entered email in subscription");
	        
	        // Locate the subscription button on the web page
	        WebElement clickSubscription = driver.findElement(By.xpath("//button[contains(@class,'subscribe-email')]"));
	        
	        // Create a JavascriptExecutor to execute JavaScript commands
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        
	        // Scroll the subscription button into view
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", clickSubscription);
	        
	        // Click the subscription button using JavaScript to bypass any potential issues
	        js.executeScript("arguments[0].click();", clickSubscription);
	        test.info("Submitted the email in subscription");
	        
	        // Uncomment the following line if a delay is needed for further validation
	        // Thread.sleep(6000);
	        
	        // Call a method for additional validation (assuming the method is defined elsewhere)
	        // addtoCartValidation.validatingSubscription(driver);
	}

	
	 public void clickOnAboutUs() throws InterruptedException {
		    // Introduce a delay for stability, allowing time for the page to load
		    Thread.sleep(5000);
		    
		    // Locate the "About Us" link on the web page
		    WebElement aboutUsLink = driver.findElement(By.xpath("//a[contains(text(),'About Us')]"));
		    
		    // Create a JavascriptExecutor to execute JavaScript commands
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    // Scroll the "About Us" link into view
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutUsLink);
		    
		    // Click the "About Us" link using JavaScript to bypass any potential issues
		    js.executeScript("arguments[0].click();", aboutUsLink);
		    
		    // Log information about the action
		    test.info("Verifying the pagination of About Us"); 
		    
		    // Introduce a delay for stability, allowing time for the page to load
		    Thread.sleep(2000);
		    
		    // Locate the element representing the page navigation for "About Us"
		    WebElement aboutUsPagination = driver.findElement(By.xpath("//div[contains(text(),'About Us')]"));
		    
		    // Retrieve the actual text of the page navigation
		    String actualPagination = aboutUsPagination.getText();
		    
		    // Define the expected page navigation text
		    String expectedPagination = "About Us";
		    
		    // Compare the actual and expected page navigation text
		    if(actualPagination.equals(expectedPagination)) {
		        // If the text matches, log and report a pass
		        test.pass("Successfully navigated to About Us page");
		        logger.info("Successfully navigated to About Us page");
		    } else {
		        // If the text does not match, log and report a fail
		        test.fail("The pagination does not match expected " + expectedPagination + ", but found " + actualPagination);
		        logger.info("Click failed");
		    }		 
		}

	 public void allAssortablePricingPagination() {
		    // Create a JavascriptExecutor to execute JavaScript commands
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    // Locate the "All-Assortable Pricing" link on the web page
		    WebElement assortablePricingLink = driver.findElement(By.xpath("//a[@title='All-Assortable Pricing']"));
		    
		    // Click the "All-Assortable Pricing" link using JavaScript to bypass any potential issues
		    js.executeScript("arguments[0].click();", assortablePricingLink);
		    
		    // Log information about the action
		    test.info("Verifying the pagination of All Assortable Pricing"); 
		    
		    // Locate the element representing the page navigation for "All Assortable Pricing"
		    WebElement assortablePricingPagination = driver.findElement(By.xpath("//h1[contains(text(),'All Assortable Pricing')]"));
		    
		    // Retrieve the actual text of the page navigation
		    String actualPagination = assortablePricingPagination.getText();
		    
		    // Define the expected page navigation text
		    String expectedPagination = "All Assortable Pricing";
		    
		    // Compare the actual and expected page navigation text
		    if(actualPagination.equals(expectedPagination)) {
		        // If the text matches, log and report a pass
		        test.pass("Successfully navigated to Assortable Pricing page");
		        logger.info("Successfully navigated to Assortable Pricing page");
		    } else {
		        // If the text does not match, log and report a fail
		        test.fail("The pagination does not match expected " + expectedPagination + ", but found " + actualPagination);
		        logger.info("Click failed");
		    }	
		}

	
	 public void randomLinkInFooter() throws InterruptedException {
		    // Create a JavascriptExecutor to execute JavaScript commands
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    
		    // Locate all the links in the footer
		    List<WebElement> linksInFooter = driver.findElements(By.xpath("//ul[@class='pt-3']//a"));

		    if (!linksInFooter.isEmpty()) {
		        // Generate a random index
		        Random random = new Random();
		        int randomIndex = random.nextInt(linksInFooter.size());

		        // Retrieve the randomly picked item
		        WebElement randomItem = linksInFooter.get(randomIndex);

		        // Get the text of the randomly picked item
		        String randomtext = randomItem.getText();

		        // Print the result
		        System.out.println("Randomly Picked Item: " + randomtext);

		        try {
		            // Click the randomly picked item using JavaScript to bypass any potential issues
		            js.executeScript("arguments[0].click();", randomItem);
		            test.pass("Successfully clicked on the randomly picked item");
		            Thread.sleep(4000);
		        } catch (Exception e) {
		            // Handle exceptions by attempting a regular click if the JavaScript click fails
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		            randomItem.click();
		            test.pass("Successfully clicked on the randomly picked item");
		            Thread.sleep(4000);
		        }

		        // Check the page title to determine which category was clicked.
		        List<WebElement> mainHeader = driver.findElements(By.xpath("//h1"));
		        List<WebElement> mainHeader2 = driver.findElements(By.xpath("//h1[@class='d-none']"));

		        if (mainHeader.size() > 0) {
		            // Handle the case when "New Arrivals" category is clicked.
		            String[] customerService = { "Contact Us", "Product Safety and Restrictions", "Returns and Exchanges", 
		                                        "Shipping Information", "Privacy Policy", "Precious Metal Pricing",
		                                        "Fire Mountain Gems and Beads’ Platinum Partner’s Program", "All Assortable Pricing"};
		            List<WebElement> pageTitleList = driver.findElements(By.xpath("(//h1)[2]"));
		            
		            if (pageTitleList.size() > 0) {
		                WebElement pageTitle = driver.findElement(By.xpath("(//h1)[2]"));
		                String pageTitleText = pageTitle.getText();
		                test.info("Verify navigation of footer link of " + pageTitleText);
		                
		                // Check if pageTitleText is in customerService array
		                if (Arrays.asList(customerService).contains(pageTitleText)) {
		                    test.pass("Successfully clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                    logger.info("Successfully clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                } else {
		                    test.fail("Not clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                    logger.info("Not clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                }
		            } else {
		                test.pass("Successfully clicked on the Gift certificate");
		            }
		        } else if (mainHeader2.size() > 0) {
		            // Handle the case when "New Arrivals" category is clicked.
		            String[] h1Links = { "Free Catalog Form", "About Us", "Employment Opportunities", "Special Orders"};
		            WebElement pageTitle2 = driver.findElement(By.xpath("//h1[@class='d-none']"));
		            String pageTitleText = pageTitle2.getText();
		            test.info("Verify navigation of footer link of " + pageTitleText);
		            
		            // Check if pageTitleText is in h1Links array
		            if (Arrays.asList(h1Links).contains(pageTitleText)) {
		                test.pass("Successfully clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                logger.info("Successfully clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		            } else {
		                test.fail("Not clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		                logger.info("Not clicked on the " + randomtext + " link and navigated to respected page " + pageTitleText);
		            }
		        }
		    }
		}

	
	public void contactUsPagination() throws InterruptedException {
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement contactUsLink= driver.findElement(By.xpath("//a[@title='Contact Us']"));
		 js.executeScript("arguments[0].click();",contactUsLink);
		  
		  //page naviagtion of contact us 
		  WebElement contactUsPagination= driver.findElement(By.xpath("//h1[contains(text(),'Contact Us')]"));
		  String actualPagination = contactUsPagination.getText();
		  String expectedPagination= "Contact Us";
		  
		  test.info("Verifying the pagination of contact Us"); 
		  if(actualPagination.equals(expectedPagination)) {		
			  		test.pass("Successfully naviagted to Contact Us");
			        logger.info("Successfully naviagted to Contact Us");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }	
		  
		  //question in fmg
		  WebElement questionsInfmg= driver.findElement(By.xpath("//a[contains(text(),'Questions@firemtn.com')]"));
		  questionsInfmg.click();
		  
		  Thread.sleep(3000);
		  //page naviagtion of contact us 
		  WebElement questionPagination= driver.findElement(By.xpath(" //h1[contains(text(),'Questions')]"));
		  String actualQuestionPagination = questionPagination.getText();
		  String expectedQuestionPagination="Questions";
		  
		  if(actualQuestionPagination.equals(expectedQuestionPagination)) {		
			  		test.pass("Successfully naviagted to Questions");
			        logger.info("Successfully naviagted to Questions");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedPagination + " " + "  but found" + " " + actualPagination+ " ");
			        logger.info("Click failed");
			    }	
		  
	
		   Thread.sleep(5000);
		// If the component is within an iframe, switch to it
		   driver.switchTo().frame("iframe-id-or-name");

		   // Interact with the elements inside the iframe

		   // Switch back to the default content
		   driver.switchTo().defaultContent();
		  // Find and interact with the elements.
		   WebElement parentField = driver.findElement(By.id("LightningComponentid"));
		   
		   WebElement categoryField = parentField.findElement(By.xpath("(//span[@class='slds-truncate'])[1]"));
	        categoryField.click();
	        
	     //Find the dropdown element by its class (you can use other locators)
	        WebElement dropdownElement = driver.findElement(By.cssSelector("lightning-base-combobox"));

	        // Create a Select object if the dropdown is a <select> element
	        Select dropdown = new Select(dropdownElement);

	        // Get all the options within the dropdown
	        List<WebElement> options = dropdown.getOptions();

	        // Generate a random index to select an option
	        Random rand = new Random();
	        int randomIndex = rand.nextInt(options.size());

	        // Select the random option
	        dropdown.selectByIndex(randomIndex);

	        // You can then select an option from the dropdown list if available.
	        String fakeEmail ="akhila.m";
	        String email = fakeEmail+ "@etg.digital";
	        WebElement emailField = driver.findElement(By.id("input-21"));
	        emailField.sendKeys(email);

	        WebElement orderField = driver.findElement(By.id("input-31"));
	        orderField.sendKeys("R000011848");

	        WebElement nameField = driver.findElement(By.id("input-37"));
	        nameField.sendKeys("John Doe");

	        WebElement questionCommentField = driver.findElement(By.id("input-46"));
	        questionCommentField.sendKeys("This is a test question/comment.");

	        // You can also handle file uploads, but it's a bit more complex. 
	        // You'll need to use the input type="file" element and sendKeys to set the file path.

	        // Submit the form.
	        WebElement submitButton = driver.findElement(By.xpath("//button[contains(text(),'Send')]"));
	        submitButton.click();
	}
	
	// Method to click on the "Free Catalog" link in the footer and navigate to the Free Catalog page
	public void freeCatalogFromFooter() throws InterruptedException {
		 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement freeCatalog = driver.findElement(By.xpath("//a[@title='Free Catalog']"));
			js.executeScript("arguments[0].click();",freeCatalog);
		 
			
		 FreeCatalog catalog= new  FreeCatalog();
		 catalog.freeCatalogPage();
		 
		 
	}
	
	public void preciousMetalPricingInformation() throws InterruptedException {
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement metalPricingLink = driver.findElement(By.xpath("//a[@title='Precious Metal Pricing Information']"));
		 js.executeScript("arguments[0].click();",metalPricingLink );
		 Thread.sleep(2000);
		 
		 //pagination of metal pricing
		 test.info("Verifying the pagination of Precious Metal Pricing"); 
		 WebElement metalPricingPage = driver.findElement(By.xpath("//h1[contains(text(),'Precious Metal Pricing')]"));
		 
		
		  String actualmetalPricinPagination =metalPricingPage.getText();
		  String expectedmetalPricinPagination="Precious Metal Pricing";
		  
		  if(actualmetalPricinPagination.equals(expectedmetalPricinPagination)) {		
			  		test.pass("Successfully naviagted to metalPricingPage ");
			        logger.info("Successfully naviagted to metalPricingPage");
			    } else {
			        test.fail( "The pagination does not match expected " + expectedmetalPricinPagination + " " + "  but found" + " " +actualmetalPricinPagination+ " ");
			        logger.info("Click failed");
			    }	

	}
	// Method to navigate to the Privacy Policy page and verify its pagination
	public void privacyPolicy() throws InterruptedException {
	    // Create a JavascriptExecutor to execute JavaScript commands
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Locate the "Privacy Policy" link on the web page
	    WebElement privacyPolicyLink = driver.findElement(By.xpath("//a[@title='Privacy Policy']"));

	    // Execute JavaScript to click on the "Privacy Policy" link
	    js.executeScript("arguments[0].click();", privacyPolicyLink);

	    // Wait for the Privacy Policy page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Privacy Policy");

	    // Locate the element representing the page navigation for "Privacy Policy"
	    WebElement privacyPolicyPage = driver.findElement(By.xpath("//h1[contains(text(),'Privacy Policy')]"));

	    // Retrieve the actual text of the page navigation
	    String actualPrivacyPolicyPagination = privacyPolicyPage.getText();
	    String expectedPrivacyPolicyPagination = "Privacy Policy";

	    // Compare the actual and expected page navigation text
	    if (actualPrivacyPolicyPagination.equals(expectedPrivacyPolicyPagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Privacy Policy Page");
	        logger.info("Successfully navigated to Privacy Policy Page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedPrivacyPolicyPagination + " but found " + actualPrivacyPolicyPagination);
	        logger.info("Click failed");
	    }
	}

	// Method to navigate to the Product Safety and Restrictions page and verify its pagination
	public void productSafety() throws InterruptedException {
	    // Create a JavascriptExecutor to execute JavaScript commands
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Locate the "Product Safety" link on the web page
	    WebElement productSafetyLink = driver.findElement(By.xpath("//a[contains(text(),'Product Safety')]"));

	    // Execute JavaScript to click on the "Product Safety" link
	    js.executeScript("arguments[0].click();", productSafetyLink);

	    // Wait for the Product Safety and Restrictions page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Product Safety and Restrictions");

	    // Locate the element representing the page navigation for "Product Safety and Restrictions"
	    WebElement productSafetyPage = driver.findElement(By.xpath("//h1[contains(text(),'Product Safety and Restrictions')]"));

	    // Retrieve the actual text of the page navigation
	    String actualProductSafetyPagination = productSafetyPage.getText();
	    String expectedProductSafetyPagination = "Product Safety and Restrictions";

	    // Compare the actual and expected page navigation text
	    if (actualProductSafetyPagination.equals(expectedProductSafetyPagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Product Safety and Restrictions page");
	        logger.info("Successfully navigated to Product Safety and Restrictions page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedProductSafetyPagination + " but found " + actualProductSafetyPagination);
	        logger.info("Click failed");
	    }
	}
	
	// Method to navigate to the Returns and Exchanges page and verify its pagination
	public void returnsandExchanges() throws InterruptedException {
	    // Create a JavascriptExecutor to execute JavaScript commands
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Locate the "Returns and Exchanges" link on the web page
	    WebElement returnsandExchangesLink = driver.findElement(By.xpath("//a[contains(text(),'Returns and Exchanges')]"));

	    // Execute JavaScript to click on the "Returns and Exchanges" link
	    js.executeScript("arguments[0].click();", returnsandExchangesLink);

	    // Wait for the Returns and Exchanges page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Returns and Exchanges");

	    // Locate the element representing the page navigation for "Returns and Exchanges"
	    WebElement returnsandExchangesPage = driver.findElement(By.xpath("//h1[contains(text(),'Returns and Exchanges')]"));

	    // Retrieve the actual text of the page navigation
	    String actualReturnsandExchangesPagination = returnsandExchangesPage.getText();
	    String expectedReturnsandExchangesPagePagination = "Returns and Exchanges";

	    // Compare the actual and expected page navigation text
	    if (actualReturnsandExchangesPagination.equals(expectedReturnsandExchangesPagePagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Returns and Exchanges page");
	        logger.info("Successfully navigated to Returns and Exchanges page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedReturnsandExchangesPagePagination + " but found " + actualReturnsandExchangesPagination);
	        logger.info("Click failed");
	    }
	}

	// Method to navigate to the Shipping Information page and verify its pagination
	public void shippingInformation() throws InterruptedException {
	    // Create a JavascriptExecutor to execute JavaScript commands
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Locate the "Shipping Information" link on the web page
	    WebElement shippingInformationLink = driver.findElement(By.xpath("(//a[contains(text(),'Shipping Information')])[2]"));

	    // Execute JavaScript to click on the "Shipping Information" link
	    js.executeScript("arguments[0].click();", shippingInformationLink);

	    // Wait for the Shipping Information page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Shipping Information");

	    // Locate the element representing the page navigation for "Shipping Information"
	    WebElement shippingInformationPage = driver.findElement(By.xpath("//h1[contains(text(), 'Shipping Information')]"));

	    // Retrieve the actual text of the page navigation
	    String actualShippingInformationPagination = shippingInformationPage.getText();
	    String expectedShippingInformationPagination = "Shipping Information";

	    // Compare the actual and expected page navigation text
	    if (actualShippingInformationPagination.equals(expectedShippingInformationPagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Shipping Information page");
	        logger.info("Successfully navigated to Shipping Information page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedShippingInformationPagination + " but found " + actualShippingInformationPagination);
	        logger.info("Click failed");
	    }
	}

	
	// Method to navigate to the Special Orders page and verify its pagination
	public void specialorders() throws InterruptedException {
	    // Create a JavascriptExecutor to execute JavaScript commands
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    // Locate the "Special orders" link on the web page
	    WebElement specialordersLink = driver.findElement(By.xpath("//a[contains(text(),'Special orders')]"));

	    // Execute JavaScript to click on the "Special orders" link
	    js.executeScript("arguments[0].click();", specialordersLink);

	    // Wait for the Special Orders page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Special Order");

	    // Locate the element representing the page navigation for "Special Order FAQs"
	    WebElement specialordersPage = driver.findElement(By.xpath("//span[contains(text(),'Special Order FAQs')]"));

	    // Retrieve the actual text of the page navigation
	    String actualSpecialordersPagination = specialordersPage.getText();
	    String expectedSpecialordersPagination = "Special Order FAQs";

	    // Compare the actual and expected page navigation text
	    if (actualSpecialordersPagination.equals(expectedSpecialordersPagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Special Order page");
	        logger.info("Successfully navigated to Special Order page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedSpecialordersPagination + " but found " + actualSpecialordersPagination);
	        logger.info("Click failed");
	    }

	    // Navigates to the Platinum Partners Program page
	    WebElement platinumPartnerLink = driver.findElement(By.xpath("//a[contains(text(),'Platinum Partners Program')]"));
	    js.executeScript("arguments[0].click();", platinumPartnerLink);

	    // Wait for the Platinum Partners Program page to load using explicit wait or other synchronization method
	    // In this case, using Thread.sleep for simplicity (consider using WebDriverWait for robustness)
	    Thread.sleep(2000);

	    // Log information about the action
	    test.info("Verifying the pagination of Fire Mountain Gems and Beads’ Platinum Partner’s Program");

	    // Locate the element representing the page navigation for "Fire Mountain Gems and Beads’ Platinum Partner’s Program"
	    WebElement platinumPartnerPage = driver.findElement(By.xpath("//h1[contains(text(), 'Fire Mountain Gems and Beads’ Platinum Partner’s Program')]"));

	    // Retrieve the actual text of the page navigation
	    String actualPlatinumPartnerPagination = platinumPartnerPage.getText();
	    String expectedPlatinumPartnerPagination = "Fire Mountain Gems and Beads’ Platinum Partner’s Program";

	    // Compare the actual and expected page navigation text
	    if (actualPlatinumPartnerPagination.equals(expectedPlatinumPartnerPagination)) {
	        // If the text matches, log and report a pass
	        test.pass("Successfully navigated to Platinum Partner page");
	        logger.info("Successfully navigated to Platinum Partner Page");
	    } else {
	        // If the text does not match, log and report a fail
	        test.fail("The pagination does not match expected " + expectedPlatinumPartnerPagination + " but found " + actualPlatinumPartnerPagination);
	        logger.info("Click failed");
	    }
	}

	
	
}

	
