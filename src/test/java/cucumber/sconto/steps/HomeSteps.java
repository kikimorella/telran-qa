package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.sconto.pages.HomeP;
import cucumber.sconto.util.Helper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


/**
 * HomePageSteps
 * Class implements the Homepage step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HomeSteps {

    HomeP homePage;

    @Given("I am on the Homepage")
    public void iAmOnHomePage() {
        homePage = Selenide.open(Helper.basicURL, HomeP.class);
        Helper.acceptCookies();
    }

    @Then("I should see icon text {}") // {} - плэйсхолдер, теперь можем менять
    public void iShouldSeeIconText(String text) {
        homePage.checkIconText(text);
    }

    @When("I click on Melkliste")  // как вариант для тестов сразу пойти в лист, если уже есть добавленные
    public void iClickOnMarkedList() {
        homePage.clickOnWishlist();
    }

}
