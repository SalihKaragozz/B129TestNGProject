package techproed.tests.day27_paralleltest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class C02_DropDown {
    @Test
    public void test01() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement yil = driver.findElement(By.xpath("//*[@id='year']"));
        Select select = new Select(yil);
        select.selectByIndex(5);//index 0 dan başlar DropDown menüde 6.yı alır
        //yil.sendKeys("2016");--> Bu şekilde de seçebilirim
        //driver.findElement(By.xpath("//*[@value='2016']")).click(); --> Bu şekilde de seçebilirim
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        Select select1 = new Select(ay);
        //select1.selectByVisibleText("April");
        select1.selectByValue("6");
        WebElement gun = driver.findElement(By.xpath("//*[@id='day']"));


        driver.close();

    }

    @Test
    public void test02() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        List<WebElement> stateList = select.getOptions();//Bütün options taglarını getir

        stateList.forEach(t-> System.out.println(t.getText()));

        driver.close();

    }

    @Test
    public void test03() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
        //State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim
        WebElement tumEyaletler = driver.findElement(By.cssSelector("select[id='state']"));
        Select select = new Select(tumEyaletler);
        String sonSecilenText = select.getFirstSelectedOption().getText();
        //getFirstSelectedOption() --> son seçilen option'i verir
        System.out.println(sonSecilenText);
        assertEquals("Select a State",sonSecilenText);
        driver.close();

    }
}
