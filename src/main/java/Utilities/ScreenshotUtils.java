package Utilities;

import org.openqa.selenium.*;


public class ScreenshotUtils {

    public static byte[] captureScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}
