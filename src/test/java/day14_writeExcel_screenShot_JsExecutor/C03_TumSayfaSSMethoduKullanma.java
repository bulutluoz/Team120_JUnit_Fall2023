package day14_writeExcel_screenShot_JsExecutor;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_TumSayfaSSMethoduKullanma extends TestBase {

    @Test
    public void testWise(){
        // wisequarter anasayfaya gidin
        driver.get("https://www.wisequarter.com");
        // url'in wise icerdigini test edin
        String expectedIcerik = "wise";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"wise");
    }

    @Test
    public void testAB(){
        // ahmetbulutluoz.com anasayfaya gidin
        driver.get("https://www.ahmetbulutluoz.com");
        // url'in bulut icerdigini test edin
        String expectedIcerik = "bulut";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));

        // sonucu raporlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"AB");
    }

    @Test
    public void testYoutube(){
        // youtube anasayfaya gidin
        driver.get("https://www.youtube.com");
        // url'in youtube icerdigini test edin
        String expectedIcerik = "youtube";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedIcerik));
        // sonucu raorlamak icin tum sayfa screenshot alip kaydedin
        ReusableMethods.tumSayfaFotografCek(driver,"youtube");
    }
}
