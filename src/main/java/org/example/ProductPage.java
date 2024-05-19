package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private By addToCartButton = By.id("add-to-cart-button");
    private By inStockText = By.xpath("//*[contains(text(),\"In Stock\")]");
    private By cartButton = By.id("nav-cart");
    private By priceElement = By.xpath("//*[contains(@id,\"corePrice\")]//*[contains(@id,\"taxInclusiveMessage\")]//..//span[@class=\"a-offscreen\"]");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void navigateToCart() {
        driver.findElement(cartButton).click();
    }

    public String getProductPrice() {
        // Implementation to get the price of the product on the product page

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(inStockText)));

        // Get the text of the price element
        List<WebElement> priceElementList = driver.findElements(priceElement);
        String productPrice = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", priceElementList.get(0));
        System.out.println("Actual price on product page" + productPrice);

        return productPrice;
    }

    public String getProductTotal() {
        // Implementation to get the total price of the product on the product page
        return getProductPrice();
    }
}
