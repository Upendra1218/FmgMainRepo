package com.commonfunctionality;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testcases.baseClass;

public class attributesSelection extends baseClass{

	//color Selection
	public static void packageSizeSelection() throws InterruptedException {
 		
		List <WebElement> packageSizeList= driver.findElements(By.id("package-qty-feet-1"));
 		logger.info(packageSizeList.size());
 	// checkoing the availbility of package size and randomizing the varities and selecting them
 		if(packageSizeList.size()>0) {			
 			if (!packageSizeList.isEmpty()) { 							
 				List<WebElement> elementList = driver.findElements(By.cssSelector(".slick-slide.slick-active .single-custom-attribute"));
 				Random random = new Random();
 				int randomIndex = random.nextInt(elementList.size());
 				WebElement randomElement = elementList.get(randomIndex);
 				randomElement.click();
 			      
 			}
 
    }
}			

}
