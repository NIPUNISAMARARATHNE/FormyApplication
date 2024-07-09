package Com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class KeyAndMouse extends PageBase{
    @Test
    public void KeyAndMousePress() throws InterruptedException {
        Thread.sleep(4000);
        WebElement element = driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Key and Mouse Press']"));
        element.click();
        Thread.sleep(4000);
        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Nipuni wasana");
        driver.findElement(By.id("button")).click();
        driver.navigate().back();
        Thread.sleep(8000);
    }
}
