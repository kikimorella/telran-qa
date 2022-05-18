package cucumber.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInfoP {

    private static By ihreKundendatenText = By.cssSelector(".titleHeadline");
    private static By ihrePersönlichenDatenText = By.cssSelector(".accordion__header:nth-child(1) .customerData__headerText"); // "customerData__headerText" на странице 4 шт.
    private static By detailsAnzeigenBtn = By.cssSelector(".accordion__header:nth-child(1) .customerData__collapseItem"); // "customerData__collapseItem" на странице 4 шт.
    private static By editBtn = By.id(".personalBtn");
    private static By firstName = By.id(".firstName");
    private static By lastName = By.id(".lastName");
    private static By saveBtn = By.id(".submitPersonalData");
    private static By fullName = By.id(".fullName");

    public SelenideElement dataHeader() {
        return $(ihreKundendatenText);
    }

    public void clickOnDataDetails() {
        $(ihrePersönlichenDatenText).shouldHave(text("Ihre persönlichen Daten"));
        $(detailsAnzeigenBtn).click();
    }

    public void clickOnDataEdit() {
        $(editBtn).click();
    }

    public void editName(String name) {
        $(firstName).setValue(name);
    }

    public void editLastname(String surname) {
        $(lastName).setValue(surname);
    }

    public void clickSaveBtn() {
        $(saveBtn).click();
    }

    public void checkTheName(String name) {
        $(fullName).shouldHave(text(name));
    }

    public void checkTheLastname(String surname) {
        $(fullName).shouldHave(text(surname));
    }

    public void backToNormal() {
        clickOnDataDetails();
        clickOnDataEdit();
        $(firstName).setValue("Violetta");
        $(lastName).setValue("Abramova");
        clickSaveBtn();
        $(fullName).shouldHave(text("Violetta Abramova"));
    }
}
