package com.capstone.pages;
import com.capstone.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchResultsPage extends BaseTest {

   
    public void clickOnFirstItem() {
        WebElement firstItem = driver.findElement(By.xpath("(//div[@class='_4rR01T'])[1]"));
        firstItem.click();
       
    }
    
    
    
}
