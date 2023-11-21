package com.PageObjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class quickShopPage {
    WebDriver lDriver;

    public quickShopPage(WebDriver rDriver) {
        lDriver = rDriver;
        PageFactory.initElements(rDriver, this);
    }

    // Add to Cart button on the Quick Shop page
    @FindBy(xpath = "//button[@class ='add-to-cart-global btn btn-primary']")
    WebElement Addtocartbutton;

    public void clickAddtocartbutton() throws InterruptedException {
        Addtocartbutton.click();
        Thread.sleep(5000);
    }

    // Add to Cart button on the Product Listing Page (PLP)
    @FindBy(xpath = "(//button[@class = 'add-to-cart btn btn-primary flex-grow-1'])[1]")
    WebElement AddtocartButtoninPlp;

    public void clickAddtocartbuttoninplp() throws InterruptedException {
        AddtocartButtoninPlp.click();
        Thread.sleep(5000);
    }

    // Back Carousel button (Previous slide)
    @FindBy(xpath = "//button[@class ='slick-prev slick-arrow']")
    WebElement BCarasol1;

    public void clickBCarasol() throws InterruptedException {
        BCarasol1.click();
        Thread.sleep(2000);
        BCarasol1.click();
        Thread.sleep(2000);
    }

    // Forward Carousel button (Next slide)
    @FindBy(xpath = "//button[@class ='slick-next slick-arrow']")
    WebElement FCarasol1;

    public void clickFCarasol() throws InterruptedException {
        FCarasol1.click();
        Thread.sleep(2000);
        FCarasol1.click();
        Thread.sleep(2000);
    }

    // Plus Quantity button
    @FindBy(xpath = "//span[@class ='qty-plus']")
    WebElement inCreaseQuantity;

    public void clickIncQuantity() throws InterruptedException {
        inCreaseQuantity.click();
        Thread.sleep(2000);
        inCreaseQuantity.click();
        Thread.sleep(2000);
    }

    // Minus Quantity button
    @FindBy(xpath = "//span[@class ='qty-minus']")
    WebElement MinusQuantity;

    public void clickMinusQuantity() throws InterruptedException {
        MinusQuantity.click();
        Thread.sleep(2000);
    }

    // Close Button
    @FindBy(xpath = "//button[@class ='close pull-right' and @type ='button']")
    WebElement CloseButton;

    public void clickCloseButton() throws InterruptedException {
        CloseButton.click();
        Thread.sleep(2000);
    }

    // PDP page view link
    @FindBy(xpath = "//a[@class ='full-pdp-link']")
    WebElement PdpPageView;

    public void clickPdpPageView() throws InterruptedException {
        PdpPageView.click();
        Thread.sleep(2000);
    }

    // Plus Quantity for all pages (e.g., multiple products on PLP)
    public void QuantityofallpagesPlus(WebDriver driver) throws InterruptedException {
        List<WebElement> noofPlusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-plus']"));
        if (noofPlusElementsPresent.size() > 0) {
            for (int i = 1; i <= noofPlusElementsPresent.size(); i++) {
                WebElement eachPlusElement = driver.findElement(By.xpath("(//span[@class ='qty-plus'])[" + i + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
                js.executeScript("arguments[0].click();", eachPlusElement);
                Thread.sleep(2000);
            }
        }
    }

    // Minus Quantity for all pages (e.g., multiple products on PLP)
    public void Quantityofallpagesminus(WebDriver driver) throws InterruptedException {
        List<WebElement> noofminusElementsPresent = driver.findElements(By.xpath("//span[@class ='qty-minus']"));
        if (noofminusElementsPresent.size() > 0) {
            for (int i = 1; i <= noofminusElementsPresent.size(); i++) {
                WebElement eachminusElement = driver.findElement(By.xpath("(//span[@class ='qty-minus'])[" + i + "]"));
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", eachminusElement);
                Thread.sleep(2000);
                js.executeScript("arguments[0].click();", eachminusElement);
                Thread.sleep(2000);
            }
        }
    }

    // Click on a random color option for a product on PLP
    public void clickcolor(WebDriver driver) throws InterruptedException {
        Random random = new Random();
        List<WebElement> products = driver.findElements(By.xpath("//button[contains(@class, 'color-attribute') and contains(@class, 'swatch-attr-style') and contains(@class, 'selectable') ]"));
        int totalProductcount = products.size();
        System.out.println(totalProductcount);
        int randomselectProduct = random.nextInt(totalProductcount);
        System.out.println(randomselectProduct);
        WebElement RandomSelectProductFormPLP = driver.findElement(By.xpath("(//button[contains(@class, 'color-attribute') and contains(@class, 'swatch-attr-style') and contains(@class, 'selectable') ])[" + randomselectProduct + "]"));
        RandomSelectProductFormPLP.click();
    }

    // Click Back Carousel button (Previous slide) on PLP
    @FindBy(xpath = "//button[@class ='slick-prev slick-arrow']")
    WebElement BCarasol;

    public void clickBCarasol(WebDriver driver) throws InterruptedException {
        List<WebElement> BCarasols = driver.findElements(By.xpath("//button[@class ='slick-prev slick-arrow']"));
        if (BCarasols.size() > 0) {
            BCarasol1.click();
            Thread.sleep(2000);
            BCarasol1.click();
            Thread.sleep(2000);
        }
    }

    // Click Forward Carousel button (Next slide) on PLP
    @FindBy(xpath = "//button[@class ='slick-next slick-arrow']")
    WebElement FCarasol;

    public void clickFCarasol(WebDriver driver) throws InterruptedException {
        List<WebElement> FCarasols = driver.findElements(By.xpath("//button[@class ='slick-next slick-arrow']"));
        if (FCarasols.size() > 0) {
            FCarasol1.click();
            Thread.sleep(2000);
            FCarasol1.click();
            Thread.sleep(2000);
        }
    }
}
