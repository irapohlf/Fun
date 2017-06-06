package com.sucho.fun;

import java.util.Scanner;

import static java.lang.Math.ceil;
import static java.lang.Math.log10;
import static java.lang.Math.pow;

/**
 * @author sucho
 * @since 6/5/17.
 */
public class ModifiedKaprekarNumbers {
    private static boolean isKaprekarNumber(final long n) {
        double base = pow(10.0, ceil(log10(n + 1)));

        long squareN = n * n;

        long right = squareN % (long) base;
        long left = squareN / (long) base;

        return (right + left) == n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long p = sc.nextLong();
        long q = sc.nextLong();

        boolean found = false;
        for (long n = p; n <= q; n++) {
            if (isKaprekarNumber(n)) {
                System.out.printf("%d ", n);
                found = true;
            }
        }

        if (!found) {
            System.out.printf("INVALID RANGE");
        }

        System.out.println();

        sc.close();
    }
}
