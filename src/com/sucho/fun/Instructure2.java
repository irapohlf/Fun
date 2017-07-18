package com.sucho.fun;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sucho
 * @since 6/26/17.
 */
public class Instructure2 {
    private static int volume(boolean[][] waterMatrix, int i, int j, int size) {
        int v = 1;
        waterMatrix[i][j] = false;
        if (waterMatrix[i][j+1] == true) {
            v += volume(waterMatrix, i, j+1, size);
        }

        if (waterMatrix[i+1][j] == true) {
            v += volume(waterMatrix, i + 1, j, size);
        }

        if (waterMatrix[i+1][j+1] == true) {
            v += volume(waterMatrix, i + 1, j+1, size);
        }
        return v;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        int[][] matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        boolean[][] waterMatrix = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != 0) {
                    waterMatrix[i][j] = false;
                } else {
                    waterMatrix[i][j] = true;
                }
            }
        }

        List<Integer> sizes = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (waterMatrix[i][j] == false) continue;

                sizes.add(volume(waterMatrix, i, j, size));
            }
        }
    }
}
