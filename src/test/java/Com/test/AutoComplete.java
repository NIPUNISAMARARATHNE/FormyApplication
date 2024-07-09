package Com.test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AutoComplete extends PageBase {
    @Test
    public void fillForm() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Autocomplete']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("No.23");
        driver.findElement(By.id("street_number")).sendKeys("Jambugasmulla mawatha");
        driver.findElement(By.id("route")).sendKeys("Nugegoda");
        driver.findElement(By.id("locality")).sendKeys("Colombo");
        driver.findElement(By.id("administrative_area_level_1")).sendKeys("Colombo Division");
        driver.findElement(By.id("postal_code")).sendKeys("1234");
        driver.findElement(By.id("country")).sendKeys("Sri Lanka");
        driver. navigate().back();
    }

}
