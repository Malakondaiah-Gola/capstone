package com.capstone.tests;
import com.capstone.base.BaseTest;
import com.capstone.pages.CartPage;
import com.capstone.pages.HomePage;
import com.capstone.pages.ProductPage;
import com.capstone.pages.SearchResultsPage;
import static org.testng.Assert.assertTrue;

import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class ECommerceTest extends BaseTest {


@Test
public void testECommerceScenario() throws InterruptedException {
// Step 1: Verify the homepage
	
   assertTrue(driver.findElement(HomePage.Flipkart_Logo).isDisplayed(), "Flipkart is not present on the homepage");

// Step 2: Search for a product
   driver.findElement(HomePage.SEARCH_BOX).sendKeys("Macbook air m2");
   driver.findElement(HomePage.SEARCH_BOX).submit();

// Step 3: Click on the first displayed item
   driver.findElement(SearchResultsPage.FIRST_ITEM).click();
   
   // Open a new tab using JavaScript
   //((ChromeDriver) driver).executeScript("window.open();");

   // Get the handles of all open tabs/windows
   Set<String> handles = driver.getWindowHandles();

   // Switch to the new tab
   for (String handle : handles) {
       driver.switchTo().window(handle);
   }

   // Wait for 10 seconds using WebDriverWait
   Thread.sleep(5000);
   
   //to enter pincode, without pincode add to cart not working properly
   WebElement PinCode_Field = driver.findElement(ProductPage.PinCode);

   PinCode_Field.sendKeys("500091");
   PinCode_Field.sendKeys(Keys.RETURN);

// Step 4: Add to Cart
   // Wait until the element is clickable
   WebDriverWait wait = new WebDriverWait(driver, 10);

   WebElement AddToCartClickable = wait.until(ExpectedConditions.elementToBeClickable(ProductPage.ADD_TO_CART_BUTTON));

   //click on add to cart
   AddToCartClickable.click();

// Step 5: Verify item added to cart successfully
   assertTrue(driver.findElement(CartPage.CART_SUCCESS_MESSAGE).isDisplayed(), "Item is not added to cart");
}


}


