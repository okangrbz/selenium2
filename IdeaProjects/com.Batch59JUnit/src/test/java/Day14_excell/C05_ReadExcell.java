package Day14_excell;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_ReadExcell {
    @Test
    public void readExcellTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook book = WorkbookFactory.create(fileInputStream);


        //sayfa 2 ye gidip satir sayisinin 24,
        //kullanilan satir sayisinin ise 12 oldugunu test edin

        int expecrtedSatirSayisi=24;
        int sonSatirIndex=book.getSheet("Sayfa2").getLastRowNum();
        Assert.assertEquals(expecrtedSatirSayisi,sonSatirIndex+1);


        int kullanilasanSatirSayisi=book.
                getSheet("Sayfa2").
                getPhysicalNumberOfRows();//kullanilan satir sayisini verir fiziksel

        int expectedKullanilanSatirsayisi=12;
        Assert.assertEquals(expectedKullanilanSatirsayisi,kullanilasanSatirSayisi);
    }
}
