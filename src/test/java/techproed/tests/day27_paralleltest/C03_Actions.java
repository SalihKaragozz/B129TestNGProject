package techproed.tests.day27_paralleltest;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.time.Duration;

import static techproed.utilities.ReusableMethods.bekle;

public class C03_Actions{
    @Test
    public void actions() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://techproeducation.com/");


        WebElement search = driver.findElement(By.xpath("//*[@type='search']"));
        Actions actions = new Actions(driver);
        actions.keyDown(search, Keys.SHIFT).//Search üzerinde shift tuşuna basılı tutar
                sendKeys("techpro").
                keyUp(Keys.SHIFT).//shift tuşuna basma işlemi sonlanır
                sendKeys(" education",Keys.ENTER).perform();

        driver.close();

    }
}
