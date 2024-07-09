package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DatePicker {
    WebDriver driver;

    @Test
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }
    @Test(dependsOnMethods = "setup")
    public void datePicker() throws InterruptedException {
          driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Datepicker']")).click();
          Thread.sleep(3000);
          WebElement datePicker =  driver.findElement(By.id("datepicker"));
          datePicker.sendKeys("03/02/2024");
          datePicker.sendKeys(Keys.RETURN);

    }


}
