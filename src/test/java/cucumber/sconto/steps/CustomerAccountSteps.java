package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.sconto.pages.CustomerAccountP;
import cucumber.sconto.pages.HomeP;
import cucumber.sconto.pages.LoginP;
import cucumber.sconto.pages.WishlistP;
import cucumber.sconto.util.Helper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.page;

/**
 * CustomerAccountSteps
 * Class implements the Customer Account page step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class CustomerAccountSteps {

    CustomerAccountP customerAccountPage;
    LoginP loginPage;
    HomeP homePage;
    WishlistP wishlistPage;

    @Then("I should be logged in")
    public void shouldBeLoggedIn() {
        customerAccountPage = page(CustomerAccountP.class);
        customerAccountPage.accountTitle().should(Condition.exist);
    }

    @When("I click on logout Button")
    public void iClickOnLogoutButton() {
        loginPage = customerAccountPage.clickOnLogout();
    }

    @Given("I am on Customer Account Page")
    public void iAmLoggedIn() {
        loginPage = Selenide.open(Helper.loginURL, LoginP.class);
        Helper.acceptCookies();
        loginPage.validLoginInput();
        homePage = loginPage.clickLoginBtn();
        customerAccountPage = homePage.clickLoginIcon(CustomerAccountP.class);
        shouldBeLoggedIn();
    }

    @When("I click on Ihre Wunschliste")
    public void clickOnWishlist() {
        wishlistPage = customerAccountPage.clickOnWishlistInKundenkontoMenu();
    }
}
