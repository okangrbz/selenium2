package Day14_excell;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C04_ReadExcell {
    @Test
    public void readExcellTest() throws IOException {

        //ingilizce baskentler stununu yazdiralim

        FileInputStream fileInputStream = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook book = WorkbookFactory.create(fileInputStream);
        int sonSatir= book.getSheet("Sayfa1").getLastRowNum();

        String satirdakiData="";
        for (int i = 0; i <=sonSatir ; i++) {
            satirdakiData=C03_ReadExcell.cellBul(i,1);
            System.out.println(satirdakiData);

        }





    }
}
