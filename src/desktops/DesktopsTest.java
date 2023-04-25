package desktops;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Utility;

import java.util.List;

public class DesktopsTest extends Utility{
    //Inheriting the BaseTest Class
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyProductArrangeInAlphabeticalOrder() {
        //1.1 Mouse hover on Desktops Tab.and click
        WebElement desktop = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktop.click();
        //1.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");
        //1.3 Select Sort By position "Name: Z to A"
        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (Z - A)");
        //1.4 Verify the Product will arrange in Descending order.
        List<WebElement> productNameElements = driver.findElements(By.cssSelector(".product-layout .caption h4 a"));
        int count = productNameElements.size();
        for (int i = 0; i < count - 1; i++) {
            String productName1 = productNameElements.get(i).getText();
            String productName2 = productNameElements.get(i + 1).getText();
            Assert.assertTrue(productName1.compareToIgnoreCase(productName2) >= 0);
        }
    }
    @Test
    public void verifyProductAddedToShoppingCartSuccessFully() throws InterruptedException {
        //2.1 Mouse hover on Desktops Tab. and click
        WebElement desktop = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktop.click();
        //2.2 Click on “Show All Desktops”
        selectMenu("Show AllDesktops");
        //2.3 Select Sort By position "Name: A to Z"
        WebElement dropDown = dropDownMenu(By.id("input-sort"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Name (A - Z)");
        //2.4 Select product “HP LP3065”
        WebElement product = driver.findElement(By.linkText("HP LP3065"));
        String productName = product.getText();
        product.click();
        //2.5 Verify the Text "HP LP3065"
        verifyText("HP LP3065", By.xpath("//a[contains(text(),'HP LP3065')]"), "HP LP3065");

        //2.6 Select Delivery Date "2022-11-30"
        // Select delivery date
        String year = "2022";
        String month = "November";
        String date = "30";

        clickOnElement(By.xpath("//body/div[@id='product-product']/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]/button[1]"));
        //clickOnElement(By.id("input-option225"));
        while (true) {
            String monthYear = driver.findElement(By.xpath("(//th[@class='picker-switch'])[1]")).getText();
            System.out.println(monthYear); // November 2022
            String[] a = monthYear.split(" ");
            String mon = a[0];
            String yer = a[1];
            if (mon.equalsIgnoreCase(month) && yer.equalsIgnoreCase(year)) {
                break;
            } else {
                clickOnElement(By.xpath("/html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]")); // /html/body/div[4]/div/div[1]/table/thead/tr[1]/th[3]
            }
        }
        //Logic to select date -
        List<WebElement> allDates = driver.findElements(By.xpath("/html/body/div[4]/div/div[1]/table/tbody/tr[5]/td[3]"));
        for (WebElement dt : allDates) {
            if (dt.getText().equalsIgnoreCase(date)) {
                dt.click();
                break;
            }
        }
        //2.7.Enter Qty "1” using Select class
        clearQty(By.xpath("//input[@id='input-quantity']"));
        sendTextToElement(By.xpath("//input[@id='input-quantity']"), "1");

        //2.8 Click on Add to Cart button
        clickOnElement(By.xpath(" //button[@id='button-cart']"));

        //2.9  Verify the Message “Success: You have added HP LP3065 to your shopping cart!”
        verifyText("Success: You have added HP LP3065 to your shopping cart!\n×", By.xpath("//div[@class='alert alert-success alert-dismissible']"),
                "Success: You have added HP LP3065 to your shopping cart!\n×");

        clickOnElement(By.xpath("//span[contains(text(),'Shopping Cart')]"));
        //2.11 Verify the text "Shopping Cart"
        verifyText("Shopping Cart", By.xpath("//span[contains(text(),'Shopping Cart')]"),
                "Shopping Cart");

        //2.12 Verify the Product name "HP LP3065"
        verifyText("HP LP3065", By.xpath("//body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[2]/a[1]"),
                "HP LP3065");

        //2.13 Verify the Delivery Date "2022-11-30"
        verifyText("Delivery Date:2022-11-30", By.xpath("//small[contains(text(),'Delivery Date:2022-11-30')]"),
                "Delivery Date:2022-11-30");

        //2.14 Verify the Model "Product21"
        verifyText("Product 21", By.xpath("//td[contains(text(),'Product 21')]"),
                "Product 21");

        //2.15 Verify the Total "£74.73" or "$122.00"
        verifyText("$122.00", By.xpath("//tbody/tr[1]/td[6]"),
                "$122.00");

        Thread.sleep(3000);
    }
    @After
    public void tearDown() {
        driver.close();//close the browser
    }
}
