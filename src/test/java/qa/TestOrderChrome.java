package qa;
import ru.seleniun.samokat.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.*;

 import org.junit.Test;
 import org.junit.After;
import ru.seleniun.samokat.Confirm;
import ru.seleniun.samokat.OrderContent;

public class TestOrderChrome extends BaseTest {

    @Test
    public void checkOrder() {
        MainPage mainPage = new MainPage(driver);
        // переход на страницу тестового приложения
        driver.get(mainPage.URL);

        mainPage.cookiesButtonClick();

        mainPage.clickNavOrderButton();

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

        MainPage mainPage = new MainPage(driver);
        // переход на страницу тестового приложения
        driver.get(mainPage.URL);

        mainPage.cookiesButtonClick();
        mainPage.clickNavOrderButtonBottom();

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
}

