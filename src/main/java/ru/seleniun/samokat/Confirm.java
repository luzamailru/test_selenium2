package ru.seleniun.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Confirm {
    private WebDriver driver;
    //Заголовок окна подтверждения заказа
    private By header = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_ModalHeader__3FDaJ']");
    //Кнопка подтверждения заказа "Да"
    private By buttonYes = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[2]");

    public Confirm  (WebDriver driver){
        this.driver = driver;
    }

    public void clickButtonYes() {
        System.out.println(driver.findElement(buttonYes).isDisplayed());
        driver.findElement(buttonYes).click();
    }

    // метод ожидания прогрузки данных
    public void waitForLoadData() {
        //System.out.println(driver.findElement(subHeader).getText() );
        new WebDriverWait(driver, 10).until(driver -> (driver.findElement(header).getText() != null
                && !driver.findElement(header).getText().isEmpty()
        ));
    }

}
