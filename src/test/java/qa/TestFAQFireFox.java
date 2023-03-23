package qa;
import ru.seleniun.samokat.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;


public class TestFAQFireFox {

        private WebDriver driver;


        @Test
        public void checkFAQ() {
            FirefoxOptions options = new FirefoxOptions ();
            options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
            driver = new FirefoxDriver(options);

            // переход на страницу тестового приложения
            driver.get("https://qa-scooter.praktikum-services.ru/");
            CookieConsent cookieConsent = new CookieConsent((driver));
            cookieConsent.buttonClick();

             FAQ objFAQ= new FAQ(driver);
             objFAQ.waitForLoadData();
             objFAQ.checkAccordion();

        }

        @After
        public void teardown() {
            // Закрой браузер
            driver.quit();
        }

    }
