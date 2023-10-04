package day12_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void cookieTesti(){

        //1- Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        //2- tum cookie’leri listeleyin
        Set<Cookie> cookieSeti =  driver.manage().getCookies();
        // System.out.println(cookieSeti);
        // bu sekilde yazdirinca kac cookie oldugu, ve bunlarin neler oldugu anlasilmiyor

        int siraNo= 1;
        for (Cookie each : cookieSeti
             ) {
            System.out.println(siraNo + "  -   " + each);
            siraNo++;
        }

        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int expectedMinCookieSayisi = 5;
        int actualCookieSayisi = cookieSeti.size();
        Assert.assertTrue(actualCookieSayisi>expectedMinCookieSayisi);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        String expectedCookieValue = "USD";
        String actualCoolieValue = driver.manage().getCookieNamed("i18n-prefs").getValue();

        Assert.assertEquals(expectedCookieValue,actualCoolieValue);

        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        //   bir cookie olusturun ve sayfaya ekleyin

        Cookie yeniCookie = new Cookie("en sevdigim cookie","cikolatali");
        driver.manage().addCookie(yeniCookie);

        //6- eklediginiz cookie’nin sayfaya eklendigini test edin
        System.out.println("========== Yeni cookie eklendikten sonra========== ");
        cookieSeti =  driver.manage().getCookies();
        siraNo= 1;
        for (Cookie each : cookieSeti
        ) {
            System.out.println(siraNo + "  -   " + each);
            siraNo++;
        }

        boolean yeniCookieEklendiMi = false ;

        for (Cookie each : cookieSeti
             ) {
            if (each.getName().equals("en sevdigim cookie")){
                yeniCookieEklendiMi = true;
            }
        }

        // yeni cookie eklenmisse yeniCookieEklendiMi'nin degeri true olmali
        Assert.assertTrue(yeniCookieEklendiMi);

        //7- ismi skin olan cookie’yi silin ve silindigini test edin

        driver.manage().deleteCookieNamed("skin");

        System.out.println("========== skin silindikten sonra========== ");
        cookieSeti =  driver.manage().getCookies();
        siraNo= 1;
        for (Cookie each : cookieSeti
        ) {
            System.out.println(siraNo + "  -   " + each);
            siraNo++;
        }


        boolean skinSilindiMi = true;

        for (Cookie each : cookieSeti
             ) {
            if (each.getName().equals("skin")){
                skinSilindiMi = false ;
            }
        }
        // en sonda testin passed olmasi icin skinSilindiMi ===> true olmali

        Assert.assertTrue(skinSilindiMi);

        //8- tum cookie’leri silin ve silindigini test edin

        driver.manage().deleteAllCookies();

        cookieSeti =  driver.manage().getCookies();

        int expectedCookieSetiSize = 0 ;
        int actualCookieSetiSize = cookieSeti.size();

        Assert.assertEquals(expectedCookieSetiSize,actualCookieSetiSize);

        bekle(2);
    }
}
