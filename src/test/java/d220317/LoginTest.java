package d220317;// Generated by Selenium IDE

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginPositive() {
        loginPage = homePage.goToLoginPage(); //  driver.findElement(By.linkText("Form Authentication")).click();
        loginPage.fillCred("tomsmith", "SuperSecretPassword!");
        securePage = loginPage.clickOnLoginBtn();
        assertTrue(securePage.isLogoutBtnDisplayed()); // assert лучше оставлять в тестах!
        // "проверь, что верно, элемент есть на странице"
    }

    @Test
    public void loginNegativeEmptyCredentials() { // ! Creds
        loginPage = homePage.goToLoginPage(); // Оптимизация, чтоб не повторяться, т.к. есть одинаковые строки (при
        // изменении части текста, не нужно будет менять в нескольких местах данные)
        loginPage.clickOnLoginBtnNeg();
        String errorText = loginPage.getErrorText();
        assertTrue(errorText.contains("Your username is invalid!"));
    }

    @Test
    public void loginNegativeNoLogin() {
        loginPage = homePage.goToLoginPage();
        loginPage.fillCred("", "SuperSecretPassword!");
        loginPage.clickOnLoginBtnNeg();
        String errorText = loginPage.getErrorText();
        assertTrue(errorText.contains("Your username is invalid!"));
    }

    @Test
    public void loginNegativeNoPass() {
        loginPage = homePage.goToLoginPage();
        loginPage.fillCred("tomsmith", "");
        loginPage.clickOnLoginBtnNeg();
        String errorText = loginPage.getErrorText();
        assertTrue(errorText.contains("Your password is invalid!"));
        /*
        почему тест не проходит при такой записи?
        driver.findElement(By.id("flash")).click();
        assertThat(driver.findElement(By.id("flash")).getText(), is("Your username is invalid!\\\\n×"));
        потому что нужно так:
        assertTrue (driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
        */
    }

    @Test
    public void loginNegativeWrongPass() {
        loginPage = homePage.goToLoginPage();
        loginPage.fillCred("tomsmith", "Super!");
        loginPage.clickOnLoginBtnNeg();
        String errorText = loginPage.getErrorText();
        assertTrue(errorText.contains("Your password is invalid!"));
    }

    @Test
    public void loginNegativeWrongLogin() {
        loginPage = homePage.goToLoginPage();
        loginPage.fillCred("Tom", "SuperSecretPassword!");
        loginPage.clickOnLoginBtnNeg();
        String errorText = loginPage.getErrorText();
        assertTrue(errorText.contains("Your username is invalid!"));
    }
}
/*
эта часть кода не нужна, прекрасно работает без:
driver.findElement(By.id("username")).click();
driver.findElement(By.id("password")).click();
*/

/*
public class LoginTest extends BaseTest {

    @Test
    public void loginPositive() {
        loginPage.goToLoginPage(); //  driver.findElement(By.linkText("Form Authentication")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.cssSelector(".icon-2x"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void loginNegativeNothing() {
        loginPage.goToLoginPage(); // Оптимизация, чтоб не повторяться, т.к. есть одинаковые строки (при изменении
        // части текста, не нужно будет менять во многих местах данные)
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("flash"));
            assert (elements.size() > 0);
        }
    }
// Домашняя работа
    @Test
    public void loginNegativeNoLogin() {
        loginPage.goToLoginPage();
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("flash"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void loginNegativeNoPass() {
        loginPage.goToLoginPage();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("TomSmith");
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("flash"));
            assert (elements.size() > 0);
        }

    @Test
    public void loginNegativeWrongPass() {
        loginPage.goToLoginPage();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("TomSmith");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Super!");
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("flash"));
            assert (elements.size() > 0);
        }
    }

    @Test
    public void loginNegativeWrongLogin() {
        loginPage.goToLoginPage();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("Tom");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.cssSelector(".fa")).click();
        {
            List<WebElement> elements = driver.findElements(By.id("flash"));
            assert (elements.size() > 0);
*/