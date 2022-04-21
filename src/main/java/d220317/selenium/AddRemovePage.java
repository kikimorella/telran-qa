package d220317.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AddRemovePage extends Page {

    public AddRemovePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button") // поиск элемента на странице
    private WebElement addEltButton; // не должен быть просто WebElement addEltButton; чтоб случайно не поменять элемент

    public void addElt() { // клик на элемент
        addEltButton.click();
    }

    @FindBy(css = ".added-manually") // поиск элемента на странице новой кнопки
    private WebElement deleteBtn;

    public void removeElt() { // клик на элемент
        deleteBtn.click();
    }

    @FindBy(css = ".added-manually") // нужно, чтоб считать количество элементов
    private List<WebElement> deleteBtnList;

    public List<WebElement> getDeleteBtn() { // проверка отсутствия новой кнопки
        return deleteBtnList;
    }
}
