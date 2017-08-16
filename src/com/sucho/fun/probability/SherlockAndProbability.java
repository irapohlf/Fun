package com.sucho.fun.probability;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author sucho
 * @since 8/11/17.
 */
public class SherlockAndProbability {
    private static int[] convert(String input) {
        char[] charArr = input.toCharArray();
        int[] ret = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            ret[i] = Character.getNumericValue(charArr[i]) - Character.getNumericValue('0');
        }
        return ret;
    }

    private static long gcd(long a, long b) {
        long rem = a % b;

        if (rem == 0) {
            return b;
        }
        return gcd(b, rem);
    }

    private static void print(long nom, long denom) {
        long g = gcd(denom, nom);
        System.out.println(nom/g + "/" + denom/g);
    }

    private static void prob(int[] arr, int K) {
        long ones = Arrays.stream(arr).sum();
        long n = arr.length;

        if (ones == 0) {
            System.out.println("0/1");
            return;
        }

        if (K >= n-1) {
            print(ones * ones, n * n);
            return;
        }

        /*
        If K is bigger than (sqrt(1 + 2n(n+1))-1)/2, it would be faster to subtract.
        */
        /*
        // O(NK) algorithm though it passes all the test cases
        Double pivot = (Math.sqrt(1.0 + 2.0 * (double) n * ((double) n + 1.0))-1.0)/2.0;
        long sum = ones;
        if (K <= pivot.intValue()) {
            for (int i = 1; i <= K; i++) {
                for (int j = 0; j < n - i; j++) {
                    if (arr[j] == 1 && arr[j + i] == 1) {
                        sum += 2L;
                    }
                }
            }
        } else {
            sum = ones * ones;
            for (int i = (int) n-1; i > K; i--) {
                for (int j = 0; j < n -i; j++) {
                    if (arr[j] == 1 && arr[j + i] == 1) {
                        sum -= 2L;
                    }
                }
            }
        }
        */

        // Following is O(N) algorithm using combinatorics.
        long sum = ones;
        long numOnes = 0;
        for (int i = 0; i <= K; i++) {
            numOnes += arr[i];
        }

        sum += numOnes * (numOnes - 1);
        for (int i = K+1; i < n; i++) {
            if (arr[i] == 1) {
                sum += (numOnes - arr[i-K-1]) * 2L;
            }
            numOnes += (arr[i] - arr[i-K-1]);
        }
        print(sum, n * n);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            String input = sc.next();
            int[] arr = convert(input);
            prob(arr, K);
        }
        sc.close();
    }
}
