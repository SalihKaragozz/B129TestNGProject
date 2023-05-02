package techproed.tests.day22_Annotation;

import org.testng.annotations.*;

public class Day22_TestNGAnnotations {

     /*
    @Test: Test case oluşturmak için kullanılır.
    @Before ve @After: 5 Before ve 5 After annotation bulunur.
    suite > tests > group > class > method
    @BeforeSuite: Herbir test suitinden önce bir kez çalışır.
    @AfterSuite: Herbir test suitinden sonra bir kez çalışır.
    @BeforeTest: Herbir test öncesi bir kez çalışır.(Herbir test case'i öncesi değil!!!)
    @AfterTest: Herbir test sonrası bir kez çalışır.(Herbir test case'i sonrası değil!!!)
    @BeforeGroups: Belirtilmiş herhangi bir grup öncesi çalışır
    @AfterGroups: Belirtilmiş herhangi bir grup sonrası çalışır
    @BeforeClass: Herbir class'tan önce bir kez çalışır
    @AfterClass: Herbir class'tan sonra bir kez çalışır
    @BeforeMethod: Herbir @Test  annotation'ı öncesi bir kez çalışır.(JUnit @Before annotation'ı gibi)
    @AfterMethod: Herbir @Test  annotation'ı sonrası bir kez çalışır.(JUnit @After annotation'ı gibi)
    ------------
    Test NG'de  test methodları alfabetik sıraya göre çalışır.
    @Test(priority = 1) Test casleride öncelikli çalıştırma için kullanuılır.
    Not: priority kullanılmayan testlerin varsıyalım priority değeri 0'dır
    ------------
    @Ignore: @Test caseleri atlamak için kullanılır
    @Test(enable=false) @Test caseleri kullanıma kapatmak için kullanılır




     */

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeGroups(groups = "regression test")
    public void beforeGroups() {
        System.out.println("Before Groups");
    }

    @AfterGroups(groups = "regression test")
    public void afterGroups() {
        System.out.println("After Groups");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test
    public void test01() {
        System.out.println("Test 1");
    }

    @Test
    public void test02() {
        System.out.println("Test 2");
    }

    @Test(groups = "regression test")
    public void test03() {
        System.out.println("Test 3");
    }

    @Ignore
    @Test
    public void test04() {
        //Çalışmam devam ediyor...
        System.out.println("Test 4");
    }

    @Test(groups = "regression test", priority = 1)
//En son çalışır==> Çünkü diğer testlerin default priority değeri 0'dır.
    public void test05() {
        System.out.println("Test 5");
    }

    @Test(priority = -1)//İlk çalışır==> Çünkü priority değeri en düşüktür.
    public void test06() {
        System.out.println("Test 6");
    }

    @Test(enabled = false)
    public void test07() {
        System.out.println("Test 7");
    }

}
