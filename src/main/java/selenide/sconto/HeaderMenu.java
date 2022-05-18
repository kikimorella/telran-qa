package selenide.sconto;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.sconto.pages.FurnitureP;
import org.openqa.selenium.By;
import selenide.sconto.util.PropertiesLoader;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class HeaderMenu {

    /* Properties from the properties file*/
    public static String kontoText = PropertiesLoader.loadProperty("konto.text");
    public static String anmeldenText = PropertiesLoader.loadProperty("anmelden.text");

    /* Locators on the website header */
    private static By wishlistNumber = By.cssSelector(".headerElement__status--wishlist");
    private static final By iconLogin = By.cssSelector(".headerElement__text--login"); // нужно уникальное и универсальное поисковое наименование!

    /* Methods for Header */
    public <T> T clickLoginIcon(Class<T> expectedPage) {
        $(iconLogin).click();
        return page(expectedPage);
    }
    /* решение проблемы с одинаковыми действиями, меняем в тесте
       Класс эквивалентности (equivalence class) — одно или несколько значений ввода, к которым программное обеспечение
       применяет одинаковую логику. Принцип: Если один тест выдает какой-то результат, то подойдет для всех остальных*/

    public void checkIconText(String iconText) {
        $(iconLogin).shouldHave(Condition.text(iconText));
    }

    public SelenideElement countNumber() {
        return $(wishlistNumber);
    }

    public FurnitureP clickOnFurniture(String menuName) {
        By menuItem = By.cssSelector(".menu__link--" + menuName.toLowerCase()); // так формируется имя меню сразу в методе
        $(menuItem).doubleClick(); // если клик 1, то открывается меню выбора вариантов софы
        return Selenide.page(FurnitureP.class);
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
