package d220317.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Page {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "username")
    WebElement usernameField; // driver.findElement(By.id("username"))

    @FindBy(id = "password")
    WebElement passwordField; // driver.findElement(By.id("password"))

    @FindBy(css = ".fa")
    WebElement loginButton;  // driver.findElement(By.cssSelector(".fa")).click();

    @FindBy(id = "flash")
    WebElement error; // driver.findElements(By.id("flash"))

    public void fillCred(String login, String pass) { // метод заполняет поля
        usernameField.sendKeys(login);
        passwordField.sendKeys(pass);
    }

    public SecurePage clickOnLoginBtn() {
        loginButton.click();
        return new SecurePage(driver);
    }

    public void clickOnLoginBtnNeg() {
        loginButton.click();
    }

    public String getErrorText() {
        return error.getText();
        // было assertTrue (driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
    }
}
