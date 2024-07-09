package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SwitchToAlert {
    WebDriver driver;
    @Test

    public void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }
   @Test (dependsOnMethods =  "Setup")
    public void openAlert() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/li[13]/a[1]")).click();
        Thread.sleep(5000);
        WebElement openAlertButton = driver.findElement(By.id("alert-button"));
        Thread.sleep(2000);
        openAlertButton.click();

        Alert alert = driver.switchTo().alert();
        alert.accept();

    }





}
