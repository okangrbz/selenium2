package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //bana icinde oldugum projenin dosya yolunu verir

        System.out.println(System.getProperty("user.home"));
        //Users/pc------> benim bilgisayarimin bana ozel kismini verdi

        //Users/pc/Downloads/

        //masa ustumuzdeki text dosyasinin varligini etst edelim

        //Users/pc/Desktop/text.docx
        String dosyaYolu = System.getProperty("user.home") + "/Desktop/text.docx";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarimizdaki bir dosyanin varligini test etmek icin once o dosyaya ulasmamiz gerekir
        javada dosyaya erisim icin dosya yoluna yani path e ihtiyac vardir
        Her bilgisayarin kullanici adi farkli olacagindan masa ustu
        dosya yoluda birbirinden farkli olacaktir
        testlerimizin tum bilgisayarlarda calismasi icin
        dosya yolunu DINAMIK yapmak zorundayiz
        */

        //bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim = System.getProperty("user.home");

        //herkesin bilgisayarinda ortak olan kisim ise
        String ortakKisim = "/Desktop/text.docx";

        String masaUstuDosyaYolu = farkliKisim + ortakKisim;

        //System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));


    }


}
