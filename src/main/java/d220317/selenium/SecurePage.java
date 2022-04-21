package d220317.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SecurePage extends Page{

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    // List<WebElement> elements = driver.findElements(By.cssSelector(".icon-2x")); assert (elements.size() > 0);
    @FindBy(css = ".icon-2x")
    WebElement logoutButton;

    public boolean isLogoutBtnDisplayed() { // driver.findElement(By.cssSelector(".icon-2x")).isDisplayed()
        return logoutButton.isDisplayed();
    }
}
