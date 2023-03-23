package qa;
import ru.seleniun.samokat.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.*;

import org.junit.Test;
import org.junit.After;

public class TestFAQChrome {

    private WebDriver driver;

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        // переход на страницу тестового приложения
        driver.get("https://qa-scooter.praktikum-services.ru/");

        CookieConsent cookieConsent = new CookieConsent((driver));
        cookieConsent.buttonClick();

        FAQ objFAQ = new FAQ(driver);
        objFAQ.waitForLoadData();
        objFAQ.checkAccordion();
    }

    @After
    public void teardown() {
        driver.quit();
    }
}

