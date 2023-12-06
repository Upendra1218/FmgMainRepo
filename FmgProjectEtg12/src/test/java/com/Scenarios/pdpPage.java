// Package declaration for the class
package com.Scenarios;

// Importing necessary Java and Selenium libraries
import java.util.List;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.PageObjects.NavigationProcess;
import com.PageObjects.productDescriptionPage;
import com.PageObjects.productListingPage;
import com.commonfunctionality.allAttributesinOneFile;
import com.testcases.baseClass;

// Class declaration for the PDP (Product Description Page) scenario, extending the base class
public class pdpPage extends baseClass {

	// Method for adding a product to the cart from the Product Description Page
	public static void addtoCartPDP() throws InterruptedException {

		// Finding elements with a specific XPath on the current web page
		List<WebElement> pdpPagecheck = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]"));

		// Checking if the Product Description Page elements are present on the page
		if (pdpPagecheck.size() > 0) {

			// Creating an instance of the Product Description Page
			productDescriptionPage pdp = new productDescriptionPage(driver);

			// Adding the product to the wishlist
			pdp.selecttheWishlist();

			// Finding elements with a specific XPath for "Add to Cart" button
			List<WebElement> pdpPageaddToCart = driver.findElements(By.xpath("//div[contains(@class,'product-main-block')]//a[contains(@class, 'add-to-cart')]"));
			int displayedAddToCartCount = 0;

			// Counting the displayed "Add to Cart" buttons
			for (WebElement item : pdpPageaddToCart) {
				if (item.isDisplayed()) {
					displayedAddToCartCount++;
				}
			}

			// Logging the count of displayed "Add to Cart" buttons
			logger.info(displayedAddToCartCount);

			// Checking if there is at least one displayed "Add to Cart" button
			if (displayedAddToCartCount > 0) {

				// Selecting product attributes on the PDP
				allAttributesinOneFile.selectTheAttributesInPdp(driver);
                Thread.sleep(4000);
				
				// Increasing the quantity in the cart
				pdp.increasetheQuantiyinPDP();

				// Checking if this is a regression test
				if (RegressionTestCase) {

					// Generating a random number for selecting different actions
					Random random = new Random();
					int randomNumber = random.nextInt(3); // Generates a random number between 0 (inclusive) and 2 (exclusive)

					// Switch statement based on the random number
					switch (randomNumber) {
					case 0:
						productDescriptionPage.haveAQuestion();
						break;
					case 1:
						productDescriptionPage.tierPricesInPdp();
						break;
					case 2:
						productDescriptionPage.NoTierSelectionInPdp();
						break;
					default:
						System.out.println("Invalid random number");
					}
				} else {
					// Logging a message if it's a smoke test
					logger.info("This is a smoke test");
				}

			} else {
				// Logging a message if no "Add to Cart" button is displayed
				logger.info("Notify me");

				// Creating an instance of the NavigationProcess class
				NavigationProcess navProcess = new NavigationProcess(driver);

				// Selecting a random menu item
				navProcess.selectRandomMenu(driver);

				// Selecting a random product from the product listing page
				productListingPage.selectRandomProduct();

				// Selecting product attributes on the PDP
				allAttributesinOneFile.selectTheAttributesInPdp(driver);
			}
		} else {

			// If Product Description Page elements are not found, navigating to a random menu
			// item and selecting a random product
			NavigationProcess navProcess = new NavigationProcess(driver);
			navProcess.selectRandomMenu(driver);
			productListingPage.selectRandomProduct();
			allAttributesinOneFile.selectTheAttributesInPdp(driver);
		}
	}
}
