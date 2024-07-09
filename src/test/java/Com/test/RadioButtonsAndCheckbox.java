package Com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButtonsAndCheckbox {

    WebDriver driver;
    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://formy-project.herokuapp.com/");
    }
    @Test (dependsOnMethods = "setUp")
    public void radioButtons() throws InterruptedException {
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Radio Button']")).click();
        Thread.sleep(3000);
        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        radioButton1.click();
        Thread.sleep(5000);
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[vaule= 'option2']"));
        radioButton2.click();
        Thread.sleep(3000);
        WebElement radioButton3 = driver.findElement(By.xpath("//label[normalize-space()='Radio button 3']"));
        radioButton3.click();
    }
    @Test (dependsOnMethods = "radioButtons")
    public void checkbox(){
        driver.findElement(By.xpath("//a[@class='btn btn-lg'][normalize-space()='Checkbox']")).click();
        WebElement checkBox1= driver.findElement(By.id("checkbox-1"));
        checkBox1.click();
        WebElement checkBox2 = driver.findElement(By.cssSelector("input[value= 'checkbox-2']"));
        checkBox2.click();
        WebElement checkBox3 = driver.findElement(By.xpath("//input[@id='checkbox-3']"));
        checkBox3.click();

    }

}
