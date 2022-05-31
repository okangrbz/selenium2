package Day14_excell;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class C06_ReadExcell {
    @Test
    public void readExcellTest() throws IOException {

        //excel dosyasindaki tum verileri clasimiza alip
        // bir java objesine stor edelim
        //boylece her seferinde excelle e ulasip satir,sutun... vs ugrasmayalim
        FileInputStream fileInputStream = new FileInputStream("src/resources/ulkeler.xlsx");
        Workbook book = WorkbookFactory.create(fileInputStream);

        //Database yapisinda olan
        // excell i koyabilecegimiz en uygun java objesi Map tir

        Map<String, String> ulkelerMap = new HashMap<>();

        int sonSatirIndex = book.getSheet("Sayfa1").getLastRowNum();
        for (int i = 0; i < sonSatirIndex; i++) {
            //key i. satirdaki 0  inci indextedki data
            String key = book.getSheet("Sayfa1").getRow(i).getCell(0).toString();
            //valu ise i. satirdaki 1. i2 ve 3 indekteki datalari birlesimi olacak

            String value = book.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + " , "
                    + book.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", " +
                    book.getSheet("Sayfa1").getRow(i).getCell(3).toString();

            ulkelerMap.put(key,value);

        }
        System.out.println(ulkelerMap);

        //Listede Ghana oldugunu test edelim
        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));
        Set<String> key=ulkelerMap.keySet();

        System.out.println("------------------------------");
        System.out.println(key.size());

    }

}
