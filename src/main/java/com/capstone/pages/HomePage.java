package com.capstone.pages;

import org.openqa.selenium.By;

public class HomePage {
    public static final String URL = "https://www.flipkart.com/";
    public static final By Flipkart_Logo = By.xpath("//img[@title='Flipkart']");
    public static final By SEARCH_BOX = By.name("q");
}