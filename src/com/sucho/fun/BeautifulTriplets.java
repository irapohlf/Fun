package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/5/17.
 */
public class BeautifulTriplets {

    private static int isExist(final int[] seq, final int index, final int number) {
        for (int i = index; i < seq.length; i++) {
            if (seq[i] > number) {
                return -1;
            }

            if (seq[i] == number) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int d = sc.nextInt();

        int[] seq = new int[n];
        for (int i = 0; i < n; i++) {
            seq[i] = sc.nextInt();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            int index = isExist(seq, i, seq[i] + d);
            if (index == -1) continue;
            index = isExist(seq, index, seq[i] + 2*d);
            if (index == -1) continue;
            count++;
        }
        System.out.println(count);

        sc.close();
    }
}
