package techproed.tests.day24_Properties_Pages.SmokeTest;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class PositiveTest {
    @Test
    public void test1() {
        /*
        Acceptance Criteria:
        Admin olarak, uygulamaya giriş yapabilmeliyim
        https://www.bluerentalcars.com/
        Admin email: jack@gmail.com
        Admin password: 12345
         */
        Driver.getDriver().get(ConfigReader.getProperty("blueRentACarUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.login.click();
        Reporter.log("Login tıklandı");
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("email"),
                Keys.TAB,ConfigReader.getProperty("pass"),Keys.ENTER);
        Reporter.log("email password girildi");
        Assert.assertEquals(blueRentalPage.verify.getText(),"Jack Nicholson");

        Driver.closeDriver();
        Reporter.log("sayfa kapatldı");
    }
}
