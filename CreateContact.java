package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateContact {
    private static WebDriver driver;
    private static final String LOGIN_PAGE_URL = "https://crm.geekbrains.space/user/login";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        //логин
        WebDriver driver = new ChromeDriver();
        driver.get(LOGIN_PAGE_URL);
        driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();

        //Перейти в «Контрагенты» → «Контактные лица», Нажать на кнопку «Создать контактное лицо»
        Actions actions = new Actions(driver);
        WebElement counterpartyItem = driver.findElement(By.xpath("//span[text()='Контрагенты']/ancestor::a"));
        actions.moveToElement(counterpartyItem).perform();

        driver.findElement(By.xpath("//span[text()='Контактные лица']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать контактное лицо']")).click();
        Thread.sleep(5000);

        //Заполнить обязательные поля:●	фамилия; ● имя; ● организация; ● должность.
        driver.findElement(By.name("crm_contact[lastName]")).sendKeys("Иванов");
        driver.findElement(By.name("crm_contact[firstName]")).sendKeys("Петр");
        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.name("crm_contact[jobTitle]")).sendKeys("Директор");

        //Нажать на кнопку «Сохранить и закрыть»
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[text()='Контактное лицо сохранено']"));
        Thread.sleep(5000);

        driver.quit();

    }
}
