package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 10/25/18.
 */
public class DivisibleSumPairs {

    private static int divisibleSumPairs(int n, int k, int[] ar) {
        for (int i = 0; i < n; i++) {
            ar[i] %= k;
        }

        int ret = 0;
        int[] counts = new int[k];
        counts[ar[n-1]]++;
        for (int i = n-2; i >= 0; i--) {
            ret += counts[(k-ar[i])%k];
            counts[ar[i]]++;
        }

        return ret;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        System.out.println(divisibleSumPairs(n, k, ar));
    }
}
