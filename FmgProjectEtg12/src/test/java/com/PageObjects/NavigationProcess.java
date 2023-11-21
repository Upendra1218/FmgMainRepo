package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.Scenarios.menuSelction;
import com.testcases.baseClass;

public class NavigationProcess extends baseClass {
    WebDriver lDriver;

    public NavigationProcess(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

 
    public void selectRandomMenu(WebDriver driver) throws InterruptedException {
    		menuSelction.randommenu();
        }
                
    }
    
    

