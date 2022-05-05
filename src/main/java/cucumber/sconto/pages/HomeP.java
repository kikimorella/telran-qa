package cucumber.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.sconto.util.PropertiesLoader;
import org.openqa.selenium.By;
import selenide.sconto.HeaderMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * HomePage
 * Class implements the HomePage methods and fields.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HomeP extends HeaderMenu {
    HomeP homePage;

    /* Elements */

    private static By acceptBtn = By.xpath("//*[@data-accept-action='all']");
    private static By loginIcon = By.cssSelector(".headerElement--login");
    private static By markedListIcon = By.cssSelector(".headerElement--Merkliste");

    private static final By iconLogin = By.cssSelector(".headerElement__text--login"); // тут можно придумать выбор из вариантов навигации

    public void checkIconText(String iconText) {
        $(iconLogin).shouldHave(Condition.text(iconText));
    }

//    public void acceptCookies(){
//        $(acceptBtn).click();
//    }

//    public LoginP clickLoginIcon() {
//        $(loginIcon).click();
//        return Selenide.page(LoginP.class);
//    }

    public WishlistP clickOnWishlist() {
        $(markedListIcon).click();
        return Selenide.page(WishlistP.class);
    }

    public void hoverLoginIcon() {
        $(loginIcon).hover();
    }

    //public SelenideElement carousel(){ return $(carouselImg); }
}
