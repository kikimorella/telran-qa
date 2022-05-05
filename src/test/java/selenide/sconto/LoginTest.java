package selenide.sconto;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static selenide.sconto.HomePage.basicURL;
import static selenide.sconto.LoginPage.validEmail;
import static selenide.sconto.LoginPage.validPwd;


public class LoginTest extends HeaderMenu{

    HomePage homePage; // эту часть мы выносим для упрощения написания других тестов
    LoginPage loginPage;
    KontoPage kontoPage;

    @Test
    public void LoginLogoutTest() {
        homePage = open(basicURL, HomePage.class);
        homePage.clickAcceptCookies(); // теперь не будет всплывающего окна
        loginPage = homePage.clickLoginIcon(LoginPage.class);
        loginPage.fillCred(validEmail, validPwd);
        homePage = loginPage.clickOnLoginBtn(); // мы фиксируем изменения
        homePage.checkIconText(kontoText); // мы проверяем изменение текста иконки
        kontoPage = homePage.clickLoginIcon(KontoPage.class);
        kontoPage.checkGreetingsText();
        loginPage = kontoPage.clickOnLogout(); // и тут мы поняли, что что-то нужно менять
        loginPage.checkIconText(anmeldenText);
    }
}
/*
        1. open HomePage
        2. click id=loginEmail
        3. LoginPage https://www.sconto.de/login
        4. fill e-mail - abramova.violetta@gmail.com
        5. click id=loginPassword
        6. fill pass - GetS0meSconto!
        7. click button
        8. HomePage
        9. shouldHave text "Mein Konto"
        10. click css=.headerElement__link--login
        11. KundenkontoPage
        12. shouldHave text "Hallo, " / "Willkommen in Ihrem Kundenkonto."
        13. click Abmelden
        14. LoginPage
        15. shouldHave text "Anmelden" / "Sie haben noch kein Kundenkonto?"
        */
