package com.sucho.fun;

import java.util.Scanner;

/**
 * @author sucho
 * @since 6/6/17.
 */
public class Equal {

    private static int[] gaps = new int[] {5, 2, 1};

    private static int[][] normalize(final int[] input) {
        int min = Integer.MAX_VALUE;
        for (int anInput : input) {
            if (anInput < min) {
                min = anInput;
            }
        }

        int zeroIndex = -1;
        for (int i = 0; i < input.length; i++) {
            input[i] -= min;
            if (input[i] == 0) {
                zeroIndex = i;
            }
        }

        int[][] newInput = new int[3][input.length];
        for (int i = 0, j = 0; i < input.length; i++) {
            newInput[0][j] = input[i];
            newInput[1][j] = input[i] + 1;
            newInput[2][j++] = input[i] + 2;
        }

        if (zeroIndex != -1) {
            newInput[1][zeroIndex] = 0;
            newInput[2][zeroIndex] = 0;
        }

        return newInput;
    }

    private static int minSteps(final int[] input) {
        int step = 0;
        for (int val : input) {
            if (val == 0) continue;

            for (int gap : gaps) {
                if (val < gap) {
                    continue;
                }

                step += (val / gap);
                val %= gap;
            }
        }

        return step;
    }

    /*
    Sample Input
1
4
2 2 3 7

    Sample Output
    2
    */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int j = 0; j < T; j++) {
            int N = sc.nextInt();
            int[] numC = new int[N];
            for (int i = 0; i < N; i++) {
                numC[i] = sc.nextInt();
            }
            int[][] inputs = normalize(numC);

            System.out.println(Math.min(minSteps(inputs[0]), Math.min(minSteps(inputs[1]), minSteps(inputs[2])) + 1));
        }

        sc.close();
    }
}
