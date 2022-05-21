package day11_faker_file;

import javax.swing.*;
import java.time.LocalDate;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        int num=456;
        int topl = 0;
        int bas;
        while (num!=0){
            bas=num%10;
            topl+=bas;
            num=num/10;

        }

LocalDate date=LocalDate.now();
        System.out.println(date);





    }
}
