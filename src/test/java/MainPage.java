import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage extends PageBase {
    public MainPage(WebDriver driver) {
        super(driver);
        this.driver.get("https://sb-dt-3a9d4.web.app/");
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }

    public String getPageText() {
        return this.waitAndReturnElement(By.id("landing")).getText();
    }

    public LoginPage getLoginPage() {
        By locator = By.xpath("//button[contains(text(),'Belépés')]");
        this.waitAndReturnElement(locator).click();
        return new LoginPage(this.driver);
    }

    public String testPageAfterLogin() {
        return waitAndReturnElement(By.xpath("//button[contains(text(),'Create')]")).getText();
    }

    public void clickOnCreate() {
        By locatorCreate = By.xpath("//button[contains(text(),'Create')]");
        this.waitAndReturnElement(locatorCreate).click();
    }

    public void logout() {
        By locatorHover = By.xpath("//button[contains(@class, 'ant-btn')");

        WebElement element = this.driver.findElement(locatorHover);
        Actions action = new Actions(this.driver);
        action.moveToElement(element).perform();

        By locatorLogout = By.xpath("//li[contains(@class, 'ant-dropdown-menu-item') and contains(@class, 'ant-dropdown-menu-item-danger') and contains(@class, 'ant-dropdown-menu-item-only-child') and .//div[.='Sign out']]\r\n");
        this.waitAndReturnElement(locatorLogout).click();
    }
}
