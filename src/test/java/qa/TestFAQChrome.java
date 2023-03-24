package qa;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.seleniun.samokat.*;

import org.openqa.selenium.chrome.ChromeDriver;


import org.junit.Test;
import org.junit.After;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(value=Parameterized.class)
public class TestFAQChrome extends BaseTest {

    private  int number;
    private String question;
    private  String answer;

    public TestFAQChrome(int number, String question, String answer) {
        this.number = number;
        this.question = question;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static List<Object[]> data() {
        Object[][] data = new Object[][] {
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                {1, "Хочу сразу несколько самокатов! Так можно?","Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?",  "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?","Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4,"Можно ли продлить заказ или вернуть самокат раньше?","Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?","Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6,"Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7,"Я жизу за МКАДом, привезёте?","Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
        return Arrays.asList(data);
    }

    @Test
    public void checkFAQ() {
        MainPage mainPage = new MainPage(driver);
        // переход на страницу тестового приложения
        driver.get(mainPage.URL);

         mainPage.cookiesButtonClick();
         mainPage.waitForLoadDataFAQ();
         mainPage.clickTextHeadingFAQ(number);
         String current_hearing = mainPage.getTextHeadingFAQ(number);
         mainPage.getTextHeadingFAQ(number);
        //текст ответа
         String current_answer = mainPage.getTextPanelFAQ(number);
         Assert.assertEquals(number + ". Ожидался вопрос " + question, current_hearing, question);
         Assert.assertEquals(number + ". Ожидался ответ " + answer, current_answer, answer);
    //     System.out.println("Parameterized Number is : " + number + question+answer);
    }

}
