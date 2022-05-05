package cucumber.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.sconto.HeaderMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CustomerAccountP extends HeaderMenu {

    /* Elements */
    private static By title = By.cssSelector(".titleHeadline");
    private static final By logout = By.xpath("//a[contains(@href, '/bestellung/logout')]");

    private static By wishlist = By.cssSelector(".sidebarNavigation__item:nth-child(3)");
    private static By orders = By.cssSelector(".sidebarNavigation__secondLevelCategoryName__text--Ihre Bestellungen");
    private static By data = By.linkText("Ihre Kundendaten");

    public SelenideElement accountTitle() {
        return $(title);
    }

    public LoginP clickOnLogout() {
        $(logout).click();
        return page(LoginP.class);
    }

    public WishlistP clickOnWishlistInKundenkontoMenu() {
        $(wishlist).click();
        return page(WishlistP.class);
    }
}
