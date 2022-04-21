package d220331.selenide;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class LoginP {
    private static final By username = By.id("username");
    private static final By pass = By.id("password");
    private static final By error = By.id("flash");
    private static final By loginButton = By.cssSelector(".fa");

}
