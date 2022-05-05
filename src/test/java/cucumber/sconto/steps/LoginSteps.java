package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import cucumber.sconto.pages.HomeP;
import cucumber.sconto.pages.LoginP;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;

/**
 * LoginSteps
 * Class implements the Login page step definitions.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class LoginSteps {

    LoginP loginPage;
    HomeP homePage;

    @When("I click on the Login icon")
    public void iClickOnLoginIcon() {
        homePage = page(HomeP.class);
        loginPage = homePage.clickLoginIcon(LoginP.class);
    }

    @Then("I see Login page")
    public void iSeeLoginPage() {
        loginPage.loginPageHeader().should(Condition.exist);
        loginPage.loginPageHeader().shouldHave(text("Anmelden"));
    }

    @When("I insert valid user credentials")
    public void iInsertUserCreds() {
        loginPage.validLoginInput();
    }

    @When("I click on Login button")
    public void iClickLoginButton() {
        homePage = loginPage.clickLoginBtn();
    }

    @When("I insert invalid user credentials") // мы добавили новый шаг
    public void iInsertInvalidUserCreds() {
        loginPage.invalidLoginInput();
    }

    @Then("I see validation message")
    public void iSeeValidationMessage() {
        loginPage.invalidLoginMessage().shouldHave(text("Bitte geben Sie eine gültige E-Mail-Adresse ein"));
    }

}
