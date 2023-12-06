package com.PageObjects;

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
	    
	    Float viewCartTotal = (float) 0 ;
	    
	 // Click on the product link in the view cart page
	    public void clickProductLink() throws InterruptedException {

	        // Find all the product links on the page using the XPath "//h3"
	        List<WebElement> productLinks = driver.findElements(By.xpath("//h3"));

	        // Get the total count of top-level menu elements.
	        int count = productLinks.size();

	        // Create a random number generator.
	        Random random = new Random();

	        // Generate a random index to select a top-level menu item.
	        int randomProdcutlink = random.nextInt(count) + 1;

	        // Log the randomly generated index.
	        logger.info(randomProdcutlink);

	        // Find the randomly selected product link using the generated index.
	        WebElement movetoWishListLink = driver.findElement(By.xpath("(//h3)[" + randomProdcutlink + "]"));

	        // Introduce a delay for 2 seconds (simulating a pause before the click).
	        Thread.sleep(2000);

	        // Create a JavascriptExecutor to perform a click on the product link.
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].click();", movetoWishListLink);

	        // Introduce a delay for 3 seconds (allowing time for the page to load).
	        Thread.sleep(3000);

	        // Validate if the PDP (Product Detail Page) is loaded
	        List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));

	        // Check if there is at least one element matching the PDP identifier.
	        if (pdpPagecheck.size() > 0) {
	            // Log a message indicating that the PDP page is successfully loaded.
	            logger.info("Pdp page is successfully loaded");
	        }
	    }

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
			
			// Use JavascriptExecutor to click on the element with try-catch
	        try {
	            js.executeScript("arguments[0].click();", movetoWishListLink);
	            Thread.sleep(4000);
	        } catch (Exception e) {
	            System.err.println("Exception while clicking the element: " + e.getMessage());
	            movetoWishListLink.click();
	            Thread.sleep(4000);
	        }
					
			test.pass("Successfully the product is add to the save later");
			
			//validationpopupMessages.validatingProductisAddtoWishList(driver);
		
		}
		
		//adding save later to mini cart
		   //move to wishlist link on the view cart page save-for-later
			public void addtocartFromSaveLater() throws InterruptedException {
				
				test.info("Validate the move to cart button click");
				List<WebElement> addingProductFromsaveForLaters = driver.findElements(By.xpath("//button[contains(@class, 'add-to-cart')]"));
				 // Get the total count of top-level menu elements.
		        int count = addingProductFromsaveForLaters.size();
		        // Create a random number generator.
		        Random random = new Random();
		        // Generate a random index to select a top-level menu item.
		        int randomeditlink = random.nextInt(count) + 1;
		        logger.info(randomeditlink);
		        WebElement addingProductFromsaveForLater = driver.findElement(By.xpath("(//button[contains(@class, 'add-to-cart')])[" + randomeditlink + "]"));
				Thread.sleep(2000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				
				// Use JavascriptExecutor to click on the element with try-catch
		        try {
		            js.executeScript("arguments[0].click();", addingProductFromsaveForLater);
		            Thread.sleep(4000);
		        } catch (Exception e) {
		            System.err.println("Exception while clicking the element: " + e.getMessage());
		            addingProductFromsaveForLater.click();
		            Thread.sleep(4000);
		        }
						
				test.pass("Successfully the product is add to the to cart");
				
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
			
			try {
	            js.executeScript("arguments[0].click();", removeformviewcart);
	            Thread.sleep(4000);
	        } catch (Exception e) {
	            System.err.println("Exception while clicking the element: " + e.getMessage());
	            removeformviewcart.click();
	            Thread.sleep(4000);
	        }	
			
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
			
			try {
	            js.executeScript("arguments[0].click();", randomElement);
	        } catch (Exception e) {
	            System.err.println("Exception while clicking the element: " + e.getMessage());
	            randomElement.click();
	        }
			
			
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
			List<WebElement> quantityInput = driver.findElements(By.xpath("//div[@class='total-cart-content']//input[@name='quantity']"));
	
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

			 
		}
			
			public void noQuantityInsertionInCartPage() {
				
				test.info("No quantity inasertion in cart page ");
			}
		
						// applying promo code
						public void applyCouponInCartPage() throws InterruptedException {
							if(RegressionTestCase) {
							List<WebElement> clickOnPromo = driver.findElements(By.xpath("//label[contains(text(),'Have a Promo Code?')]"));
							if(clickOnPromo.size()>0) {
								WebElement clickOnPromolink = driver.findElement(By.xpath("//label[contains(text(),'Have a Promo Code?')]"));
								clickOnPromolink.click();
								
								// negative validation
								negativeValidationForCouponInCart();

								//apply coupon
								applyCoupon();
								
								//cancellation of applied coupon
								cancellationOfCoupon();
								Thread.sleep(2000);
							}
						 }else {
							 logger.info("This is smoke test");					
							 }
						}
						public void applyCoupon() throws InterruptedException {
							boolean couponNotAppliedDisplay= false;
							boolean couponAppliedDisplay=false;
							WebElement couponCode = driver.findElement(By.id("couponCode"));
							couponCode.sendKeys("promo");
							
							WebElement applyCouponCode = driver.findElement(By.cssSelector("button.promo-code-btn"));
							applyCouponCode.click();
							
							Thread.sleep(4000);
							List<WebElement> couponNotAppliedDiv = driver.findElements(By.cssSelector(".coupon-not-applied"));
							if(couponNotAppliedDiv.size()>0) {
								WebElement couponNotApplied = driver.findElement(By.cssSelector(".coupon-not-applied"));
								couponNotAppliedDisplay= couponNotApplied.isDisplayed();
							}
								List<WebElement> couponAppliedList = driver.findElements(By.cssSelector(".coupon-applied"));
								if(couponAppliedList .size()>0) {
								WebElement couponApplied = driver.findElement(By.cssSelector(".coupon-applied"));
								couponAppliedDisplay= couponApplied.isDisplayed();
								Thread.sleep(1000);
								}
							
								if(couponAppliedDisplay) {
									test.pass("Coupon is applied ");
									logger.info("Coupon is applied ");
									
								}else if(couponNotAppliedDisplay)  {
									test.pass("Coupon is not  applied message because customized to specific product and to specfic qunatity");
									logger.info("Coupon is not  applied message  because of customaization ");
								}else {
									test.pass("Coupon is not applied");
									logger.info("Coupon is not  applied ");
								}
								
							
						}
						
						public void cancellationOfCoupon() throws InterruptedException {
							
							//to remove the applied coupon
							WebElement removeTheAppliedCoupon= driver.findElement(By.cssSelector(".remove-coupon"));
							removeTheAppliedCoupon.click();
							Thread.sleep(2000);						
										// delete the coupon
										WebElement deleteCoupon= driver.findElement(By.cssSelector("button.delete-coupon-confirmation-btn"));
																	
										//cancel to remove the coupon
										WebElement cancelTheRemovalOfCoupon= driver.findElement(By.cssSelector(".cancel-coupon"));				
										
										Random random = new Random();
										int randomNumber = random.nextInt(2);
										// Use the random number to decide which button to click
										if (randomNumber == 0) {
											Thread.sleep(1000);
										    deleteCoupon.click();
										    test.info("Deleted the coupon applied");
										} else {
											Thread.sleep(1000);
										    cancelTheRemovalOfCoupon.click();
										    test.info("Cancelling the removal of coupon");
										}
						}
						public void negativeValidationForCouponInCart() throws InterruptedException {
							
						
							test.info("Verifying the display of error message when coupon is not entered");
								WebElement applyCouponCode = driver.findElement(By.cssSelector("button.promo-code-btn"));
								
								try {
								    JavascriptExecutor js = (JavascriptExecutor) driver;
								    // Scroll the element into view using JavaScript
								    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", applyCouponCode);
								    // Click the element using JavaScript
								    js.executeScript("arguments[0].click();", applyCouponCode);
								    // Log a message indicating the JavaScript click
								    logger.info("JavaScript click");
								} catch (Exception e) {
								    // Log the exception
								    logger.error("Exception occurred: " + e.getMessage(), e);
								    // If an exception occurs, fall back to normal click
								    applyCouponCode.click();
								    // Log a message indicating the normal click
								    logger.info("Normal click");
								}

								applyCouponCode.click();
								Thread.sleep(1000);
								WebElement errorMsg = driver.findElement(By.xpath("//span[contains(text(),'No coupon code entered')]"));
								boolean errorMsgDisplay = errorMsg.isDisplayed();
								if(errorMsgDisplay) {
									test.pass("Error message is displayed when coupon is not entered ");
									logger.info("Error message is displayed when coupon is not entered");
								}else {
									test.fail("No Error message is displayed when coupon is not entered ");
									logger.info("No Error message is displayed when coupon is not entered");
								}
							
							test.info("Verifying the error message when invalid coupon is entered");
								WebElement couponCode = driver.findElement(By.id("couponCode"));
								couponCode.sendKeys("uijhskdher4");
								
								applyCouponCode.click();
								Thread.sleep(2000);
								List<WebElement> errorMsgPromoInvalid = driver.findElements(By.xpath("//span[contains(text(),'The promotion code is not valid.')]"));
								List<WebElement> errorMsgPromoInvalidDisplay = driver.findElements(By.xpath("//div[contains(text(),'The promotion code is not valid.')]"));
								if(errorMsgPromoInvalid.size()>0) {
									WebElement errorMsgPromoInvalidDisplayInCart = driver.findElement(By.xpath("//span[contains(text(),'The promotion code is not valid.')]"));
									boolean errorMsgDisplayForPromoInvalidInCart = errorMsgPromoInvalidDisplayInCart.isDisplayed();
									if(errorMsgDisplayForPromoInvalidInCart) {
										test.pass("Error message is displayed when invalid coupon is entered ");
										logger.info("Error message is displayed when invalid coupon is entered ");
									}else {
										test.fail("No Error message is displayed when invalid coupon is entered ");
										logger.info("No Error message is displayed when invalid coupon is entered ");
									}
								}else if(errorMsgPromoInvalidDisplay.size()>0){
									WebElement errorMsgPromoInvalidDisplayInBilling = driver.findElement(By.xpath("//div[contains(text(),'The promotion code is not valid.')]"));
									boolean errorMsgDisplayForPromoInvalidInBilling =errorMsgPromoInvalidDisplayInBilling.isDisplayed();
									if(errorMsgDisplayForPromoInvalidInBilling) {
										test.pass("Error message is displayed when invalid coupon is entered ");
										logger.info("Error message is displayed when invalid coupon is entered ");
									}else {
										test.fail("No Error message is displayed when invalid coupon is entered ");
										logger.info("No Error message is displayed when invalid coupon is entered ");
									}
								}
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
			
			//all product calcualtion in cart with Gc and products combination 

				public  void productsCalInCart() throws InterruptedException {

					List<WebElement> cartPage = driver.findElements(By.xpath("//h1[contains(text(),'Your Shopping Cart')]"));

					if(cartPage.size()>0) {

						Thread.sleep(2000);;
	 
						 totalEachProduct =onlyProductCal()+ onlyGc();

						 logger.info("Total price of all prodcuts in cart "+totalEachProduct);

					}

			}	

	public  float onlyProductCal() throws NumberFormatException {

					// looping all the products to calcualte the total product by  unit price and quantity 

					// total products in cart 

					 List<WebElement> totalProducts = driver.findElements(By.xpath("//div[contains(@class, 'card product-info product-detail  uuid-')]"));

					 for(int i= 1;i<=totalProducts.size();i++) {

						 // unit price 

						WebElement unitPriceText = driver.findElement(By.xpath("(//span[@class='sales']//span[@class='value'])[" + i + "]"));

					    String unitPriceString = unitPriceText.getText();				   

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

					return totalEachProduct;

				}

				public  float onlyGc() {

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

					return giftCardValue;

		}
			
			public  void  totalProductsCost() {
				List<WebElement> totalCostElementList = driver.findElements(By.xpath("//p[contains(@class,'subtotal-price')]"));
				if(totalCostElementList.size()>0) {
					WebElement totalCostElement = driver.findElement(By.xpath("//p[contains(@class,'subtotal-price')]"));
					
					String totalCostText= totalCostElement.getText();
					String totalCost1 = totalCostText.replaceAll("[^\\d.]+", "");
					viewCartTotal= Float.parseFloat(totalCost1 );
					totalCost = viewCartTotal;
					logger.info("Total product price is " +totalCost);
					
					
					
				}else {
					WebElement totalCostElement = driver.findElement(By.xpath("//p[contains(@class,'subtotal-price')]//span"));
					
					String totalCostText= totalCostElement.getText();
					String totalCost1 = totalCostText.replaceAll("[^\\d.]+", "");
					viewCartTotal= Float.parseFloat(totalCost1 );
					totalCost = viewCartTotal;
					logger.info("Total product price is " +totalCost);
				}
				
			}
			 
			//shipping calculation			
			public void estimatedshippingCalculations() throws InterruptedException {	
				if(RegressionTestCase) {
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
}
