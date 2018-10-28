package com.sucho.fun;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author sucho
 * @since 10/27/18.
 */
public class ExtraLongFactorials {
    private static BigInteger extraLongFactorials(int n) {
        if (n <= 2) {
            return BigInteger.valueOf(n);
        }
        return BigInteger.valueOf(n).multiply(extraLongFactorials(n-1));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(extraLongFactorials(n));
    }
}
