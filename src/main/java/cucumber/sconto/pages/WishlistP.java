package cucumber.sconto.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.sconto.HeaderMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WishlistP extends HeaderMenu {

    private static By itemInWishlist = By.cssSelector(".wishlistEntry");
    private static By wishlistEntries = By.className("wishlistEntry");
    private static By textUnderTheItem = By.cssSelector(".wishlistEntry__articleAddToWishlistInformation--hiddenInS");
    // textUnderTheItem - мы можем делать проверку наличия списка добавленных элементов теперь другим способом

    public SelenideElement listHasAnItem() {
        return $(textUnderTheItem);
    }

    public ElementsCollection wishlistItems() {
        return $$(wishlistEntries);
    }
}
