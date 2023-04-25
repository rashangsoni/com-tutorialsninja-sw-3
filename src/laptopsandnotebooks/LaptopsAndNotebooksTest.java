package laptopsandnotebooks;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

public class LaptopsAndNotebooksTest extends Utility {
    //Inheriting the BaseTest Class
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    private By by;
    private String text;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductsPriceDisplayHighToLowSuccessfully() {
        //1.1 Mouse hover on Laptops & Notebooks Tab.and click
        WebElement laptops$Notebooks = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptops$Notebooks.click();
        //1.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //1.3 Select Sort By "Price (High > Low)"
        Select sortByDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortByDropdown.selectByVisibleText("Price (High > Low)");

        // verify that the product price is displayed in high to low order
        String expectedMessage = "Price (High > Low)";
        String actualMessage = driver.findElement(By.xpath("//option[contains(text(),'Price (High > Low)')]")).getText();

        if (actualMessage.contains(expectedMessage)) {
            System.out.println("PASS: Product price arranged in High to Low order");
        } else {
            System.out.println("FAIL: Product price NOT arranged in High to Low order");
        }
    }

    @Test
    public void verifyThatUserPlaceOrderSuccessfully() throws InterruptedException {
        //2.1 Mouse hover on Laptops & Notebooks Tab and click
        WebElement laptops$Notebooks = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptops$Notebooks.click();
        //2.2 Click on “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");
        //2.3 Select Sort By "Price (High > Low)"
        Select sortByDropdown = new Select(driver.findElement(By.id("input-sort")));
        sortByDropdown.selectByVisibleText("Price (High > Low)");
        //2.4 Select Product “MacBook”
        clickOnElement(By.linkText("MacBook"));
        //2.5 Verify the text “MacBook
        verifyText("MacBook", By.xpath("//h1[contains(text(),'MacBook')]"), "MacBook");
        // assertEquals("MacBook", driver.findElement(By.xpath("//h1[contains(text(),'MacBook')]")).getText());
        //2.6 Click on ‘Add To Cart’ button
        clickOnElement(By.id("button-cart"));
        //2.7 Verify the message “Success: You have added MacBook to your shopping cart!×”
        verifyText("Success: You have added MacBook to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have added MacBook to your shopping cart!\n×");

        //2.8 Click on link “shopping cart” display into success message
        clickOnElement(By.xpath("//a[contains(text(),'shopping cart')]"));
        //2.9 Verify the text "Shopping Cart"
        verifyText("Shopping Cart", By.xpath("//a[contains(text(),'Shopping Cart')]"), "Shopping Cart");

        //2.10 Verify the Product name "MacBook"
        verifyText("MacBook", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"), "MacBook");

        //2.11 Change Quantity "2"
        clearTextFromField(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"));
        sendTextToElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/input[1]"), "2");
        //2.12 Click on “Update” Tab
        clickOnElement(By.xpath("//tbody/tr[1]/td[4]/div[1]/span[1]/button[1]/i[1]"));
        //2.13 Verify the message “Success: You have modified your shopping cart!”
        verifyText("Success: You have modified your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have modified your shopping cart!\n×");

        //2.14 Verify the Total £737.45 or $1,204.00
        verifyText("$1,204.00", By.xpath("//tbody/tr[1]/td[6]"), "$1,204.00");

        //2.15 Click on “Checkout” button
        clickOnElement(By.xpath("//a[contains(text(),'Checkout')]"));
        //2.16 Verify the text “Checkout”
        verifyText("Checkout", By.xpath("//h1[contains(text(),'Checkout')]"), "Checkout");

        Thread.sleep(2000);
        //2.17 Verify the Text “New Customer”
        verifyText("New Customer", By.xpath("//h2[normalize-space()='New Customer']"), "New Customer");

        //2.18 Click on “Guest Checkout” radio button
        clickOnElement(By.xpath("//label[normalize-space()='Guest Checkout']"));
        //2.19 Click on “Continue” tab
        clickOnElement(By.xpath("//input[@id='button-account']"));
        //2.20 Fill the mandatory fields, enter email into email field
        sendTextToElement(By.xpath("//input[@id='input-payment-firstname']"), "Rashang");
        sendTextToElement(By.xpath("//input[@id='input-payment-lastname']"), "Thakur");
        sendTextToElement(By.xpath("//input[@id='input-payment-email']"), "mvthakur2011@gmail.com");
        sendTextToElement(By.xpath("//input[@id='input-payment-telephone']"), "07777777000");
        sendTextToElement(By.xpath("//input[@id='input-payment-address-1']"), "101,keats court, Wembley");
        sendTextToElement(By.xpath("//input[@id='input-payment-city']"), "London");
        sendTextToElement(By.xpath("//input[@id='input-payment-postcode']"), "HA0 3NZ");
        WebElement country = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select select = new Select(country);
        select.selectByVisibleText("United Kingdom");

        Thread.sleep(2000);
        WebElement region = driver.findElement(By.xpath("//select[@name='zone_id']"));
        Select select1 = new Select(region);
        select1.selectByVisibleText("Greater London");

        //2.21 Click on “Continue” Button
        clickOnElement(By.xpath(" //input[@id='button-guest']"));
        //2.22 Add Comments About your order into text area
        sendTextToElement(By.xpath("//body/div[@id='checkout-checkout']/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p[2]/textarea[1]"), "Hi I am Manju");
        Thread.sleep(2000);
        //2.23 Check the Terms & Conditions check box
        clickOnElement(By.xpath("//input[@name='agree']"));

        //2.24 Click on “Continue” button
        clickOnElement(By.xpath("//input[@id='button-payment-method']"));

        //2.25 Verify the message “Warning: Payment method required!
        verifyText("Warning: Payment method required!\n×", By.xpath("//div[@class='alert alert-danger alert-dismissible']"),
                "Warning: Payment method required!\n×");

        Thread.sleep(2000);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}