package homework3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class CRM_PROJECT {
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

        //Перейти в «Проекты» → «Мои проекты», Нажать на кнопку «Создать проект»
        Actions actions = new Actions(driver);
        WebElement projectMenuItem = driver.findElement(By.xpath("//span[text()='Проекты']/ancestor::a"));
        actions.moveToElement(projectMenuItem).perform();

        driver.findElement(By.xpath("//li[@data-route='crm_project_my']/a")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[text()='Создать проект']")).click();
        Thread.sleep(5000);

        //Заполнить обязательные поля:●	наименование; ●	организация; ● основное контактное лицо;
        //●	подразделение; ● куратор проекта; ●	руководитель проекта; ●	администратор проекта; ● менеджер.

        driver.findElement(By.name("crm_project[name]")).sendKeys("FirstProject");

        driver.findElement(By.xpath("//span[text()='Укажите организацию']/..")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys("Test_from_GB");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@class='select2-input select2-focused']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);
        driver.findElement(By.name("crm_project[businessUnit]")).click();

        //тест падает на селекте

        Select businessUnit = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
        Thread.sleep(5000);
        businessUnit.selectByVisibleText("Research & Development");
        Select curator = new Select(driver.findElement(By.name("crm_project[curator]")));
        curator.selectByVisibleText("Амелин Владимир");
        Select rp = new Select(driver.findElement(By.name("crm_project[rp]")));
        rp.selectByVisibleText("Воденеев Денис");
        Select administrator = new Select(driver.findElement(By.name("crm_project[administrator]")));
        administrator.selectByVisibleText("Исаева Анастасия");
        Select manager = new Select(driver.findElement(By.name("crm_project[manager]")));
        manager.selectByVisibleText("Ломакина Ксения");
        Select selectContact = new Select(driver.findElement(By.xpath("//span[text()='Выберите контактное лицо']")));
        selectContact.selectByVisibleText("Ivanov Ivan");

        //Нажать на кнопку «Сохранить и закрыть»
        driver.findElement(By.xpath("//button[contains(text(),'Сохранить и закрыть')]")).click();
        driver.findElement(By.xpath("//*[text()='Заявка на расход сохранена']"));
        Thread.sleep(5000);

        driver.quit();
    }

}
