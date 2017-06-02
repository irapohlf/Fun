package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/1/17.
 */
public class ReadLine {
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";

        Scanner scan = new Scanner(System.in);

        int iValue = Integer.parseInt(scan.nextLine());
        double dValue = Double.parseDouble(scan.nextLine());
        String msg = scan.nextLine();

        System.out.println(i + iValue);
        System.out.println(d + dValue);
        System.out.println(s + msg);

        scan.close();
    }
}
