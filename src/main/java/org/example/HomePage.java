package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By searchField = By.xpath(" //*[@id=\"twotabsearchtextbox\"] | //*[@id=\"nav-bb-search\"]");
    private By resultList = By.xpath("//*[@data-component-type=\"s-search-results\"]//div[1]//h2/a");

    private By results = By.xpath("//span[contains(text(),\"Results\")]");
    private By selectLocationbtn = By.xpath("//*[@data-action-type=\"SELECT_LOCATION\"]");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://www.amazon.com/");
        //driver.get("https://www.amazon.com/s?k=Laptop");
    }

    public WebElement getresults() {
        return driver.findElement(results);

    }

    public void searchForItem(String item) {
        driver.findElement(searchField).sendKeys(item);
        driver.findElement(searchField).sendKeys(Keys.ENTER);

    }


    public void clickOnItemInList(int itemNumber) {
        // Implementation to click on the nth item in the search results list
        List<String> productList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(resultList);
        System.out.println("No of monitors searched=" + productElements.size());
        if (itemNumber == 1)
            productElements.get(itemNumber).click();
        else if (itemNumber == 2)
            productElements.get(itemNumber - 1).click();

    }


    public void setAddress() throws InterruptedException {
        driver.findElement(selectLocationbtn).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.TAB);
        action.sendKeys(Keys.TAB);
        action.sendKeys("12045");

        action.sendKeys(Keys.TAB);
        action.sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        action.sendKeys(Keys.ESCAPE);
        action.perform();

    }

    public void clickAction(String keystroke) {
        Actions action = new Actions(driver);
        String act = keystroke;
        action.sendKeys(Keys.ESCAPE);
        action.perform();
    }
}

