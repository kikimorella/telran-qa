package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.sconto.pages.HomeP;
import cucumber.sconto.pages.FurnitureP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;

public class FurnitureSteps {

    FurnitureP furniturePage = new FurnitureP();

    @Then("I see {} page")
    public void iSeeFurniturePage(String pageName) {
        furniturePage.furnitureHeader().shouldHave(text(pageName));
    }

    @When("I add {} item(s) to Wishlist")
    public void iClickOnWischlistIcon(Integer item) {
        furniturePage.addItemToWishlist(item);
    }

    @Then("I see Wishlist icon is activated for {} item(s)")
    public void wishlistIconActivated(Integer wishlistItems) {
        furniturePage.activatedWishListIcon().shouldBe(size(wishlistItems));
    }

    @Then("I see added item in Merkliste")
    public void iSeeAddedItemInMarkedList() {
        furniturePage.countNumber().should(Condition.exist);
    }
}
