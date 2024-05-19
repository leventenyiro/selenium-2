import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() {
        By usernameLocator = By.id("inputEmail");
        By passwordLocator = By.id("inputPassword");
        By loginButtonLocator = By.className("btn-primary");

        this.waitAndReturnElement(usernameLocator).sendKeys("nyiro.levente@gmail.com");

        this.waitAndReturnElement(passwordLocator).sendKeys("Valami1212");

        clickOnButton(loginButtonLocator);
    }
}
