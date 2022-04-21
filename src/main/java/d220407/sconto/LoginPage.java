package d220407.sconto;

import d220407.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import java.security.PublicKey;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage extends HeaderMenu{

    /* Properties */
    public static String validEmail = PropertiesLoader.loadProperty("valid.email");
    public static String validPwd = PropertiesLoader.loadProperty("valid.password");


    private static final By emailField = By.id("loginEmail");
    private static final By passField = By.id("loginPassword");
    private static final By loginButton = By.id("login-submit");

    public void fillCred(String login, String pass) {
        $(emailField).setValue(login);
        $(passField).setValue(pass);
    }

    public HomePage clickOnLoginBtn() {
        $(loginButton).click();
        return page(HomePage.class);
    }
}
