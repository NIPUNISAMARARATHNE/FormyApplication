package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwitchWindow {
    WebDriver driver;
    @Test
    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }
    @Test (dependsOnMethods =  "setup")
    public void SwitchWindowOpen () throws InterruptedException {
        Thread.sleep(8000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/li[13]/a[1]")).click();
        Thread.sleep(4000);
        WebElement newTabButton = driver.findElement(By.xpath("//button[@id='new-tab-button']"));
        newTabButton.click();
//          driver.navigate().back();

        String originalHandle = driver.getWindowHandle();

        for (String handle1 : driver.getWindowHandles()) {
            driver.switchTo().window(handle1);
            Thread.sleep(2000);
        }
        driver.switchTo().window(originalHandle);
    }
}

