package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import cucumber.sconto.pages.*;
import cucumber.sconto.util.Helper;
import io.cucumber.java.en.And;
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
    KundenDatenP kundenDatenPage;

    @Then("I should be logged in")
    public void shouldBeLoggedIn() {
        customerAccountPage = page(CustomerAccountP.class);
        customerAccountPage.accountTitle().should(Condition.exist);
    }

    @When("I click on logout Button")
    public void iClickOnLogoutButton() {
        loginPage = customerAccountPage.clickOnLogout();
    }

//    @Given("I am on Customer Account Page") // мы комментируем шаг, который работает для другого сценария
//    public void iAmLoggedIn() {
//        loginPage = Selenide.open(Helper.loginURL, LoginP.class);
//        Helper.acceptCookies();
//        loginPage.validLoginInput();
//        homePage = loginPage.clickLoginBtn();
//        homePage.checkIconText("Mein Konto");
//        customerAccountPage = homePage.clickLoginIcon(CustomerAccountP.class);
//        shouldBeLoggedIn();
//    }

    @When("I click on Ihre Wunschliste")
    public void clickOnWishlist() {
        wishlistPage = customerAccountPage.clickOnWishlistInKundenkontoMenu();
    }

    @When("I click on Ihre Kundendata")
    public void clickOnDataMenu() {
        kundenDatenPage = customerAccountPage.clickOnIhreKundenDatenMenu();
    }

    @Given("I am on Customer Account Page")
    public void iAmOnCustomerAccountPage() {
        loginPage = Selenide.open(Helper.loginURL, LoginP.class);
        Helper.acceptCookies();
        loginPage.validLoginInput();
        homePage = loginPage.clickLoginBtn();
        homePage.checkIconText("Mein Konto");
        customerAccountPage = homePage.clickLoginIcon(CustomerAccountP.class);
        shouldBeLoggedIn();
    }

    @When("I expand on Ihre persönlichen Daten")
    public void clickODataDetails() {
        kundenDatenPage.clickOnPersonDataDetails();
    }

    @When("I click on Edit button")
    public void clickOnEditBtn() {
        kundenDatenPage.clickOnDataEditBtn();
    }

    @Then("I see Ihre persönlichen Daten edit form")
    public void iSeeIhrePersönlichenDatenEditForm() {
        kundenDatenPage.getSaveBtn().should(Condition.exist);
    }
}
