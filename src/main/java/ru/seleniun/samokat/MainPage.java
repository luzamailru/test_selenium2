package ru.seleniun.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    public static final String URL="https://qa-scooter.praktikum-services.ru/";

    private WebDriver driver;
    //Кнопка "Да все привыкли для Cookies
    public By cookiesButton = By.className("App_CookieButton__3cvqF");
    //Заголовок - вопрос
    private By subHeader = By.xpath(".//div[@class='Home_FourPart__1uthg']/div");
    //Выпадающий ответ
    private By accordionItem = By.className("accordion__item");

    //Нижняя кнопка "Заказать"
    private By newOrderBottom = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");
    //верхняя кнопка "Заказать"
    private By newOrderTop = By.xpath(".//div[@class='Header_Nav__AGCXC']/button");


    public MainPage(WebDriver driver){
        this.driver = driver;

    }
    public void cookiesButtonClick(){
        WebElement element = driver.findElement(cookiesButton);
        if (element.isDisplayed())
        {
            element.click();
        }
    }


    //Нижняя кнопка "Заказать"
    public void clickNavOrderButtonBottom() {
        WebElement element = driver.findElement(newOrderBottom);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

    //Верхняя кнопка "Заказать"
    public void clickNavOrderButton() {
        driver.findElement(newOrderTop).click();
    }

    // метод ожидания прогрузки данных FAQ
    public void waitForLoadDataFAQ() {

        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(subHeader).getText() != null
                && !driver.findElement(subHeader).getText().isEmpty()
        ));
        //System.out.println(driver.findElement(subHeader).getText() );
    }

    // метод для нажать на вопрос FAQ
    public void clickTextHeadingFAQ(int i) {
        String current_path = ".//div[@id='accordion__heading-" + i + "']";
        By current_heading = By.xpath(current_path);
        WebElement element = driver.findElement(current_heading);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.isDisplayed();
        element.click();

    }

    // метод для теста вопроса FAQ
    public String getTextHeadingFAQ(int i) {
        String current_path = ".//div[@id='accordion__heading-" + i + "']";
        By current_heading = By.xpath(current_path);
        return driver.findElement(current_heading).getText();
    }

    // метод для текста ответа FAQ
    public String getTextPanelFAQ(int i) {
        String current_path = ".//div[@id='accordion__panel-" + i + "']/p";
        By current_panel = By.xpath(current_path);
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(current_panel).getText() != null
                && !driver.findElement(current_panel).getText().isEmpty()
        ));
        return driver.findElement(current_panel).getText();
    }



}
