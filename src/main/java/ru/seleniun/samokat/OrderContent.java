package ru.seleniun.samokat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.Set;
import java.util.*;

import java.util.List;

public class OrderContent {

    private WebDriver driver;
    // для заголовка формы заказа
    private By header = By.className("Order_Header__BZXOb");
    // имя клиента
    private By firstName = By.cssSelector("div > input[placeholder='* Имя']");
    // фамилия клиента
    private By lastName = By.cssSelector("div > input[placeholder='* Фамилия']");
    // адрес
    private By address = By.cssSelector("div > input[placeholder='* Адрес: куда привезти заказ']");
    // телефон
    private By phone = By.cssSelector("div > input[placeholder='* Телефон: на него позвонит курьер']");
    // станция метро
    private By metro = By.cssSelector("div > input[placeholder='* Станция метро']");
    //выпадающий список для выбора станций метро
    private By metroList = By.xpath(".//li/button/div[2]");
    // дата доставки
    private By dateDelivery = By.cssSelector("div > input[placeholder='* Когда привезти самокат']");
    //кнопка для раскрытия списка возможных сроков
    private By dropDownArrowTerm = By.className("Dropdown-arrow");
    //выпадающий список для сроков
    private By DropDownOptionTerm = By.className("Dropdown-option");
    // чекбоксы для выбора цвета
    private By checkBoxColor = By.className("Checkbox_Input__14A2w");
    //комментарий для курьера
    private By comment = By.cssSelector("div > input[placeholder='Комментарий для курьера']");

    // локатор для кнопки "Дальше" в заказе
    private By next = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");
    // локатор для кнопки «Сохранить» в заказе
    private By save = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[2]");

    public OrderContent (WebDriver driver){
        this.driver = driver;
    }

    // метод ожидания прогрузки данных
    public void waitForLoadData() {
        WebElement element = driver.findElement(firstName);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
    }

    public void changeInput(By locator, String newText){
        WebElement element = driver.findElement(locator);
        if (element.isEnabled() ) {
            element.click();
            element.clear();
            element.sendKeys(newText);
        }
    }


    public void selectMetro(String station){
        WebElement element = driver.findElement(metro);
        if (element.isEnabled() ) {
            element.click();
            List<WebElement> options = driver.findElements(metroList);
            for (WebElement option : options) {
                if(station.equals(option.getText().trim())) {
                    option.click();
                    break;
                }
            }
        }
    }

    public void selectTerm(int i){
        WebElement element = driver.findElement(dropDownArrowTerm);
        if (element.isEnabled() ) {
            element.click();
            List<WebElement> options = driver.findElements(DropDownOptionTerm);
            if (i<options.size()){
                WebElement option = options.get(i-1);
                option.click();
            }
        }
    }

    public void selectColor(int i){
        List<WebElement> options = driver.findElements(checkBoxColor);
        if (i<options.size()){
            WebElement option = options.get(i-1);
            option.click();
            }
    }

    public void changeComment(String newName){
        WebElement element = driver.findElement(comment);
        if (element.isEnabled() ) {
            element.clear();
            element.sendKeys(newName);
        }
    }

    // метод для нажатия на кнопку Дальше
    public void clickNextButton() {
        WebElement element = driver.findElement(next);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        if (element.isEnabled() ) {
            element.click();
        }
    }
    // метод для нажатия на кнопку сохранения
    public void clickSaveButton() {
        if (driver.findElement(save).isEnabled() ) {
            driver.findElement(save).click();
        }
    }

    public void fill1Form(String firstName, String lastName, String address, String phone, String metro) {
        changeInput(this.firstName, firstName);
        //changeFirstName(firstName);
        changeInput(this.lastName, lastName);
        //changeLastName(lastName);
        changeInput(this.address, address);
        //changeAddress(Address);
        changeInput(this.phone, phone);
        //changePhone(phone);
        selectMetro(metro);
    }
    public void fill2Form(int term, int color, String dateDelivery, String comment) {
        selectTerm(term);
        selectColor(color);
        changeInput(this.dateDelivery,dateDelivery);
        //changeDateDelivery(dateDelivery);
        //changeInput(this.comment, comment);
       changeComment(comment);
    }

}
