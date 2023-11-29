package com.testcases;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.EmailException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.TestNG;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.utilities.readConfig;
import com.utilities.reportToMail;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;



public class baseClass {
	
	//test case type 
	protected static boolean RegressionTestCase = false;

	
	
	// Create an instance of the readConfig class to read configuration data
	static readConfig readconfig = new readConfig();

	// Login details
	public String baseURL = readconfig.getApplicationURL(); // Base URL for the application
	public String name = readconfig.getUsername(); // User name for login
	public String password = readconfig.getPassword(); // Password for login
	public String reemail = readconfig.getReEnterMail(); // Re-enter email for login

	// Shipping details
	public String fname = readconfig.getFName(); // First name for shipping
	public String lname = readconfig.getLName(); // Last name for shipping
	public String address = readconfig.getAddress(); // Address for shipping
	public String cityname = readconfig.getCity(); // City for shipping
	public String zipcode = readconfig.getzipcode(); // Zip code for shipping
	public String phonenumber = readconfig.getphone(); // Phone number for shipping

	// Edit page details
	public String epfname = readconfig.getepFName(); // Edited first name
	public String eplname = readconfig.getepLName(); // Edited last name
	public String epconfirmEmail = readconfig.getepconformMail(); // Edited confirmation email
	public String eppassword = readconfig.getepconformpassword(); // Edited password

	// Profile Password Change
	public String epcurrentPassword = readconfig.getepcurrentPassword(); // Current password
	public String epnewPassword = readconfig.getepnewPassword(); // New password
	public String epnewPasswordConfirm = readconfig.getepnewPasswordConfirm(); // Confirm new password

	// To write a review
	public String headline = readconfig.getWriteAReview(); // Headline for the review
	public String comment = readconfig.getComments(); // Comment for the review
	public String nickName = readconfig.getNickName(); // Nickname for the review
	public String location = readconfig.getLocation(); // Location for the review

	// In Find a Store
	public String zipcodeStore = readconfig.getZipcodeInStore(); // Zip code for finding a store

	// Search bar
	public String searchBar = readconfig.searchSomething(); // Search term for the search bar

	// Footer mail
	public String footerMail = readconfig.getFooterMail(); // Email for the footer

	// Guest login details
	public String guestmail = readconfig.getGuestMail(); // Guest user's email
	public String guestPassword = readconfig.getGuestPassword(); // Guest user's password
	public String reEnterMail = readconfig.getReEnterMail(); // Re-enter email for guest login

	
	// Excel file locations
	public String GiftCerificateCodeforGc = readconfig.GiftCerificateCodeforGc(); // Gift certificate code for Gift Card
	public String GiftCertificatesforPaypal = readconfig.GiftCertificatesforPaypal(); // Gift certificates for PayPal
	public static String Report = readconfig.Report(); // Location for the report
	public static String ReportScreenshot = readconfig.ReportScreenshot(); // Location for report screenshots

	// WebDriver and logger instances
	public static WebDriver driver; // WebDriver instance
	public static Logger logger; // Logger instance

	// Flags for tracking test state
	protected static boolean isLoggedIn = false; // Flag indicating whether the user is logged in
	protected static boolean CheckoutProcessClick = false; // Flag indicating whether the checkout process was clicked
	protected static boolean isBrowserLaunched = false; // Flag indicating whether the browser is launched

	// Menu related variable
	protected static int menu5 = 0; // Menu-related variable (initially set to 0)

	// Total cost at cart page
	protected static Float totalCost = (float) 0; // Total cost at the cart page
	// Subtotal cost at hovered cart
	protected static Float subTotalCost = (float) 0; // Subtotal cost at the hovered cart

	// Guest user and registration flags
	protected static boolean guestuser = false; // Flag indicating whether the user is a guest user

	// Gift card flag
	protected static boolean giftCard = false; // Flag indicating whether a gift card is used

	// Edited details store
	protected static String prviousEmail = ""; // Previous email before editing
	protected static String email = ""; // Current email
	protected static String emailEdited = ""; // Edited email

	protected static String prviousAddress = ""; // Previous address before editing
	protected static String Address = ""; // Current address
	protected static String AddressEdited = ""; // Edited address

	protected static String prviousShippingMethod = ""; // Previous shipping method before editing
	protected static String shippingMethodtitle = ""; // Current shipping method
	protected static String shippingMethodEdited = ""; // Edited shipping method

	// ExtentReports and ExtentTest instances for reporting
	private static ExtentReports report = new ExtentReports();
	private ExtentSparkReporter reporter = new ExtentSparkReporter(Report);

	// Reporting
	// static ExtentReports report;
	protected static ExtentTest test;

	@BeforeSuite
	public void setUpforReport() throws InterruptedException {
	    // Create a new ExtentReports instance
	    report = new ExtentReports();
	    // Attach the ExtentSparkReporter to the ExtentReports
	    report.attachReporter(reporter);
	    // Initialize the WebDriver (assuming the method initializeDriver() is available)
	    initializeDriver();
	}
	
