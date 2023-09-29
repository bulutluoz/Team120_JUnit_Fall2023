package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_JSAlerts extends TestBase {


    @Test
    public void test01(){
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");

        // cookies kabul edin
        driver.findElement(By.xpath("(//div[@class='yt-spec-touch-feedback-shape__fill'])[16]")).click();

        bekle(7);
    }



    @Test
    public void jsAlertTesti(){
        //2. Test
        //	-  https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        //	- 1.alert'e tiklayin
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        bekle(2);
        //	-  Alert'deki yazinin "I am a JS Alert" oldugunu test edin
        String expectedYazi = "I am a JS Alert";
        String actualYazi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        //	-  OK tusuna basip alert'i kapatin
        driver.switchTo().alert().accept();
        bekle(2);
    }



    @Test
    public void cancelTesti(){
        //3.Test
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        bekle(2);
        //	- 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        bekle(2);
        //	- Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();
        bekle(2);
        String expectedSonucYazisi = "You clicked: Cancel";
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi= sonucYaziElementi.getText();

        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);
    }


    @Test
    public void promptTesti(){
        //4.Test
        //	- https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        //	- 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //	- Cikan prompt ekranina "Abdullah" yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");

        //	- OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().accept();

        //	- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@id='result']"));
        String actualSonucYazisi= sonucYaziElementi.getText();
        String expectedIcerik = "Abdullah";

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
}
