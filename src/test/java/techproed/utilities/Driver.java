package techproed.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {
    /*
        Driver class'ındaki temel mantık extends yöntemiyle değil yani ReusableMethods class'ına extent etmek yerine
    Driver class'ından static methodlar kullanarak driver oluştururuz. Static olduğu için class ismi ile
    her yerden methoda ulaşabileceğiz.
     */
    /*
    Singleton Pattern: Tekli kullanım kalıbı.
        Bir class'tan obje oluşturulmasının önüne geçilmesi için kullanılan ifade
        Bir class'tan obje oluşturmanın önüne geçmek için default constructor'ın kullanımını engellemek için
    private access modifire kullanarak bir constructor oluştururuz
     */
    private Driver(){
    }


    private static WebDriver driver;

    public static WebDriver getDriver(){
        /*
            Driver'i her çağırdığında yeni bir pencere açılmasının önüne geçmek için
        if bloğu içinde Eğer driver'a değer atanmamışsa(driver doluysa) değer ata, Eğer değer atanmışsa Driver'i aynı
        sayfada RETURN et. Bunun sadece yapmamız gereken if(driver==null) kullanmak
         */
        if(driver==null) {

            switch (ConfigReader.getProperty("browser")){

                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                    break;

                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();

            }


        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver(){
        if (driver!=null) {//Driver a değer atanmışsa
            driver.close();//close when I call closeDriver
            driver=null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }

    public static void quitDriver(){
        if (driver!=null) {//Driver a değer atanmışsa
            driver.quit();//quit when I call closeDriver
            driver=null;//make the driver null so when we call getDriver, we can open the driver again
        }
    }
}
