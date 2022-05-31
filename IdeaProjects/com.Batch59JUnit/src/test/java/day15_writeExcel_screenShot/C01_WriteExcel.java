package day15_writeExcel_screenShot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C01_WriteExcel {

    @Test
    public void FileoutpoutStreamTest() throws IOException {

        String yol="src/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(yol);
        Workbook book = WorkbookFactory.create(fis);


        //tabloda ilk satirin 4 hucerine ism yazdir
        book.getSheet("Sayfa1").
                getRow(0).
                createCell(4).
                setCellValue("okan");


        //tabloda ikinci satirin 4 hucerine soyisim yazdir
        book.getSheet("Sayfa1").
                getRow(1).
                createCell(4).
                setCellValue("Gurubuz");


        //tabloda ilk satirin 5 hucerine yas yazdir
        book.getSheet("Sayfa1").
                getRow(0).
                createCell(5).
                setCellValue(37);


        //tabloda ucuncu satirin 5 hucerine yas yazdir
        book.getSheet("Sayfa1").
                getRow(2).
                createCell(5).
                setCellValue(0545625014);

        //degisiklikleri kaydet

        FileOutputStream fos=new FileOutputStream(yol);
        book.write(fos);



        //daha sonra tabloyu kapatalim
        fis.close();
        fos.close();
        book.close();


    }




}
