package com.capstone.pages;
import com.capstone.base.BaseTest;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends BaseTest {

    public void addToCart() {
       
        int attempts = 0;
        while (attempts < 3) {
            try {
                // Re-locate the "Add to Cart" button
                WebElement addToCartButton = driver.findElement(By.xpath("//button[contains(., 'Add to cart')]"));
                addToCartButton.click();
                break;
            } catch (StaleElementReferenceException e) {
                // Handle or log the exception
                System.out.println("StaleElementReferenceException. Retrying...");
            }
            attempts++;
        }
     
    }
    
    
    public void enterPincode(String pin) {
    	
    	// Wait for the pincode input element to be present
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement enterPin = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='pincodeInputId']")));
        enterPin.sendKeys(pin);
        enterPin.submit();
    }
    
    
    public  void switchToSecondTab(WebDriver driver) {
        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Check if there are exactly two tabs/windows
        if (windowHandles.size() == 2) {
            // Get the current window handle
            String currentWindowHandle = driver.getWindowHandle();

            // Iterate through the handles
            for (String windowHandle : windowHandles) {
                // Switch to the second window
                if (!windowHandle.equals(currentWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break; // Break out of the loop after switching to the second window
                }
            }
        } else {
            // Print a message or handle the case where there are not exactly two tabs
            System.out.println("There are not exactly two tabs open.");
        }
    }


    
}
