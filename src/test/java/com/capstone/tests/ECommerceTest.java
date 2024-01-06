package com.capstone.tests;
import com.capstone.base.BaseTest;
import com.capstone.pages.CartPage;
import com.capstone.pages.HomePage;
import com.capstone.pages.ProductPage;
import com.capstone.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ECommerceTest extends BaseTest {

    @Test
    public void testECommerceScenario() throws InterruptedException {
        
    	// intialization of pages
    	HomePage homePage = new HomePage();
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        ProductPage productPage = new ProductPage();
        CartPage cartPage = new CartPage();

        // Checking the Flipkart is present on left side of the top 
        Assert.assertTrue(homePage.isFlipkartLogoDisplayed(), "Flipkart logo is not displayed.");

        //Enter “Macbook air m2” in text box and search
        homePage.searchProduct("Macbook air m2");
        
        //Click on First displayed Item
        searchResultsPage.clickOnFirstItem();
        
        //Switching to next tab
        productPage.switchToSecondTab(driver);
        //entering pincode
        productPage.enterPincode("500091");
       
        //Click on Add To Cart button
        productPage.addToCart();
        
        //checking product in cart
        Assert.assertTrue(cartPage.checkItemAddedToCart(), "Item was not added to the cart.");
    }
}



