package d220317.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page { // PageFactory
    public HomePage(WebDriver driver) { // конструктор
        super(driver);
    }

    //@FindBy - в скобках мы выбираем linkText и добавляем нужную надпись, сразу под этой строкой пишем какой WebElement
    @FindBy(linkText = "Form Authentication")
    WebElement authenticationText;
    // выше преобразование строчки driver.findElement(By.linkText("Form Authentication")).click();

    @FindBy(linkText = "Add/Remove Elements")
    WebElement addRemoveElt;

    @FindBy(linkText = "Checkboxes")
    WebElement checkbox;

    public LoginPage goToLoginPage() { // метод, который кликает на элемент
        authenticationText.click();
        return new LoginPage(driver);
    }

    public AddRemovePage goToAddRemovePage() {
        addRemoveElt.click();
        return new AddRemovePage(driver);
    }

    public CheckboxPage goToCheckboxPage() {
        checkbox.click();
        return new CheckboxPage(driver);
    }
}

