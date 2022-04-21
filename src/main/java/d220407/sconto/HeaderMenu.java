package d220407.sconto;

import com.codeborne.selenide.Condition;
import d220407.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderMenu {

    /* Properties */
    public static String kontoText = PropertiesLoader.loadProperty("konto.text");
    public static String anmeldenText = PropertiesLoader.loadProperty("anmelden.text");

    private static final By iconLogin = By.cssSelector(".headerElement__text--login"); // нужно уникальное и универсальное поисковое наименование!

    public <T> T clickLoginBtn(Class<T> expectedPage){ // решение проблемы с одинаковыми действиями, меняем в тесте
        $(iconLogin).click();
        return page(expectedPage);
    }

    public void checkIconText(String iconText) {
        $(iconLogin).shouldHave(Condition.text(iconText));
    }
}

/*
    public LoginPage clickOnLoginIcon() {
        $(iconLogin).click();
        return page(LoginPage.class);
    }

    public KontoPage clickMyKontoIcon() {
        $(iconLogin).click();
        return page(KontoPage.class);
    }
*/
