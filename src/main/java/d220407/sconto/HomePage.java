package d220407.sconto;

import com.codeborne.selenide.Condition;
import d220407.sconto.util.PropertiesLoader;
import org.checkerframework.checker.index.qual.UpperBoundUnknown;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class HomePage extends HeaderMenu{ // мы привязали headerMenu

    /* Properties */
    public static String basicURL = PropertiesLoader.loadProperty("url");


    private static By acceptBtn = By.xpath("//*[@data-accept-action='all']");

    public void clickAcceptCookies() {
        $(acceptBtn).click();
    }

/*
    private static final By iconLogin = By.cssSelector(".headerElement__suffix");

    public LoginPage clickOnLoginIcon() {
        $(iconLogin).click();
        return page(LoginPage.class);
    }

    public KontoPage clickMyKontoIcon() {
        $(iconLogin).click();
        return page(KontoPage.class);
    }

    public void checkIconText(String iconText) {
    $(iconLogin).shouldHave(Condition.text(iconText));
    }

 */
}
