package homepage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class TopMenuTest extends Utility {

    //Inheriting the BaseTest Class
    String baseUrl = "https://tutorialsninja.com/demo/index.php";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @Test
    public void verifyUserShouldNavigateToDesktopsPageSuccessfully() {
        //1.1 Mouse hover on “Desktops” Tab and click
        WebElement desktop = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        desktop.click();

        //1.2 call selectMenu method and pass the menu = “Show All Desktops”
        selectMenu("Show AllDesktops");

        //1.3 Verify the text ‘Desktops’
        verifyText("Desktops", By.xpath("//h2[contains(text(),'Desktops')]"), "Desktops");
    }
    @Test
    public void verifyUserShouldNavigateToLaptopsAndNotebooksPageSuccessfully() {
        //2.1 Mouse hover on “Laptops & Notebooks” Tab and click
        WebElement laptopsNoteBooks = mouseHover(By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[2]/a[1]"));
        laptopsNoteBooks.click();

        //2.2 call selectMenu method and pass the menu = “Show All Laptops & Notebooks”
        selectMenu("Show AllLaptops & Notebooks");

        //2.3 Verify the text ‘Laptops & Notebooks’
        verifyText("Laptops & Notebooks", By.xpath("//h2[contains(text(),'Laptops & Notebooks')]"), "Laptops & Notebooks");
    }

    @Test
    public void verifyUserShouldNavigateToComponentsPageSuccessfully() {
        //2.1 Mouse hover on ““Components" Tab and Click
        WebElement components = mouseHover(By.xpath(" //body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"));
        components.click();

        //2.2 call selectMenu method and pass the menu = = ““Show All Components”
        selectMenu("Show AllComponents");

        //3.3 Verify the text ‘Components’
        verifyText("Components", By.xpath("//body/div[1]/nav[1]/div[2]/ul[1]/li[3]/a[1]"), "Components");

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}