	@BeforeClass
	public void setUp() throws InterruptedException {
	    // Pause the execution for 2000 milliseconds (2 seconds)
	    Thread.sleep(2000);
	    
	    // Create a new ExtentTest with the name of the current test class
	    test = report.createTest(getClass().getSimpleName());
	    
	    // Initialize the logger with the name "FMG"
	    logger = Logger.getLogger("FMG");
	    
	    // Configure the logger using the "log4j.properties" file
	    PropertyConfigurator.configure("log4j.properties");
	    
	    // Uncomment the line below if you want to log information related to the test
	    // logger.info(test);
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException {
	    // Check if the browser has crashed
	    if (!isBrowserRunning()) {
	        // Log a message indicating that the browser is relaunching
	        logger.info("Relaunching the browser");
	        
	        // Uncomment the line below if you want to rerun the entire test suite when the browser crashes
	        // testsuitRunner(); 
	    }
	    
	    // Taking a screenshot when an error occurs
	    if (result.getStatus() == ITestResult.FAILURE) {
	        // Log the name of the error
	        test.fail(result.getThrowable().getClass().getSimpleName());
	        
	        // Log the full error with code lines
	        test.fail(result.getThrowable());

	        // Taking a screenshot with the method name and storing it in a file
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        String fileName = result.getMethod().getMethodName() + "_" + ".jpg";

	        try {
	            // Print a message indicating that a screenshot is taken
	            System.out.println("Screenshot taken for test case: " + result.getMethod().getMethodName());
	            
	            // Set the destination file for the screenshot
	            File destination = new File("./Screenshots/" + fileName);
	            
	            // Copy the screenshot from source to destination
	            FileUtils.copyFile(source, destination);
	            
	            // Get the absolute path of the screenshot
	            String screenshotPath = destination.getAbsolutePath();

	            // Attach the screenshot to the test report
	            test.fail("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	        } catch (IOException e) {
	            // Log an exception message if there's an issue with taking the screenshot
	            System.out.println("Exception while taking screenshot: " + e.getMessage());
	        }
	    }
	}

	
	@AfterSuite
	public void tearDown() throws IOException, EmailException, InterruptedException {
	    // Change the view of the report to include DASHBOARD and TEST views
	    reporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST}).apply();
	    
	    // Flush the ExtentReports to write the test information to the report
	    report.flush();
	    
	    // Navigate to the report URL in the WebDriver
	    driver.get(Report);
	    
	    // Maximize the browser window
	    driver.manage().window().maximize();
	    
	    // Pause execution for 5000 milliseconds (5 seconds)
	    Thread.sleep(5000);
	    
	    // Take a screenshot of the entire browser window
	    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    // Define the destination path for the screenshot
	    String screenshotPath = ReportScreenshot;
	    
	    // Save the screenshot to the specified path
	    FileUtils.copyFile(screenshot, new File(screenshotPath));

	    // Close the WebDriver instance 
	    // driver.quit();
	    
	    // Send the report via email
	    reportToMail.Reporttomail();
	}

	   
	// Private method to initialize the WebDriver
	private void initializeDriver() throws InterruptedException {
	    // Pause execution for 3000 milliseconds (3 seconds)
	    Thread.sleep(3000);
	    
	    // Create ChromeOptions for configuring the ChromeDriver
	    ChromeOptions co = new ChromeOptions();
	    
	    // Uncomment the line below if you want to add a specific Chrome option
	    // co.addArguments("--remote-allow-origins=*");
	    
	    // Add the "--incognito" argument to open Chrome in incognito mode
	    co.addArguments("--incognito");
	    
	    // Create a new ChromeDriver with the configured ChromeOptions
	    driver = new ChromeDriver(co);
	    
	    // Maximize the browser window
	    driver.manage().window().maximize();
	    
	    // Delete all cookies in the browser session
	    driver.manage().deleteAllCookies();
	}

		
	   
	// Private method to validate if the browser is running
	private boolean isBrowserRunning() {
	    try {
	        // Attempt to retrieve the title of the current page in the browser
	        driver.getTitle();

	        // Uncomment the line below if you want to clear all cookies in the browser session
	        // driver.manage().deleteAllCookies();

	        // Return true if the title is successfully retrieved, indicating the browser is running
	        return true;
	    } catch (NoSuchWindowException e) {
	        // Return false if a NoSuchWindowException occurs, indicating the browser is not running
	        return false;
	    } catch (Exception e) {
	        // Handle any other exceptions and return false, indicating the browser is not running
	        return false;
	    }
	}

	   
	// Public method to invoke the test suite whenever the browser crashes
	public void executeTestSuite(String... suiteFiles) {
	    // Log a message indicating that the method is invoked
	    logger.info("Coming here");

	    // Create a new TestNG instance
	    TestNG testng = new TestNG();

	    // Create a new XmlSuite instance
	    XmlSuite suite = new XmlSuite();

	    // Create a list to store suite file names
	    List<String> suiteFileList = new ArrayList<>();

	    // Add suite files to the list
	    Collections.addAll(suiteFileList, suiteFiles);

	    // Set the suite files for the XmlSuite
	    suite.setSuiteFiles(suiteFileList);

	    // Set the XmlSuites for the TestNG instance
	    testng.setXmlSuites(Collections.singletonList(suite));

	    // Run the TestNG instance, executing the specified test suite
	    testng.run();
	}

	   
	// Public method to run the test suite when the browser crashes
	public void testsuitRunner() {
	    // Check if the browser has crashed
	    if (!isBrowserRunning()) {
	        // Specify the suite file paths in an array
	        String[] suiteFiles = {
	            "C:\\Users\\user\\git\\MuskuAkhilaRepo16\\proVidioETG\\Excutingalltestcases.xml",

	            // Add more suite file paths if needed
	        };

	        // Execute the test suite with the specified suite files
	        executeTestSuite(suiteFiles);
	    }
	}
}