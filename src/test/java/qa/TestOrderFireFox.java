package qa;
import org.openqa.selenium.WebDriver;
import ru.seleniun.samokat.*;

import java.time.*;


import org.junit.Test;
import org.junit.After;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import ru.seleniun.samokat.Confirm;
import ru.seleniun.samokat.OrderContent;

public class TestOrderFireFox {

    private WebDriver driver;


    @Test
    public void checkOrder() {
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookieConsent cookieConsent = new CookieConsent((driver));
        cookieConsent.buttonClick();

        NavOrderButton objNavOrderButton = new NavOrderButton(driver);
        objNavOrderButton.clickNavOrderButton();

        OrderContent objOrderContent = new OrderContent(driver);
        objOrderContent.waitForLoadData();
        objOrderContent.fill1Form("Иван", "Фокс", "Балашиха", "+79274445888","Спортивная");
        objOrderContent.clickNextButton();
        objOrderContent.fill2Form(2, 1, LocalDate.now().plusDays(2).toString(), "Стучите громче, бабушка плохо слышит");
        objOrderContent.clickSaveButton();

        Confirm confirm = new Confirm(driver);
        confirm.waitForLoadData();
        confirm.clickButtonYes();

        OrderCompleteWindow orderCompleteWindow = new OrderCompleteWindow(driver);
        orderCompleteWindow.checkComplete();
    }

    @Test
    public void checkOrder2() {
        driver = new FirefoxDriver();
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookieConsent cookieConsent = new CookieConsent((driver));
        cookieConsent.buttonClick();

       HomeThirdPart homeThirdPart  = new HomeThirdPart(driver);
       homeThirdPart.clickNavOrderButton();

        OrderContent objOrderContent = new OrderContent(driver);
        objOrderContent.waitForLoadData();
        objOrderContent.fill1Form("Иван", "Фокс", "Балашиха", "+79274445888","Спортивная");
        objOrderContent.clickNextButton();
        objOrderContent.fill2Form(2, 1, LocalDate.now().plusDays(2).toString(), "Стучите громче, бабушка плохо слышит");
        objOrderContent.clickSaveButton();

        Confirm confirm = new Confirm(driver);
        confirm.waitForLoadData();
        confirm.clickButtonYes();

        OrderCompleteWindow orderCompleteWindow = new OrderCompleteWindow(driver);
        orderCompleteWindow.checkComplete();
    }
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }

}
