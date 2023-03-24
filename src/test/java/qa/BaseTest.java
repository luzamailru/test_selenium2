package qa;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver driver;
    protected  ChromeOptions chromeOptions;

    @Before
    public void setUP() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
        driver = new ChromeDriver(chromeOptions);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
