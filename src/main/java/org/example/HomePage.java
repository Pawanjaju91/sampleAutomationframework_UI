package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.w3c.dom.stylesheets.LinkStyle;
;import java.util.ArrayList;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private By searchField = By.xpath(" //*[@id=\"twotabsearchtextbox\"] | //*[@id=\"nav-bb-search\"]");
    private By resultList = By.xpath("//*[@data-component-type=\"s-search-results\"]//div[1]//h2/a");

    private By results = By.xpath("//span[contains(text(),\"Results\")]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://www.amazon.com/");

    }

    public WebElement getresults() {
        return driver.findElement(results);

    }

    public void searchForItem(String item) {
        driver.findElement(searchField).sendKeys(item);
        driver.findElement(searchField).sendKeys(Keys.ENTER);
        //  driver.findElement(searchButton).click();
    }


    public void clickOnItemInList(int itemNumber) {
        // Implementation to click on the nth item in the search results list
        List<String> productList = new ArrayList<>();
        List<WebElement> productElements = driver.findElements(resultList);
        System.out.println("No of monitors searched=" + productElements.size());
        if (itemNumber == 1)
            productElements.get(itemNumber).click();
        else if (itemNumber == 2)
            productElements.get(itemNumber).click();

    }


}
