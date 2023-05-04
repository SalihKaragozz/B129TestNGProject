package techproed.tests.day28_Listeners;

import org.openqa.selenium.By;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import static org.testng.AssertJUnit.assertTrue;

@Listeners(techproed.utilities.Listeners.class)
public class C02_Listeners {

    @Test
    public void successTest(){
        System.out.println("PASS");

        assertTrue(true);

    }

    @Test
    public void failTest(){
        System.out.println("FAİL");

        assertTrue(false);

    }

    @Test
    public void skipTest(){
        System.out.println("SKİP");

        throw  new SkipException(("Atlandı!!!"));

    }


    @Test
    public void failTestTechpro(){

        System.out.println("TechPro Fail Test");
        Driver.getDriver().get(ConfigReader.getProperty("techproeducation_url"));
        Driver.getDriver().findElement(By.xpath("//OlmayanXpath"));//NoSuchElementException



    }

}
