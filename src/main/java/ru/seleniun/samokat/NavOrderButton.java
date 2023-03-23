package ru.seleniun.samokat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavOrderButton {
    private WebDriver driver;
    //верхняя кнопка "Заказать"
    private By newOrder = By.xpath(".//div[@class='Header_Nav__AGCXC']/button");

    public NavOrderButton (WebDriver driver){
        this.driver = driver;
    }
    public void clickNavOrderButton() {
        driver.findElement(newOrder).click();
    }

}