package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class CompleteWebPage {
    WebDriver driver;
@Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test(dependsOnMethods = "setUp")
    public void webForm(){
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Complete Web Form']")).click();
        driver.findElement(By.id("first-name")).sendKeys("Nipuni");
        driver.findElement(By.id("last-name")).sendKeys("Wasana");
        driver.findElement(By.id("job-title")).sendKeys("QA Engineer");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-3")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("06/03/2024");
        driver.findElement(By.id("datepicker")).sendKeys(Keys.RETURN);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn.btn-lg.btn-primary")));
        WebElement submitButton= driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary"));
        submitButton.click();
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert alert-success")));

        String alertText = alert.getText();
        assertEquals(alertText, "The form was successfully submitted!");

    }
}
