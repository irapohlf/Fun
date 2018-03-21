package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 8/18/17.
 *
 * working except number==0 case
 */
public class CountDigit2 {
    private static long countDigitDTH(long d) {
        if (d == 1L) {
            return 1L;
        }

        return ((long) Math.pow(10.0, d-1L)) + 10L * countDigitDTH(d-1L);
    }

    private static long countNumber(long n, long number) {
        if (n <= 0L) {
            return 0L;
        }

        long log10 = (long) Math.log10((double) n);
        if (log10 == 0L) {
            if (n >= number) {
                return 1L;
            } else {
                return 0L;
            }
        }

        long msd = n/((long) Math.pow(10.0, log10));
        long remainder = n % ((long) Math.pow(10.0, log10));

        if (msd < number) {
            return msd * countDigitDTH(log10) + countNumber(remainder, number);
        } else if (msd == number) {
            return msd * countDigitDTH(log10) + countNumber(remainder, number) + remainder + 1L;
        } else {
            return msd * countDigitDTH(log10) + countNumber(remainder, number) + ((long) Math.pow(10.0, log10));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int digit = sc.nextInt();
            System.out.println(countNumber(n, digit));
        }

        sc.close();
    }
}
