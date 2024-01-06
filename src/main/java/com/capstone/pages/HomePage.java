package com.capstone.pages;
import com.capstone.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseTest {

   
    public void searchProduct(String productName) {
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='q']"));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }
    public boolean isFlipkartLogoDisplayed() {
        WebElement flipkartLogo = driver.findElement(By.xpath("//img[@title='Flipkart']"));
        return flipkartLogo.isDisplayed();
    }
}
