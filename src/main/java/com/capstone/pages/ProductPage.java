package com.capstone.pages;

import org.openqa.selenium.By;

public class ProductPage {

	//add to cart button
	public static final By ADD_TO_CART_BUTTON = By.xpath("//button[contains(., 'Add to cart')]");
	
	//pincode text box as add to cart is not working without filling it
		public static final By PinCode= By.xpath("//input[@id='pincodeInputId']");


}
