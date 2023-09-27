package day06_notations_assertions;

import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_Assertions {

    // Amazon anasayfaya gidin
    // 3 farkli test method'u olusturarak asagidaki gorevleri yapin
    // 1- Title'in Amazon icerdigini test edin
    // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin
    // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin

    /*
        JUnit test method'lari icinde yapilan testlerin
        failed veya passed oldugunu bize raporlar

        Ancak bu raporlama
        kodlar sorunsuz calisip bittiyse PASSED
        exception ile karsilasilirsa FAILED olarak gerceklesir

        Ayrica JUnit test method'lari icinde yapilan testleri degil
        method'lari raporlar

        JUnit bu is icin Assertion class'i olusturmustur

        Bir test method'unun icinde
        birden fazla assertion varsa
        bu assertion'lardan bir tanesi FAILED olursa
        kodun calismasi o satirda durur
        geriye kalan assertion'lar kontrol edilmemis olur

        Eger bir class calistiginda
        tum assertion'larin mutlaka gozden gecirilmesini istiyorsak
        her assertion icin ayri test method'u olusturabiliriz

        test method'larinin ismi de
        yaptigi is ile uyumlu olursa
        konsolda neyin calisip neyin calismadigini kolayca gorebiliriz

     */
    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void teardown(){
        driver.close();
    }


    @Test
    public void titleTest(){
        // 1- Title'in Amazon icerdigini test edin
        String expectedTitleIcerik ="Amazon";
        String actualTitle = driver.getTitle();


        Assert.assertTrue("Title Amazon icermiyor",actualTitle.contains(expectedTitleIcerik));
        System.out.println("Bu satir, test passed olursa calisir, failed olursa calismaz");

    }

    @Test
    public void nutellaTest(){
        // 2- Arama kutusuna "Nutella" yazip aratin ve sonucun Nutella icerdigini test edin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Nutella" + Keys.ENTER);
        ReusableMethods.bekle(2);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik = "Kutella";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }

    @Test
    public void javaTest(){
        // 3- Arama kutusuna "Java" yazip aratin ve sonucun Java icerdigini test edin
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.clear();
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        ReusableMethods.bekle(2);
        WebElement sonucYaziElementi = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String expectedSonucIcerik = "Hava";
        String actualSonucYazisi = sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedSonucIcerik));

    }
}
