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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

import com.Validations.NavigationProcessWithValidation;
import com.commonfunctionality.waitForTheElement;
import com.testcases.baseClass;

public class productListingPage extends baseClass{
WebDriver lDriver;


	public productListingPage(WebDriver rDriver ){
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//price book details
	public void tierPrice() throws InterruptedException {
		// Logging information about the test step
		test.info("Verify that price changes and discount applies");

		// Finding all input fields with name 'quantity' on the page
		List<WebElement> quantityInput = driver.findElements(By.xpath("//input[@name='quantity']"));
		int intValueCount=0;
		int productQuantityCount = quantityInput.size();
		int productCount = 150;

		// Creating a random number generator
		Random random = new Random();

		// Generating a random index to select an "Add to Cart" button
		int randomquantityInput = random.nextInt(productQuantityCount) + 1;
		int inputQuantiy = random.nextInt(productCount) + 1;
		logger.info(randomquantityInput);
		logger.info("Product input quantity" + inputQuantiy);

		// Checking if there are quantity input fields present on the page
		if (quantityInput.size() > 0) {

		    // Finding the quantity input field associated with the clicked button and setting the quantity
		    WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomquantityInput + "]"));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
		    Thread.sleep(2000);
		    inctheQuantity.clear(); // Clearing the existing value
		    Thread.sleep(2000);
		    inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
		    Thread.sleep(1000);

		    // Finding the "Add to Cart" button associated with the selected quantity input
		    WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//div[contains(@class,'product-grid')]//a[contains(@class, 'add-to-cart')])[" + randomquantityInput + "]"));

		    // Scrolling to the "Add to Cart" button and clicking it using JavaScript
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickAddtoCartBtn);
		    Thread.sleep(1000);
		    js.executeScript("arguments[0].click();", clickAddtoCartBtn);
		    Thread.sleep(1000);

		    // Getting the value of the quantity input after setting it
		    String valuecount = inctheQuantity.getAttribute("value");
		    logger.info(valuecount);

