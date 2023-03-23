package ru.seleniun.samokat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

// Класс для Вопросов о важном
public class FAQ {

    private WebDriver driver;
    //Заголовок - вопрос
    private By subHeader = By.xpath(".//div[@class='Home_FourPart__1uthg']/div");
    //Выпадающий ответ
    private By accordionItem = By.className("accordion__item");
    private String[] answer = {
            "Сутки — 400 рублей. Оплата курьеру — наличными или картой.",
            "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.",
            "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.",
            "Только начиная с завтрашнего дня. Но скоро станем расторопнее.",
            "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.",
            "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.",
            "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.",
            "Да, обязательно. Всем самокатов! И Москве, и Московской области."
    };

    private String[] question = {
            "Сколько это стоит? И как оплатить?",
            "Хочу сразу несколько самокатов! Так можно?",
            "Как рассчитывается время аренды?",
            "Можно ли заказать самокат прямо на сегодня?",
            "Можно ли продлить заказ или вернуть самокат раньше?",
            "Вы привозите зарядку вместе с самокатом?",
            "Можно ли отменить заказ?",
            "Я жизу за МКАДом, привезёте?"
    };

    public FAQ(WebDriver driver) {
        this.driver = driver;
    }

    // метод ожидания прогрузки данных
    public void waitForLoadData() {
        //System.out.println(driver.findElement(subHeader).getText() );
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(subHeader).getText() != null
                && !driver.findElement(subHeader).getText().isEmpty()
        ));
    }

    // метод для нажать на вопрос
    public void clickTextHeading(int i) {
        String current_path = ".//div[@id='accordion__heading-" + i + "']";
        By current_heading = By.xpath(current_path);
        WebElement element = driver.findElement(current_heading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();

    }

    // метод для теста вопроса
    public String getTextHeading(int i) {
        String current_path = ".//div[@id='accordion__heading-" + i + "']";
        By current_heading = By.xpath(current_path);
        return driver.findElement(current_heading).getText();
    }

    // метод для теста ответа
    public String getTextPanel(int i) {
        String current_path = ".//div[@id='accordion__panel-" + i + "']/p";
        By current_panel = By.xpath(current_path);
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(current_panel).getText() != null
                && !driver.findElement(current_panel).getText().isEmpty()
        ));
        return driver.findElement(current_panel).getText();
    }

    public void checkAccordion() {
        List<WebElement> elements = driver.findElements(accordionItem);
        String current_hearing;
        String current_answer;
        for (int i = 0; i < elements.size(); i++) {
            //текст вопроса
            current_hearing = getTextHeading(i);
            clickTextHeading(i);
            //текст ответа
            current_answer = getTextPanel(i);
            Assert.assertEquals(i + ". Ожидался вопрос " + question[i], current_hearing, question[i]);
            Assert.assertEquals(i + ". Ожидался ответ " + answer[i], current_answer, answer[i]);
        }
    }
}
