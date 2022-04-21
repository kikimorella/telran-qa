package d220317.selenium;
// сначала мы переносим @Before и @After из LoginTest, из последнего удаляем эту часть кода, и пишем extends BaseTest
// добавляем то, что повторяется (строка о сайте и размере экрана)
// теперь при добавлении новых тестов, нам остаётся только их причесать
// так же для схожих частей кода мы создаём класс d220317.Page (без Package - не работает) в src/main/java/

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {
    HomePage homePage;
    LoginPage loginPage; // передаётся всегда, но инициализация не тут
    AddRemovePage addRemovePage;
    CheckboxPage checkboxPage;
    SecurePage securePage;
    WebDriver driver;
    Map<String, Object> vars;
    JavascriptExecutor js;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        driver.get("http://the-internet.herokuapp.com/");
        driver.manage().window().setSize(new Dimension(1792, 1010));
        homePage = new HomePage(driver);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}