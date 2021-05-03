package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationDairy {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://diary.ru/user/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //авторизация на сайте
        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("loginform-username")).sendKeys("marina123456");
        driver.findElement(By.id("loginform-password")).sendKeys("123qwe456qwe");
//        driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();
        Cookie sessionCookie = driver.manage().getCookieNamed("APISID");
        driver.manage().deleteCookie(sessionCookie);
        Cookie cookie = new Cookie("APISID", "uCHOflUjYTidlFv2/AKonhmMJE5hg7WMZB");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        driver.findElement(By.id("login_btn")).click();
        Thread.sleep(50000);
        driver.quit();
    }
}
