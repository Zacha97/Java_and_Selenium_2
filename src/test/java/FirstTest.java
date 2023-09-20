import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.security.Key;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import static org.openqa.selenium.By.xpath;

public class FirstTest {
    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("web-driver.chrome.driver", "C:\\Users\\zgred\\Downloads\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterEach
    public void driverClose() {
        driver.close();
    }

    @Test
    public void firstMethod() throws InterruptedException{

        driver.get(" https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();
        driver.findElement(xpath("//button[contains(text(),'Continue with Recommended Cookies')]")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.navigate().back(); //ad is appearing so when going back it's disappearing
        driver.findElement(By.name("firstname")).sendKeys("Stefan");
        driver.findElement(By.name("lastname")).sendKeys("Sztacheta");
        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-4")).click();
        driver.findElement(By.id("datepicker")).sendKeys("12-05-2023");

        WebElement ele = driver.findElement(By.id("profession-1"));
        JavascriptExecutor jse = (JavascriptExecutor)driver; // { using those JavascriptExecutor due to error appearing with 'element click intercepted'
        jse.executeScript("arguments[0].click()", ele);

        // multiple checkboxes
        // 1st checkbox
        WebElement dre = driver.findElement(By.id("tool-2"));
        JavascriptExecutor asb = (JavascriptExecutor)driver; // { using those JavascriptExecutor due to error appearing with 'element click intercepted'
        asb.executeScript("arguments[0].click()", dre);
        // 2nd checkbox
        WebElement dre2 = driver.findElement(By.id("tool-1")); // {
        JavascriptExecutor asb2 = (JavascriptExecutor)driver; // { using those JavascriptExecutor due to error appearing with 'element click intercepted'
        asb2.executeScript("arguments[0].click()", dre2); // {

        //select continents from the dropdown menu
        driver.findElement(By.xpath("//option[. ='Europe']")).click();

        //multiple select boxes
        WebElement element1 = driver.findElement(By.xpath("//option[. ='Browser Commands']"));
        WebElement element2 = driver.findElement(By.xpath("//option[. ='Switch Commands']"));
        Actions action = new Actions(driver);
        Action seriesOfActions = (Action) action.keyDown(Keys.CONTROL)
                .click(element1)
                .click(element2)
                .build();
        seriesOfActions.perform();
        Thread.sleep(3000);

        //upload file
        WebElement uploadFile = driver.findElement(By.xpath("//input[@id='photo']"));
        uploadFile.sendKeys("C:\\Users\\zgred\\OneDrive\\Pulpit\\asd.jpg");

        //submit button
        WebElement dre3 = driver.findElement(By.id("submit")); // {
        JavascriptExecutor asb3 = (JavascriptExecutor)driver; // { using those JavascriptExecutor due to error appearing with 'element click intercepted'
        asb3.executeScript("arguments[0].click()", dre3); // {
        System.out.println("Passed");

    }
}