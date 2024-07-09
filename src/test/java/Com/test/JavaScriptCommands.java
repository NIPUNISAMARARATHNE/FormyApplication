package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScriptCommands{
    WebDriver driver;

    @Test
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");

    }

    @Test (dependsOnMethods =  "setUp")
    public void executeJavaScript() throws InterruptedException {
        WebElement modelButton = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Modal']"));
        modelButton.click();
        Thread.sleep(4000);
        WebElement openModelButton = driver.findElement(By.id("modal-button"));
        openModelButton.click();
        WebElement closeButton = driver.findElement(By.id("close-button"));
        Thread.sleep(4000);
        closeButton.click();

        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",closeButton);
    }
}
