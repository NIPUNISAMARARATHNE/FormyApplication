package Com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


public class ScrollPage extends PageBase {
    @Test
    public void scrollPage() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Page Scroll']")).click();
        Thread.sleep(4000);
        WebElement name= driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(name);
        name.sendKeys("Nipuni");

        WebElement date = driver.findElement(By.id("date"));
        date.sendKeys("01/01/2020");
        driver.navigate().back();

    }

}
