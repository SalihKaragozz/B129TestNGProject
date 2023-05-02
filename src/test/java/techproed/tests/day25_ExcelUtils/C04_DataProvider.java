package techproed.tests.day25_ExcelUtils;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;
public class C04_DataProvider {
    /*
    -DataProvider, bir çok veriyi test caselere loop kullanmadan aktarmak için kullanılır.
    TestNG den gelen bir özelliktir. 2 boyutlu bir Object Array return eder.
     DDT(Data Driven Testing) için kullanılır. Yani birden fazla veriyi test case'lerde aynı anda kullanmak
    için kullanılır
     Kullanımı için @Test notasyonundan sonra paremetre olarak dataprovider yazilir ve String bir isim
    belirtilir. Bu belittiğimiz isimle @DataProvider notasyonu ile bir method oluşturulur
     */
    /*
    Eğer farklı bir test methodu için aynı dataProvider methodu kullanılacaksa
    @DataProvider(name = "googleTest") şeklinde dataprovider notasyonundan sonra name paremetresine yeni olusturduğumuz
    methodun adını yazarız
     */
    @Test(dataProvider = "urunler")
    public void testdataprovider(String data) {//DataP.'daki verileri alabilmek için
        // Test methodumuza String bir parametre ataması yaparız
        System.out.println(data);
    }
    @DataProvider(name = "googleTest")
    public static Object[][] urunler() {
        return new Object[][]{{"Volvo"}, {"Mercedes"}, {"Audi"}, {"Honda"}, {"Toyota"}, {"Opel"}, {"BMW"}};
    }
    @Test(dataProvider = "googleTest")
    public void googleTest(String araclar) {
        //Google sayfasına gidiniz
        //Driver.getDriver().get("https://google.com");
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        //{"Volvo"},{"Mercedes"},{"Audi"},{"Honda"},{"Toyota"},{"Opel"},{"BMW"} araçları aratınız
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        //Her aratmadan sonra sayfa resmi alınız
        ReusableMethods.tumSayfaResmi();
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
