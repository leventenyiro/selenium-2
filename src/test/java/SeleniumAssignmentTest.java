import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumAssignmentTest {
    public WebDriver driver;
    
    @Before
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        this.driver = new ChromeDriver(options);
    }

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage(this.driver);

        Assert.assertTrue(mainPage.getPageTitle().contains("SB-DT"));

        Assert.assertTrue(mainPage.getPageText().contains("Fedezd fel"));

        Thread.sleep(1000);

        LoginPage loginPage = mainPage.getLoginPage();
        loginPage.login();

        Thread.sleep(1000);

        assertTrue(mainPage.testPageAfterLogin().contains("Create"));

        Thread.sleep(1000);

        mainPage.clickOnCreate();

        Thread.sleep(1000);

        mainPage.navigateBack();

        Thread.sleep(1000);

        mainPage.logout();

        Thread.sleep(1000);
    }

    @After
    public void close() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }
}
