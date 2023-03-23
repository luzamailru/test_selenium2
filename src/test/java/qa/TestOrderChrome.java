package qa;
import ru.seleniun.samokat.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.*;

 import org.junit.Test;
 import org.junit.After;
import ru.seleniun.samokat.Confirm;
import ru.seleniun.samokat.OrderContent;

public class TestOrderChrome {

    private WebDriver driver;

    @Test
    public void checkOrder() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookieConsent cookieConsent = new CookieConsent((driver));
        cookieConsent.buttonClick();

        NavOrderButton objNavOrderButton = new NavOrderButton(driver);
        objNavOrderButton.clickNavOrderButton();

        OrderContent objOrderContent = new OrderContent(driver);
        objOrderContent.waitForLoadData();
        objOrderContent.fill1Form("Иван", "Иванов", "Балашиха", "+79274445888", "Спортивная");
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
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookieConsent cookieConsent = new CookieConsent((driver));
        cookieConsent.buttonClick();

        HomeThirdPart homeThirdPart  = new HomeThirdPart(driver);
        homeThirdPart.clickNavOrderButton();

        OrderContent objOrderContent = new OrderContent(driver);
        objOrderContent.waitForLoadData();
        objOrderContent.fill1Form("Иван", "Иванов", "Балашиха", "+79274445888", "Спортивная");
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
        driver.quit();
    }
}

