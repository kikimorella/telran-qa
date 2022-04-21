package d220317.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckboxPage extends Page {

    public CheckboxPage(WebDriver driver) {
        super(driver);
    }

    /*
        @FindBy(css = "input:nth-child(1)")
        WebElement checkbox1;

        @FindBy(css = "input:nth-child(3)")
        WebElement checkbox2;
    */
    @FindBy(xpath = "//form[@id='checkboxes']/input")
    List<WebElement> checkboxesList;
    /*
        public void clickOn1checkbox() {
            checkbox1.click();
        }

        public void clickOn2checkbox() {
            checkbox2.click();
        }

    public boolean isCheckboxNotSelected(int ind) { // при тесте мы выбираем сразу какой элемент нам нужен
        String clicked = "checked";
        return checkboxesList.get(ind).getAttribute(clicked).isEmpty(); // try catch exception
    }
    */

    public boolean isCheckboxNotSelected(int ind) { // при тесте мы выбираем сразу какой элемент нам нужен
        String clicked = "checked";
        return checkboxesList.get(ind).getAttribute(clicked) != null; // try catch exception
    }

    public void clickOnCheckbox(int ind) {
        checkboxesList.get(ind).click();
    }
}
// https://stackoverflow.com/questions/20645013/how-to-verify-an-attribute-is-present-in-an-element-using-selenium-webdriver