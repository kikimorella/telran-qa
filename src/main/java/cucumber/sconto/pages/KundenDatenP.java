package cucumber.sconto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class KundenDatenP {

    private static By ihreKundendatenHeader = By.xpath("//*[@class='titleHeadline']"); // но их 2
    private static By persönlichenDatenDropdown = By.xpath("//*[contains(text(),'persönlichen')]/following-sibling::div");
    // "содержит текст и клик на следующего брата этого элемента", нам не подходил "customerData__headerText" на странице 4 шт.
    private static By editBtn = By.id(".personalBtn");
    private static By saveBtn = By.id(".submitPersonalData");
    private static By firstName = By.id(".firstName");
    private static By lastName = By.id(".lastName");
    private static By fullName = By.id(".fullName");

    public SelenideElement getKundendatenHeader() {
        return $(ihreKundendatenHeader);
    }

    public void clickOnPersonDataDetails() {
        $(persönlichenDatenDropdown).click();
    }

    public void clickOnDataEditBtn() {
        $(editBtn).click();
    }

    public SelenideElement getSaveBtn() {
        return $(saveBtn);
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
        clickOnPersonDataDetails();
        clickOnDataEditBtn();
        $(firstName).setValue("Violetta");
        $(lastName).setValue("Abramova");
        clickSaveBtn();
        $(fullName).shouldHave(text("Violetta Abramova"));
    }
}
