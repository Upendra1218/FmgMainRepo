package com.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.CreateAccount;
import com.PageObjects.loginPage;
import com.github.javafaker.Faker;
import com.testcases.baseClass;
		
		public class tc__createAccount extends baseClass{
			boolean openBrowserandClickSignInButtonset = false;
			 Faker faker = new Faker();
			
			@Test
			public void openBrowserandClickSignInButton() throws InterruptedException {
			    test.info("Open browser");
			    
			       
		       if(isBrowserLaunched){
		        
					
				    Thread.sleep(2000L);
				 // Create an instance of the "loginPage" class
			        loginPage lp = new loginPage(driver);        
			        
			        lp.hoverOnCreateloginAcc(driver);
				    logger.info("clicked on sign in");
				    
			        CreateAccount createAcc= new CreateAccount(driver);
			        
					createAcc.clickOnCreateAcc(driver);		
					logger.info("Clicked on create Account");
				   openBrowserandClickSignInButtonset = true;
			}
			}
		
			
			
		@Test(priority = 2,dependsOnMethods = "openBrowserandClickSignInButton")
		public void passwordMismatch() throws InterruptedException {
			test.info("Validating the passwprd mismatch error");
			
		if(openBrowserandClickSignInButtonset)	{
		
				Thread.sleep(5000);
		        CreateAccount createAcc= new CreateAccount(driver);
		        
		        JavascriptExecutor js = (JavascriptExecutor) driver;
		        js.executeScript("window.scrollBy(0, -500);");
		        
		     
				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhila@gmail.com");		
				logger.info("Enter email");
							
				
				CreateAccount.enterPassword("Akhila@07");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("Akhila@077");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
				
				WebElement passwordErrorElement = driver.findElement(By.xpath("//div[contains(text(),'Passwords do not match')]"));
				boolean isDisplayedErrorEmail = passwordErrorElement.isDisplayed();
				if(isDisplayedErrorEmail) {
					test.pass("Test case passed and Error message is dispalyed as  "+passwordErrorElement .getText());
					logger.info(" Showing this --Does not match password");
				}else {
					test.fail("Test case failed and Error message is not dispalyed as "+ passwordErrorElement .getText() );
					logger.info(" Not Showing this-- error Does not match password");
				}
			}
		}
			
			
		@Test(priority = 3,dependsOnMethods = "openBrowserandClickSignInButton")
		public void emptyText() throws InterruptedException {
			
			test.info("validating the error if empty text is passed");
				if( openBrowserandClickSignInButtonset)	{
					Thread.sleep(5000);
					CreateAccount createAcc= new CreateAccount(driver);
			        
			        JavascriptExecutor js = (JavascriptExecutor) driver;
			        js.executeScript("window.scrollBy(0, -500);");

					createAcc.enterFirstName("");		
					logger.info("Entered first Name");
					
					createAcc.enterLastName("");		
					logger.info("Entered lastName");
					
					createAcc.enterPhone("");		
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("");		
					logger.info("Enter email");				
					
					CreateAccount.enterPassword("");		
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("");		
					logger.info("incorrectPassword");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(3000);
					
					WebElement errorForEmptyText= driver.findElement(By.xpath("//div[contains(text(),'This field is required.')]"));
					boolean isDisplayedErrorForEmpty= errorForEmptyText.isDisplayed();
					if(isDisplayedErrorForEmpty) {
						test.pass(errorForEmptyText.getText() +" This Error is displaying if empty text is send " );
						logger.info(" This Error is displaying as "+ errorForEmptyText.getText());
					}else {
						test.fail(errorForEmptyText.getText() +" this Error is not displaying if empty text is send");
						logger.info(" This Error is not displaying as "+ errorForEmptyText.getText());
					}			
			}
		}
		
			@Test(priority = 4,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatePasswordStrength() throws InterruptedException {
				test.info("Validating password strength");
				
			if( openBrowserandClickSignInButtonset)	{
							
				Thread.sleep(5000);
				CreateAccount createAcc= new CreateAccount(driver);
		      

				createAcc.enterFirstName(faker.name().firstName());		
				logger.info("Entered first Name");
				
				createAcc.enterLastName(faker.name().lastName());		
				logger.info("Entered lastName");
				
				createAcc.enterPhone(phonenumber);		
				logger.info("Entered phonenumber");
				
				createAcc.enterEmail("akhil@gmail.com");		
				logger.info("Enter email");		
				
				CreateAccount.enterPassword("asddfdgd");		
				logger.info("Entered password");
						
				createAcc.enterConfirmPassword("asddfgsd");		
				logger.info("incorrectPassword");
				
				createAcc.clickCreateAccountButton(driver);		
				logger.info("Clicked on create account");
				Thread.sleep(5000);
		     
				
				WebElement errorForPasswordStrength= driver.findElement(By.xpath("//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]"));
				boolean isDisplayedErrorForEmpty= errorForPasswordStrength.isDisplayed();
				if(isDisplayedErrorForEmpty) {
					test.pass(errorForPasswordStrength.getText() +" this Error is displaying" );
					logger.info(" This Error is displaying as "+ errorForPasswordStrength.getText());
				}else {
					test.fail(errorForPasswordStrength.getText() +" this Error is not displaying");
					logger.info(" This Error is not displaying as "+ errorForPasswordStrength.getText());
				}			
			}
		}
			
			@Test(priority = 5,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatingWithExistingAccount() throws InterruptedException {
			        test.info("Verifying the error with already created account");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone(phonenumber);
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhila.m@etg.digital");
					
					logger.info("Enter email");
												
					CreateAccount.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement errorEmailAlreadyExists= driver.findElement(By.xpath("//div[contains(text(),'Already exists, Please enter another value.')]"));
			boolean textErrorEmailAlreadyExists= errorEmailAlreadyExists.isDisplayed();
			if( textErrorEmailAlreadyExists) {
				test.pass("Test case passed and Error message is displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" +errorEmailAlreadyExists.getText() );
				logger.info("Test case failed");
			}
		}
			
		
			@Test(priority = 6,dependsOnMethods = "openBrowserandClickSignInButton")
			public void ValidatingEmailformatError() throws InterruptedException {
			        test.info("Verifying Email format  error");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("12453334343");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhilgmail.com");
					
					logger.info("Enter email");
															
					CreateAccount.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement emailFormatError= driver.findElement(By.xpath("(//div[@id='form-email-error'])[1]"));
			boolean isDisplayedemailFormatError= emailFormatError.isDisplayed();
			if( isDisplayedemailFormatError) {
				test.pass("Test case passed and Error message is displayed as" + emailFormatError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + emailFormatError.getText() );
				logger.info("Test case failed");
			}
		}
			
			@Test(priority = 6,dependsOnMethods = "openBrowserandClickSignInButton")
			public void validatingPhoneNumError() throws InterruptedException {
			        test.info("Verifying Phone number error");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());
					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());
					
					logger.info("Entered lastName");
					
					createAcc.enterPhone("1245");
					
					logger.info("Entered phonenumber");
					
					createAcc.enterEmail("akhil@gmail.com");
					
					logger.info("Enter email");								
					
					CreateAccount.enterPassword("Akhireddy@07");
					
					logger.info("Entered password");
							
					createAcc.enterConfirmPassword("Akhireddy@07");
					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(5000);
			     
					}
	
			WebElement phoneNumError= driver.findElement(By.xpath("//div[@id='form-phone-error']"));
			boolean isDisplayedphoneNumError= phoneNumError.isDisplayed();
			if( isDisplayedphoneNumError) {
				test.pass("Test case passed and Error message is displayed as" + phoneNumError.getText() );
				logger.info("Test case passed");
			}else {
				test.pass("Test case failed and Error message is not  displayed as" + phoneNumError.getText() );
				logger.info("Test case failed");
			}
		}
			
		
			@Test(priority = 7,dependsOnMethods = "openBrowserandClickSignInButton")
			public void createAccountWithValidCredientials() throws InterruptedException {
			        test.info("Verifying  with valid data");
			        
				if( openBrowserandClickSignInButtonset){
				
					CreateAccount createAcc= new CreateAccount(driver);
					logger.info("Creating account with valid credientials");
										
					createAcc.enterFirstName(faker.name().firstName());					
					logger.info("Entered first Name");
					
					createAcc.enterLastName(faker.name().lastName());					
					logger.info("Entered lastName");
					
					int minLength = 10;
			        int maxLength = 25;
			        int phoneNumberLength = faker.random().nextInt(minLength, maxLength + 1);
			        String fakePhoneNumber = faker.number().digits(phoneNumberLength);
					createAcc.enterPhone(fakePhoneNumber);					
					logger.info("Entered phonenumber");
					
					
					String firstName = faker.name().firstName();
		            String email = firstName+ "@etg.digital"; // Change suffix as needed
		            System.out.println("Email id is " + email);
					createAcc.enterEmail(email);					
					logger.info("Enter email");
											      
					
					CreateAccount.enterPassword("Akhireddy@07");					
					logger.info("Entered password");
					
					createAcc.enterConfirmPassword("Akhireddy@07");					
					logger.info("Confirmed password");
					
					createAcc.clickCreateAccountButton(driver);		
					logger.info("Clicked on create account");
					Thread.sleep(10000);
			     
					}
	
				WebElement loginTitle = driver.findElement(By.xpath("//h1[contains(text(),'Dashboard')]"));
				String expectedTitle = "Dashboard";
				String actualTitle = loginTitle.getText();

		        
		        if (actualTitle.equals(expectedTitle)) {
		        	test.pass("Account created sucessfully");         
		            logger.info("Account created sucessfully");
		            isLoggedIn = true;
		            
		            //registered user name 
		            WebElement userName = driver.findElement(By.className("registered-user-message"));
		            test.info("Name of User name is " + userName.getText());
		            logger.info("Name of User name is " + userName.getText());
		           
		            //registered email id 
		            WebElement regMail = driver.findElement(By.xpath("(//dd)[2]"));
		            test.info("Email is " + regMail.getText());
		            logger.info("Email  is " + regMail.getText());
		            
		        } else {
		        	test.fail("The page Title does not match expected " + expectedTitle + " but found " + actualTitle);
		            logger.info("Click failed and account not created");
		            
		        }
		}
		
		}



