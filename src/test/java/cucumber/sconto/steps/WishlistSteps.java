package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import cucumber.sconto.pages.CustomerAccountP;
import cucumber.sconto.pages.WishlistP;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.CollectionCondition.empty;
import static com.codeborne.selenide.Selenide.$;

public class WishlistSteps {

    WishlistP wishlistPage = new WishlistP();

    @Then("I see added item")
    public void iSeeItems() {
        wishlistPage.listHasAnItem();
    }

    @Then("I see empty Wishlist")
    public void emptyWishlist() {
        wishlistPage.wishlistItems().shouldBe(empty); //!!!
    }

    @When("I click on {} menu") // @When("I click on {}") - если настроить навигацию мебели
    public void iClickOnHeaderMenuNavigation(String menuName) {
        wishlistPage.clickOnFurniture(menuName);
    }

    @When("I remove {} item")
    public void removeItem(Integer item) {
        wishlistPage.clickToRemoveItem(item);
    }

}
