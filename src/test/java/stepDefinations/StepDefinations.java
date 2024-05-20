package stepDefinations;

import Utilities.ScreenshotUtils;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import org.example.CartPage;
import org.example.HomePage;
import org.example.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class StepDefinations {
    WebDriver driver;
    HomePage homePage;
    ProductPage productPage;
    CartPage cartPage;
    public static String productPagePrice;
    public static String cartPagePrice;
    public static String cartSubTotalPagePrice;

    @Before
    public void setUp() {

        driver = new ChromeDriver();
        // driver.manage().deleteAllCookies();
    }


    @AfterStep
    public void embedScreenshotAfterStep(Scenario scenario) {
        byte[] screenshot = ScreenshotUtils.captureScreenshot(driver);
        scenario.attach(screenshot, "image/jpg", "Step Screenshot");
    }

    @After
    public void teardown() {

        driver.quit();
    }

    @Given("^User is on the Amazon website$")
    public void user_is_on_the_amazon_website() {
        homePage = new HomePage(driver);
        homePage.navigateToHomePage();

        // Wait for the page to fully load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Amazon.com"));

        String expectedTitle = "Amazon.com. Spend less. Smile more.";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Amazon page is not loaded");


    }

    @When("^User searches for \"([^\"]*)\"$")
    public void user_searches_for(String item) {

        homePage.searchForItem(item);
    }


    @And("^User selects the (\\d+)(?:st|nd|rd|th) item in the List$")
    public void user_selects_the_item_in_the_list(int itemNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(homePage.getresults()));
        homePage.clickOnItemInList(itemNumber);
        productPage = new ProductPage(driver);
    }


    @And("^User adds the item to cart$")
    public void user_adds_the_item_to_cart() {
        productPage.addToCart();
    }

    @And("^User opens the Cart$")
    public void user_opens_the_cart() {
        productPage.navigateToCart();
        cartPage = new CartPage(driver);
    }

    @Then("^Verify that the price is identical to the product page$")
    public void verify_that_the_price_is_identical_to_the_product_page() {
        Assert.assertEquals(productPagePrice, cartPagePrice, "Price on product page and cart page is matching");
    }

    @And("^Verify that the subtotal is identical to the product page$")
    public void verify_that_the_subtotal_is_identical_to_the_product_page() {
        Assert.assertEquals(productPagePrice.trim(), cartSubTotalPagePrice.trim(), "Sub Total Price on product page and Sub total product price on cart page is matching");
    }

    @And("^Verify that the subtotal is calculated correctly$")
    public void verify_that_the_subtotal_is_calculated_correctly() {
        System.out.println("Total cart sub value=" + cartSubTotalPagePrice);
        System.out.println("Total cart sub value of first item=" + cartPagePrice);
        //cartSubTotalPagePrice

        cartPage.verifySubtotal(cartSubTotalPagePrice);
        //driver.quit();
    }

    @Then("User fetch product price on product page")
    public void userFetchProductPriceProductPage() {
        productPagePrice = productPage.getProductPrice().trim();
    }

    @Then("User fetch product price on cart page")
    public void userFetchProductPriceCartPage() {
        cartPagePrice = cartPage.getCartPrice().trim();
    }

    @Then("User fetch sub total price on cart page")
    public void userFetchSubTotalProductPriceCartPage() {
        cartSubTotalPagePrice = cartPage.getCartSubtotal().trim();
    }

    @Then("User sets american address")
    public void userSetsAmericanAddress() throws InterruptedException {
        homePage.setAddress();
    }

    @And("User clicks {string}")
    public void userClicks(String act) throws InterruptedException {
        homePage.clickAction(act);
    }
}
