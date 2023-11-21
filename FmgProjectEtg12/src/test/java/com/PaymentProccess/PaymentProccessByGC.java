package com.PaymentProccess;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.PageObjects.reviewOrderPage;
import com.Validations.Checkout_Validation;
import com.testcases.baseClass;

public class PaymentProccessByGC extends baseClass{

	public List<String> readDataFromExcel(String filePath, String sheetName) throws IOException {

		List<String> data = new ArrayList<String>();
		FileInputStream file = new FileInputStream(new File(filePath));
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet(sheetName);

		boolean isFirstRow = true; // Flag to skip the first row

	    for (Row row : sheet) {
	        // Skip the first row
	        if (isFirstRow) {
	            isFirstRow = false;
	            continue;
	        }

	        for (Cell cell : row) {
	            String stringValue = cell.toString();
	            data.add(stringValue);
	        }
	    }

		workbook.close();
		return data;
	}
// to pick the GC code randomly
	public void performRandomOperations(WebDriver driver) throws InterruptedException {
		//driver.get(baseURL);
		//logger.info("enterd into url");
		String filePath = GiftCerificateCodeforGc;
		String sheetName = "GC_Codes";

		try {
				List<String> dataList = readDataFromExcel(filePath, sheetName);
				int totalProducts = dataList.size();
				// Remove spaces from each element in the dataList
			    for (int i = 0; i < dataList.size(); i++) {
			        String element = dataList.get(i);
			        element = element.replace(" ", "");
			        dataList.set(i, element);
			    }
			 // Remove empty strings (commas) from the dataList
			    dataList.removeIf(String::isEmpty);
			    // Print the updated dataList
			 
				logger.info(dataList);
				int operations = 0;
				   Set<String> pickedValues = new HashSet<>();

				   while (true) {
						 String randomValue = pickRandomValueWithoutDuplicate(dataList, pickedValues);
			                logger.info(randomValue);
						if (randomValue == null) {
							logger.info("No data found");
							break; // No more values to pick
						}
						if (randomValue != null) {
							
						JavascriptExecutor js = (JavascriptExecutor) driver;	
						//click on radio button
						WebElement giftCertificateRadioButton = driver.findElement(By.id("gift-promo"));
						 giftCertificateRadioButton.click();
						 //send the code to Gc 
						WebElement giftCertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
						js.executeScript("arguments[0].click();", giftCertificate);	
						giftCertificate.sendKeys(randomValue);
						Thread.sleep(2000);
							
							  
			            //check balance validation and checking the bal of GC
			             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
			             test.info("Verifying check balance button");
		            
			             //clicked on check bal button
		                js.executeScript("arguments[0].click();",checkBalButton);
		                
		                Thread.sleep(2000);
		                List<WebElement> checkBalList= driver.findElements(By.xpath("//div[@class='balance success']"));
		                if(checkBalList.size()>0) {
				                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
				                logger.info(checkBal.getText()); 
				                if(checkBalButton.isDisplayed()) {				                	
				                	test.pass("Check button is enabled and selected");
				                	logger.info("Check button is enabled and selected");
				                }else {
				                	test.fail("Check button is not enabled and not selected");
				                	logger.info("Check button is  not enabled and selected");
				                }
		                }
		                
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftCertificate);	
						giftCertificate.sendKeys(randomValue);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
									if(driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size()!=0) {
										logger.info("Insufficent funds in this " +randomValue + " gift card" );
										giftCertificate.clear();
									}else if(driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size()!=0){
										logger.info("This " + randomValue + "Gift Card belongs to different customer ");
										giftCertificate.clear();
									}
									
							        if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size()!=0) {
								    	 logger.info("Your order has no balance,so no payment method is necessary");
								    	 giftCertificate.clear();
								    	 break;
							        } else {
								        	
							        	dataList.remove(randomValue);
										logger.info(" After applying GC we have this in datalist"+ dataList);
								    	    Thread.sleep(5000);
											operations++;	
									     }
								 
							
								}
		                 } catch (NoSuchElementException e) {
					  				logger.info("Element not found: " + e.getMessage());
								}  
						}			
			  }
					logger.info("Total data: " + totalProducts);
					logger.info("Total operations performed: " + operations);
		  }catch (IOException e) {
		
				e.printStackTrace();
	   }	
		   if (driver.findElements(By.xpath("//div[contains(text(),'Your order has no balance, so no payment method is necessary to complete this order')]")).size() != 0) {
				 //revieworder button  
				
	    		 reviewOrderPage rop = new reviewOrderPage(driver);			    				    		
	    		 rop.clickonReviewOrder(driver);
				logger.info("clicked on the review oreder");
				
			
				Thread.sleep(3000);
			
				//rop.clickonplaceorderwithJsExuter(driver);
				logger.info("successfully click on the place order button");
				Thread.sleep(10000);
				logger.info(driver.getTitle());
			
				 Checkout_Validation checkout= new Checkout_Validation();
			 //validate the final place the order page
				 checkout.validatePlacetheOrderPage();
			
		     //ordernumberandOrderdate
				 checkout.ordernumberandOrderdate();
		   }
	}
	private String pickRandomValueWithoutDuplicate(List<String> dataList, Set<String> pickedValues) {
        Random random = new Random();
        int index = random.nextInt(dataList.size());

        String randomValue = dataList.get(index);
        if (pickedValues.contains(randomValue)) {
            // All values have been picked, return null
            if (pickedValues.size() == dataList.size()) {
                return null;
            }
            // Recursively pick another value
            return pickRandomValueWithoutDuplicate(dataList, pickedValues);
        } else {
            // Add the picked value to the set
            pickedValues.add(randomValue);
            return randomValue;
        }
    }

	// to pick the GC code sequentially
	
	public void performSequentialOperations(WebDriver driver) throws InterruptedException {
		
	    String filePath = GiftCerificateCodeforGc;
	    String sheetName = "GC_Codes";

	    try {
	        List<String> dataList = readDataFromExcel(filePath, sheetName);
	        int totalProducts = dataList.size();
	        
//	     // Remove spaces and non-alphanumeric characters from the dataList
//	        for (int i = 0; i < dataList.size(); i++) {
//	            String element = dataList.get(i);
//	            element = element.replaceAll("[^a-zA-Z0-9]", ""); // This regular expression removes non-alphanumeric characters
//	            dataList.set(i, element);
//	        }

		    // Print the updated dataList
		 
			logger.info(dataList);
	        int operations = 0;
	      	 Iterator<String> iterator = dataList.iterator();
	      	 
	      	WebElement checkoutPage2= driver.findElement(By.xpath("//label[contains(text(),'Billing Address')]"));
	      	 if(checkoutPage2.isDisplayed()) {
		        while (iterator.hasNext()) {
		            String value = iterator.next();
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebElement giftCertificate = driver.findElement(By.xpath("//input[@id='giftCert']"));
		            js.executeScript("arguments[0].click();", giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);

		            
		            //check balance validation and checking the bal of GC
		             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
		             test.info("Verifying check balance button");
		           
	                // Scroll down by 500 pixels
		             js.executeScript("window.scrollBy(0, 500);");                 
	                 js.executeScript("arguments[0].click();",checkBalButton);
	                //checkBalButton.click();		            
	                 List<WebElement> checkBal= driver.findElements(By.xpath("//div[@class='balance success']"));
	                 if(checkBal.size()>0) {
	            	   	 WebElement checkBalDisplay= driver.findElement(By.xpath("//div[@class='balance success']"));
		                if(checkBalDisplay.isDisplayed()) {
		                	logger.info(checkBalDisplay.getText()); 
		                	test.pass("Check button is enabled and selected ");
		                	logger.info("Check button is enabled and selected");
		                }else {
		                	test.fail("Check button is not enabled and not selected");
		                	logger.info("Check button is  not enabled and selected");
		                }
	               }
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftCertificate);
			            giftCertificate.sendKeys(value);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                // Scroll down by 500 pixels
		                js.executeScript("window.scrollBy(0, 200);");  
		             
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
				                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
				                    logger.info("Insufficient funds in this " + value + " gift card");
				                    giftCertificate.clear();
				                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
				                    logger.info("This " + value + " Gift Card belongs to a different customer");
				                    giftCertificate.clear();
				                }
			
				                if (driver.findElements(By.xpath("//div[contains(text(),'Please enter a gift certificate code.')]")).size() != 0) {
				                	   logger.info("Enter the gift certificate");
				                		break;
				                } else {  				                	
				                	iterator.remove(); // Safely remove the element from the list
				                    logger.info("After applying GC we have this in datalist: " + dataList);
				                    Thread.sleep(5000);
				                    operations++;
				                }
	           
		                }else {
		                	test.fail("Apply button is not  selected");
		                	logger.info("Apply button is not selected");
		                }
		             
		                
		            } catch (NoSuchElementException e) {
		                logger.info("Element not found: " + e.getMessage());
		            }
	        }
	     }      
	        logger.info("Total data: " + totalProducts);
	        logger.info("Total operations performed: " + operations);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	 //revieworder button  
	    Thread.sleep(4000);
	    List<WebElement> gcTotalRedemption= driver.findElements(By.xpath("//div[contains(text(),'Your order will be paid using gift certificate')]")); 
	    if(gcTotalRedemption.size()>0) {	
	    	 	logger.info("applied gift card code");
			  //review order page
		        reviewOrderPage rop = new reviewOrderPage(driver);	        
				Thread.sleep(2000);	  
				rop.clickonReviewOrder(driver);
				logger.info("clicked on the review oreder");
		
		       //place order 
				rop.clickonplaceorderwithJsExuter(driver);
				logger.info("successfully click on the place order button");
	
			  Thread.sleep(5000);
		
				 // Checkout validation
  			
	    			 Checkout_Validation checkout= new Checkout_Validation();
	    			 
	    		 // Validate the final place the order page
	    			 checkout.validatePlacetheOrderPage();
	    		
	    	     // Order number and order date
	    			 checkout.ordernumberandOrderdate();
	    			 Thread.sleep(5000);
	    		
	   }else {
		   test.pass("No sufficient balance in Gift certificate so continuing the payment with credit card");
		   //Payment process		     
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
		     cc.paymentByCreditCard();
		     
		     
		 
	   }
	}
