package Day14_excell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcell {
     /*
    1. apache poi dependency’i pom file’a ekleyelim
2. Java klasoru altinda
resources klasoru olusturalim
3. Excel dosyamizi resources klasorune ekleyelim
4. excelAutomation
isminde bir package olusturalim
5. ReadExcel isminde bir class olusturalim
6. readExcel() method olusturalim
7. Dosya yolunu bir String degiskene atayalim
8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
10.
WorkbookFactory.create(fileInputStream)
11. Worksheet objesi olusturun
workbook.getSheetAt(index)
12. Row objesi olusturun
sheet.getRow(index)
13. Cell objesi olusturun
row.getCell(index)
     */


    @Test
    public void readExcellTest() throws IOException {
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyayolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream file=new FileInputStream(dosyayolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10.
        //WorkbookFactory.create(fileInputStream)
        Workbook book= WorkbookFactory.create(file);

        String actual=book.
                getSheet("Sayfa1").
                getRow(1).
                getCell(3).
                toString();

        System.out.println(actual);
    }

}