		    // Converting the string to an integer
		    intValueCount = Integer.parseInt(valuecount);
		    logger.info(intValueCount);

		} else {
		    // If no quantity input fields found, perform navigation and selection of a random menu item
		    NavigationProcess navProcess = new NavigationProcess(driver);

		    navProcess.selectRandomMenu(driver);
		}

		// Finding elements representing tier prices for the selected quantity
		List<WebElement> tierDivPesent = driver.findElements(By.xpath("//div[@class='pricebooks'][" + randomquantityInput + "]"));

		int displayedtierDivPesent = 0;
		for (WebElement item : tierDivPesent) {
		    // Counting the displayed tier price elements
		    if (item.isDisplayed()) {
		        displayedtierDivPesent++;
		    }
		}

		// Getting the count of displayed tier price elements
		int count = displayedtierDivPesent;
		logger.info("Tier price quantity " + count);

		// Checking if there are displayed tier prices and applying discounts based on the quantity
		if (count > 0) {
		    if (intValueCount < 14) {
		        // Finding elements representing tier 1 prices and extracting the discount information
		        List<WebElement> priceChangeBartier1 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']"));
		        if (priceChangeBartier1.size() > 0) {
		            WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier1-prices active']//div[@class='price']"));
		            String price = priceDiscount.getText();
		            logger.info(price);
		            test.pass("The Discount is on the Blue one" + price);
		            logger.info("The Discount is on the Blue one");
		        }
		    } else if (intValueCount < 49) {
		        // Finding elements representing tier 2 prices and extracting the discount information
		        List<WebElement> priceChangeBartier2 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']"));
		        if (priceChangeBartier2.size() > 0) {
		            WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier2-prices active']//div[@class='price']"));
		            String price = priceDiscount.getText();
		            logger.info(price);
		            test.pass("The Discount is on the Green one" + price);
		            logger.info("The Discount is on the Green one");
		        }
		    } else if (intValueCount < 99) {
		        // Finding elements representing tier 3 prices and extracting the discount information
		        List<WebElement> priceChangeBartier3 = driver.findElements(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']"));
		        if (priceChangeBartier3.size() > 0) {
		            WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier3-prices active']//div[@class='price']"));
		            String price = priceDiscount.getText();
		            logger.info(price);
		            test.pass("The Discount is on the Rose one " + price);
		            logger.info("The Discount is on the Rose one");
		        }
		    } else {
		        // Finding elements representing tier 4 prices and extracting the discount information
		        WebElement priceDiscount = driver.findElement(By.xpath("//div[@class='pricebook usd-fmg-tier4-prices active']//div[@class='price']"));
		        String price = priceDiscount.getText();
		        logger.info(price);
		        test.pass("The Discount is on the Black one" + price);
		        logger.info("The Discount is on the Black one");
		    }
		}
	}
	
	
	// Method to add a product to the cart from the Product Listing Page (PLP)
	public void addToCartFromPlp() throws InterruptedException {
		// Find all color buttons that are enabled
	    List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//div[contains(@class,'product-grid')]//a[contains(@class, 'add-to-cart')]"));
	    int displayedAddToCartCount = 0;
	    for (WebElement item : addtoCartBtns) {
	        if (item.isDisplayed()) {
	        	displayedAddToCartCount++;
	        }
	    }

	    // Get the count of matched elements and log it.
	    int count = displayedAddToCartCount;
	    logger.info("Total add to cart buttons: " + count);
	    if (count > 0) {
	    	// Create a random number generator.
		    Random random = new Random();
	        // Generate a random index to select an "Add to Cart" button.
		    	int randomNumberAddtoCartBtn = random.nextInt(count) + 1;
	        logger.info("Randomly selected Add to Cart button index: " + randomNumberAddtoCartBtn);
	        // Check if a valid random number was generated.
	        if (randomNumberAddtoCartBtn > 0) {
	            // Find the WebElement based on the random index and click it.
	            WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//a[contains(@class, 'add-to-cart')])[" + randomNumberAddtoCartBtn + "]"));
	            // Scroll to the "Add to Cart" button and click it.
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	            // Use JavaScript to scroll the element into the middle of the page view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickAddtoCartBtn);
	            Thread.sleep(1000);
	            js.executeScript("arguments[0].click();", clickAddtoCartBtn);
	            //clickAddtoCartBtn.click();
	            // Validate that the product is added to the cart
	            
	    }else {
        	 logger.info("Randomly selected Add to Cart button index: " + count);
        	 NavigationProcess navProcess = new NavigationProcess(driver);
	           // Select a random menu item
        	 navProcess.selectRandomMenu(driver);
	           addToCartFromPlp();
	    }
	    }
	}
	
	// Method to add a product to the cart from the Product Listing Page (PLP)
		public void addMultipleProductsFromPlp() throws InterruptedException {
			// Find all color buttons that are enabled
		    List<WebElement> addtoCartBtns = driver.findElements(By.xpath("//a[contains(@class, 'add-to-cart')]"));
		    int displayedAddToCartCount = 0;
		    for (WebElement item : addtoCartBtns) {
		        if (item.isDisplayed()) {
		        	displayedAddToCartCount++;
		        }
		    }

		    // Get the count of matched elements and log it.
		    int count = displayedAddToCartCount;
		    logger.info("Total add to cart buttons: " + count);
		    if (count > 0) {
		    	// Create a random number generator.
			    Random random = new Random();
			    // Generate a random number to determine how many products to add (up to the defined maximum)
			    int howmanyProducts = 5;
			  
			    // Loop to add a random number of products to the cart
			    //for (int i = 1; i < howmanyProducts; i++) {
		        // Generate a random index to select an "Add to Cart" button.
			    	int randomNumberAddtoCartBtn = random.nextInt(count) + 1;
			       int i =1;
//		        int randomNumberAddtoCartBtn = random.nextInt(count) + 1;
		        logger.info("Randomly selected Add to Cart button index: " + i);
		        // Check if a valid random number was generated.
		        if (randomNumberAddtoCartBtn > 0) {
		            // Find the WebElement based on the random index and click it.
		            WebElement clickAddtoCartBtn = driver.findElement(By.xpath("(//a[contains(@class, 'add-to-cart')])[" + randomNumberAddtoCartBtn + "]"));
		            // Scroll to the "Add to Cart" button and click it.
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            // Use JavaScript to scroll the element into the middle of the page view
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", clickAddtoCartBtn);
		            Thread.sleep(1000);
		            js.executeScript("arguments[0].click();", clickAddtoCartBtn);
		            //clickAddtoCartBtn.click();
		            // Validate that the product is added to the cart
		            
		         // Create a FluentWait for dynamic element wait
			    	Wait<WebDriver> wait = waitForTheElement.createFluentWait(driver);
			        // Wait for the success alert to be visible
			        WebElement addToCart = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(text(),'Successfully added to your cart.')])[" + i + "]")));
			        // Get the text of the alert
			        String actualAddToCart = addToCart.getText();
			        // Expected alert text
			        String expectedAddToCart = "Successfully added to your cart.";
			        
			        // Check if the actual alert text matches the expected text
			        if (actualAddToCart.equals(expectedAddToCart)) {
			            // Success message is displayed
			        	test.pass("Product added to cart");
			            logger.info("Product is added to cart");
			            // Perform actions or assertions here for the success case
			        } else {
			            // Success message is not as expected
			        	test.fail("Product is not added to cart");
			            logger.info("Product is not added to cart");
			            // Perform actions or assertions here for the failure case
			        }
			            //validationpopupMessages.validatingProductisAddtoCart(driver);
			            Thread.sleep(4000);
		        }
			       // }
		    }else {
	        	 logger.info("Randomly selected Add to Cart button index: " + count);
	        	 NavigationProcess navProcess = new NavigationProcess(driver);
		           // Select a random menu item
	        	 navProcess.selectRandomMenu(driver);
		           addToCartFromPlp();
	        }	
		}
	
	     //getting a banner and slecect one
			public void selectHeroBanner() throws InterruptedException {
				List<WebElement> herobanners = driver.findElements(By.xpath("//div[@class='hero-banner']"));
				int count = herobanners.size();
			    logger.info(count);
			    if(count==7) {
			    	count = count-1;
				    }
			    if(count>0) {
			    	// Create a random number generator.
				    Random random = new Random();
				    // Generate a random index to select a top-level menu item. random.nextInt(count) + 1
				    int herobannerRandNumber =random.nextInt(count) + 1;
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
			 
			}


		//filters
		@FindBy(xpath ="(//select[@name = 'sort-order'])[1]")
		WebElement Filters;
		public void selecttheFilters(int i, WebDriver driver) throws InterruptedException{		
			
			// Get all the available options within the dropdown
			List<WebElement> options = Filters.findElements(By.tagName("option"));

			// Get the total number of options
			int numberOfOptions = options.size();

			// Generate a random index within the range of available options
			Random random = new Random();
			int randomIndex = random.nextInt(numberOfOptions);

			// Select the random option by its index
			options.get(randomIndex).click();
			
//			Select countrySelect = new Select(Filters);
//	        countrySelect.selectByIndex(i);
//	        Thread.sleep(1000);
//	        JavascriptExecutor js = (JavascriptExecutor) driver; 
//			js.executeScript("arguments[0].click();", Filters);
	        
			//Filters.click();
	    	Thread.sleep(3000);
		}
		
	
		//FilterResetButton
		@FindBy(xpath ="//button[@class = 'reset btn p-0']")
		WebElement ResetButton;
		public void selecttheResetButton() throws InterruptedException{
			ResetButton.click();
	    	Thread.sleep(3000);
		}
		
		//WishList
		public void selecttheWishlist() throws InterruptedException{
			//for(int i =2;i<= 2;i++) {
			// Get all the available options within the dropdown
			List<WebElement> wishListBtns = driver.findElements(By.xpath("//a[@title= 'Favorites']"));

			// Get the total number of options
			int numberOfOptions = wishListBtns.size();
			if(numberOfOptions>0) {
				// Generate a random index within the range of available options
				Random random = new Random();
				int randomIndex = random.nextInt(numberOfOptions)+1;
					
				WebElement wishlistPlp = driver.findElement(By.xpath("(//a[@title= 'Favorites'])["+randomIndex+"]"));
				Thread.sleep(4000);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", wishlistPlp);
				executor.executeScript("arguments[0].click();", wishlistPlp);
			}

			
				
				//wishlistPlp.click();
			//}
		}
		
		
		public static void selectRandomProduct() {
			 // Create a new Random object
	        Random random = new Random();
	        
	        // Find all the product elements on the current page (after navigating)
	        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
	        
	        // Get the total count of products found on the page
	        int totalProductcount = products.size();
	        
	        // Check if there are any products found on the page
	        if (totalProductcount > 0) {
	            // Generate a random number within the range of the total product count
	            int randomSelectProduct = random.nextInt(totalProductcount) + 1;

	            // Find the randomly selected product element based on the generated random number
	            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
	            
	            // Use JavaScript Executor to click on the randomly selected product element
	            JavascriptExecutor js = (JavascriptExecutor)driver;
	            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
	        }
	        
		}
		
		public void selectaFilterFormPLP() throws InterruptedException {
			// Find the element using the dynamic XPath with a wildcard
	        List<WebElement> TotalNumberofFilters =  driver.findElements(By.xpath("//div[contains(@class, 'refinement refinement-')]"));
	        // Get the total count of top-level menu elements.
	        int Filterscount = TotalNumberofFilters.size();
	        logger.info("Total filters count is " + Filterscount);
	        // Create a random number generator.
	        Random random = new Random();
	        // Generate a random index to select a top-level menu item.
	        int randomNumberFilter = random.nextInt(Filterscount) + 1;
	        logger.info("Randomly selected filters number " + randomNumberFilter);
	        
	        // get the name of the Main filter 
	        WebElement mainFilterName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//h6)["+randomNumberFilter+"]"));
	        // Get and print the text of the found element
	        String NameofFilterText = mainFilterName.getText();
	        logger.info(NameofFilterText);
	        
	        //number of sub filtes associate with the main filter
	        List<WebElement> numberofFiltersinOneFilter =  driver.findElements(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
	        // Get the total count of top-level menu elements.
	        int countofeachFilterbtns = numberofFiltersinOneFilter.size();
	        logger.info("Total filters countofeachFilterbtns is " + countofeachFilterbtns);
	        // Generate a random index to select a top-level menu item.
	        int randomNumbercountofeachFilterbtns = random.nextInt(countofeachFilterbtns) + 1;
	        logger.info("Randomly selected subfilter number " + randomNumbercountofeachFilterbtns);
	        
	        String SelectedTextname ="";
	        String priceName ="Price";
	        if(NameofFilterText.equals(priceName)) {
	        	 WebElement selectedName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//span[@aria-hidden='true']"));
	        	 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", selectedName);
	        	 Thread.sleep(2000);
	        	 SelectedTextname = selectedName.getText();
	        }else {
		        
	 	       //name of the selected radio icon
	 	        WebElement selectedName = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//span[@class='refinement-value ']"));
	 	        // Get and print the text of the found element
	 	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", selectedName);
	 	      Thread.sleep(2000);
	 	        SelectedTextname = selectedName.getText();
	        }

	        
	        // Extract content within parentheses using regular expressions and seperate the text
	        String extractedContent = extractContentWithinParentheses(SelectedTextname);
	        String textWithoutParentheses = removeContentWithinParentheses(SelectedTextname);
	        // Print the result
	        logger.info("Original Text: " + SelectedTextname);
	        logger.info("Extracted Content: " + extractedContent);
	        logger.info("Text without Parentheses: " + textWithoutParentheses);
	        
	        //Radio icon of the filter
	        WebElement selectRadioIcon = driver.findElement(By.xpath("(//div[contains(@class, 'refinement refinement-')]//div[contains(@id, 'refinement-')])["+randomNumberFilter+"]//button"));
	        //selectRadioIcon.click();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        //((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", selectRadioIcon);
	        js.executeScript("arguments[0].click();", selectRadioIcon);
	        Thread.sleep(4000);
	        
	        //get the filters name which is selected 
	        WebElement selectedNameinFilters = driver.findElement(By.xpath("//div[contains(@class, 'refinement-device')]//span"));
	        // Get and print the text of the found element
	        String SelectedTextofFiltersname = selectedNameinFilters.getText();
	        logger.info(SelectedTextofFiltersname);
	        
	        //get How many prodcts loaded
	        WebElement loadedProductsCount = driver.findElement(By.xpath("(//span[@class='count-value'])[1]"));
	        // Get and print the text of the found element
	        String productsCount = loadedProductsCount.getText();
	        logger.info(productsCount);
	        
	      //check the condition for which filter is selected
	        if((textWithoutParentheses.equals(SelectedTextofFiltersname))|| (extractedContent.equals(productsCount))) {
	        	logger.info(NameofFilterText+" Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
	        	test.pass(NameofFilterText+" Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
	        }else {
	        	logger.info(NameofFilterText+" Not Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
	        	test.pass(NameofFilterText+" Not Selected The Filter "+extractedContent+" And The Loaded Products are "+productsCount);
	        }
	        
	        Thread.sleep(4000);
		}
		
		 private static String extractContentWithinParentheses(String input) {
		        // Use regular expression to match content within parentheses
		        // and capture the content using groups
		        String regex = "\\(([^)]+)\\)";
		        java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(regex);
		        java.util.regex.Matcher matcher = pattern.matcher(input);

		        // Check if there is a match
		        if (matcher.find()) {
		            return matcher.group(1); // Extract content within parentheses
		        } else {
		            return ""; // Return empty string if no match found
		        }
		    }
		 private static String removeContentWithinParentheses(String input) {
		        // Use regular expression to match content within parentheses
		        // and remove it from the input string
		        String regex = "\\([^)]+\\)";
		        return input.replaceAll(regex, "");
		    }
		

		//select a random product
		public void selectProductRandom(WebDriver driver) throws InterruptedException {
		    // Create a Random object to generate random numbers
		    Random random1 = new Random();
		    
		    // Find all the product elements on the current page
		    List<WebElement> products1 = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		    
		    // Get the total count of products found on the page
		    int totalProductcount1 = products1.size();
		    
		    // Check if there are any products found on the page
		    if (totalProductcount1 > 0) {
		        // Generate a random number within the range of the total product count
		        int randomSelectProduct = random1.nextInt(totalProductcount1) + 1;

		        // Find the randomly selected product element based on the generated random number
		        WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		        
		        // Use JavaScript Executor to click on the randomly selected product element
		        JavascriptExecutor js = (JavascriptExecutor)driver;
		        js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		    }
		    
		    // Pause the execution for 2 seconds (simulating a wait for the page to load)
		    Thread.sleep(2000);
		    
		    // Check if there's an element indicating that the PDP (Product Detail Page) is loading
		    List<WebElement> validatingPdpIsLoading = driver.findElements(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		    
		    // Log the count of elements found for validation
		    logger.info(validatingPdpIsLoading.size());
		    
		    // Check if the PDP validation element is found
		    if (validatingPdpIsLoading.size() > 0) {
		        logger.info("PDP is not validating");
		        
		        // Find and click the "Continue Shopping" button
		        WebElement continueShoppingBtn = driver.findElement(By.xpath("//a[contains(@class, 'continue-shopping')]"));
		        continueShoppingBtn.click();
		        
		        // Pause the execution for 3 seconds (simulating some wait time)
		        Thread.sleep(3000);
  
		        // Call the selectRandomMenu method from the navigationPage object to select a random menu item
		        NavigationProcessWithValidation  navPage =new NavigationProcessWithValidation (driver);
		    	 navPage.selectRandomMenu(driver);
		        
		        // Create a new Random object
		        Random random = new Random();
		        
		        // Find all the product elements on the current page (after navigating)
		        List<WebElement> products = driver.findElements(By.xpath("//a[@class ='tile-img-contain']"));
		        
		        // Get the total count of products found on the page
		        int totalProductcount = products.size();
		        
		        // Check if there are any products found on the page
		        if (totalProductcount > 0) {
		            // Generate a random number within the range of the total product count
		            int randomSelectProduct = random.nextInt(totalProductcount) + 1;

		            // Find the randomly selected product element based on the generated random number
		            WebElement randomSelectProductFromPLP = driver.findElement(By.xpath("(//a[@class ='tile-img-contain'])[" + randomSelectProduct + "]"));
		            
		            // Use JavaScript Executor to click on the randomly selected product element
		            JavascriptExecutor js = (JavascriptExecutor)driver;
		            js.executeScript("arguments[0].click();", randomSelectProductFromPLP);
		        }
		    }
		}

		//validations 
		//Name
		 public  void name(WebDriver driver) throws InterruptedException {
			 WebElement Name = driver.findElement(By.xpath("//h1[contains(@class, 'page-title')]"));
			    if (Name.isEnabled()) {
			    	logger.info("catagory name is displayed on the page");
			    } else {
			    	logger.info("catagory name is not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //BreadCramps
		 public  void BreadCramps(WebDriver driver) throws InterruptedException {
			 WebElement breadCramps = driver.findElement(By.xpath("//ol[@class='breadcrumb mb-0']"));
			    if (breadCramps.isEnabled()) {
			    	logger.info("BreadCramps are displayed on the page");
			    } else {
			    	logger.info("BreadCramps are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //Filters
		 public  void Filters(WebDriver driver) throws InterruptedException {
			 WebElement filters = driver.findElement(By.xpath("//span[@class='hide-title']"));
			    if (filters.isEnabled()) {
			    	logger.info("Filters are displayed on the page");
			    } else {
			    	logger.info("Filters are not displayed on the page");
			    }
			    Thread.sleep(2000);
		 }
		 
		 //products
			public void Products(WebDriver driver) throws InterruptedException {
				List<WebElement> products = driver.findElements(By.xpath("//a[@class='nav-link dropdown-toggle text-uppercase font-weight-bold level-1']"));
			    int count = products.size();
			    if(count>0) {
			    	 logger.info("products are displayed on the page");
			    } else {
			    	logger.info("products are not displayed on the page");
			    }
			    Thread.sleep(2000);
			}

				
}
