package uz.pdp.ui.utils;

import java.util.Scanner;

public interface ScanUtil {

    static Integer intScan(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextInt();
    }
    static String  strScan(String hint){
        Scanner scanner = new Scanner(System.in);
        System.out.print(hint);
        return scanner.nextLine();
    }

}
