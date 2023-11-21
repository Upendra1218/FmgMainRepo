package com.Scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.testcases.baseClass;

public class AddAddressFromMyAccountPage extends baseClass{

	 @Test(dependsOnMethods = {"com.providio.login.tc__Login.loginTest"}, alwaysRun = true)
	public void addAddressInMyAccount() {

			if(isLoggedIn) {
				
				
				
			}else {
		        Assert.fail("User not logged in");
		    }
	}
			
}
