package cucumber.sconto.util;

import com.codeborne.selenide.WebDriverRunner;
import cucumber.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Helper {

    private static By acceptBtn = By.xpath("//*[@data-accept-action='all']");

    /* Properties */
    public static String basicURL = PropertiesLoader.loadProperty("url");
    public static String loginURL = basicURL + "/login"; // 0_0 - concatenation!!!

    /* Kunden Konto Menu */
    public static By ihreKundendatenMenu = By.linkText("Iren Kundendaten");
    // xpath можно сикать через дерево элементов и Ctrl+F

    public static void acceptCookies() {
        $(acceptBtn).click();
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }
}
