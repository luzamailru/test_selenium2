package ru.seleniun.samokat;
import static org.hamcrest.CoreMatchers.containsString;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderCompleteWindow {
    WebDriver driver;
    //Сообщение о результате оформления заказа
    By completeHeader = By.className("Order_ModalHeader__3FDaJ");
    public OrderCompleteWindow (WebDriver driver){
        this.driver = driver;
    }

    public void checkComplete() {
        WebElement element = driver.findElement(completeHeader);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        System.out.println(element.getText());
        MatcherAssert.assertThat("Ожидалось сообщение 'Заказ оформлен'",element.getText(), containsString("Заказ оформлен"));
    }


}
