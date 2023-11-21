package com.PageObjects;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.Validations.validationpopupMessages;
import com.testcases.baseClass;

public class viewCartPage extends baseClass {
	
WebDriver lDriver;
	
	public viewCartPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}

	    Float  unitPrice = (float) 0 ;
	    Float quantity = (float) 0 ;
	    Float productValue = (float) 0 ;
	    Float giftCardValue = (float) 0 ;   
	    Float totalEachProduct = (float) 0 ;
	    Float totalProduct = (float) 0 ;
	    Float shippingValue = (float) 0 ;
	    Float expectedPreTotalTax = (float) 0 ;
	    Float actualPreTotalTax = (float) 0 ;
	    Float expectedPreTotalTaxGc=(float) 0 ;
	    Float assortablePrice = (float) 0 ;
	 
	   
	   //total cost at cart page
	 	protected static Float totalCost = (float) 0 ;
	
	//Checkout :- 
		@FindBy(xpath="//a[contains(text(),'Checkout')]")
		WebElement Checkout;	
		public void clickCheckout(WebDriver driver) throws InterruptedException{
			test.info("Validate check out Btn ViewCart page");
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", Checkout);	
			test.pass("Successfully Checkout Btn is Clicked");
	        Thread.sleep(5000);
		}
		
		//Removeitem	
		@FindBy(xpath="(//button[@class ='remove-btn-lg cart-delete-confirmation-btn btn btn-light'])[1]")
		WebElement CancelItem;
		public void clickCancelItem(WebDriver driver) throws InterruptedException{	
			JavascriptExecutor js = (JavascriptExecutor) driver; 
			js.executeScript("arguments[0].click();", CancelItem);
	        Thread.sleep(5000);
		}
			
		
		   //move to wishlist link on the view cart page save-for-later
			public void saveForLater() throws InterruptedException {
				test.info("Validate the save later button click");
				List<WebElement> saveForLaterLink = driver.findElements(By.xpath("//div[@class='total-cart-content']//div[contains(@class,'save-for-later')]"));
				 // Get the total count of top-level menu elements.
		        int count = saveForLaterLink.size();
		        // Create a random number generator.
		        Random random = new Random();
		        // Generate a random index to select a top-level menu item.
		        int randomeditlink = random.nextInt(count) + 1;
		        logger.info(randomeditlink);
		        WebElement movetoWishListLink = driver.findElement(By.xpath("(//div[@class='total-cart-content']//div[contains(@class,'save-for-later')])[" + randomeditlink + "]"));
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].click();", movetoWishListLink);		
				//movetoWishListLink.click();
				test.pass("Successfully the product is add to the save later");
				
				//validationpopupMessages.validatingProductisAddtoWishList(driver);
				
		        
			}
			
			//move to wishlist link on the view cart page
			public void removeBtn() throws InterruptedException {
				test.info("Validate the remove button click");
				Thread.sleep(3000);
				List<WebElement> removeBtns = driver.findElements(By.xpath("//div[contains(@class,'cart-delete')]"));
				 // Get the total count of top-level menu elements.
		        int count = removeBtns.size();
		        // Create a random number generator.
		        Random random = new Random();
		        // Generate a random index to select a top-level menu item.
		        int randomRemoveBtn = random.nextInt(count) + 1;
		        logger.info(randomRemoveBtn);
		        WebElement removeformviewcart = driver.findElement(By.xpath("(//div[contains(@class,'cart-delete')])[" + randomRemoveBtn + "]"));
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].click();", removeformviewcart);		
				
				Thread.sleep(5000);
				
				String[] xpathsofViewcart = {
					    "//a[contains(@class,'undolink')]",
					    "//a[contains(@class,'save-for-later')]",
					    "//button[contains(@class,'removecart')]"
					};
				
				// Generate a random index to select an XPath expression
				int randomIndex = random.nextInt(xpathsofViewcart.length);

				// Access the randomly selected XPath expression
				String randomXPath = xpathsofViewcart[randomIndex];
				
				//RandomElement
				WebElement randomElement = driver.findElement(By.xpath(randomXPath));
				
				js.executeScript("arguments[0].click();", randomElement);		
				//randomElement.click();
				
				if(randomIndex==0) {
					validationpopupMessages.validatingProductisAddtoCart(lDriver);
				}else if(randomIndex==1) {
					// Success message is displayed
			       	   test.pass("Product added to saveForLater");
			           logger.info("Product is added to saveForLater");
					//validationpopupMessages.validatingProductisSaveforLater(driver);
				}else {
					   test.pass("Product Removed from the cart");
			           logger.info("Product Removed from the cart");
					//validationpopupMessages.validatingProductisAddtoWishList(driver);
				}
				
			
				//removeformviewcart.click();
				//popup validations
				//validationpopupMessages.removeproductformminicartValidation();
		        
			}
			
		
	   //brain tree paypal button

			public void braintreePayPalButton(WebDriver driver) {
				
			    // Find the element using its xpath
			    WebElement payPalButton = driver.findElement(By.xpath("//div[contains(@class,'js_braintree_paypal_cart_button')]"));
		
			    // Perform the click action
			    payPalButton.click();
			}

	

			public void quantityInsertionInCartPage() throws InterruptedException {
						
				test.info("Verify quantity increase and assortable price discount  with  color");
				//qunatity insertion in cart page
				List<WebElement> quantityInput = driver.findElements(By.xpath("//input[@name='quantity']"));
		
				if(quantityInput.size()>0) {	
					
					WebElement quantityInputDisplay = driver.findElement(By.xpath("//input[@name='quantity']"));
					if(quantityInputDisplay.isDisplayed()) {
						int productQuantityCount = quantityInput.size();
						// maximum quantity of products
						int productCount = 150;
						// Create a random number generator.
					    Random random = new Random();
				        // Generate a random index to insert the qunatity
					    int randomquantityInput = random.nextInt(productQuantityCount) + 1;
					    int inputQuantiy = random.nextInt(productCount)+1;
					    logger.info("Product input quantity "+inputQuantiy);
					    // Find the quantity input field associated with the clicked button and set the quantity.
				        WebElement inctheQuantity = driver.findElement(By.xpath("(//input[@name='quantity'])[" + randomquantityInput + "]"));
				        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", inctheQuantity);
				        Thread.sleep(2000);
				        inctheQuantity.clear(); // Clear the existing value
				        Thread.sleep(2000);
				        inctheQuantity.sendKeys(String.valueOf(inputQuantiy));
				        Thread.sleep(1000);
				    
				       //update the qunatity
				        List<WebElement> updateQuantityList = driver.findElements(By.xpath("//div[contains(text(),' Update')]"));		     
				        if(updateQuantityList.size()>0) {
					       WebElement updateQuantity = driver.findElement(By.xpath("(//div[contains(text(),' Update')])[" + randomquantityInput + "]"));
					       if(updateQuantity.isDisplayed()) {
					    	   updateQuantity.click();
					    	   Thread.sleep(3000);
					    	   
			    	   
					       }
					       
					       
				       }else {
				    	   logger.info("Updating the quantity in Pdp page ");
				       }
					} 
				}else {
					logger.info("Gc in cart no chance of quantity increase of GC");
				}
				
				//locate the quantity in elements
				 WebElement miniCartQuantity = driver.findElement(By.xpath("//span[contains(@class,'minicart-quantity')]"));
				 String countOfProducts= miniCartQuantity.getText();
				 test.info("The total number of products in cart are " +countOfProducts);
				 logger.info("The total number of products in cart are " +countOfProducts);
				 
				 // tier price and color
				 TierPrice tp= new TierPrice();
				 tp.tierPriceAndColor();
				 
			}
			
			public void noQuantityInsertionInCartPage() {
				
				test.info("No quantity inasertion in cart page ");
			}

			
			
			public static void countryDropDown() throws InterruptedException {
				 // Locate the dropdown element by its ID
		        WebElement countryDropdown = driver.findElement(By.id("shippingCountrydefault"));

		        // Create a Select object
		        Select select = new Select(countryDropdown);

		        // Get all the options within the dropdown
		        List<WebElement> countryOptions = select.getOptions();

		        // Get the total number of options
		        int numberOfOptions = countryOptions.size();

		        // Generate a random index within the range of available options
		        Random random = new Random();
		        int randomIndex = random.nextInt(numberOfOptions);

		        // Select the random option by its index
		        select.selectByIndex(randomIndex);
		        Thread.sleep(5000);
		        
		        // Locate the zipcode error
		        List<WebElement> zipCodeErrorList = driver.findElements(By.xpath("//div[contains(text(),'This field is required and cannot be empty')]"));
		        if(zipCodeErrorList.size()>0) {
		        	//fetching the zipcode error
			        WebElement zipCodeError = driver.findElement(By.xpath("//div[contains(text(),'This field is required and cannot be empty')]"));
			        boolean zipCodeErrorText = zipCodeError.isDisplayed();
				        if(zipCodeErrorText) {
				        	
				        	logger.info("Selected US in shipping");
				        	String[] usZipCodes = {"10038-3804", "89044", "34102", "30291","21798","07801","13224"};
				
				             // Get a random index from the array
				             int randomIndex1 = random.nextInt(usZipCodes.length);
		
				             // Select a string value randomly
				             String selectedValue = usZipCodes[randomIndex1];
				             WebElement zipCode = driver.findElement(By.id("shippingZipCodedefault"));
				             zipCode.sendKeys(selectedValue);
				        }
		        }
			}	
			
			public  void onlyProductCal() throws NumberFormatException {
				// looping all the products to calcualte the total product by  unit price and quantity 
				// total products in cart 
				 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info product-detail  uuid-')]"));
				 for(int i= 1;i<=totalProducts.size();i++) {
					
					 // unit price 
					WebElement unitPriceText = driver.findElement(By.xpath("(//span[@class='sales']//span[@class='value'])[" + i + "]"));
				    String unitPriceString = unitPriceText.getText();
				    System.out.println(unitPriceString);
				    String unitPriceValue = unitPriceString.replaceAll("[^\\d.]+", "");
				    unitPrice = Float.parseFloat(unitPriceValue);
				    logger.info("The unit price of each prodcut is "+unitPrice);
	
				//qunatity
				    WebElement quantityListText = driver.findElement(By.xpath("(//input[@name='quantity'])[" + i + "]"));
				    String quantityValue = quantityListText.getAttribute("value");
				  
				    quantity = Float.parseFloat(quantityValue);
				    logger.info("The quantity  is "+quantity);
			
			 
			// total product cost = quantity * unit price
				    WebElement eachProductValue = driver.findElement(By.xpath("(//div[contains(@class, 'pricing line-item-total-price-amount item-total')])[" + i + "]"));
				    String eachProductValueText= eachProductValue.getText();
				    String productValue1 = eachProductValueText.replaceAll("[^\\d.]+", "");
				    productValue = Float.parseFloat(productValue1);
				    logger.info("Extended value is " +productValue);
 
				    float totalProduct = unitPrice * quantity;
				  		    
				    System.out.println("The total price of each product is " + totalProduct +"[" + i + "]" );
				    totalEachProduct += totalProduct;	
				    
				    logger.info(totalEachProduct);
				 }
			}
			
			public  void onlyGc() {
				// only gc in cart 
				 List<WebElement> giftCerificateList = driver.findElements(By.xpath("//div[contains(@class, 'card product-info gift-certificate uuid-')]"));
				 if((giftCerificateList.size()>0)){
					 
					 	test.info("Gc is cart ");
							 int countOfGc= giftCerificateList.size();
							 for(int j=1;j<=countOfGc;j++) {
								 
								 // getting the price of gc's
								 WebElement eachProductValue1 = driver.findElement(By.xpath("(//div[contains(@class, 'card product-info gift-certificate uuid-')]//div[contains(@class, 'pricing line-item-total-price-amount item-total')])[" + j + "]"));
								 
							     String eachProductValueText1= eachProductValue1.getText();
							     logger.info(eachProductValueText1);
							     String productValue2 = eachProductValueText1.replaceAll("[^\\d.]+", "");
							     Float giftCardValue1 = Float.parseFloat(productValue2);
							     logger.info("Extended value is " + giftCardValue1 );
							     System.out.println(giftCardValue);
							     giftCardValue=giftCardValue+giftCardValue1;
							     logger.info(giftCardValue);	
				}
			}
	}
			
			
			//all product calcualtion in cart with Gc and products combination 
			public  void productsCalInCart() {
				
				//only products in cart 
				viewCartPage vcp = new  viewCartPage(driver) ;
				vcp.onlyProductCal();
	
				 //only gc in cart 
				 onlyGc();
				
				 logger.info(totalProduct);
				 logger.info(giftCardValue);
				
				 totalEachProduct += totalProduct+giftCardValue;
				 logger.info("Total price of all prodcuts in cart "+totalEachProduct);
		}
			
			
			
			 public static Float  totalProductsCost() {
				List<WebElement> totalCostElementList = driver.findElements(By.xpath("//p[contains(@class,'subtotal-price')]"));
				if(totalCostElementList.size()>0) {
					WebElement totalCostElement = driver.findElement(By.xpath("//p[contains(@class,'subtotal-price')]"));
					
					String totalCostText= totalCostElement.getText();
					String totalCost1 = totalCostText.replaceAll("[^\\d.]+", "");
					totalCost= Float.parseFloat(totalCost1 );
					logger.info("Total product price is " +totalCost);
					
				}else {
					WebElement totalCostElement = driver.findElement(By.xpath("//p[contains(@class,'subtotal-price')]//span"));
					
					String totalCostText= totalCostElement.getText();
					String totalCost1 = totalCostText.replaceAll("[^\\d.]+", "");
					totalCost= Float.parseFloat(totalCost1 );
					logger.info("Total product price is " +totalCost);
				}
				return totalCost;
			}
			 
			//shipping calculation			
			public void estimatedshippingCalculations() throws InterruptedException {	 
				String shippingValueText =null;
				float shippingValue=0;
				 List<WebElement> giftCerificate = driver.findElements(By.xpath("//div[contains(@class, 'card product-info gift-certificate uuid-')]"));
				 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info product-detail  uuid-')]"));
				 
				 if((giftCerificate.size()>0 && totalProducts.size()>0) || (totalProducts.size()>0) ) {
					 //country
					 	countryDropDown();
					 	logger.info("Entered shipping address");

					 	WebElement assortablePriceElement = driver.findElement(By.xpath("//p[contains(@class,'assortable-price')]"));
					    String assortablePriceText= assortablePriceElement.getText();
						String assortablePriceText1 = assortablePriceText.replaceAll("[^\\d.]+", "");
						assortablePrice = Float.parseFloat(assortablePriceText1);
						logger.info("Assortable price is " +assortablePrice);
					 	
					 	test.info("Calculating the pre-total tax with the estimated shipping cost");
					   List<WebElement> shippingValueElementList = driver.findElements(By.xpath("//p[@class='text-right shipping-cost accessibility-element']"));
					   if(shippingValueElementList.size()>0) {
						   WebElement shippingValueElement = driver.findElement(By.xpath("//p[@class='text-right shipping-cost accessibility-element']"));
						   if(shippingValueElement.isDisplayed()) {
						   String eachShippingValueText= shippingValueElement.getText();
						   System.out.println("Shipping cost "+eachShippingValueText);
						   // Remove all non-numeric characters using regular expression
						    shippingValueText = eachShippingValueText.replaceAll("[^\\d.]+", "");
						    // If you need a float value, you can convert it
						    shippingValue = Float.parseFloat(shippingValueText);
						
						   }
					   }
					
					 
					    float formattedPreTotalTax =(shippingValue +totalEachProduct);
					    logger.info("Estimated and expected Pre total price tax " +formattedPreTotalTax);					    
					    test.info("The total pre-tax calculation is " +formattedPreTotalTax);
					    
					  
					 // Casting to int to remove the decimal part
					    int intValue1 = (int) formattedPreTotalTax;
					 
					    expectedPreTotalTax = (float) intValue1;
					  
					    System.out.println("Integer part: " + intValue1);
					    logger.info(expectedPreTotalTax);
					  //actual pre total tax
					    WebElement preTotalTaxGrandTotal = driver.findElement(By.xpath("//p[contains(@class,'grand-total')]"));
					    String preTotalTaxGrandTotalText= preTotalTaxGrandTotal.getText();
					    
					    // Remove all non-numeric characters using regular expression
					    String  preTotalTax = preTotalTaxGrandTotalText.replaceAll("[^\\d.]+", "");
					    
					 // Split the string using the dot as a delimiter
					    String[] parts = preTotalTax .split("\\.");

					    // Extract the integer part
					    String integerPart = parts[0];

					    // Convert the string to an integer
					    actualPreTotalTax =  Float.parseFloat(integerPart);
					    
					    logger.info("Actual pre-total price is " +actualPreTotalTax);
						if(expectedPreTotalTax.equals(actualPreTotalTax)) {
							test.pass("The  estimated  pre-total tax is " + expectedPreTotalTax + " is equal to " + actualPreTotalTax);
							logger.info("The  estimated pre-total tax is " +expectedPreTotalTax + " is equal to " + actualPreTotalTax);
						}else {
							test.fail("The estimated pre-total tax is " +expectedPreTotalTax + " is not equal to " + actualPreTotalTax);
							logger.info("The  estimated pre-total tax is " + expectedPreTotalTax + " is not equal to " + actualPreTotalTax);
						}
						
						
				 } else {
					 test.info("Cart contain only Gc products");							
						 expectedPreTotalTaxGc=  totalEachProduct;
		
					 //actual pre total tax
					 Thread.sleep(3000);
					    WebElement preTotalTaxGrandTotal = driver.findElement(By.xpath("//p[contains(@class,'grand-total')]"));
					    String preTotalTaxGrandTotalText= preTotalTaxGrandTotal.getText();
					    logger.info(preTotalTaxGrandTotalText);
						String preTotalTaxGrandTotalTextText1 = preTotalTaxGrandTotalText.replaceAll("[^\\d.]+", "");
						actualPreTotalTax = Float.parseFloat( preTotalTaxGrandTotalTextText1);
						logger.info("Actual pre total-price is " +actualPreTotalTax);
						

						if( expectedPreTotalTaxGc.equals(actualPreTotalTax)) {
							test.pass("The caluated pre-total tax is " + expectedPreTotalTaxGc + " is equal to " + actualPreTotalTax);
							logger.info("The caluated pre-total tax is " + expectedPreTotalTaxGc + " is equal to " + actualPreTotalTax);
						}else {
							test.fail("The caluated pre-total tax is " + expectedPreTotalTaxGc + " is not equal to " + actualPreTotalTax);
							logger.info("The caluated pre-total tax is " + expectedPreTotalTaxGc + " is not equal to " + actualPreTotalTax);
						}
				 }
			}
}
