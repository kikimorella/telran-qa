package cucumber.sconto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PersonalInfoP {

    String name;

    private static By ihreKundendatenText = By.cssSelector(".customerData > .customerData__title > .titleHeadline");
    private static By ihrePersönlichenDatenText = By.cssSelector(".accordion__header:nth-child(1) .customerData__headerText");
    private static By detailsAnzeigenBtn = By.cssSelector(".customerData__collapseItem");
    private static By editBtn = By.id(".personalBtn");
    private static By firstName = By.id(".firstName");
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

    public void editName() {
        $(firstName).setValue(name);
    }

    public void clickSaveBtn() {
        $(saveBtn).click();
    }

    public void checkTheName() {
        $(fullName).shouldHave(text(name));
    }
}
