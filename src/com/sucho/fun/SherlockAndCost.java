package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/12/17.
 */
public class SherlockAndCost {
    private static int[][] maxCosts;
    private static int max(int a, int b) {
        if (a > b) {
            return a;
        }
        return b;
    }

    private static int abs(int a, int b) {
        if (a > b) {
            return a - b;
        }
        return b - a;
    }

    private static int maxCost(int[] B, int index, int value) {
        int subIndex = value == 1? 0 : 1;
        if (maxCosts[index][subIndex] != -1) {
            return maxCosts[index][subIndex];
        }

        int cost;
        if (B[index+1] == 1) {
            cost = maxCost(B, index + 1, 1) + abs(value, 1);
        } else {
            cost = max(maxCost(B, index + 1, 1) + abs(value, 1), maxCost(B, index + 1, B[index + 1]) + abs(value, B[index + 1]));
        }
        maxCosts[index][value == 1? 0 : 1] = cost;
        return cost;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                B[i] = sc.nextInt();
            }

            maxCosts = new int[N][2];
            for (int i = 0; i < N-1; i++) {
                maxCosts[i][0] = -1;
                maxCosts[i][1] = -1;
            }
            maxCosts[N-1][0] = 0;
            maxCosts[N-1][1] = 0;
            System.out.println(max(maxCost(B, 0, 1), maxCost(B, 0, B[0])));
        }
        sc.close();
    }
}
