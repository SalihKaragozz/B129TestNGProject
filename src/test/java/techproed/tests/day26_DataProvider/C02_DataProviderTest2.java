package techproed.tests.day26_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;

public class C02_DataProviderTest2 {

        /*
    Burada DataProvider methodlarımızı DataProviderUtils Class'ından alacağız.
    Başka bir Class'dan DataProvider alacağımız zaman @Test notasyonunun yanında belirmemiz gerkir.
    ====>>> @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
     */

    @Test(dataProvider = "sehirVerileri", dataProviderClass = DataProviderUtils.class)
    public void test1(String ad, String bolge ,String plaka){

        System.out.println("Sehir adi = " + ad + " bolge = " + bolge + " plaka = " + plaka);


    }

    @Test(dataProvider = "kullaniciBilgileri", dataProviderClass = DataProviderUtils.class)
    public void test2(String username, String password){

        System.out.println("Kullanıcı adı: "+username+", Şifre: "+password);

    }

    @Test(dataProvider = "customerData", dataProviderClass = DataProviderUtils.class)
    public void test3(String username, String password){

        System.out.println("Kullanıcı adı: "+username+", Şifre: "+password);
    }


}
