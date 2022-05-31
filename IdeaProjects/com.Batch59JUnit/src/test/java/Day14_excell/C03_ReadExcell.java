package Day14_excell;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C03_ReadExcell {
    @Test
    public void readExcellTest() throws IOException {
        //input olarak verilen
        //satirNo, sutunNo degerlerini parametre olarak alip
        //O celle deki datayi String olarak bana donduren bir method olusutrun

        int satirNo = 4;
        int sutunNo = 4;

        //donen Stringin cezayir oldugugunu test edin
        String excpectedData = "Cezayir";
        String actualdata = cellBul(satirNo - 1, sutunNo - 1);//cunki excell indek ile calisir
        Assert.assertEquals(excpectedData,actualdata);

    }

    public static String cellBul(int satiridex, int stunindex) throws IOException {
        String isteneData = "";
        FileInputStream fileInputStream = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook book = WorkbookFactory.create(fileInputStream);
        isteneData =
                book.
                        getSheet("Sayfa1").
                        getRow(satiridex).
                        getCell(stunindex).
                        toString();


        return isteneData;
    }


}
