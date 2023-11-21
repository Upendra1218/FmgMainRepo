package com.pageValidations;

import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.Validations.preValidationCheck;
import com.testcases.baseClass;

public class pageValidations extends baseClass{
	@Test
	public void eachPageValidations() throws InterruptedException {
    	//launching the browser and passing the url into it
		launchBrowsering lb = new launchBrowsering();
		lb.chromeBrowser();

	    // Pause the execution for 5 seconds (5000 milliseconds) to ensure the page loads
	    Thread.sleep(5000);

	    // Perform pre-validation checks on the home page
	    preValidationCheck.prevalidationHome(driver);

	    // Initialize a navigation process for selecting a random menu
	    NavigationProcess np = new NavigationProcess(driver);

	    // Select a random menu item and navigate to a PLP (Product Listing Page)
	    np.selectRandomMenu(driver);

	    // Perform pre-validation checks on the PLP
	 /*   preValidationCheck.prevalidationPLP();

	    // Initialize the process for selecting filters on the PLP
	    selectingFilterFromPlp.selectingFilterisFormplp();

	    // Initialize the product description page (PDP) for further actions
	    productDescriptionPage pdp = new productDescriptionPage(driver);

	    // Validate breadcrumbs on the product description page
	    pdp.validateBreadCrumbs();

	    // Perform pre-validation checks on the PDP
	    preValidationCheck.preValidationPDP();
	    
	    
      	NavigationProcess npMCVC = new NavigationProcess(driver);
      	npMCVC.addingProductsforValidatingMiniandViewCartpages();
    	
    	 // Check if the minicart is displayed
        List<WebElement> minicartdisplayedcount = driver.findElements(By.xpath("//span[contains(@class,'minicart')]"));
        if (minicartdisplayedcount.size() > 0) {

            // Get the number of products in the cart
            WebElement productCountInCart = driver.findElement(By.xpath("//span[contains(@class,'minicart')]"));
            String countOfMinicart = productCountInCart.getText();
            int minicartProductCountValue = Integer.parseInt(countOfMinicart);

            // If products are in the minicart, proceed
            if (minicartProductCountValue > 0) {

            	miniCartActionsandValidations.validationsandActions();
      
                //validate the view cart
               ViewCartValidation.viewCartValidations();
                
            }
        }
	}*/
	}
}
