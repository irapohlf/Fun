package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 8/17/17.
 *
 * MS phone interview question - difficult
 */
public class CountDigit {
    /*
    private static void countDigits(long n, long d) {
        long numD = 0;
        long digit = 1L;
        do {
            digit *= 10L;
            long q = n/digit;
            long rem1 = n % digit;
            long rem2 = n % (digit/10L);

            numD += q * (digit/10L);
            numD += (rem1 >= (d * digit / 10L))? rem2 + 1 : 0;
        } while ((n / digit) > 0);

        System.out.println(numD);
    }
    */

    // ground truth
    private static void countDigits(long n, long d) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            char[] chs = Integer.toString(i).toCharArray();
            for (char ch : chs) {
                if (Character.getNumericValue(ch) == d) {
                    num++;
                }
            }
        }
        System.out.println(num);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int digit = sc.nextInt();
            countDigits(n, digit);
        }

        sc.close();
    }
}
