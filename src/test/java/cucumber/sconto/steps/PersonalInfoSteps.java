package cucumber.sconto.steps;

import com.codeborne.selenide.Condition;
import cucumber.sconto.pages.PersonalInfoP;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.text;

public class PersonalInfoSteps {
    PersonalInfoP personalInfoPage;

    @Then("I see Data page")
    public void iSeeLoginPage() {
        personalInfoPage.dataHeader().should(Condition.exist);
        personalInfoPage.dataHeader().shouldHave(text("Ihre Kundendaten"));
    }

    @When("I click on Ihre persönlichen Daten")
    public void clickODataDetails() {
        personalInfoPage.clickOnDataDetails();
    }

    @And("I click on Edit button")
    public void clickOnEditBtn() {
        personalInfoPage.clickOnDataEdit();
    }

    @And("I change customer name to {}")
    public void nameChange() {
        personalInfoPage.editName();
    }

    @And("I click Save button")
    public void ClickSaveBtn() {
        personalInfoPage.clickSaveBtn();
    }

    @Then("I see customer name {}")
    public void checkTheName() {
        personalInfoPage.checkTheName();
    }
}
