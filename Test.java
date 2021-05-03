package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://mail.ru/?utm_source=portal&utm_medium=portal_navigation&utm_campaign=mail.ru";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //логин
        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
//        driver.findElement(By.xpath("//button[@data-click-counter='75068996']")).click();
//        Thread.sleep(5000);
//
//        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("marina_1992marina");
//        driver.findElement(By.xpath("//span[text()='Ввести пароль']")).sendKeys("098lkj098lkj");
//        driver.findElement(By.xpath("//span[text()='Войти']")).click();
        driver.findElement(By.xpath("//div[@data-click-counter='66843940, 61021872']")).click();
        driver.findElement(By.xpath("//span[text()='Погода']")).click();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Киров");
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(Keys.ENTER);

        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@href='/prognoz/kirov/']]")).click(); //здесь падает

        Thread.sleep(5000);

        driver.quit();
    }
}
