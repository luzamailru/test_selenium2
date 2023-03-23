package ru.seleniun.samokat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieConsent {
    private WebDriver driver;
    //Кнопка "Да все привыкли для Cookies
    private By button = By.className("App_CookieButton__3cvqF");

    public CookieConsent(WebDriver driver){
        this.driver = driver;
    }

    public void buttonClick(){
        WebElement element = driver.findElement(button);
        if (element.isDisplayed())
            {
                element.click();
            }
    }


}
