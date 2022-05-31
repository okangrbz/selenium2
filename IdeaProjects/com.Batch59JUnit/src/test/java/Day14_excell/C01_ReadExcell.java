package Day14_excell;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcell {
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

    //6. readExcel() method olusturalim
    @Test
    public void readExcellTest() throws IOException {


        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";

        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream file=new FileInputStream(dosyaYolu);

        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(file);

        //workbook.getSheetAt(index)
        //11. Sheet objesi olusturun
         Sheet sheet = workbook.getSheet("Sayfa1");



        //12. Row objesi olusturun
        //sheet.getRow(index)
        Row row=sheet.getRow(3);//


        //13. Cell objesi olusturun
        //row.getCell(index)
        Cell cell=row.getCell(3);//index 0 dan basliyor satir ve sutun icin

        String expecteddata="Cezayir";
        String actualdata=cell.getStringCellValue();
        Assert.assertEquals(actualdata,expecteddata);
        System.out.println(cell);//cezayir

        //3. index deki satirin 3. index indeki datanin cezayir oldgugunu test edin





    }
}
