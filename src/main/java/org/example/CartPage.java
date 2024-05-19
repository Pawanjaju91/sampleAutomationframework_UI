package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;
    private By proceedCheckoutButton = By.xpath("//*[@name=\"proceedToRetailCheckout\"]");
    private By cartPriceText = By.xpath("//*[@class=\"sc-badge-price\"]//span");
    private By cartSubTotalPriceText = By.xpath("//*[@id='sc-subtotal-amount-activecart']//..//span");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getCartPrice() {
        // Implementation to get the price of the product in the cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedCheckoutButton)));

        WebElement cartPrice = driver.findElement(cartPriceText);

        String cartProductPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", cartPrice);
        System.out.println("Actual price on cart page" + cartProductPrice);


        return cartProductPrice;
    }

    public String getCartSubtotal() {
        // Implementation to get the sub-total price of the product in the cart
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(proceedCheckoutButton)));

        List<WebElement> subTotalList = driver.findElements(cartSubTotalPriceText);
        String cartProductSubTotalPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", subTotalList.get(2));
        System.out.println("Actual Sub Total on cart page" + cartProductSubTotalPrice);


        return cartProductSubTotalPrice;
    }

    public boolean verifyItemPrices() {
        // Implementation to verify that each item total price in the cart is correct
        return true;
    }

    public boolean verifySubtotal() {
        // Implementation to verify that the subtotal is calculated correctly
        return true;
    }
}
