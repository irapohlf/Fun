package com.sucho.fun.DynamicProgramming;

import java.util.Scanner;

/**
 * @author sucho
 * @since 8/10/17.
 */
public class Candies {
    static long candies(int n, int[] arr) {
        if (arr.length == 0) {
            return 0;
        }
        if (arr.length == 1) {
            return 1;
        }
        int[] c = new int[n];
        c[0] = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i-1]) {
                c[i] = c[i-1] + 1;
            } else {
                c[i] = 1;
            }
        }

        for (int i = n-2; i >= 0; i--) {
            if (arr[i] > arr[i+1] && c[i] <= c[i+1]) {
                c[i] = c[i+1] + 1;
            }
        }

        long sum = 0L;
        for (int i = 0; i < n; i++) {
            sum += (long) c[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int arr_i = 0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
        }
        long result = candies(n, arr);
        System.out.println(result);
        in.close();
    }
}
