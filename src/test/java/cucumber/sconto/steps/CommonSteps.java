package cucumber.sconto.steps;

import cucumber.sconto.pages.FurnitureP;
import cucumber.sconto.pages.KundenDatenP;
import io.cucumber.java.en.Then;

import static com.codeborne.selenide.Condition.text;

public class CommonSteps {

    FurnitureP furniturePage = new FurnitureP();
    KundenDatenP kundenDatenPage = new KundenDatenP();

    @Then("I see {} page") // хорошая практика, чтоб не плодить шаги (переиспользование)
    public void iSeePage(String pageName) { // String pageName - параметр
        if (pageName.contains("Ihre Kundendaten")) {
            kundenDatenPage.getKundendatenHeader().shouldHave(text(pageName)); // shouldHave - говорит, что у локатора должен быть соответствующий текст
//            kundenDatenPage.getHeader().shouldHave(text("Ihre Kundendaten")); // конкретное значение, просто Kundendaten бы не нашёлся
//            String text = kundenDatenPage.getHeader().getText(); // мы вытягиваем текст (1:52 на видео уроке
//            System.out.println(text); // метод, который мы использовали, чтоб найти элемент по локатору
        } else {
            furniturePage.furnitureHeader().shouldHave(text(pageName));
        }
    }
}
