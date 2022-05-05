package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.sconto.pages.HomeP;
import cucumber.sconto.pages.FurnitureP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FurnitureSteps {

    FurnitureP furniturePage = new FurnitureP();

    @Then("I see Sofas page")
    public void iSeeFurniturePage() {
           furniturePage.furnitureHeader().should(Condition.exist);
    }

    @When("I click on Wishlist icon of the product")
    public void iClickOnWischlistIcon() {
        furniturePage.clickOn();
    }

    @Then("I see Wishlist icon is activated")
    public void wishlistIconActivated() {
        furniturePage.activeWishlistIcon();
    }

    @Then("I see added item in Merkliste")
    public void iSeeAddedItemInMarkedList() {
        furniturePage.countNumber().should(Condition.exist);
    }
}
