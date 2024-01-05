import pytest
import time
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
from selenium.common.exceptions import TimeoutException 
from selenium.webdriver.common.keys import Keys

@pytest.fixture
def driver():
    # Set up the WebDriver with ChromeOptions
    options = webdriver.ChromeOptions()
    options.add_argument('executable_path=C:\\Users\\LENOVO-VSC\\Desktop\\Capstone\\chromedriver-win64\\chromedriver.exe')

    # Initialize Chrome WebDriver with options
    driver = webdriver.Chrome(options=options)
    
    driver.maximize_window()
    yield driver
    
    # Teardown - close the browser after the test is done
    driver.quit()

def test_capstone_flipkart_python(driver):
    
    # 1. Launch the URL and verify "Flipkart" is present on the left side of the top

    # Navigate to flipkart site
    driver.get("https://www.flipkart.com/")

    # verify Flipkart present on left side
    verify_flipkart = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, "//a[@title='Flipkart']")))
    assert verify_flipkart.is_displayed

    # 2. Enter “Macbook air m2” in the search text box and search
    search_box = driver.find_element(By.NAME, "q")
    search_box.send_keys("Macbook air m2")
    search_box.submit()

    # 3. Click on the first displayed item
    first_item = WebDriverWait(driver, 10).until(EC.visibility_of_element_located((By.XPATH, "(//div[@class='_4rR01T'])[1]")))
    first_item.click()
    # Copy name of first displayed item to verify in cart
    first_item_text=first_item.text

    # 4. Click on the "Add To Cart" button
    # Switch to the new tab as new tab opens on click of first displayed product
    driver.switch_to.window(driver.window_handles[1])  # Index 1 corresponds to the second tab
    #enter pincode as not able to add to cart without pincode
    time.sleep(5)
    pin_code = WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, "//input[@id='pincodeInputId']")))
    pin_code.send_keys("500091")
    pin_code.send_keys(Keys.RETURN)
    time.sleep(5)
    try:
     add_to_cart_button = WebDriverWait(driver, 20).until(EC.element_to_be_clickable((By.XPATH, "//button[contains(., 'Add to cart')]")))
     print("Add to cart displayed and clickable.")
    except TimeoutException:
         print("Timeout: Add to cart not found or not clickable within the specified time.")
    add_to_cart_button.click()

    # 5. Verify that the item has been added to the cart successfully
    # Building xpath with text copied from first displayed product
    verify_cart_xpath = f"//a[contains(text(), '{first_item_text}')]"
    verify_cart_element = WebDriverWait(driver, 10).until(EC.presence_of_element_located((By.XPATH, verify_cart_xpath)))
    # Assert that added product present in cart
    assert verify_cart_element is not None, f"Element with XPath '{verify_cart_xpath}' not found on the page."
    assert verify_cart_element.is_displayed(), "Element is not displayed."
    
# Run the test using the following command in the terminal:
# pytest capstone_flipkart_pytest.py
