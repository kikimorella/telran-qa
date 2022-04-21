package d220317;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Page { // этот класс - базовый, который позволяет инициализировать драйвер и элементы

    protected WebDriver driver;

    /*
     * Constructor injecting the WebDriver interface
     *
     * @param webDriver
     */
    public Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
