package com.capstone.base;
import com.capstone.pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



//BaseTest.java
public class BaseTest {
 protected WebDriver driver;

 @BeforeSuite
 public void setUp() {
     // Initialize WebDriver
     System.setProperty("webdriver.chrome.driver", "C:\\Users\\LENOVO-VSC\\Desktop\\Capstone\\chromedriver-win64\\chromedriver.exe");
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get(HomePage.URL);
 }

 @AfterSuite
 public void tearDown() {
     // Close the browser
     if (driver != null) {
        // driver.quit();
     }
 }
}
