package cucumber.sconto.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import selenide.sconto.HeaderMenu;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FurnitureP extends HeaderMenu {

    /* Elements */
    private static By furnitureHeader = By.tagName("h1");
    private static By filledWishlistIcon = By.xpath("//*[contains(@class, 'wishlistIcon--filled')]");

    public SelenideElement furnitureHeader() {
        return $(furnitureHeader);
    }

    // public void clickOn(){$(itemWishlistIcon).click();}

    public void addItemToWishlist(int itemAmount) {
        int[] tiles = {1, 2, 4, 5};
        for (int i = 0; i <= itemAmount - 1; i++) {
            By wishlistIconItem = By.xpath("//*[@data-tile-position='" + tiles[i] + "']/*/*/*[contains(@class, 'wishlistIcon')]");  // 1-е пустое сердечко
            $(wishlistIconItem).hover();
            $(wishlistIconItem).click();
        }
    }

//    public void activeWishlistIcon() { $(wishlistIconFirstItem).hover(); }

    public ElementsCollection activatedWishListIcon() {
        return $$(filledWishlistIcon);
    }
}