/*	
	//TO PLACE THE ORDER BY GC AND CC
		public void paymentBySemiGC () throws InterruptedException {
			
			double halfPrice=0;
            List<WebElement> gcText= driver.findElements(By.xpath("//div[@class='success giftcert-pi']"));
            int sizeOfGc = gcText.size();
            //get the total price and removed the dallar and commas
            WebElement totalPrice= driver.findElement(By.xpath("//span[@class='grand-total-sum']"));
            String totalPriceText = totalPrice.getText().replace("$", "").replace(",", ""); // Remove "$" and commas
            double totalPricAmount = Double.parseDouble(totalPriceText);
            
            System.out.println("Total price is " + totalPricAmount);
            // Calculate half of the total price
            
            halfPrice = totalPricAmount  / 2;
            System.out.println("The half price is " +halfPrice);
           
			String filePath = "C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\testDate\\GiftCertificateCodes.xlsx";
		    String sheetName = "GC_Codes";

		    try {
		        List<String> dataList = readDataFromExcel(filePath, sheetName);
		        int totalProducts = dataList.size();
		        
		     // Remove spaces from each element in the dataList
			    for (int i = 0; i < dataList.size(); i++) {
			        String element = dataList.get(i);
			        element = element.replace(" ", "");
			        dataList.set(i, element);
			    }

			    // Remove the empty strings from the list
		        dataList.removeIf(String::isEmpty);

		        // Concatenate the elements of the list without the comma
		      
				logger.info(dataList);
		        int operations = 0;
		      	 Iterator<String> iterator = dataList.iterator();
		      	 
		        while (iterator.hasNext()) {

	                
		            String value = iterator.next();
		            JavascriptExecutor js = (JavascriptExecutor) driver;
		            WebElement giftCertificate = driver.findElement(By.id("giftCert"));
		            js.executeScript("arguments[0].click();", giftCertificate);
		            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",giftCertificate);
		            giftCertificate.sendKeys(value);
		            Thread.sleep(2000);

		            
		            //check balance validation and checking the bal of GC
		             WebElement checkBalButton= driver.findElement(By.xpath("//button[@class='btn btn-primary check-balance']"));
		             test.info("Verifying check balance button");
		            
		                // Scroll down by 500 pixels
		             	js.executeScript("window.scrollBy(0, 500);");         
		                js.executeScript("arguments[0].click();",checkBalButton);
		                //checkBalButton.click();
		                Thread.sleep(2000);
		                WebElement checkBal= driver.findElement(By.xpath("//div[@class='balance success']"));
		                logger.info(checkBal.getText()); 
		                if(checkBalButton.isDisplayed()) {
		                	
	                	test.pass("Check button is enabled and selected");
		                	logger.info("Check button is enabled and selected");
		                }else {
		                	test.fail("Check button is not enabled and not selected");
		                	logger.info("Check button is  not enabled and selected");
		                }
		                
		            // Click the apply button by passing GC
		            try {
		            	Thread.sleep(2000);
		            	js.executeScript("arguments[0].click();", giftCertificate);
			            giftCertificate.sendKeys(value);
			            Thread.sleep(2000);
			            
		                WebElement applyGiftCard = driver.findElement(By.xpath("//button[@value='submit-gifrcert']"));
		                Thread.sleep(3000);	              
		                // Scroll down by 500 pixels
		                js.executeScript("window.scrollBy(0, 200);");
		             
		                // apply button validation
		                test.info("Verifying apply button is selected");
		                if(applyGiftCard.isDisplayed()) {
		                	    js.executeScript("arguments[0].click();", applyGiftCard);
		                	    test.pass("Apply button is selected");
		                	    logger.info("Apply button is selected");
		              
				                Thread.sleep(2000);
				                if (driver.findElements(By.xpath("//div[contains(text(),'Insufficient Gift Certificate balance')]")).size() != 0) {
				                	logger.info("Insufficient funds in this " + value + " gift card");
				                    giftCertificate.clear();
				                } else if (driver.findElements(By.xpath("//div[contains(text(),'Gift card belongs to a different customer')]")).size() != 0) {
				                	logger.info("This " + value + " Gift Card belongs to a different customer");
				                    giftCertificate.clear();
				                }
		
				                
				             // Check if a gift certificate can be applied
				                WebElement giftCertificateBalance = driver.findElement(By.xpath("//span[@class='gift-certificate-total']"));
				                String giftCertificateBalanceText = giftCertificateBalance.getText().replace("$", "").replace(",", ""); // Remove "$" and commas
				                double giftCertificateBalanceAmount = Double.parseDouble(giftCertificateBalanceText);
				                System.out.println("Gift certificate amount is "+giftCertificateBalanceAmount);

				                if (giftCertificateBalanceAmount >= halfPrice) {
				                    // Apply gift certificate for half of the total price
				                    giftCertificateBalanceAmount -= halfPrice;
				                    System.out.println("Gift certificate applied for $" + halfPrice);

				                    // Calculate remaining payment (credit card)
				                    double remainingPayment = halfPrice;
				                    System.out.println("Remaining payment with credit card: $" + remainingPayment);
				                    break;
				                    
				                } else {
				                	 iterator.remove(); // Safely remove the element from the list
					                    logger.info("After applying GC we have this in datalist: " + dataList);
					                    Thread.sleep(5000);
					                    operations++;
				                }
				                 /*   // Apply gift certificate for the available balance
				                    System.out.println("Gift certificate applied for $" + giftCertificateBalanceAmount);

				                    // Calculate remaining payment (credit card)
				                    double remainingPayment = halfPrice - giftCertificateBalanceAmount;
				                    System.out.println("Remaining payment with credit card: $" + remainingPayment);
			               
	           
		                }else {
		                	test.fail("Apply button is not  selected");
		                	logger.info("Apply button is not selected");
		                }
		             
		                
		            } catch (NoSuchElementException e) {
		                logger.info("Element not found: " + e.getMessage());
		            }
		        }

		        logger.info("Total data: " + totalProducts);
		        logger.info("Total operations performed: " + operations);
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}*/

}
