package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDown {
    WebDriver driver;
    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }

    @Test(dependsOnMethods = "setUp")
    public void dropDrownMenu () throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Dropdown']")).click();
        Thread.sleep(4000);
        WebElement dropDown = driver.findElement(By.id("dropdownMenuButton"));
        dropDown.click();
        WebElement autocomplete = driver.findElement(By.id("autocomplete"));
        autocomplete.click();
    }
}
