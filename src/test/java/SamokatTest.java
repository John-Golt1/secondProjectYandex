import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class SamokatTest {
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();


    @Before //перед каждым тестом открываем страницу и скроллим её до элементов + ждём пока они прогрузятся
    public void checkTextSamocat() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        Object elementQuestions = driver.findElement(By.xpath("//div[@class='Home_FourPart__1uthg']/div[1]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", elementQuestions);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(By.id("accordion__heading-0")));
    }

    @Test  //проверяем текст с первой кнопке
    public void checkTextSamocatText0() {
        driver.findElement(By.id("accordion__heading-0")).click();
        String forText = driver.findElement(By.id("accordion__panel-0")).getText();
        assertEquals("Сутки — 400 рублей. Оплата курьеру — наличными или картой.", forText);
    }
    @Test //проверяем текст во второй кнопке
    public void checkTextSamocatText1() {
        driver.findElement(By.id("accordion__heading-1")).click();
        String forText2 = driver.findElement(By.id("accordion__panel-1")).getText();
        assertEquals("Пока что у нас так: один заказ — один самокат. " +
                    "Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.", forText2);
    }
    @Test  //проверяем текст в третьей кнопке
    public void checkTextSamocatText2() {
        driver.findElement(By.id("accordion__heading-2")).click();
        String forText3 = driver.findElement(By.id("accordion__panel-2")).getText();
        assertEquals("Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. " +
                "Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру." +
                " Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.", forText3);
    }
    @Test  //проверяем текст в четвертой кнопке
    public void checkTextSamocatText3() {
        driver.findElement(By.id("accordion__heading-3")).click();
        String forText4 = driver.findElement(By.id("accordion__panel-3")).getText();
        assertEquals("Только начиная с завтрашнего дня. Но скоро станем расторопнее.", forText4);
    }
    @Test  //проверяем текст в пятой кнопке
    public void checkTextSamocatText4() {
        driver.findElement(By.id("accordion__heading-4")).click();
        String forText5 = driver.findElement(By.id("accordion__panel-4")).getText();
        assertEquals("Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.", forText5);
    }
    @Test  //проверяем текст в шестой кнопке
    public void checkTextSamocatText5() {
        driver.findElement(By.id("accordion__heading-5")).click();
        String forText6 = driver.findElement(By.id("accordion__panel-5")).getText();
        assertEquals("Самокат приезжает к вам с полной зарядкой." +
                " Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.", forText6);
    }
    @Test  //проверяем текст в седьмой кнопке
    public void checkTextSamocatText6() {
        driver.findElement(By.id("accordion__heading-6")).click();
        String forText7 = driver.findElement(By.id("accordion__panel-6")).getText();
        assertEquals("Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.", forText7);
    }
    @Test  //проверяем текст в восьмой кнопке
    public void checkTextSamocatText7() {
        driver.findElement(By.id("accordion__heading-7")).click();
        String forText8 = driver.findElement(By.id("accordion__panel-7")).getText();
        assertEquals("Да, обязательно. Всем самокатов! И Москве, и Московской области.", forText8);
    }

    @After
        public void checkTextClose () {
            driver.quit();
        }

}
