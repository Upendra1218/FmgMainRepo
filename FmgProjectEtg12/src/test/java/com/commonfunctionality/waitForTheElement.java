package com.commonfunctionality;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class waitForTheElement {
	
	public static Wait<WebDriver> createFluentWait(WebDriver driver) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofMillis(100))
            .ignoring(org.openqa.selenium.NoSuchElementException.class);
     
}
}