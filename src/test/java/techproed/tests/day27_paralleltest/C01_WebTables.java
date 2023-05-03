package techproed.tests.day27_paralleltest;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;

public class C01_WebTables {
    @Test
    public void table1Print() {
        //Bu classta her method bağımsız  bir driver objesi üretmektedir. Parelel çalışırken başka metholara bağımlılık olmayacaktır.

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/tables");
        String table1 = driver.findElement(By.id("table1")).getText();
        System.out.println("Table1:");
        System.out.println(table1);

        List<WebElement> tumElementler = driver.findElements(By.xpath("//table[@id='table1']//td"));

        tumElementler.forEach(t -> System.out.print(t.getText() + " ==> "));

        driver.close();
    }

    @Test
    public void satir3VerileriPrint() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> satir3List = driver.findElements(By.xpath("//table[@id='table1']//tr[3]/td"));

        satir3List.forEach(t -> System.out.print(t.getText() + " | "));
        driver.close();

    }

    @Test
    public void sonSatirVerileri() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sonSatirList = driver.findElements(By.xpath("//table[@id='table1']//tbody/tr[last()]/td"));
        //last() ==> ile son satır indeksini yazıyorum.
        sonSatirList.forEach(t -> System.out.print(t.getText() + " | "));
        driver.close();

    }


    @Test
    public void sutun5Verileri() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/tables");
        List<WebElement> sutun5List = driver.findElements(By.xpath("//table[@id='table1']//td[5]"));
        sutun5List.forEach(t -> System.out.print(t.getText() + " | "));
        driver.close();
    }


    public void printData(int satir, int sutun) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("https://the-internet.herokuapp.com/tables");
        WebElement belirliVeri = driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + satir + "]/td[" + sutun + "]"));
        System.out.println(belirliVeri.getText());
        driver.close();

    }

    @Test
    public void printDataTest() {

        printData(2, 3);//fbach@yahoo.com
        printData(3, 5);//http://www.jdoe.com

    }
}
