package d220407.sconto;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class KontoPage extends HeaderMenu{

private static final By logout = By.xpath("//a[contains(@href, '/bestellung/logout')]");

    private static final By greeting = By.cssSelector(".simpleText--grey");

    public void checkGreetingsText() {
        $(greeting).shouldHave(Condition.text("Willkommen in Ihrem Kundenkonto.")); // https://selenide.org/documentation.html
    }

    public LoginPage clickOnLogout() {
        $(logout).click();
        return page(LoginPage.class);
    }
}
