package myaccounts;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class MyAccountsTest extends Utility {
    //Inheriting the BaseTest Class
    String baseUrl = "https://tutorialsninja.com/demo/index.php";
    public By by;
    public String text;

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        //1.1 Click on My Account Link.
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        //1.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");
        //1.3 3 Verify the text “Register Account”
        verifyText("Register Account", By.xpath("//h1[contains(text(),'Register Account')]"), "Register Account");


    }
    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        //2.1 Click on My Account Link
        driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
        //2.2 Call the method “selectMyAccountOptions” method and pass the parameter ““Login”
        selectMyAccountOption("Login");
        //2.3 Verify the text “Returning Customer”
        verifyText("Returning Customer", By.xpath("//h2[contains(text(),'Returning Customer')]"), "Returning Customer");

    }

    @Test
    public void verifyThatUserRegisterAccountSuccessfully() throws InterruptedException {
        //3.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //3.2 Call the method “selectMyAccountOptions” method and pass the parameter “Register”
        selectMyAccountOption("Register");
        //3.3 Enter First Name
        sendTextToElement(By.xpath("//input[@id='input-firstname']"), "Rashang");
        //3.4 Enter last name
        sendTextToElement(By.xpath("//input[@id='input-lastname']"), "Soni");

        //3.5 Enter Email
        sendTextToElement(By.xpath("//input[@id='input-email']"), "rashangs15@yahoo.co.uk");
        //3.6 Enter Telephone
        sendTextToElement(By.xpath("//input[@id='input-telephone']"), "07777777009");
        //3.7 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Groupjava@11");
        //3.8 Enter Password Confirm
        sendTextToElement(By.xpath("//input[@id='input-confirm']"), "Groupjava@11");
        //3.9 Select Subscribe Yes radio button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/fieldset[3]/div[1]/div[1]/label[1]/input[1]"));
        //3.10 Click on Privacy Policy check box
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]"));
        //3.11 Click on Continue button
        clickOnElement(By.xpath("//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[2]"));
        //3.12 Verify the message “Your Account Has Been Created!”

        verifyText("Your Account Has Been Created!", By.xpath("//h1[contains(text(),'Your Account Has Been Created!')]"), "Your Account Has Been Created!");

        //3.13 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
        //3.14 Click on My Account Link
        clickOnElement(By.xpath("//h2[contains(text(),'My Account')]"));
        //3.15 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");
        //3.16 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        Thread.sleep(2000);
        //3.17 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }

    @Test
    public void verifyThatUserShouldLoginAndLogoutSuccessfully() throws InterruptedException {
        //4.1 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.2 Call the method “selectMyAccountOptions” method and pass the parameter “Login”
        selectMyAccountOption("Login");
        //4.3 Enter Email address
        sendTextToElement(By.xpath("//input[@id='input-email']"), "rashangs14@yahoo.co.uk");
        //4.6 Enter Password
        sendTextToElement(By.xpath("//input[@id='input-password']"), "Groupjava@11");
        //4.7 Click on Login button
        clickOnElement(By.xpath("//body/div[@id='account-login']/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/input[1]"));
        //4.8 Verify text “My Account”
        verifyText("My Account", By.xpath("//h2[contains(text(),'My Account')]"), "My Account");

        Thread.sleep(2000);
        //4.9 Click on My Account Link.
        clickOnElement(By.xpath("//span[contains(text(),'My Account')]"));
        //4.10 Call the method “selectMyAccountOptions” method and pass the parameter “Logout”
        selectMyAccountOption("Logout");
        //4.11 Verify the text “Account Logout”
        verifyText("Account Logout", By.xpath("//h1[contains(text(),'Account Logout')]"), "Account Logout");

        Thread.sleep(2000);
        //4.12 Click on Continue button
        clickOnElement(By.xpath("//a[contains(text(),'Continue')]"));
    }
        @After
        public void tearDown() {
            closeBrowser();
        }
    }