package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.WatchEvent;

public class C04_BasicAuthentication extends TestBase {

    @Test
    public void test01(){
        //1- Bir class olusturun : BasicAuthentication
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //
        //Html komutu : https://username:password@URL
        //	Username     : admin
        // 	password      : admin
        //

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String expectedIcerik = "Congratulations";
        WebElement tebrikYaziElementi = driver.findElement(By.tagName("p"));
        String actualTebrikYazisi = tebrikYaziElementi.getText();

        Assert.assertTrue(actualTebrikYazisi.contains(expectedIcerik));

        bekle(10);
    }
}
