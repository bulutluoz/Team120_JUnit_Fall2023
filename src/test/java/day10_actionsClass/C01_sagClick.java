package day10_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C01_sagClick extends TestBase {

    @Test
    public void test01(){

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        bekle(2);
        //3- Cizili alan uzerinde sag click yapin
        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(ciziliAlanElementi).perform();
        bekle(2);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertyazi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertyazi,actualAlertYazisi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        bekle(2);
        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWhd = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        bekle(2);
        String ikinciSayfaWhd = "";
        Set<String> whdSeti = driver.getWindowHandles();

        for (String each : whdSeti
             ) {

            if (!each.equals(ilkSayfaWhd)){
                ikinciSayfaWhd = each;
            }
        }

        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        driver.switchTo().window(ikinciSayfaWhd);

        String expectedYazi = "Make sure your code lands";
        String actualYazi = driver.findElement(By.tagName("h1")).getText();

        Assert.assertEquals(expectedYazi,actualYazi);

    }

}
