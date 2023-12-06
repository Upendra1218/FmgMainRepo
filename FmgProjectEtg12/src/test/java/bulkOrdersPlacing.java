import org.testng.annotations.Test;

import com.Launchingbrowser.launchBrowsering;
import com.PageObjects.NavigationProcess;
import com.PageObjects.productListingPage;
import com.PaymentProccess.CreditCardPaymentProcess;
import com.PaymentProccess.MinicartViewCartProcess;
import com.testcases.baseClass;

public class bulkOrdersPlacing extends baseClass{


	@Test(invocationCount = 5)
    public void guestlogin() throws InterruptedException {
    	
		
		//selects a random catgory and product add to cart
		NavigationProcess navProccess = new NavigationProcess(driver);
        navProccess.selectRandomMenu(driver);
        
        //click add to cart button
        productListingPage plp = new productListingPage(driver);
        plp.addToCartFromPlp();
        
    	
        //check out process
	     MinicartViewCartProcess cp = new MinicartViewCartProcess();			     
	     cp.checkoutprocess();
	    
	     //Payment process		     
	     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();			     
	     cc.paymentByCreditCard();
	     
	     Thread.sleep(3000);
		}
    
}
