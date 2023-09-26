package day05_JUnitFramework;


import org.junit.Ignore;
import org.junit.Test;

public class C02_TestNotasyonu {
    /*
        @Test notasyonu siradan method'lari
        bagimsiz olarak calistirabilmemize imkan tanir

        boylece main method bagimliligi ortadan kalkar
        ve biz istedigimiz testi tek basina
        veya class level'dan toplu olarak calistirabiliriz

        ayrica ilerde gorecegimiz sekilde
        test method'larini belirli gruplara dahil edip
        toplu olarak da calistirabiliriz

        @Test notasyonuna sahip methodlar
        toplu olarak calistirildiginda
        hangi sira ile calisacagina dair bir kural yoktur
        JUnit bu koduda bir yontem gelistirmemistir
        calisma sirasi ONGORULEMEZ ve KONTROL EDILEMEZ

        Eger bir test method'u @ignore olarak isaretlenirse
        Selenium o method'u ignore eder
        calistirmaz

        JUnit bize calisan testlerden
        kacinin PASSED, kacinin FAILED oldugunu verir
        ANCAK JUnit testlerin gecip gecmedigini
        kodlarda bir sorun yasanip yasanmamasina baglar

        kodlar sorunsuz calisirsa, Test PASSED
        bir exception olusursa, Test FAILED
        olarak kaydedilir

     */


    @Test
    public void amazonTest(){
        System.out.println("amazon test calisti");
    }

    @Test @Ignore
    public void youtubeTest(){
        System.out.println("youtube test calisti");

    }

    @Test
    public void wiseTest(){
        System.out.println("wise test calisti");

    }

    @Test
    public void test04(){
        // verilen iki sayidan, sayi1'in daha buyuk oldugunu test edin
        int sayi1 = 10;
        int sayi2 = 50;

        if (sayi1 > sayi2){
            System.out.println("Karsilastirma testi PASSED");
        }else {
            System.out.println("Karsilastirma testi FAILED");
            throw new IllegalArgumentException();
        }
    }
}
