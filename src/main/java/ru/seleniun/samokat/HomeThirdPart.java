package ru.seleniun.samokat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeThirdPart {
    private WebDriver driver;
    //Нижняя кнопка "Заказать"
    private By newOrder = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    public HomeThirdPart (WebDriver driver){
        this.driver = driver;
    }

    public void clickNavOrderButton() {
        WebElement element = driver.findElement(newOrder);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }

}