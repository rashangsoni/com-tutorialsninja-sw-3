package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    public void selectMenu(String menu) {
        driver.findElement(By.linkText(menu)).click();
    }

    /**
     * This method will hoover mouse on the element
     */
    public WebElement mouseHover(By by) {
        return driver.findElement(by);
    }

    /**
     * This method will get text from element
     */
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();

    }

    /**
     * This method will click on element
     */
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    public WebElement dropDownMenu(By by) {
        return driver.findElement(by);

    }

    /**
     * This method will send text to element
     */
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);
    }

    /**
     * This method will clear quantity from element
     */
    public void clearQty(By by) {
        driver.findElement(by).clear();
    }

    /**
     * This method will select from element
     */
    public void selectMyAccountOption(String option) {
        driver.findElement(By.linkText(option)).click();
    }

    /**
     * This method will clear text from element
     */
    public void clearTextFromField(By by) {
        driver.findElement(by).sendKeys(Keys.CONTROL + "a");
        driver.findElement(by).sendKeys(Keys.DELETE);
    }
    /**
     * This method will verify text displayed on web page
     */
    public void verifyText(String expectedMessage, By by, String displayMessage) {
        String actualMessage = getTextFromElement(by);
        Assert.assertEquals(displayMessage, expectedMessage, actualMessage);
    }


}