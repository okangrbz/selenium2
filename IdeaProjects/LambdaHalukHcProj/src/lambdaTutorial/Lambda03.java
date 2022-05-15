package lambdaTutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Lambda03 {
    public static void main(String[] args) {

        List<String> menu = new ArrayList<>(Arrays.asList("küşleme", "wadana", "trileçe", "havucDilim", "buryan",
                "yaglama", "kokkoreç", "arabAşı", "güveç", "trileçe", "trileçe"));
        System.out.println("\n   ***   ");
        alfabetikBuykharfTekrarsiz(menu);//ADANA ARABAŞI BURYAN GÜVEÇ HAVUCDILIM KOKKOREÇ KÜŞLEME TRILEÇE YAGLAMA
        System.out.println("\n   ***   ");
        karakterSayisiTerssirala(menu);//10 8 7 6 5
        System.out.println("\n   ***   ");
        karakterSayisinagoreKB(menu);//adana güveç buryan küşleme trileçe yaglama arabAşı trileçe trileçe kokkoreç havucDilim
        System.out.println("\n   ***   ");
        sonHarfegoreSirala(menu);//arabAşı kokkoreç güveç buryan havucDilim küşleme trileçe trileçe trileçe adana yaglama
        System.out.println("\n   ***   ");
        charKaresiCiftElSirala(menu);
        System.out.println("\n   ***   ");
        harfSayisiYedidenAzKontrol(menu);
        System.out.println("\n   ***   ");
        wIleBaslayanElemanKotrol(menu);
        System.out.println("\n   ***   ");
        xIleBitenElemanKotrol(menu);
        System.out.println("\n   ***   ");
        characterSayisiBuyuElemanPrintEt(menu);
        System.out.println("\n   ***   ");
        ilkElemanHarcSonHarfSiraliariprint(menu);


    }

    // Task : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.
    public static void alfabetikBuykharfTekrarsiz(List<String> str) {
        str.//akis kaynagi
                stream().//akisa aldik
                // map(t-> t.toUpperCase()).//hepsini buyuk harf yapti
                        map(String::toUpperCase).
                sorted().//bu alfabetik siralama yapti
                distinct().//benzersiz yada tekrarsiz hale getirdi
                forEach(t -> System.out.print(t + " "));//bu expretion olarak print etti
/*
distinct()----> bu meth elemanlari sadece bir kez akisa sokarar
ayni seyden birden fazla farsa sadece birini alip akisa koyar (trilice -4 adet- ornegindeki gibi)
 */

    }

    // Task : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz..

    public static void karakterSayisiTerssirala(List<String> str) {
        str.
                stream().//akisa aldik
                //map(t->t.length()).//her bir elemanin lengtini aldik
                        map(String::length).
                sorted(Comparator.reverseOrder()).//bu meth ters siralama yapar
                distinct().//benzersiz yada tekrarsiz hale getirdi
                forEach(Lambda01::yazdir);//yazdirir


    }


    // Task : List elemanlarini character sayisina gore kckten byk e gore print ediniz..

    public static void karakterSayisinagoreKB(List<String> str) {

        str.
                stream().
                sorted(Comparator.
                        comparing(String::length)).
                forEach(t -> System.out.print(t + " "));
    }


    // Task : list elemanlarinin son harfine gore ters sirali print ediniz.

    public static void sonHarfegoreSirala(List<String> str) {
        str.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().charAt(t.toString().length() - 1)).
                        reversed()).
                forEach(t -> System.out.print(t + " "));


    }

    // Task : listin elemanlarin karakterlerinin cift sayili  karelerini hesaplayan,ve karelerini tekrarsiz buyukten kucuge sirali  print ediniz..
    public static void charKaresiCiftElSirala(List<String> str) {
        str.
                stream().
                map(t -> t.length() * t.length()).//akısdaki string elemanları boyutlarının karesine update edildi
                filter(Lambda01::ciftBul).
                distinct().
                sorted(Comparator.reverseOrder()).
                forEach(Lambda01::yazdir);
    }


    // Task : List elelmmalarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.

    public static void harfSayisiYedidenAzKontrol(List<String> str) {
        boolean kontrol = str.
                stream().//akisa aldik
                        allMatch(t -> t.length() < +7);//butun elemanlari buyuklugune gore kotrol eder booulen deger verir
        if (kontrol) {
            System.out.println("liste elemanlari 7 harf ve daha az harften olusuyor");
        } else System.out.println("list elemanlari 7 haften buyuk");

        System.out.println(kontrol);
        //cincik code
        System.out.println("cincik kod");
        System.out.println(str.stream().allMatch(t -> t.length() <= 7) ? "liste elemanlari 7 harf ve daha az harften olusuyor" : "list elemanlari 7 haften buyuk");

//anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
//allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
//noneMatch() --> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    }


    // Task : List elelmanlarinin "W" ile baslamasını kontrol ediniz.
    public static void wIleBaslayanElemanKotrol(List<String> str) {
        System.out.println(str.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile baslayan yemegin menude ne isi var" : "agam hic w li yemek olur mu");

    }

    // Task : List elelmanlarinin "x" ile biten en az bir elemaı kontrol ediniz.
    public static void xIleBitenElemanKotrol(List<String> str) {
        System.out.println(str.
                stream().
                map(String::toUpperCase).
                anyMatch(t -> t.endsWith("X")) ? "x ile baslayan yemegin menude ne isi var" : "agam hic x li yemek olur mu");

    }

    // Task : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void characterSayisiBuyuElemanPrintEt(List<String> str) {
        //System.out.println(str.stream().sorted(Comparator.comparing(t->t.toString().length()).reversed()).findFirst());
        Stream<String> enBuyukrElmn = str.
                stream().
                sorted(Comparator.
                        comparing(t -> t.toString().length()).reversed()).
                limit(1);//limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır
                          //burda 1 yazdigimiz icin akistan cikan elemanlarin 1. sini alir

        /*
        enBuyukrElmn.toArray()) --->limit() meth dan dolayi stream type olan
        enBuyukrElmn toArry() meth ile arry e convert edildi
         */

         /*
  TRİCK : •    Stream'ler ekrana direk yazdırılamaz. Stream'i toArray() ile Array'e çeviririz.
  Array'i de Arrays.toString() 'in içine alıp yazdırabiliriz.
•  Ör; System.out.println(Arrays.toString(***.toArray())); veya System.out.println(Arrays.asList(***.toArray())); kullanılabilir.

   */
        System.out.println(Arrays.toString(enBuyukrElmn.toArray()));

        //limit(1) => Sınırlandırma demek. Bu akışın elemanlarından oluşan, uzunluğu maxSize'dan uzun olmayacak
   // şekilde kesilmiş bir akış return eder. Stream return eder.



    }


    // Task : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
    public static void ilkElemanHarcSonHarfSiraliariprint(List<String> str){


        str.
                stream().//akisa alindi
                sorted(Comparator.comparing(t->t.charAt(t.length()-1))).//son harfe gore siralandicomparing
                skip(1).////skip() atlama islemi yapiyor, ilk elemani atlar 5ilk eleman adana yi atladi)
                forEach(t-> System.out.print(t+" "));//yazdirir



    }

}
