package d220317.selenium;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;

public class CheckboxTest extends BaseTest {

    @Test
    public void checkbox1Click() { // оба выбраны
        int checkboxIndex = 0;
        checkboxPage = homePage.goToCheckboxPage(); // driver.findElement(By.linkText("Checkboxes")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(1)")).click();
        assert (checkboxPage.isCheckboxNotSelected(checkboxIndex));
    }

    @Test
    public void checkbox2Click() { // оба не выбраны
        int checkboxIndex = 1;
        checkboxPage = homePage.goToCheckboxPage(); // driver.findElement(By.linkText("Checkboxes")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        assert (!checkboxPage.isCheckboxNotSelected(checkboxIndex));
    }

    @Test
    public void clickCheckbox1and2() { // верхний даб нижний нет
        checkboxPage = homePage.goToCheckboxPage(); // driver.findElement(By.linkText("Checkboxes")).click();
        checkboxPage.clickOnCheckbox(0); // driver.findElement(By.cssSelector("input:nth-child(1)")).click();
        checkboxPage.clickOnCheckbox(1); // driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        assert (checkboxPage.isCheckboxNotSelected(0));
        assert (!checkboxPage.isCheckboxNotSelected(1));
    }

    @Test
    public void clickCheckbox1twoTimes() { // нажимаем 2 раза на 1 элемент
        int checkboxIndex = 0;
        checkboxPage = homePage.goToCheckboxPage(); // driver.findElement(By.linkText("Checkboxes")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(1)")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(1)")).click();
        assert (!checkboxPage.isCheckboxNotSelected(checkboxIndex));
    }

    @Test
    public void clickCheckbox2twoTimes() { // нажимаем 2 раза на 2 элемент
        int checkboxIndex = 1;
        checkboxPage = homePage.goToCheckboxPage(); // driver.findElement(By.linkText("Checkboxes")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        checkboxPage.clickOnCheckbox(checkboxIndex); // driver.findElement(By.cssSelector("input:nth-child(3)")).click();
        assert (checkboxPage.isCheckboxNotSelected(checkboxIndex));
    }
}
