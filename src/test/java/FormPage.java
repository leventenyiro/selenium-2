import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FormPage extends PageBase {
    private WebDriver driver;
    private WebDriverWait wait;

    private By nameLocator = By.name("name");
    private By emailLocator = By.name("email");
    private By messageLocator = By.name("message");
    private By submitButtonLocator = By.xpath("//button[@type='submit']");

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void fillForm() {
        Properties properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("userdata.properties");
            properties.load(fileInputStream);
            fileInputStream.close();

            driver.get("https://balatonapartmanok.hu/ajanlat.html");

            this.waitAndReturnElement(nameLocator).sendKeys(properties.getProperty("name"));
            this.waitAndReturnElement(emailLocator).sendKeys(properties.getProperty("email"));
            this.waitAndReturnElement(messageLocator).sendKeys(properties.getProperty("message"));

            this.waitFor(1000);

            WebElement submitButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(submitButtonLocator));
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            jsExecutor.executeScript("arguments[0].click();", submitButtonElement);

            this.waitFor(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
