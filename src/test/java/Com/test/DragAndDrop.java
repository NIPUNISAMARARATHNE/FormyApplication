package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDrop {

    WebDriver driver;

    @Test
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }
   @Test
    public void dragAndDropOption(){
        WebElement dragDrop = driver.findElement(By.id("//a[@class='btn btn-lg'][normalize-space()='Drag and Drop']"));
        dragDrop.click();
        WebElement image= driver.findElement(By.xpath("//div[@id='image']//img"));
        image.click();
        WebElement box = driver.findElement(By.xpath("//div[@id='box']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(image,box).build().perform();
    }

}
