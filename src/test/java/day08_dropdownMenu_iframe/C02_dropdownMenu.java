package day08_dropdownMenu_iframe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase_BeforeClass;

import java.util.List;

public class C02_dropdownMenu extends TestBase_BeforeClass {

    WebElement kategoriDropdownElementi;
    Select select;

    @Before
    public void amazonaGidis(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        kategoriDropdownElementi= driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        select = new Select(kategoriDropdownElementi);
    }

    @Test
    public void dropdownTesti(){

        //- Test 1
        //	Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        List<WebElement> optionsList = select.getOptions();

        int expectedKategoriSayisi= 45;
        int actualKategoriListesi = optionsList.size();

        Assert.assertEquals("Kategori dropdown menusunde 45 opsiyon yok",expectedKategoriSayisi,actualKategoriListesi);

    }


    @Test
    public void javaAramaTesti(){

        //-Test 2
        //	1. Kategori menusunden Books secenegini  secin

        //	2. Arama kutusuna Java yazin ve aratin
        //	3. Bulunan sonuc sayisini yazdirin
        //	4. Sonucun Java kelimesini icerdigini test edin
    }
}
