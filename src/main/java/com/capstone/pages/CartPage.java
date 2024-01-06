package com.capstone.pages;
import com.capstone.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class CartPage extends BaseTest {

	
    public  boolean checkItemAddedToCart() {
    	
    	
        WebElement addedToCart = driver.findElement(By.xpath("//a[contains(text(),'APPLE 2022 MacBook AIR Apple M2 - (8 GB/512 GB SSD')]"));

        return addedToCart.isDisplayed();
    }
    
    
    
}

