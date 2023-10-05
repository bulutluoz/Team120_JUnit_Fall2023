package day13_excelOtomasyonu;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTestleri() throws IOException {

        String dosyaYolu = "src/test/java/day13_excelOtomasyonu/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);
        // olusturdugumuz workbook, online olarak excel dosyasina erismez
        // 18.satirda fileInputStream kullanarak excel'deki bilgileri aldik
        // 20.satirda fis'in aldigi bilgileri kullanarak kodlarimizin icinde
        // fiziki excl dosyasinin bir kopyasini olusturmus olduk.

        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(3); // index
        Cell cell = row.getCell(3); // index

        System.out.println(cell); // Cezayir

    }

}
